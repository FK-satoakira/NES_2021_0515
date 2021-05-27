package nc20210515_card.card_FoodAndDrink;

import nc20210515_card.Card;
import nc20210515_processor.Board;
import nc20210515_processor.Message;
import nc20210515_processor.Player;

public abstract class Card_Eat_and_Drink extends Card {


	private int hikidashikin = 0;
	private int trushCardNum = 0;
	public Card_Eat_and_Drink(String name, int price, int cost, String type, int hikidashikin, int trushCardNum) {
		super(name, price, cost, type);
		this.hikidashikin=hikidashikin;
		this.trushCardNum = trushCardNum;
	}


	@Override
	public abstract boolean thisAbility(Player player, Board board);

	public boolean kakei(Player player, Board board) {
		if (board.getHousehold() < this.hikidashikin) {/*check*/
			System.out.println("家計が足りません");
			return true;
		}
		if(trushCardNum > player.getCards().size()) {
			Message.CardsNotEnough();
			return true;
		}
		if(this.trushCardNum>0) {
			System.out.println("このカードは手札を"+this.trushCardNum+"枚捨て、"+this.hikidashikin+"$を家計から引き出します");
		}
		for (int i = 0; i < trushCardNum; i++) {
			System.out.println("捨て札を"+(trushCardNum-i)+"枚選んでください");
			player.getCards().remove(board.SelectFromPlayerCard(player));
		}
		board.plusHousehold(-this.hikidashikin);/*check*/
		player.plusMoney(this.hikidashikin);
		System.out.println("家計から"+this.hikidashikin+"ドル受け取りました");
		System.out.print("家計:"+board.getHousehold());System.out.print(" , 資金:"+player.getMoney());
		return false;
	}


//	－－－－－－－－－－－－－－－－－－ セッターゲッター －－－－－－－－－－－－－－－－－－
	public int getHikidashikin() {
		return hikidashikin;
	}
	public void setHikidashikin(int hikidashikin) {
		this.hikidashikin = hikidashikin;
	}

	public int getTrushCardNum() {
		return trushCardNum;
	}
	public void setTrushCardNum(int trushCardNum) {
		this.trushCardNum = trushCardNum;
	}

}
