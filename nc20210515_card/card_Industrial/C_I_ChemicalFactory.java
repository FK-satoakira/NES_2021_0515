package nc20210515_card.card_Industrial;

import java.util.Random;

import nc20210515_processor.Board;
import nc20210515_processor.Message;
import nc20210515_processor.Player;

public class C_I_ChemicalFactory extends Card_Drow {
//  ＊注意
//	化学工場だけはフィールドのdrow & trush は0

	public C_I_ChemicalFactory() {
		super("化学工場", 18, 4, "工", 0, 0);
	}

	@Override
	public boolean thisAbility(Player player, Board board) {
//		System.out.println("手札が空のときは４枚、それ以外のときは２枚デッキからカードを引きます。");
//		boolean useble = true;
//		if(player.getCards().size()==0) {
//			for (int i = 0; i < 4; i++) {
//				useble = super.drow_ability(player, board);
//			}
//		}else {
//			for (int i = 0; i < 2; i++) {
//				useble = super.drow_ability(player, board);
//			}
//		}
//		return useble;
		System.out.println(this.getName()+"を使用します");
		System.out.println("このカードは、手札が空のとき4枚、手札があるときは2枚デッキからカードを引きます");

		if (player.getCards().size()==0) {
//			System.out.println("");
			for (int i = 0; i < 4; i++) {
				int r = new Random().nextInt(board.getDeck().getCards(board).size());
				player.plusCards(board.getDeck().getCards(board).remove(r));
			}
			System.out.println("デッキから4枚カードを引きました");
		}else {
			for (int i = 0; i < 2; i++) {
				int r = new Random().nextInt(board.getDeck().getCards(board).size());
				player.plusCards(board.getDeck().getCards(board).remove(r));
			}
			System.out.println("デッキから2枚カードを引きました");
		}
		Message.playerCard(player);
		return false;
	}

}
