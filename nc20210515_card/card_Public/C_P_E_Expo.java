package nc20210515_card.card_Public;

import nc20210515_card.card_FoodAndDrink.Card_Eat_and_Drink;
import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class C_P_E_Expo extends Card_Eat_and_Drink {

	public C_P_E_Expo() {
		super("万博", 0, 0, "公", 30, 5);
	}

	@Override
	public boolean thisAbility(Player player, Board board) {
//		if (board.getHousehold() < this.getHikidashikin()) {/*check*/
//			System.out.println("家計が足りません");
//			return true;
//		}
//		if(player.getCards().size()==0) {System.out.println("手札が空です。");return true;}
//		for (int i = 0; i < 5; i++) {
//			System.out.println("捨て札を"+(5-i)+"枚選んでください");
//			player.getCards().remove(board.SelectFromPlayerCard(player));
//		}
		return super.kakei(player, board);
	}
}
