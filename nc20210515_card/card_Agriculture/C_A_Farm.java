package nc20210515_card.card_Agriculture;

import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class C_A_Farm extends Card_Agriculture {

	public C_A_Farm() {
		super("農場", 6, 1);
	}

	@Override
	public boolean thisAbility(Player player, Board board) {
		System.out.println(this.getName()+"を使用します");
		for (int i = 0; i < 2; i++) {
			super.thisAbility(player, board);
		}
		System.out.println("消費財を2枚引きました");
		return false;
	}
}
