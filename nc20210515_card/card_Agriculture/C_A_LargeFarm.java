package nc20210515_card.card_Agriculture;

import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class C_A_LargeFarm extends Card_Agriculture {

	public C_A_LargeFarm() {
		super("大農園", 12, 3);
	}

	@Override
	public boolean thisAbility(Player player, Board board) {
		System.out.println(this.getName()+"を使用します");
		for (int i = 0; i < 3; i++) {
			super.thisAbility(player, board);
		}
		System.out.println("消費財を3枚引きました");
		return false;
	}
}
