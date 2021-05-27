package nc20210515_card.card_Public;

import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class C_P_S_University extends Card_School {

	public C_P_S_University() {
		super("大学", 0, 0, "公");

	}

	@Override
	public boolean thisAbility(Player player, Board board) {

		//		単に5人以上いる
		if (player.getWoker() >= 5) {
			System.out.println("既に労働者が5人以上いるのでこのカードは使えません");
			System.out.println("5人");
			return true;
		}

		//		4人 && 「学校」 を使用
		if (player.getWoker() >= 4) {
			for (int i = 0; i < board.getCards().size(); i++) {
				if (board.getCards().get(i).getName().equals("学校")) {
					if (board.getCards().get(i).isUseable()) {
						System.out.println("既に労働者が5人以上いるのでこのカードは使えません");
						System.out.println("学校");
						return true;
					}
				}
			}
		}

		//		「高校」+「学校」 を使用(この順番のときだけNG)
		int schoolIndexNumber = 0;
		int highschoolIndexNumber = 0;
		Card_School school = null;/*new Card_School();*/
		Card_School highschool = null;/*new Card_School();*/
		for (int s = 0,hs = 0; s < player.getAfterFinish().size(); s++,hs++) {
			if(player.getAfterFinish().get(s) instanceof Card_School) {
				school = (Card_School)player.getAfterFinish().get(s);
				schoolIndexNumber = s;
			}
			if(player.getAfterFinish().get(hs) instanceof Card_School) {
				highschool = (Card_School)player.getAfterFinish().get(hs);
				highschoolIndexNumber = hs;
			}
		}
		if((school!=null && highschool!=null) && (schoolIndexNumber>highschoolIndexNumber) ) {
			System.out.println("既に労働者が5人以上いるのでこのカードは使えません");System.out.println("「高校」+「学校」 ");
		}

		System.out.println("次のターンから労働者が5人になります");
		player.add_AF(this);
		return false;
	}

	@Override
	public void invoke(Player player, Board board) {
		player.setWoker(5);
		System.out.println("労働者が5人になりました");
	}

}