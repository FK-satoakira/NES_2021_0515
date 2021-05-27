package nc20210515_card.card_Facilities;

import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class C_Faci_RealEstate extends Card_Facility {

	public C_Faci_RealEstate() {
		super("不動産", 10, 3);
	}
	@Override
	public boolean thisAbility(Player player, Board board) {
		System.out.println("終了時:所有する建物1つにつき+3点(この建物を含む)");
		return super.thisAbility(player, board);
	}
}
