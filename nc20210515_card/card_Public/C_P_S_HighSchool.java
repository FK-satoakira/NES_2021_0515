
package nc20210515_card.card_Public;

import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class C_P_S_HighSchool extends Card_School{

	public C_P_S_HighSchool() {
		super("高等学校", 0, 0, "公");
	}

	@Override
	public boolean thisAbility(Player player, Board board) {

//		単に4人以上いる
		if(player.getWoker()>=4) {
			System.out.println("既に労働者が4人以上いるのでこのカードは使えません");
			System.out.println("4人");
			return true;
		}

//		3人 && 「学校」を使用
		if(player.getWoker()>=3) {
			for (int i = 0; i < board.getCards().size(); i++) {
				if(board.getCards().get(i).getName().equals("学校")) {
					if (board.getCards().get(i).isUseable()) {
						System.out.println("既に労働者が4人以上いるのでこのカードは使えません");
						System.out.println("学校");
						return true;
					}
				}
			}
		}

//		「大学」を使用
		for (int i = 0; i < board.getCards().size(); i++) {
			if(board.getCards().get(i).getName().equals("大学")) {
				if (board.getCards().get(i).isUseable()) {
					System.out.println("既に労働者が4人以上いるのでこのカードは使えません");
					System.out.println("大学");
					return true;
				}
			}
		}

		System.out.println("次のターンから労働者が4人になります");
		player.add_AF(this);
		return false;
	}
	@Override
	public void invoke(Player player, Board board) {
		player.setWoker(4);
		System.out.println("労働者が4人になりました");
	}


}