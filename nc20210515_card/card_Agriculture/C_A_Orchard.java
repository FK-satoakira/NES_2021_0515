package nc20210515_card.card_Agriculture;

import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class C_A_Orchard extends Card_Agriculture{

	public C_A_Orchard() {
		super("果樹園", 10, 2);

	}

	@Override
	public boolean thisAbility(Player player, Board board) {
		int count = 0;
		if(player.getCards().size()>=4) {
			System.out.println("手札に4枚以上カードがあるので使えません");

//			手札4枚以上カードだと使用できないのでカードのuseableはfalseのまま保ちたいので。
//			本来なら、Card.jacvaのability()で自動でtrueになるのをここでfalseにし直してる。
//			this.setUseable(false);
			return true;
		}else {
			while(player.getCards().size()<4) {
				super.thisAbility(player, board);
				count++;
			}
		}
		System.out.println(this.getName()+"を使用します");
		System.out.println("消費財を"+count+"枚引きました");
		return false;
	}
}
