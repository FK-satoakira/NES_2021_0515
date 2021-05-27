package nc20210515_card.card_Industrial;

import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class C_I_SteelMill extends Card_Drow {

	public C_I_SteelMill() {
		super("製鉄所", 20, 4, "工", 3, 0);

	}



	@Override
	public boolean thisAbility(Player player, Board board) {
//		何故これで三枚引けるか謎?↓
//		A. return boolean useble = true;って記述してたから

//		System.out.println("デッキから３枚カードを引きます");
//		boolean useble = true;
//		for (int i = 0; i < 3; i++) {
////			M.test("C_I_SteelMill");
//			useble = super.drow_ability(player, board);
//		}
//		return useble;

		return super.drow_ability(player, board);
	}

}
