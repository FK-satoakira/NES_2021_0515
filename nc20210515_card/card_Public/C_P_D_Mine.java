package nc20210515_card.card_Public;

import java.util.Random;

import nc20210515_card.Card;
import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class C_P_D_Mine extends Card{

public C_P_D_Mine() {
		super("鉱山", 0, 0, "公");
	}
//	public C_Public_Mine() {
//		this.setName("鉱山");
//	}


//	どうして鉱山はこの記述で何回も使えるのか不思議だったが、解明した。
//	ability()をこのクラスでオーバーライドし-→親のCard.javaのability()は不発動→
//	このクラスのability()は発動-→ここのability()にはCardのuseableをいじってないから、falseのまま。
//	-→だけど、thisAbility()のリターンのbooleanはfalseだから何回も使える状態で1ターン分と認められてる
	@Override
	public boolean ability(Player player, Board board) {
		return thisAbility(player, board);
	}


	@Override
	public boolean thisAbility(Player player, Board board) {
		System.out.println("山札から１枚カードを引きます");
		int r = new Random().nextInt(board.getDeck().getCards(board).size());
		player.plusCards(board.getDeck().getCards(board).remove(r));
//		drow_ability(player, board);
		return false;
	}


}
