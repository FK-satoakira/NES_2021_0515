package nc20210515_processor;

import java.util.ArrayList;
import java.util.List;

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
import nc20210515_card.card_Facilities.C_Faci_AgriculturalCooperative;
import nc20210515_card.card_Facilities.C_Faci_CompanyHousing;
import nc20210515_card.card_Facilities.C_Faci_HeadOfficeBuilding;
import nc20210515_card.card_Facilities.C_Faci_LawOffice;
import nc20210515_card.card_Facilities.C_Faci_Mansion;
import nc20210515_card.card_Facilities.C_Faci_RealEstate;
import nc20210515_card.card_Facilities.C_Faci_Train;
import nc20210515_card.card_Facilities.C_Faci_Union;
import nc20210515_card.card_Facilities.C_Faci_WareHouse;
import nc20210515_card.card_FoodAndDrink.C_F_CoffeeShop;
import nc20210515_card.card_FoodAndDrink.C_F_Restaurant;
import nc20210515_card.card_Industrial.C_I_CarFactory;
import nc20210515_card.card_Industrial.C_I_ChemicalFactory;
import nc20210515_card.card_Industrial.C_I_Factory;
import nc20210515_card.card_Industrial.C_I_SteelMill;
import nc20210515_card.card_Public.C_P_C_Carpenter;
import nc20210515_card.card_Public.C_P_D_Mine;
import nc20210515_card.card_Public.C_P_S_School;




public class Board {

	private List<Card> cards = new ArrayList<>();
	private Trash trashCard = new Trash();
	private Deck deck = new Deck();
	private int household = 0;

//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ constructa ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝

	public Board() {
//		for (int i = 0; i < 2; i++) {
//			this.cards.add(new C_I_Factory());
//		}

//		this.cards.add(new ());
//		this.cards.add(new C_C_GeneralContractor());
//		this.cards.add(new C_C_ConstructionCompany());
//		this.cards.add(new C_C_ErhuConstruction());
		this.cards.add(new C_P_D_Mine());
		this.cards.add(new C_P_C_Carpenter());
		this.cards.add(new C_P_S_School());
		this.cards.add(new C_A_Farm());

//		this.cards.add(new C_P_E_Stall());/*露店 2*/
//		this.cards.add(new C_P_E_market());/*市場 3*/
//		this.cards.add(new C_P_S_HighSchool());/*高等学校 4*/
//		this.cards.add(new C_P_E_Supermarket());/*スーパーマーケット 5*/
//		this.cards.add(new C_P_S_University());/*大学 6*/
//		this.cards.add(new C_P_E_DepartmentStore());/*百貨店 7*/
//		this.cards.add(new C_P_S_Vocational());/*専門学校 8*/
//		this.cards.add(new C_P_E_Expo());/*万博 9*/
//		this.cards.add(new C_A_Farm());
//		this.cards.add(new C_A_LargeFarm());
//		this.cards.add(new C_A_Orchard());
//		this.cards.add(new C_I_SteelMill());
//		this.cards.add(new C_I_ChemicalFactory());
//		this.cards.add(new C_I_CarFactory());
//		this.cards.add(new C_Etc_DesignOffice());
//		this.cards.add(new C_I_DesignOffice());

//		ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
//		全部で63枚になるようにデッキを構成している。
//		このゲームで使用するすべてのカードを生成し、デッキに挿入してる

//		農業系14枚
/*焼畑*/		this.deck.plusCards(new C_A_SlashAndBurn());
/*農場*/		for (int i = 0; i < 6; i++) {this.deck.plusCards(new C_A_Farm());}
/*果樹園*/	for (int i = 0; i < 4; i++) {this.deck.plusCards(new C_A_Orchard());}
/*大農園*/	for (int i = 0; i < 3; i++) {this.deck.plusCards(new C_A_LargeFarm());}

//		無記載系15枚
//			無(3)
/*開拓民*/	for (int i = 0; i < 2; i++) {this.deck.plusCards(new C_N_Pioneer());}
/*設計事務*/ for (int i = 0; i < 1; i++) {this.deck.plusCards(new C_Etc_DesignOffice());}

//		無記載系(建築)(9)
/*建設会社*/	for (int i = 0; i < 4; i++) {this.deck.plusCards(new C_C_ConstructionCompany());}/*建設8*/
/*ゼネコン*/	for (int i = 0; i < 3; i++) {this.deck.plusCards(new C_C_GeneralContractor());}
/*二胡建設*/	for (int i = 0; i < 2; i++) {this.deck.plusCards(new C_C_ErhuConstruction());}

//		無記載系(飲食・家計)(3)
//		this.deck.plusCards(new C_F_CoffeeShop());
/*喫茶店*/	for (int i = 0; i < 1; i++) {this.deck.plusCards(new C_F_CoffeeShop());} /*家計4*/
/*レストラン*/	for (int i = 0; i < 2; i++) {this.deck.plusCards(new C_F_Restaurant());}

//		工業系18枚
/*工場*/		for (int i = 0; i < 6; i++) {this.deck.plusCards(new C_I_Factory());} /*工業18*/
/*化学工場*/	for (int i = 0; i < 4; i++) {this.deck.plusCards(new C_I_ChemicalFactory());}
/*製鉄所*/	for (int i = 0; i < 4; i++) {this.deck.plusCards(new C_I_SteelMill());}
/*自動車工場*/for (int i = 0; i < 4; i++) {this.deck.plusCards(new C_I_CarFactory());}


//	施設系16枚
//			(コスト大かつ一枚だけ順)6枚
/*本社ビル*/	this.deck.getCards(this).add(new C_Faci_HeadOfficeBuilding());
/*鉄道会社*/	this.deck.getCards(this).add(new C_Faci_Train());
/*邸宅*/		this.deck.getCards(this).add(new C_Faci_Mansion());
/*労働組合*/	this.deck.getCards(this).add(new C_Faci_Union());
/*農協*/		this.deck.getCards(this).add(new C_Faci_AgriculturalCooperative());/*これはミスではなく農協。ゲーム終了時に消費財分だけスコアが上がる*/
/*法律事務*/	this.deck.getCards(this).add(new C_Faci_LawOffice());

//			(複数枚)(10)
/*社宅*/		for (int i = 0; i < 4; i++) {this.deck.getCards(this).add(new C_Faci_CompanyHousing());}
/*不動産*/	for (int i = 0; i < 2; i++) {this.deck.getCards(this).add(new C_Faci_RealEstate());}
/*倉庫*/		for (int i = 0; i < 4; i++) {this.deck.getCards(this).add(new C_Faci_WareHouse());}

//		for (int i = 0; i < 2; i++) {this.deck.getCards(this).add(new ());}
//		this.deck.getCards(this).add(new ());


//		デッキ生成 & デッキ枚数指定
//		for (int i = 0; i < 50; i++) {
//			this.deck.plusCards(new C_I_Factory());
//		}
	}
//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ constructa ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝


//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ method/s＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
//	カードのabilityを使う
	public void useCard(Player player) {
//		ボードかプレイヤーボードかを選択
		boolean onroop = true;

		while(onroop) {
//			try {
				Message.playerCard(player);
//				［ボード］を使用する場合は[1]、
//				［マイボード］を使用する場合は[2]を選択してください

				Message.Board_Or_PlayerBoard();
				Message.board(this);
				Message.playerBoard(player);
				int numberB_or_PB = GameBoard_Or_PlayerBoard(player);/*なぜintを返しる？→A.	GameBoardかPlayerBoardを選んで0ならボード、１ならプレイヤーボードにswitchしてる*/
//				switch文に慣れていないので、メモする。bｒeakが無いと無限ループ
				switch(numberB_or_PB) {

//				---------boradから選んでる----------
					case 0:
						Message.CardChoice();
//						Message.board(this);
						int boardCard = SelectFromBoard(player);

//						＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝  ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
//						if(boardCard==-1) {
//							System.out.println("ボードを選び直します");continue;
//						}
//						＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝  ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝

//						boardCard=(数値)のボードカードを使用している
						onroop = this.cards.get(boardCard).ability(player, this);
//						System.out.println(onroop);
						break;

//				---------player.boradから選んでる----------
					case 1:
						if(player.getBoardOfPlayer().getCards().size()==0) {
							System.out.println("プレイヤーボードは空です");Message.retry();continue;
						}
						int count = 0;
						for (int i = 0; i < player.getBoardOfPlayer().getCards().size(); i++) {
							String type = player.getBoardOfPlayer().getCards().get(i).getType();
							if(!type.equals("施")) {
								count++;
							}
						}
						if(count==0) {
							System.out.println("プレイヤーボードは施設カードしかありません");continue;
						}
						Message.CardChoice();
//						Message.playerBoard(player);
						int playerBoardCard = SelectFromPlayerBoard(player);

//						＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝  ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
//						if(playerBoardCard==-1) {
//							System.out.println("ボードを選び直します");continue;
//						}
//						＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝  ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝


//						playerBoardCard=(数値)のボードカードを使用している
						onroop = player.getBoardOfPlayer().getCards().get(playerBoardCard).ability(player, this);
//						焼畑の場合プレイヤーフィールドから消す
						if(player.getBoardOfPlayer().getCards().get(playerBoardCard).getName().equals("焼畑")) {
							this.plusTrashCard(player.getBoardOfPlayer().getCards().remove(playerBoardCard));
						}
						break;
					default:
						System.out.println("もう一度やり直してください");
						continue;
				}
//			} catch (Exception e) {
//				Message.DifferentType(e);
//				continue;
//			}
		}
	}
//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ method/f＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝


//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝どこからカードを選ぶか＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ method/s＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
//	手札からカードを選択
	public int SelectFromPlayerCard(Player player) {
		int number = 0;
		boolean onRoop = true;
		while(onRoop) {
			//ここでは単に手札範囲内から正しく選んでいるかどうかの記述
			try {
//				Message.CardChoice();
				Message.playerCard(player);/*手札を表示*/
				int num = new java.util.Scanner(System.in).nextInt();

				number = num-1;

//				＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝  ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
//				if(number==-1) {
//					return number;
//				}
//				＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝  ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝

				if(number < 0 || number+1 > player.getCards().size()) {
					Message.rengeOver();continue;
				}else if(!(number < 0 || number+1 > player.getCards().size())) {
					onRoop = false;
					return number;/*onRoop=trueで永遠にwhile文はが回るので、ここでfalseにして(正しく手札内から選んで)whileから抜け出してる*/
				}
			} catch (Exception e) {
//				e.printStackTrace();
//				Message.DifferentType(e);
				Message.retry();
				System.out.println("");
//				Message.playerCard(player);
				continue;
			}
		}
		return number;
	}
//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ method/f＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝


//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ method/s＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
//	ボードからカードを選択
	public int SelectFromBoard(Player player) {
		int number = 0;
		boolean onRoop = true;
		Message.board(this);
		while(onRoop) {
			try {
				int num = new java.util.Scanner(System.in).nextInt();
				number = num-1;

//				＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝  ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
//				if(number==-1) {
//					return number;
//				}
//				＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝  ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝

				if(number < 0 || number+1 > this.getCards().size()) {
					Message.rengeOver();continue;
				}else if(!(number < 0 || number+1 > this.getCards().size())) {
					onRoop = false;return number;
				}
			} catch (Exception e) {
//				e.printStackTrace();
//				Message.DifferentType(e);
				Message.retry();
				System.out.println("");
//				Message.board(this);
				continue;
			}
		}
		return number;
	}
//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ method/f＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝

//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ method/s＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
//	プレイヤーボードからカードを選択
	public int SelectFromPlayerBoard(Player player) {
		int number = 0;
		boolean onRoop = true;
		Message.playerBoard(player);

		while(onRoop) {
			try {
				int num = new java.util.Scanner(System.in).nextInt();

				number = num-1;

//				＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝  ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
//				if(number==-1) {
//					return number;
//				}
//				＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝  ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝

				if(number < 0 || number+1 > player.getBoardOfPlayer().getCards().size()) {
					Message.rengeOver();continue;
				}else if(!(number < 0 || number+1 > player.getBoardOfPlayer().getCards().size())) {
					onRoop = false;return number;
				}
			} catch (Exception e) {
//				e.printStackTrace();
//				Message.DifferentType(e);
				Message.retry();
				System.out.println("");
//				Message.playerBoard(player);
				continue;
			}
		}
		return number;
	}
//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ method/f＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝

//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ method/s＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
//	ボードかプレイヤーボードかを選択
	public static int GameBoard_Or_PlayerBoard(Player player) {
		int number = 0;
		boolean onRoop = true;
		while(onRoop) {
			try {
				int num = new java.util.Scanner(System.in).nextInt();
				number = num-1;
				if(number < 0 || number > 1) {
					Message.rengeOver();continue;
				}else if(!(number < 0 || number > 1)) {
					onRoop = false;return number;
				}
			} catch (Exception e) {
//				e.printStackTrace();
//				Message.DifferentType(e);
				Message.retry();
				System.out.println("");
				Message.Board_Or_PlayerBoard();
				continue;
			}
		}
		return number;
	}
//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ method/f＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝


//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ getter/setter＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
//	ボード
	public List<Card> getCards() {return cards;	}
	public void plusCards(Card card) {this.cards.add(card);}
	public void setCards(List<Card> cards) {this.cards = cards;}
	public void plusCardsSet(List<Card> cards) {
		for (int i = 0; i < cards.size(); i++) {
			this.cards.add(cards.get(i));
		}
	}

//	トラッシュ
	public Trash getTrashCard() {return trashCard;}
	public void plusTrashCard(Card card) {
		this.trashCard.getCards().add(card);
		this.trashCard.plusCard(card,this);

	}

//		これは試し------------------
//	this.trashCard.plusCard(card, this);
//	-----------------------------------

	public void setTrashCard(Trash trashCard) {this.trashCard = trashCard;}

//	デッキが空になったらトラッシュから新たにデッキを作る
	public Deck getDeck() {return deck;}
	public void plusDeck(Card card) {this.deck.getCards(this).add(card);}
	public void setDeck(Deck deck) {this.deck = deck;}

//	家計
	public int getHousehold() {return household;}
	public void plusHousehold(int household) {this.household += household;}
	public void setHousehold(int household) {this.household = household;}


//	toString
	@Override
	public String toString() {
//		return "ボード: " + cards;
		return "";
	}
}
