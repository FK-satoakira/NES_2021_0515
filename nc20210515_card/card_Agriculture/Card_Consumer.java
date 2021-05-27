package nc20210515_card.card_Agriculture;

import nc20210515_card.Card;
import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class Card_Consumer extends Card {

	public Card_Consumer() {
		super("消費財", 0, 0, "0");

	}

	@Override
	public boolean thisAbility(Player player, Board board) {
		return false;
	}

}
