package nc20210515_card.card_Facilities;

import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class C_Faci_LawOffice extends Card_Facility {
	public C_Faci_LawOffice() {
		super("法律事務所", 8, 2);
	}
	@Override
	public boolean thisAbility(Player player, Board board) {
		System.out.println("終了時:負債から5枚まで免除する");
		return super.thisAbility(player, board);
	}
}
