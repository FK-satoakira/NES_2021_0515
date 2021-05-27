package nc20210515_card.card_Industrial;

import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class C_I_CarFactory extends Card_Drow {


	public C_I_CarFactory() {
		super("自動車工場", 24, 5, "工", 7, 3);
	}

	@Override
	public boolean thisAbility(Player player, Board board) {
		return super.drow_ability(player, board);
	}



}
