package nc20210515_processor;

public class ScoreCalc {

	private Player player;
	private FacilityCalc facilityCalc;
	private Board board;

	public ScoreCalc(Player player, FacilityCalc facilityCalc, Board board) {
		super();
		this.player = player;
		this.facilityCalc = facilityCalc;
		this.board = board;
	}


	public int getScore() {
		return player.getDebit()+player.getMoney()+player.getLand()+facilityCalc.getAllBonus();
	}

	public String AllScore() {
		return "[スコア:"+getScore()+" デッキ"+board.getDeck().getCards().size()+"  労働者数:"+player.getWoker()+"  家計:"+board.getHousehold()+
				"  資金:"+player.getMoney()+"  土地数:"+player.getBoardOfPlayer().getCards().size()+"  土地価格:"+player.getLand()+
				"  借金:"+player.getDebit()+"  ボーナス:"+facilityCalc.getAllBonus()+"]";
	}

	public String eachBonus() {
		return "[本社ビル:"+facilityCalc.getBonusHeadOfficeBuilding()+"  鉄道会社:"+facilityCalc.getBonusTrain()+
				"  労働組合:"+facilityCalc.getBonusUnion()+"  不動産:"+facilityCalc.getBonusRealEstate()+
				"  農協:"+facilityCalc.getBonusAgriculturalCooperative()+
				"  法律事務所:"+facilityCalc.getBonusLawOffice()+"]";
	}

}
