package nc20210515_card.card_Construction;

import java.util.List;

import nc20210515_card.Card;
import nc20210515_processor.Board;
import nc20210515_processor.Message;
import nc20210515_processor.Player;

public abstract class Card_Construction extends Card {

	public Card_Construction(String name, int price, int cost) {
		super(name, price, cost);this.setType("無");
	}

	public int dwon(int num) {
		return num;
	}


//	二胡建設だけこのメソッドではやらない
	@Override
	public boolean thisAbility(Player player, Board board) {

		//			手札空＝建設不可
		if (player.getCards().size() == 0) {
			System.out.println("手札は空です");
			return true;
		}

//		消費財を建築しようとしたとき
		Message.BuildChoice();
//		Message.playerCard(player);
		int num = board.SelectFromPlayerCard(player);
		List<Card> playerCards = player.getCards();

//		if(num==-1) {
//			return true;
//		}

		if (playerCards.get(num).getType().equals("0")) {
			System.out.println("消費財は建設不可です");
			return true;
		}

		//			この一文は「建設会社」の、コストを―1するためのやつ

		if (playerCards.get(num).getCost() >= player.getCards().size()) {
			System.out.println(playerCards.get(num).getName() + "を建設するには手札が足りません");
			return true;
		}

//		正常に入力し、建設する処理。
		Card buildCard = playerCards.remove(num);/*建設カードを手札から除去し*/
		player.plusBoardOfPlayer(buildCard);/*プレイヤーボードに建設*/
		Message.BuildPlans(buildCard);
		int count = 0;
		for (int i = 0; i < buildCard.getCost(); i++) {
			int trashnum = buildCard.getCost();
			Message.CardChoiceTrash(trashnum - count);
//			Message.playerCard(player);
			int trashCard = board.SelectFromPlayerCard(player);
			board.plusTrashCard(player.getCards().remove(trashCard));
			count++;
		}
		return false;
	}

}
