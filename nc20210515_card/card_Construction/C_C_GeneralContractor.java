package nc20210515_card.card_Construction;

import java.util.List;
import java.util.Random;

import nc20210515_card.Card;
import nc20210515_processor.Board;
import nc20210515_processor.Player;



public class C_C_GeneralContractor extends Card_Construction {

	public C_C_GeneralContractor() {
		super("ゼネコン", 18, 4);

	}

	@Override
	public boolean thisAbility(Player player, Board board) {
//	if(player.getCards().size()==0) {System.out.println("手札がありません");return true;}

//	手札が空、消費財建設の場合にtrueを返すようにC_BクラスのsecondAbilityをsuperで呼び出して
//	boolean usebleに代入してる。
	System.out.println(this.getName()+"を使用します");
	System.out.println("このカードはカードを建設した後、デッキからカードを2枚ドローします");
	boolean useble = super.thisAbility(player, board);
	if(useble) {
		return useble;
	}
	for (int i = 0; i < 2; i++) {

		List<Card> deckCard = board.getDeck().getCards(board);
		int r = new Random().nextInt(deckCard.size());
		player.plusCards(deckCard.remove(r));
	}
		return useble;
	}



}
