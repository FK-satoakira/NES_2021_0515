package nc20210515_card.card_Public;

import nc20210515_processor.Board;
import nc20210515_processor.Player;

public abstract class Card_School extends Card_and_IInvoke {

	public Card_School(String name, int price, int cost, String type) {
		super(name, price, cost, type);
	}

	@Override
	public abstract boolean thisAbility(Player player, Board board);

	@Override
	public abstract void invoke(Player player, Board board);
}
