package nc20210515_card.card_Public;

import nc20210515_card.Card;
import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class C_P_S_Vocational extends Card {

	public C_P_S_Vocational() {
		super("専門学校", 0, 0, "公");
	}

	@Override
	public boolean thisAbility(Player player, Board board) {
		if(player.getWoker()<player.getWokerlimit()) {
			player.plusWoker(1);
			return false;
		}
		System.out.println("労働者数は上限に達しています");
		return true;
	}
}