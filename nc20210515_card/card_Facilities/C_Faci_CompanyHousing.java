package nc20210515_card.card_Facilities;

import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class C_Faci_CompanyHousing extends Card_Facility {

	public C_Faci_CompanyHousing() {
		super("社宅", 8, 2);

	}
	@Override
	public boolean thisAbility(Player player, Board board) {
		System.out.println("労働者上限+1");
		return super.thisAbility(player, board);
	}
}
