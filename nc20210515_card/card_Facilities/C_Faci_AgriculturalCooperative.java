package nc20210515_card.card_Facilities;

import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class C_Faci_AgriculturalCooperative extends Card_Facility {

	public C_Faci_AgriculturalCooperative() {
		super("農協", 12, 3);

	}
	@Override
	public boolean thisAbility(Player player, Board board) {
		System.out.println("手札の消費財1枚につき+3点");
		return super.thisAbility(player, board);
	}
}
