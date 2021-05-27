package nc20210515_card.card_Agriculture;

import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class C_A_SlashAndBurn extends Card_Agriculture {

	public C_A_SlashAndBurn() {
		super("焼畑", 0, 1);

	}

	@Override
	public boolean thisAbility(Player player, Board board) {
		System.out.println(this.getName()+"を使用します");
		System.out.println("消費財を5枚引きました。このカードは使用すると自動で消滅します");

		for (int i = 0; i < 5; i++) {
			super.thisAbility(player, board);
		}
		return false;
	}

}
