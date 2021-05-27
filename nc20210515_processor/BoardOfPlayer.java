package nc20210515_processor;

import java.util.ArrayList;
import java.util.List;

import nc20210515_card.Card;

public class BoardOfPlayer {
	private List<Card> cards = new ArrayList<>();

	public BoardOfPlayer() {
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public void plusCards(Card card) {
		this.cards.add(card);
	}

	@Override
	public String toString() {
		return "[プレイヤーボード]: " + cards;
	}
	public void hyouji() {
		System.out.println("[プレイヤーボード]: ");
		if(this.cards.size()<=5) {
			System.out.print(cards);
		}else {
			for (int i = 0; i <this.cards.size(); i++) {
				System.out.print(this.cards.get(i));
				if((i+1)%5==0) {
					System.out.println();
				}
			}
		}
		System.out.println();
	}

}
