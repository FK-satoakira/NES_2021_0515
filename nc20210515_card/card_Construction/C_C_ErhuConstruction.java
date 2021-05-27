package nc20210515_card.card_Construction;
import java.util.HashMap;
import java.util.Map;

import nc20210515_card.Card;
import nc20210515_processor.Board;
import nc20210515_processor.Message;
import nc20210515_processor.Player;


public class C_C_ErhuConstruction extends Card{

	public C_C_ErhuConstruction() {
		super("二胡建設", 20 , 5);this.setType("無");
	}
	@Override
	public boolean thisAbility(Player player, Board board) {
//		カード説明

		int count = 0;
		for (int i = 0; i < player.getCards().size(); i++) {
			if(!player.getCards().get(i).getType().equals("0")) {
				count++;
			}
		}
		if(player.getCards().size()==0 || count<2) {
			System.out.println("このカードを使用する条件を満たしていません");return true;
		}


		System.out.println(this.getName()+"を使用します");
		System.out.println("このカードは捨て札数が同じなら２つ同時に建設できます");
		System.out.print("１枚目の");

//		1枚目を選択
		int firstSelectCard = board.SelectFromPlayerCard(player);/*FBCnum＝firstbuildcard＝「１個めの建設」の略*/
		int costNumberForRoop = player.getCards().get(firstSelectCard).getCost();
//		1枚目が消費財だった時の拒否の処理
		if (player.getCards().get(firstSelectCard).getType().equals("0")) {
			System.out.println("消費財は建設出来ません");return true;
		}

//		手札不足時の処理
		if (player.getCards().get(firstSelectCard).getCost() + 2 > player.getCards().size()) {/*そのカードを建設するための捨て札の枚数分が手札にあるかチェックしてるif文*/
			Message.BuildedCannot(player.getCards().get(firstSelectCard));return true;/*建設できない場合のメッセージ*/
		}

//		同コストが2枚以上ない時の処理
		int trashnum = player.getCards().get(firstSelectCard).getCost();
		int count2 = 0;
		for (int i = 0; i < player.getCards().size(); i++) {
			if(trashnum == player.getCards().get(i).getCost()) {
				count2++;
			}
		}
		if(count2 < 2) {
			System.out.println("同じコストのカードがありません。");return true;
		}

//		一枚目のを手札から除去して、mapにindex番号とカードを入れてる。仮として。
//		そうすれば、2枚目を手札から選ぶときに1枚目が手札にない状態で手札から選べる
		Map<Integer, Card> mapConstructCard = new HashMap<Integer, Card>();
		mapConstructCard.put(firstSelectCard, player.getCards().remove(firstSelectCard));





//		ーーーーーーーーーーーーーーーーーーーー2枚目のカード選択ーーーーーーーーーーーーーーーーーーーー
		System.out.print("２枚目の");
		int secondSelectCard = board.SelectFromPlayerCard(player);/*FBCnum＝firstbuildcard＝「１個めの建設」の略*/

//		〖2枚目が消費財だった時の拒否の処理〗
		if (player.getCards().get(secondSelectCard).getType().equals("0")) {

//			ここで思ったが、MapじゃなくてListでもよかったかも。
//			手札のもとあったindex番号に戻す
			player.getCards().add(firstSelectCard, mapConstructCard.remove(firstSelectCard));
			System.out.println("消費財は建設出来ません");return true;
		}


//		〖１，２のカードのコストが一致してない時〗
		if(mapConstructCard.get(firstSelectCard).getCost() != player.getCards().get(secondSelectCard).getCost()) {

//			手札のもとあったindex番号に戻す
			player.getCards().add(firstSelectCard, mapConstructCard.remove(firstSelectCard));
			System.out.println("2枚の捨て札枚数が一致していません");
			return true;
		}

//		〖成功して、2つを建設する〗
//		1枚目を建設(ここはmapでなくてもいい)
		player.getBoardOfPlayer().getCards().add(mapConstructCard.remove(firstSelectCard));
//		2枚目を建設
		player.getBoardOfPlayer().getCards().add(player.getCards().remove(secondSelectCard));




//		ここから costNumberForRoop
		for (int i = 0; i < costNumberForRoop; i++) {
			Message.CardChoiceTrash(costNumberForRoop-i);
			int trashNum = board.SelectFromPlayerCard(player);
			board.plusTrashCard(player.getCards().remove(trashNum));
		}
		int playerBoardSize = player.getBoardOfPlayer().getCards().size()-1;

		System.out.println(player.getBoardOfPlayer().getCards().get(playerBoardSize).getName()
				+"と"+player.getBoardOfPlayer().getCards().get(playerBoardSize-1).getName()+"を建設しました");
		return false;
	}

}
