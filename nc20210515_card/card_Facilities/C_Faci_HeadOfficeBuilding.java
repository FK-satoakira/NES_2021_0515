package nc20210515_card.card_Facilities;

import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class C_Faci_HeadOfficeBuilding extends Card_Facility {

	public C_Faci_HeadOfficeBuilding() {
		super("本社ビル", 20, 5);

	}
	@Override
	public boolean thisAbility(Player player, Board board) {
		System.out.println("所有する施設カテゴリの建物1つにつき+6点");
		return super.thisAbility(player, board);
	}
}
