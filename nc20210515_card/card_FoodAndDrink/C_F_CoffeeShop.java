package nc20210515_card.card_FoodAndDrink;

import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class C_F_CoffeeShop extends Card_Eat_and_Drink {

	public C_F_CoffeeShop() {
		super("珈琲店", 8, 1, "無", 5, 0);

	}

	@Override
	public boolean thisAbility(Player player, Board board) {
		System.out.println(this.getName()+"を使用します");
		super.kakei(player, board);
		return false;
	}
}
