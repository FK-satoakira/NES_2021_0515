package nc20210515_processor;

import java.util.ArrayList;
import java.util.List;

import nc20210515_card.Card;

public class Trash {
	private List<Card> cards = new ArrayList<>();
	public Trash() {
	}


//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ method/s ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
//	全てのメソッドにトラッシュにある消費財を除去する処理がされてある
//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ method/s ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝


//	トラッシュカードを単に参照するだけでも消費財が除去されるようになってる
	public List<Card> getCards() {
		for (int i = 0; i < this.cards.size(); i++) {
			if(this.cards.get(i).getType().equals("0")) {
				this.cards.remove(i);
			}
		}

//	----------ここでトラッシュ内を表示してある--------
//		何故一枚目が表示されない?
//		A.上のremoveは消費財除去なので勘違いしてるだけで、まだトラッシュにカードは追加されてない。
//			getCards()は参照してるだけ。
//		System.out.println(this.toString());System.out.println("★★★★★★★★★★★★");
		return cards;
	}


//	トラッシュにカードを入れてる
//	public void plusCard(Card card) {
//		for (int i = 0; i < this.cards.size(); i++) {
//			if(this.cards.get(i).getType().equals("0")) {
//				this.cards.remove(i);
//			}
//		}
//
//		this.cards.add(card);
//
////		これでトラッシュの中身を確認できる
////		System.out.println(this);
//	}



//	上のメソッドのアレンジ--------------------------
	public void plusCard(Card card, Board board) {
		if(card.getType().equals("0")) {
			this.cards.clear();
		}else {
			board.plusDeck(this.cards.remove(0));
		}
//		これでトラッシュの中身を確認できる
//		System.out.println(this);
	}
//---------------------------------------

//	いっぺんにトラッシュをセット
	public void setCards(List<Card> cards) {
		for (int i = 0; i < this.cards.size(); i++) {
			if(this.cards.get(i).getType().equals("0")) {
				this.cards.remove(i);
			}
		}
		this.cards = cards;
	}

//	このクラス内のgetCards()で使われてる。ちゃんと捨てたカードがトラッシュ内に入ってるかどうかの確認
	@Override
	public String toString() {
		return "[トラッシュ:::]=" + cards;
	}
}
