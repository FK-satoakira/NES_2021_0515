package nc20210515_processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import nc20210515_card.Card;
import nc20210515_card.card_Agriculture.C_A_Farm;
import nc20210515_card.card_Agriculture.C_A_LargeFarm;
import nc20210515_card.card_Agriculture.C_A_Orchard;
import nc20210515_card.card_Agriculture.C_A_SlashAndBurn;
import nc20210515_card.card_Construction.C_C_ConstructionCompany;
import nc20210515_card.card_Construction.C_C_ErhuConstruction;
import nc20210515_card.card_Construction.C_C_GeneralContractor;
import nc20210515_card.card_Etc.C_Etc_DesignOffice;
import nc20210515_card.card_Etc.C_N_Pioneer;
import nc20210515_card.card_FoodAndDrink.C_F_CoffeeShop;
import nc20210515_card.card_FoodAndDrink.C_F_Restaurant;
import nc20210515_card.card_Public.Card_and_IInvoke;


public class Player {


//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ フィールド/s ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
	private int money = 5;/*資金*/
	private int woker = 2;/*労働者数*/
	private int wokerlimit = 5;/*労働者限度*/
	private int handlimit = 5;/*手札限度枚数*/
//	借金の実験をしたときに 「+の20」としたためうまくいかなかった。
//	借金テストをしたいときはマイナス(-)を忘れずに
	private int debit = 0;/*借金*/
	private List<Card> cards = new ArrayList<>();/*手札。『card;』	で記述を終わらせるのではなく、『...= new ArrayList<>();』と記述しないとリストにカードを追加できない*/
	private BoardOfPlayer boardOfPlayer = new BoardOfPlayer();/*プレイヤー側のボード*/

	private int landPrice;
	private int score;
	private List<Card_and_IInvoke> AfterFinishList = new ArrayList<>();/*発動タイミング操作のリスト型フィールド*/
//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ フィールド/f ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝




//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ コンストラクタ/s ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
	public Player(Board board) {
//		手札：デッキからランダムにカードを引いてる。
		for (int i = 0; i < 3; i++) {
			int r = new Random().nextInt(board.getDeck().getCards(board).size());
			this.plusCards(board.getDeck().getCards(board).remove(r));
//			ここをremove()にしてなかったのでダブりが起きた
		}

//		--------------------------- 手札 s------------------------------
//		---------------------------------------------------------------
//		消費財
//		for (int i = 0; i < 30; i++) {this.cards.add(new Card_Consumer());}

//		農業 4種
///*焼畑*/	this.cards.add(new C_A_SlashAndBurn());
///*農場*/	this.cards.add(new C_A_Farm());
///*果樹園*/	this.cards.add(new C_A_Orchard());
///*大農園*/	this.cards.add(new C_A_LargeFarm());

//		無記載 7種
///*開拓民*/	this.cards.add(new C_N_Pioneer());
///*設計事務*/	this.cards.add(new C_Etc_DesignOffice());
///*建設会社*/	this.cards.add(new C_C_ConstructionCompany());
///*ゼネコン*/	this.cards.add(new C_C_GeneralContractor());
///*二胡建設*/	this.cards.add(new C_C_ErhuConstruction());
///*喫茶店*/	this.cards.add(new C_F_CoffeeShop());
///*レストラン*/	this.cards.add(new C_F_Restaurant());

//		工業 4種
///*工場*/		this.cards.add(new C_I_Factory());
///*化学工場*/	this.cards.add(new C_I_ChemicalFactory());
///*製鉄所*/	this.cards.add(new C_I_SteelMill());
///*自動車工場*/this.cards.add(new C_I_CarFactory());

//		施設 9種
///*本社ビル*/	this.cards.add(new C_Faci_HeadOfficeBuilding());
///*鉄道会社*/	this.cards.add(new C_Faci_Train());
///*邸宅*/		this.cards.add(new C_Faci_Mansion());
///*労働組合*/	this.cards.add(new C_Faci_Union());
///*不動産*/	this.cards.add(new C_Faci_RealEstate());
///*不動産*/	this.cards.add(new C_Faci_RealEstate());
///*農協*/		this.cards.add(new C_Faci_AgriculturalCooperative());
///*法律事務*/	this.cards.add(new C_Faci_LawOffice());
///*社宅*/		this.cards.add(new C_Faci_CompanyHousing());
///*社宅*/		this.cards.add(new C_Faci_CompanyHousing());
///*倉庫*/		this.cards.add(new C_Faci_WareHouse());
///*倉庫*/		this.cards.add(new C_Faci_WareHouse());

//		--------------------------- 手札 f------------------------------
//		---------------------------------------------------------------


//		----------------------- プレイヤーボード s---------------------------
//		---------------------------------------------------------------
//		農業 4種

/*焼畑*/		this.boardOfPlayer.plusCards(new C_A_SlashAndBurn());
/*農場*/		this.boardOfPlayer.plusCards(new C_A_Farm());
/*果樹園*/	this.boardOfPlayer.plusCards(new C_A_Orchard());
/*大農園*/	this.boardOfPlayer.plusCards(new C_A_LargeFarm());

//		無記載 7種

/*開拓民*/	this.boardOfPlayer.plusCards(new C_N_Pioneer());
/*設計事務*/	this.boardOfPlayer.plusCards(new C_Etc_DesignOffice());
/*建設会社*/	this.boardOfPlayer.plusCards(new C_C_ConstructionCompany());
/*ゼネコン*/	this.boardOfPlayer.plusCards(new C_C_GeneralContractor());
/*二胡建設*/	this.boardOfPlayer.plusCards(new C_C_ErhuConstruction());
/*喫茶店*/	this.boardOfPlayer.plusCards(new C_F_CoffeeShop());
/*レストラン*/	this.boardOfPlayer.plusCards(new C_F_Restaurant());
//
////		工業 4種
//
///*工場*/		this.boardOfPlayer.plusCards(new C_I_Factory());
///*化学工場*/	this.boardOfPlayer.plusCards(new C_I_ChemicalFactory());
///*製鉄所*/	this.boardOfPlayer.plusCards(new C_I_SteelMill());
///*自動車工場*/this.boardOfPlayer.plusCards(new C_I_CarFactory());
////
////		施設 9種
//
///*本社ビル*/	this.boardOfPlayer.plusCards(new C_Faci_HeadOfficeBuilding());
///*鉄道会社*/	this.boardOfPlayer.plusCards(new C_Faci_Train());
///*邸宅*/		this.boardOfPlayer.plusCards(new C_Faci_Mansion());
///*労働組合*/	this.boardOfPlayer.plusCards(new C_Faci_Union());
///*不動産*/	this.boardOfPlayer.plusCards(new C_Faci_RealEstate());
///*不動産*/	this.boardOfPlayer.plusCards(new C_Faci_RealEstate());
///*農協*/		this.boardOfPlayer.plusCards(new C_Faci_AgriculturalCooperative());
///*法律事務*/	this.boardOfPlayer.plusCards(new C_Faci_LawOffice());
///*社宅*/		this.boardOfPlayer.plusCards(new C_Faci_CompanyHousing());
///*社宅*/		this.boardOfPlayer.plusCards(new C_Faci_CompanyHousing());
///*倉庫*/		this.boardOfPlayer.plusCards(new C_Faci_WareHouse());
///*倉庫*/		this.boardOfPlayer.plusCards(new C_Faci_WareHouse());

///**/		this.boardOfPlayer.getCards().add(new ());
///**/		this.boardOfPlayer.getCards().add(new ());

//			----------------------- プレイヤーボード f---------------------------
//			---------------------------------------------------------------
	}
//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ コンストラクタ/f ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
//	------------------------------------------------------------------------------



//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ メソッド/s ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝

//	boardを使う
	public boolean useboard(Player player, Board board) {
		board.useCard(this);
		return false;
	}

//	ターン終了間際に実行
	public void AfterFinish(Board board) {
		for(Card_and_IInvoke card_snd_iinvoke : AfterFinishList) {
			card_snd_iinvoke.invoke(this, board);
		}
		clear_AF();
	}

//	AF,BSを消す、clear------------
	public void clear_AF() {
		this.AfterFinishList.clear();
	}

//	AF,BSを追加する。add----
	public void add_AF(Card_and_IInvoke card_snd_iinvoke) {
		AfterFinishList.add(card_snd_iinvoke);
	}

	public List<Card_and_IInvoke> getAfterFinish() {
		return AfterFinishList;
	}
//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ メソッド/f ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝



//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ ゲッター・セッター/s ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ getter&setter/s ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
//	労働者
	public int getWoker() {return woker;}
	public void setWoker(int woker) {this.woker = woker;}
	public void plusWoker(int woker) {this.woker += woker;}


//	労働者制限
	public int getWokerlimit() {return wokerlimit;}
	public void plusWokerlimit(int wokerlimit) {this.wokerlimit += wokerlimit;}
	public void clearWokerlimit() {this.wokerlimit = 5;}


//	資金
	public int getMoney() {return money;}
	public void plusMoney(int money) {
		this.money += money;
		if(this.money<0) {
			plusDebit(this.money);
			this.money = 0;
		}
	}


//	借金...【ここ重要】小から大を引けば自然とマイナスになるのでここでは特別な処理はしていない。だからスコアもただ借金を足せばいい。
	public int getDebit() {
		return debit;
	}
	public void setDebit(int debit) {
		this.debit = debit*3;
	}
	public void plusDebit(int debit) {
		this.debit += debit*(3);
	}
	public void clearDebit() {
		this.debit = 0;
	}

//	手札
	public List<Card> getCards() {return cards;}
	public void plusCards(Card card) {this.cards.add(card);	}
	public void setCards(List<Card> cards) {this.cards = cards;	}
//手札制限
	public int getHandlimit() {return handlimit;}
	public void plusHandlimit(int handlimit) {this.handlimit += handlimit;}
	public void clearHandlimit() {this.handlimit = 5;}
//プレイヤーフィールド
	public BoardOfPlayer getBoardOfPlayer() {
		return boardOfPlayer;
	}
	public void plusBoardOfPlayer(Card card) {
		this.boardOfPlayer.getCards().add(card);
	}
	public void setBoardOfPlayer(BoardOfPlayer boardOfPlayer) {
		this.boardOfPlayer = boardOfPlayer;
	}

//	土地の合計価格
	public int getLand() {setLand();return landPrice;}
	public void setLand() {
		int totalPrice = 0;
		for (int i = 0; i < boardOfPlayer.getCards().size(); i++) {
			totalPrice += boardOfPlayer.getCards().get(i).getPrice();
		}
		this.landPrice = totalPrice;
	}

//スコア
	public int getScore(FacilityCalc f) {setScore(f);return score;}
	public void setScore(FacilityCalc f) {
		this.score = f.getAllBonus()+this.landPrice+this.money;
	}

	@Override
	public String toString() {
		return ""+ cards;
	}

}