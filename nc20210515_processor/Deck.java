package nc20210515_processor;

import java.util.ArrayList;
import java.util.List;

import nc20210515_card.Card;

public class Deck {
	private List<Card> cards = new ArrayList<>();

	public Deck() {

	}
	public List<Card> getCards(Board board) {
		if(this.cards.isEmpty()) {
			while(board.getTrashCard().getCards().size()>0) {
				this.cards.add(board.getTrashCard().getCards().remove(0));
			}
		}
		return cards;
	}
	public void plusCards(Card card) {
		this.cards.add(card);
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	public List<Card> getCards() {
		return this.cards;
	}
}
//Cardクラスはabstractなのでnew不可なのでclone()で
//[Card c = new Card()]が不可なのでクローンはやってない