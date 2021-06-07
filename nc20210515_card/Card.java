package nc20210515_card;

import nc20210515_processor.Board;
import nc20210515_processor.Player;

//***Card.javaではCard使用に関するbooeanは定義していない。

public abstract class Card {
	private String name;/*カード名*/
	private int price;/*カードの価格価値*/
	private int cost;/*カード建設コスト*/
	private boolean useable;/*カードを使用したかどうか*/
	private String type ="";/*カードのタイプ*/



	//	コンストラクタ
//	public Card() {super();}
//	public Card(String name2) {}
	public Card(String name, int price, int cost) {
		this.name=name;
		this.price=price;
		this.cost=cost;
	}

	public Card(String name, int price, int cost, String type) {
		this.name=name;
		this.price=price;
		this.cost=cost;
		this.type=type;
	}


//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ method/s ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝

//	Board.javaのuseCard()メソッドが呼び出すメソッド。 全カードを「Card」として扱い、のこability()メソッドを発動させる。
	public boolean ability(Player player, Board board) {
//		「施設は使えない」の処理
//		if(this.type.equals("F")) {
//			System.out.println("施設カードは使用するものではありません");
//			return true;
//		}
		if(this.isUseable()) {
			System.out.println("このカードは使用できません\n");
			return true;
		}else {

//			カードのオンオフとは別の条件で使えなかったとき不便なのでここでの記述はやめる
//			this.useable = true;

//			上の記述ではない方法でやってみた
//			thisAbility()が上手く発動できなかったとき
//			if(!this.type.equals("F")) {
//				System.out.println("【"+this.name+"】"+"を使用します");
//			}

//			何らかの理由でカードが使えなかったときの処理(手札不足とか．．．)。
//			その時は、thisAbilityからtrueが返ってくるので、カードのuseableはそのままfalseにして。

			boolean cardUseable = thisAbility(player, board);
			if(cardUseable) {
//				this.setUseable(false);
				return cardUseable;
			}

//			カードが使用出来たら、カードのuseableをtrueにする。
			this.setUseable(true);
			return cardUseable;
		}
	};


//	カードの能力。  継承したクラスがここに自分の能力を記述。
	public abstract boolean thisAbility(Player player, Board board);


//	カードの使用可、使用不可
	public void useableCard(Player player, Board board) {
		this.setUseable(true);
	}

//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ method/f ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝





//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ セッターゲッター/s ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝

//カード名
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	//	カード価格
	public int getPrice() {return price;}
	public void setPrice(int price) {this.price = price;}

//	カード建設に必要なコスト
	public int getCost() {return cost;}
	public void setCost(int cost) {this.cost = cost;}

//	カード使用の有無
	public boolean isUseable() {return useable;}
	public void setUseable(boolean useable) {this.useable = useable;}

//	タイプ
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}

//	toString()
	@Override
	public String toString() {
		String bool = "";
		if(this.useable) {
			bool = "✖";
		}else {
			bool = "〇";
		}
		if(this.type.equals("施"))bool="✖";

		return "【" + type + ":" + name + ":"+price+":"+ cost + ":" + bool + "】  ";

//		慣れてくれば価格とコストは覚えれるので省略して見た目がすっきりする
//		return "【"/* + type + ":"*/ + name + ":"/*+price+":"+ cost + ":"*/ + bool + "】  ";

	}

//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ セッターゲッター/f ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝

}
