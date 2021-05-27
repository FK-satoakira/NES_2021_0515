package nc20210515_card.card_Agriculture;

import nc20210515_card.Card;
import nc20210515_processor.Board;
import nc20210515_processor.Player;

public abstract class Card_Agriculture extends Card {

	public Card_Agriculture(String name, int price, int trash) {
		super(name, price, trash);
		this.setType("農");

	}



	@Override
	public boolean thisAbility(Player player, Board board) {
		player.plusCards(new Card_Consumer());
		return false;
	}

}
