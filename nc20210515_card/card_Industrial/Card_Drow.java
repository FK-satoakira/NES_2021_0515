package nc20210515_card.card_Industrial;

import java.util.Random;

import nc20210515_card.Card;
import nc20210515_processor.Board;
import nc20210515_processor.Message;
import nc20210515_processor.Player;

public abstract class Card_Drow extends Card {

	private int drow;
	private int trush;

	public Card_Drow(String name, int price, int cost, String type, int drow, int trush) {
		super(name, price, cost, type);
		this.drow = drow;
		this.trush = trush;
	}

	//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ メソッド ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
	public boolean drow_ability(Player player, Board board) {
		if (player.getCards().size() < this.trush) {
			Message.CardsNotEnough();
			return true;
		}
		System.out.println(this.getName() + "を使用します");
		if (!this.getName().equals("製鉄所")) {
			System.out.println("このカードは手札から" + this.trush + "枚選んで捨てて、デッキから" + this.drow + "枚引きます");
		} else {
			System.out.println("このカードは、デッキから"+this.drow+"枚カードを引きます");
		}
		for (int i = 0; i < this.trush; i++) {
			board.plusTrashCard(player.getCards().remove(board.SelectFromPlayerCard(player)));
		}
		for (int i = 0; i < drow; i++) {
			int r = new Random().nextInt(board.getDeck().getCards(board).size());
			player.plusCards(board.getDeck().getCards(board).remove(r));
		}
		Message.playerCard(player);
		return false;
	}

	public int getDrow() {
		return drow;
	}

	public void setDrow(int drow) {
		this.drow = drow;
	}

	public int getTrush() {
		return trush;
	}

	public void setTrush(int trush) {
		this.trush = trush;
	}

}
