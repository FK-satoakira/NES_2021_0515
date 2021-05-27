package nc20210515_card.card_Public;

import nc20210515_card.Card;
import nc20210515_card.IInvoke;
import nc20210515_processor.Board;
import nc20210515_processor.Player;

public abstract class Card_and_IInvoke extends Card implements IInvoke {

	public Card_and_IInvoke(String name, int price, int cost, String type) {
		super(name, price, cost, type);

	}

	@Override
	public void invoke(Player player, Board board) {
	}

	@Override
	public boolean thisAbility(Player player, Board board) {

		return false;
	}

}
