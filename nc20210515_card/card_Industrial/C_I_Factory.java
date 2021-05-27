package nc20210515_card.card_Industrial;

import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class C_I_Factory extends Card_Drow {


	public C_I_Factory() {
		super("工場",12,2,"工", 4, 2);
	}


	@Override
	public boolean thisAbility(Player player, Board board) {
////		「手札が2枚以上ないと使えない」という処理
//		if(player.getCards().size()<2){
//			Message.CardsNotEnough();
//			return true;
//		}
////		手札から2枚選んで捨てる処理
//		for (int i = 0; i < 2; i++) {
//			if(2-i>0) {
//				Message.CardChoiceTrash(2-i);
//			}
//			int t = board.SelectFromPlayerCard(player);
//			board.plusTrashCard(player.getCards().remove(t));
//		}
////		デッキから4枚引く
//		for (int i = 0; i < 4; i++) {
//			drow_ability(player, board);
//		}
//		return false;

		return super.drow_ability(player, board);
	}

}
