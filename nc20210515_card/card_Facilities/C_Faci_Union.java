package nc20210515_card.card_Facilities;

import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class C_Faci_Union extends Card_Facility {

	public C_Faci_Union() {
		super("労働組合", 0, 4);
	}
	@Override
	public boolean thisAbility(Player player, Board board) {
		System.out.println("終了時:労働者1人につき+6点");
		return super.thisAbility(player, board);
	}
}
