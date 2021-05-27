package nc20210515_card.card_Construction;

import java.util.List;

import nc20210515_card.Card;
import nc20210515_processor.Board;
import nc20210515_processor.Message;
import nc20210515_processor.Player;

public class C_C_ConstructionCompany extends Card {

	public C_C_ConstructionCompany() {
		super("建設会社", 10, 2);this.setType("無");

	}

	@Override
	public boolean thisAbility(Player player, Board board) {
		//	if(playerCards.size()==0) {System.out.println("手札がありません");return true;}
		if (player.getCards().size() == 0) {
			System.out.println("手札がありません");
			return true;
		}

		System.out.println(this.getName()+"を使用します");
		System.out.println("このカードは一つ少ないコストでカードを建設できます");
		Message.playerCard(player);
		int num = board.SelectFromPlayerCard(player);/*手札から建設するカードを選択*/
		List<Card> playerCards = player.getCards();

		if (playerCards.get(num).getCost() - 1 >= player.getCards().size()) {
			System.out.println(playerCards.get(num).getName() + "を建設するには手札が足りません");
			return true;
		}

		if (playerCards.get(num).getType().equals("0")) {
			System.out.println("消費財は建設不可です");
			return true;
		}

//		成功パターン
		Card buildCard = playerCards.remove(num);
		player.plusBoardOfPlayer(buildCard);
		Message.BuildPlans(buildCard);
		int count = 0;
		int trashnum = buildCard.getCost() - 1;
		for (int i = 0; i < trashnum; i++) {
			Message.CardChoiceTrash(trashnum - count);
			Message.playerCard(player);
			int trashCard = board.SelectFromPlayerCard(player);
			board.plusTrashCard(player.getCards().remove(trashCard));
			count++;
		}
		//	this.setOn(false);
		return false;
	}

}
