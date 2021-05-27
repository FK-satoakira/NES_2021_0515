package nc20210515_card.card_Facilities;

import nc20210515_card.Card;
import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class Card_Facility extends Card {

	public Card_Facility(String name, int price, int trash) {
		super(name, price, trash, "施");
	}

	@Override
	public boolean thisAbility(Player player, Board board) {
		System.out.println("施設カードは使用するものではありません");
		return true;
	}


}
