package nc20210515_card.card_Etc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import nc20210515_card.Card;
import nc20210515_processor.Board;
import nc20210515_processor.Message;
import nc20210515_processor.Player;


public class C_Etc_DesignOffice extends Card {

	public C_Etc_DesignOffice() {
		super("設計事務", 8, 1);this.setType("無");

	}

	@Override
	public boolean thisAbility(Player player, Board board) {
		System.out.println(this.getName()+"を使用します");
		List<Card> card5 = new ArrayList<>();
		
//		5つのcard5リストに入れてる
		for (int i = 0; i < 5; i++) {
			int r = new Random().nextInt(board.getDeck().getCards(board).size());
			card5.add(board.getDeck().getCards(board).remove(r));
			System.out.print("("+(i+1)+") "+card5.get(i));
		}
		
		System.out.println("");
		int number = 0;
		boolean onRoop = true;
		while(onRoop) {
			try {
				System.out.println("上に表示されてる5枚の中から一枚手札に加えるカードを選んでください");
				int num = new java.util.Scanner(System.in).nextInt();
				number = num-1;
				if(number < 0 || number+1 > card5.size()) {
					Message.rengeOver();continue;
				} else /*if(!(number < 0 || number+1 > card5.size()))*/ {
					player.plusCards(card5.remove(number));
//					card5.clear();
					board.plusTrashCard(card5.remove(0));
					board.plusTrashCard(card5.remove(0));
					board.plusTrashCard(card5.remove(0));
					board.plusTrashCard(card5.remove(0));
					onRoop = false;
				}
			} catch (Exception e) {
				e.printStackTrace();
				Message.DifferentType(e);
				Message.retry();
				continue;
			}
		}
		return false;
	}

}
