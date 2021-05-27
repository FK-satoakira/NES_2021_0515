package nc20210515_card.card_Facilities;

import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class C_Faci_Train extends Card_Facility {

	public C_Faci_Train() {
		super("鉄道", 18, 5);

	}
	@Override
	public boolean thisAbility(Player player, Board board) {
		System.out.println("終了時:所有する工業カテゴリの建物1つにつき+8点");
		return super.thisAbility(player, board);
	}
}
