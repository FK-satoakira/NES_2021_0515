package nc20210515_processor;


import nc20210515_card.Card;

public class Message {

	public Message() {
	}
//	単に手札を表示してる
	public static void playerCard(Player player) {
		System.out.println("🔻〖手札〗: "+player.getCards().size()+"枚");
		for (int i = 0; i < player.getCards().size(); i++) {
			System.out.print("("+(i+1)+")"+player.getCards().get(i)+" ");
			if((i+1)%5==0 && i > 0) {
				System.out.print("\n");
			}
		}
		System.out.println("");		System.out.println("");

	}
//	ボードカードを表示している
	public static void board(Board board) {
		System.out.println(/*①*/ "🟢〖ボード〗: "+board.getCards().size()+"枚");
		for (int i = 0; i < board.getCards().size(); i++) {
			System.out.print("("+(i+1)+")"+board.getCards().get(i));
			if((i+1)%5==0 && i > 0) {
				System.out.print("\n");
			}
		}
//		このsysoをforループ内で書いていたため、理想道理にならなかった
		System.out.println("");		System.out.println("");

	}
//	プレイヤーボードカードを表示している
	public static void playerBoard(Player player) {
		System.out.println(/*②*/ "🟥〖プレイヤーボード〗: "+player.getBoardOfPlayer().getCards().size()+"枚");
		for (int i = 0; i < player.getBoardOfPlayer().getCards().size(); i++) {
			System.out.print("("+(i+1)+")"+ player.getBoardOfPlayer().getCards().get(i));
			if((i+1)%5==0 && i > 0) {
				System.out.print("\n");
			}
		}
		System.out.println("");

	}
//	カード
	public static void CardChoiceTrash(int trash) {
		System.out.println("捨て札を"+trash+"枚選択して下さい");
	}
	public static void CardChoice() {
		System.out.println("カードを選択してください");
	}
	public static void Choicenot() {
		System.out.println("このカードは選択できません");
	}
	public static void CardsNotEnough() {
		System.out.println("手札が足りないので使用できません");
	}
	public static void sell_Card() {
		System.out.println("カードを売ってください");
	}
//	----
//	建設系
	public static void BuildChoice() {
		System.out.println("建設するカードを選択してください");
	}
	public static void BuildPlans(Card card) {
		System.out.println(card.getName()+"を建設します");
	}
	public static void Builded(Card card) {
		System.out.println(card.getName()+"を建設しました");
	}
	public static void BuildedCannot(Card card) {
		System.out.println(card.getName()+"を建設するにはカードが足りません");
	}
//	-----
//	想定外入力
	public static void rengeOver() {
		System.out.println("範囲内の数値を入力してください");
	}
	public static void DifferentType(Exception e) {
		System.out.println("型が違います"+e);
	}
//	-----
//	やり直し
	public static void retry() {
		System.out.println("もう一度選んでください");
	}

	public static void Board_Or_PlayerBoard() {
		System.out.println("［ボード］を使用する場合は[1]、\n［マイボード］を使用する場合は[2]を選択してください");
	}
//	資金
	public static void moneyNotEnough(int m) {
		System.out.println("お金が足りません。"+m+"ドル分のカードを売ってください");
	}

	public static void explanation() {
		System.out.println("【説明】\nこのゲームはカードを建設していき高得点を目指すゲームです\n"
			+ "【無:設計事務:8:1:〇】 \n"
			+ "カードにはこのような情報が記載されています。左から\n"
			+ "[無=タイプ、設計事務=名前、8=価格、1=コスト、〇=使用の可or不可、または、転売の可or不可]\n"
			+ "カードをプレイヤーボードに建設して保持すればその価格の数値がスコアに加算されます\n"
			+ "1ターン内の行動回数は保持している労働者数で決まります。労働者数のは最大5人まで増やせます\n"
			+ "ターン終了毎に労働者分の給料を家計に支払います。"
			+ "資金不足時はプレイヤーボードのカードを転売し資金に変換して給料を支払います\n"
			+ "カードを売る場合、売値は価格の半分になります。(例)価格10$のカードを売る→資金5$プラス\n"
			+ "それでも足りないときは、借金が増えます。借金は x3 で増えていきます(例)借金5→借金15\n"
			+ "鉱山以外のカードは1ターンに1度しか使用できません。また施設タイプのカードは転売不可です。\n"
			+ "カードは各々の能力を有しており、建設されているカードの能力しか使用できません。\n"
			+ "カードの建設は手札から建設したいカードを選び、そのコスト分のカードを手札から捨てて建設します。\n"
			+ "施設カードは特殊な能力を持ち使用・転売不可です。\n"
			+ "特殊な能力とは主にボーナスポイント加算でその数値はそのままスコアに加算されます。\n"
			+ "ターン終了時に手札数が限度数を超えていたらその分手札を捨てます。\n【それぞれのカードの説明】\n"
			+ "【公:鉱山:0:0:〇】 デッキからカードを1枚手札に加えます。1ターンに何度も使用できます\n"
			+ "【公:大工:0:0:〇】 カードを建設します。\n"
			+ "【公:学校:0:0:〇】 労働者を1人増やします \n"
			+ "【公:露店:0:0:〇】 手札を1枚捨て家計から6$を資金に加えます\n"
			+ "【公:市場:0:0:〇】 手札を2枚捨て家計から12$を資金に加えます\n "
			+ "【公:高等学校:0:0:〇】  労働者数を4人にします \n"
			+ "【公:スーパー:0:0:〇】 手札を3枚捨て家計から18$を資金に加えます\n"
			+ "【公:大学:0:0:〇】  労働者数を5人にします \n"
			+ "【公:百貨店:0:0:〇】  手札を4枚捨て家計から24$を資金に加えます\n"
			+ "【公:専門学校:0:0:〇】 このターンに使用できる労働者を1人増やします \\n"
			+ "【公:万博:0:0:〇】 手札を5枚捨て家計から30$を資金に加えます\n"
			+ "【農:焼畑:0:1:〇】 消費財を5枚手札に加えます。公共ボードには売れず、使用後はマイボードから消滅します。\n"
			+ "【農:農場:6:1:〇】 消費財を2枚手札に加えます。\n "
			+ "【農:果樹園:10:2:〇】 手札が4枚になるまで消費財を加えます。手札が4枚以上のときは使用不可\n"
			+ "【農:大農園:12:3:〇】 消費財を3枚手札に加えます。\n。"
			+ "【無:開拓民:14:3:〇】 農業タイプカードを1枚コスト0で建設できます。\n"
			+ "【無:設計事務:8:1:〇】 5枚デッキからカードを引き、1枚選んで手札に加えます。\n"
			+ "【無:珈琲店:8:1:〇】 家計から5$を資金に加えます。\n"
			+ "【無:レストラン:16:3:〇】 手札を1枚捨て家計から15$を資金に加えます\n"
			+ "【無:建設会社:10:2:〇】 1つ少ないコストでカードを建設できます。\n"
			+ "【無:ゼネコン:18:4:〇】 カードを建設した後デッキからカードを2枚手札に加えます\n"
			+ "【無:二胡建設:20:5:〇】 同コスト数のカードを2つ同時に建設できます\n"
			+ "【工:工場:12:2:〇】 手札を2枚捨てデッキからカードを4枚引きます。\n"
			+ "【工:化学工場:18:4:〇】 手札が空のときは4枚、それ以外は2枚デッキからカードを引きます。\n"
			+ "【工:製鉄所:20:4:〇】 デッキからカードを3枚引きます。\n"
			+ "【工:自動車工場:24:5:〇】 手札を3枚捨てデッキからカードを7枚引きます。\n"
			+ "【施:本社ビル:20:5:✖】 プレイヤーボードの施設系カード数 x6 をボーナスに加算"
			+ "【施:鉄道:18:5:✖】 プレイヤーボードの工業系カード数 x8 をボーナスに加算 \n"
			+ "【施:邸宅:28:4:✖】 \n"
			+ "【施:労働組合:0:4:✖】 労働者数 x6 をボーナスに加算"
			+ "【施:不動産:10:3:✖】 プレイヤーボードのカード数 x3 をボーナスに加算\n"
			+ "【施:農協:12:3:✖】 ゲーム終了時の手札の消費財カード数 x3 をボーナスに加算\n"
			+ "【施:法律事務所:8:2:✖】 借金を15$まで無効にする\n"
			+ "【施:社宅:8:2:✖】 労働者限度数を +1\n"
			+ "【施:倉庫:10:2:✖】 手札限度数を +1\n"
			+ "説明が長いですが数回ゲームをやればすぐになれます。"
			+ "スコアは資金+土地資産+ボーンスの合計です。\nそれではゲームスタート！");

	}
}
