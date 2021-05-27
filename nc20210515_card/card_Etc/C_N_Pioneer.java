package nc20210515_card.card_Etc;

import java.util.List;

import nc20210515_card.Card;
import nc20210515_processor.Board;
import nc20210515_processor.Player;

public class C_N_Pioneer extends Card {

	public C_N_Pioneer() {
		super("開拓民", 14, 3, "無");

	}

	@Override
	public boolean thisAbility(Player player, Board board) {
		List<Card> pc = player.getCards();
		int count = 0;
		for (int i = 0; i < pc.size(); i++) {
			if (pc.get(i).getType().equals("農")) {
				count++;
			}
		}
		if (count == 0) {
			System.out.println("手札に「農業」タイプのカードはありません");
			return true;
		}

		System.out.println("建設する、「農業」タイプカードを選択してください");

		int buildAgr = board.SelectFromPlayerCard(player);
		if (!pc.get(buildAgr).getType().equals("農")) {
			System.out.println("「農業」タイプ以外は建設できません");
			return true;
		}
		System.out.println(pc.get(buildAgr).getName()+"を建設します");
		player.plusBoardOfPlayer(pc.remove(buildAgr));

		return false;
	}

}
