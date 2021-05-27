package nc20210515_processor;

import nc20210515_card.card_Public.C_P_E_DepartmentStore;
import nc20210515_card.card_Public.C_P_E_Expo;
import nc20210515_card.card_Public.C_P_E_Stall;
import nc20210515_card.card_Public.C_P_E_Supermarket;
import nc20210515_card.card_Public.C_P_E_market;
import nc20210515_card.card_Public.C_P_S_HighSchool;
import nc20210515_card.card_Public.C_P_S_University;
import nc20210515_card.card_Public.C_P_S_Vocational;

public class Main {

	public static void main(String[] args) {
		Board board = new Board();
		Player player = new Player(board);
		FacilityCalc faciCalc = new FacilityCalc();
		MoneyCalc moneyCalc = new MoneyCalc();
		ScoreCalc scoreCalc = new ScoreCalc(player,faciCalc,board);

//		スコア表示
//		faciCalc.facilityCalc(player);
//		System.out.println(scoreCalc.AllScore());
//		System.out.println(scoreCalc.eachBonus());
		int turnCount = 1;

		//ターンのループ
		while (turnCount < 2) {


			if(turnCount==2) {board.plusCards(new C_P_E_Stall());}/*露店 2*/
			if(turnCount==3) {board.plusCards(new C_P_E_market());}/*市場 3*/
			if(turnCount==4) {board.plusCards(new C_P_S_HighSchool());}/*高等学校 4*/
			if(turnCount==5) {board.plusCards(new C_P_E_Supermarket());}/*スーパーマーケット 5*/
			if(turnCount==6) {board.plusCards(new C_P_S_University());}/*大学 6*/
			if(turnCount==7) {board.plusCards(new C_P_E_DepartmentStore());}/*百貨店 7*/
			if(turnCount==8) {board.plusCards(new C_P_S_Vocational());}/*専門学校 8*/
			if(turnCount==9) {board.plusCards(new C_P_E_Expo());}/*万博 9*/

			for (int i = 0; i < turnCount; i++) {
				System.out.print("◎");
			}

			System.out.println(turnCount + "ターン目---------");
			System.out.println();
			//			労働者の行動のループ
			int actionCount = 1;
			while (player.getWoker() >= actionCount) {

//				スコア表示
				faciCalc.facilityCalc(player);
				System.out.println(scoreCalc.AllScore());
				System.out.println(scoreCalc.eachBonus());

				for (int i = 0; i < actionCount; i++) {
					System.out.print("★");
				}
				System.out.println(turnCount + "ターン目,"+actionCount + "人目の行動");
				System.out.println();

				//				enterきーを押させる処理。今何人目かわかりやすくするため
				//				System.out.println("enterキーを押して次に進んでください");
				//				try {
				//					System.in.read();
				//				} catch (IOException e1) {
				//					// TODO 自動生成された catch ブロック
				//					e1.printStackTrace();
				//				}


				player.useboard(player, board);
				actionCount++;
				//				System.out.println("money"+player.getMoney());
				//				System.out.println("money"+player.getMoney());
				//				System.out.println("land"+player.getLand());
				//				System.out.println("bonus"+faciCalc.getAllBonus());
				//				System.out.println("score"+player.getScore(faciCalc));

//				一つずつ後ろからボードカードが使用不可になる
				for (int i = 0; i < board.getCards().size(); i++) {
					int index = board.getCards().size()-1-i;
					if(board.getCards().get(index).isUseable()==false) {
						board.getCards().get(index).setUseable(true);
						break;
					}
				}

				System.out.println();
			}

			//			ターン終了後に発動するカード(主に学校系)
			player.AfterFinish(board);


			//			ボードのカードのuseableをfalseにもどす
//			for (int i = 0; i < board.getCards().size(); i++) {
//				if (!board.getCards().get(i).getType().equals("施")) {
//					board.getCards().get(i).setUseable(false);
//				}
//			}
//			ボードの場合これでもいいだろう
			for (int i = 0; i < board.getCards().size(); i++) {
					board.getCards().get(i).setUseable(false);
			}

			//			プレイヤーボードのカードのuseableをfalseにもどす(施設以外)
			for (int i = 0; i < player.getBoardOfPlayer().getCards().size(); i++) {
				if (!player.getBoardOfPlayer().getCards().get(i).getType().equals("施")) {
					player.getBoardOfPlayer().getCards().get(i).setUseable(false);
				}
			}

			faciCalc.facilityCalc(player);
			System.out.println(turnCount + "ターン目終了");

//			手札枚数調整
			while (player.getCards().size() > player.getHandlimit()) {
				System.out.println("手札制限は" + player.getHandlimit() + "枚でです。あと"
						+ (player.getCards().size() - player.getHandlimit()) + "枚捨ててください");
				int trushHandCardNum = board.SelectFromPlayerCard(player);
				board.plusTrashCard(player.getCards().remove(trushHandCardNum));
			}

//			支払金の計算
			moneyCalc.moneyCalc(player, board, turnCount);
//			スコア計算
			faciCalc.facilityCalc(player);
			System.out.println(scoreCalc.AllScore());
			System.out.println(scoreCalc.eachBonus());
			if(turnCount==3) {
				System.out.println(player.getBoardOfPlayer());
			}
			System.out.println("---------------");
			System.out.println("---------------");
			System.out.println("---------------");
			turnCount++;

		}

//		スコア表示
		System.out.println("ゲーム終了です。最終スコアはこちら");
		faciCalc.facilityCalc(player);
		System.out.println(scoreCalc.AllScore());
		System.out.println(scoreCalc.eachBonus());
		player.getBoardOfPlayer().hyouji();
	}

}
