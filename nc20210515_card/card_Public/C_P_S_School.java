package nc20210515_card.card_Public;

import nc20210515_processor.Board;
import nc20210515_processor.Player;



public class C_P_S_School extends Card_School{

	public C_P_S_School() {
		super("学校", 0, 0, "公");

	}

//	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ メソッド ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝

	@Override
	public boolean thisAbility(Player player, Board board) {
		C_P_S_University univerity = null;
		for (int i = 0; i < player.getAfterFinish().size(); i++) {
			if(player.getAfterFinish().get(i) instanceof C_P_S_University) {
				univerity = (C_P_S_University)player.getAfterFinish().get(i);
			}
		}
		if(univerity!=null) {
		}
		if(univerity==null) {
		}
//		if()
		if(player.getWoker() < player.getWokerlimit() && univerity == null) {
			System.out.println("次のターンから労働者が一人増えます");
			player.add_AF(this);
			return false;
		}
		System.out.println("労働者数は上限に達しています。これ以上増やせません");
		return true;
	}

//	時間差のIInvokeを実装したものだけはinvoke()にthisAbility()に記述すべきカードの能力を記述
	@Override
	public void invoke(Player player, Board board) {
		player.plusWoker(1);
		System.out.println("労働者を一人増やしました");
	}
}
