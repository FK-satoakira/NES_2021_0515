package nc20210515_card.card_Public;

import nc20210515_card.card_Construction.Card_Construction;
import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class C_P_C_Carpenter extends Card_Construction {

	public C_P_C_Carpenter() {
		super("大工", 0, 0);this.setType("公");
	}


	@Override
	public boolean thisAbility(Player player, Board board) {
		return super.thisAbility(player, board);
	}

}
