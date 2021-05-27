package nc20210515_card.card_Facilities;

import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class C_Faci_WareHouse extends Card_Facility {

	public C_Faci_WareHouse() {
		super("倉庫", 10, 2);
	}

	@Override
	public boolean thisAbility(Player player, Board board) {
		System.out.println("手札上限+4");
		return super.thisAbility(player, board);
	}
}
