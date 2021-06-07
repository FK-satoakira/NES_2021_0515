package nc20210515_processor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nc20210515_card.Card;



public class MoneyCalc {

	public void moneyCalc(Player player, Board board, int turn) {
		/*仮捨てカード*/
		List<Card> TemporaryCards = new ArrayList<>();
		/*プレイヤーボードのカード一覧をcopyPlayerCardsに渡してる*/
//		List<Card> copyBoardOPlayer = new ArrayList<>(player.getBoardOfPlayer().getCards());
//		売るカードのインデックス番号
		List<Integer> index = new ArrayList<>();
		/*そのターンの一人当たり給料*/
		int perPerson = 0;

		if(turn<3) {perPerson = 2;}
		else if (turn < 6) {perPerson = 3;}
		else if (turn < 8) {perPerson = 4;}
		else {perPerson = 5;}

		int salary = player.getWoker()*perPerson;/*支払金額。wokerについてはplayerのフィールドを参照*/
		int shortfall = 0;/*残高*/
		int playerMoney = player.getMoney();/*資金*/
		int totalPrice = 0;/*売るカードの値段*/

//		System.out.println(turn+"目ターン終了");

		boolean roop_on = true;
		while (true) {
//			【パターン1		資金が足りてる】
			if(playerMoney >= salary) {
				player.plusMoney(-salary);board.plusHousehold(salary);
				System.out.println(salary+"ドルを資金から家計に入れます");break;
			}

//			【資金不足】
			if(playerMoney < salary) {
				shortfall = salary - playerMoney;
				try {
					System.in.read();
				} catch (IOException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}

//				売るカードの価格の配列。ここに記述してる理由は、過剰転売のときにまた初期化するため。
				List<Integer> priceArray = new ArrayList<>();
				while(totalPrice < shortfall) {
					boolean board_empty = false;/*プレイヤーボード空ならtrue*/
					boolean AllFacility = true;/*施設カードだけならtrue*/
					boolean canSoldCard = false;/*焼畑カードだけならtrue*/
//					【パターン2		資金不足	&&	プレイヤーボード空】
					if (player.getBoardOfPlayer().getCards().size() == 0) {
						board_empty = true;
					}

//					一つでも施設以外のカードがあればAllFacilityがtrueになる処理
					for (int i = 0; i < player.getBoardOfPlayer().getCards().size(); i++) {

//						施設以外のカードだけif文に入る
						if(!player.getBoardOfPlayer().getCards().get(i).getType().equals("施")) {
							AllFacility = false;

//							焼畑以外のカードならif文に入る
							if(!player.getBoardOfPlayer().getCards().get(i).getName().equals("焼畑")) {
								canSoldCard = true;
							}
						}
					}

//					「プレイヤーボード空」  or 「 すべて施設」 or 「焼畑だけ」 or 「焼畑+施設」 の場合、
//					要するに売るカードがない場合
					if((board_empty || AllFacility) || !canSoldCard ) {
//						【パターン3 	転売可能カードが途中で不足するときも兼ねてる】
//						一回目のTemporaryCardsは必ず空

//						ここいらない気がする20210522
//						if(!TemporaryCards.isEmpty()) {
//							for (int i = 0; i < TemporaryCards.size(); i++) {
//								player.plusMoney(TemporaryCards.get(i).getPrice());
//								board.plusCardsSet(TemporaryCards);
//							}
//						}

//						カードを売ったが、給料分に足りず、かつ、もう売れるカードがなくなった時、かつ、2周目の時
						if(!TemporaryCards.isEmpty()) {
							board.plusCardsSet(TemporaryCards);
							player.plusMoney(totalPrice);
							TemporaryCards.clear();

						}
						if(player.getMoney() > 0) {
							System.out.println(player.getMoney()+"ドルを家計に入れます");
						}
						board.plusHousehold(player.getMoney());
						player.plusMoney(-salary);
//						totalPrice=0;salary=0;
						System.out.println("未払い分の"+player.getDebit()+"ドルが借金に加算されます");
						roop_on=false; break;

					}
//					ok
					System.out.println(shortfall-totalPrice + "ドル分のカードを転売してください");
//					Message.playerBoard(player);System.out.print("sksksksksks");
					int num = board.SelectFromPlayerBoard(player);
					if(player.getBoardOfPlayer().getCards().get(num).getType().equals("施")) {
						System.out.println("施設カードは売れません");
						continue;
					}
					if(player.getBoardOfPlayer().getCards().get(num).getName().equals("焼畑")) {
						System.out.println("焼畑カードは売れません");
						continue;
					}


//					<転売カードを除去、仮箱入れ、合計価格箱入れ>
					Card sell_card = player.getBoardOfPlayer().getCards().remove(num);
					index.add(num);
					TemporaryCards.add(sell_card);

//					カードの価格を半分にしてpriceArrayに入れる
					priceArray.add(sell_card.getPrice()/2);

//					降順にしてる
					Collections.sort(priceArray, Collections.reverseOrder());
//					for (int i = 0; i <  priceArray.size(); i++) {
//						System.out.println(priceArray.get(i));
//					}

//					priceArray...転売カードの価格のリスト
//					sell_card...カード(一枚ずつの売りに選択したカード)
//					totalsellCardprice...合計額(売りに選択したカードの)

//					【過剰転売防止】
					totalPrice = 0;
					for (int i = 0; i < priceArray.size(); i++) {

//						ここでtotalPriceに合計金額として代入
						totalPrice += priceArray.get(i);

//						ここで過剰転売を防ぐ
						if(totalPrice >= shortfall && i < TemporaryCards.size()-1) {
							System.out.println("過剰転売です。やり直してください。");

//							過剰転売の場合、それに付随してものをここでリセットする

//							一度プレイヤーボードをすべて消す
//							TemporaryCards.clear();

//							プレイヤーボードを丸ごとコピーしたものをプレイヤーボードに入れる。
							for (int j =index.size()-1 ; j >= 0 ; j--) {
								player.getBoardOfPlayer().getCards().add(index.remove(j),TemporaryCards.remove(j));
							}
							priceArray.clear();
							totalPrice = 0;
							System.out.println("POBsize"+player.getBoardOfPlayer().getCards().size());
							System.out.println("Tsize"+TemporaryCards.size());
							System.out.println("Psize"+priceArray.size());
							System.out.println("totalPrice"+totalPrice);

						}
					}

//					カードを売って足りた場合
					if(totalPrice >= shortfall) {
						player.plusMoney(totalPrice);
						board.plusHousehold(salary);
						player.plusMoney(-salary);
						board.plusCardsSet(TemporaryCards);

						for (int i = 0; i < TemporaryCards.size(); i++) {
							System.out.print(TemporaryCards.get(i).getName()+" "+(TemporaryCards.get(i).getPrice()/2)+"$,");
						}

						System.out.print("を転売しました。");
						System.out.println(salary+"ドルを資金から家計に入れます");
						roop_on=false;
						break;
					}
				}
//				try {
//					System.in.read();
//				} catch (IOException e1) {
//					// TODO 自動生成された catch ブロック
//					e1.printStackTrace();
//				}
				if(!roop_on) break;
			}
		}

	}
}
