package nc20210515_card.card_Public;

import nc20210515_card.card_FoodAndDrink.Card_Eat_and_Drink;
import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class C_P_E_Stall extends Card_Eat_and_Drink {

	public C_P_E_Stall() {
		super("露店", 0, 0, "公", 6, 1);

	}

	@Override
	public boolean thisAbility(Player player, Board board) {
//		if (board.getHousehold() < this.getHikidashikin()) {/*check*/
//			System.out.println("家計が足りません");
//			return true;
//		}
//		if(player.getCards().size()==0) {System.out.println("手札が空です。");return true;}
//		System.out.println("捨て札を1枚選んでください");
//		player.getCards().remove(board.SelectFromPlayerCard(player));
		return super.kakei(player, board);
	}
}
