package nc20210515_card.card_FoodAndDrink;

import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class C_F_Restaurant extends Card_Eat_and_Drink {

	public C_F_Restaurant() {
		super("レストラン", 16, 3, "無", 15, 1);

	}

	@Override
	public boolean thisAbility(Player player, Board board) {
//		if (board.getHousehold() < this.getHikidashikin()) {/*check*/
//			System.out.println("家計が足りません");
//			return true;
//		}
//		if(player.getCards().size()==0) {System.out.println("手札が空です。");return true;}
//		System.out.println("捨て札を一枚選んでください");
//		player.getCards().remove(board.SelectFromPlayerCard(player));
		return super.kakei(player, board);
	}

}
