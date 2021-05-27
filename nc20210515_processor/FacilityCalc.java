package nc20210515_processor;

import java.util.List;

import nc20210515_card.Card;

public class FacilityCalc {

	//	施設カードのボーナス。		メソッドの引数にPlayerがある。

	/*本社ビル*/private int bonusHeadOfficeBuilding = 0;
	/*鉄道*/private int bonusTrain = 0;
	/*労働組合*/private int bonusUnion = 0;
	/*不動産*/private int bonusRealEstate = 0;
	/*農協*/private int bonusAgriculturalCooperative = 0;
	/*法律事務所*/private int bonusLawOffice = 0;
	/*倉庫*/private int bonusWareHouse = 0;
	/*社宅*/private int bonusCompanyHousing = 0;

	/*ボーナス合計*/private int AllBonus = 0;

	public FacilityCalc() {
	}

	public void facilityCalc(Player player) {
//		player.clearBonusRealEstate();
		List<Card> pbc = player.getBoardOfPlayer().getCards();
		clearBonusRealEstate();
		player.clearHandlimit();
		player.clearWokerlimit();


		for (int i = 0; i < pbc.size(); i++) {
			Card facilityCard = pbc.get(i);
			switch (facilityCard.getName()) {
			case "倉庫":
					player.plusHandlimit(4);
				break;
			case "社宅":
					player.plusWokerlimit(1);
				break;
			case "不動産":
				plusBonusRealEstate(pbc.size() * 3);
				break;
			case "労働組合":
				setBonusUnion(player.getWoker() * 6);
				break;
			case "本社ビル":
				int count = 0;
				for (int j = 0; j < pbc.size(); j++) {
					if (pbc.get(j).getType().equals("施")) {
						count++;
					}
				}
				setBonusHeadOfficeBuilding(count * 6);
				break;
			case "鉄道":
				int countT = 0;
				for (int j = 0; j < pbc.size(); j++) {
					if (pbc.get(j).getType().equals("工")) {
						countT++;
					}
				}
				setBonusTrain(countT * 8);
				break;
			case "農協":
				int countC = 0;
				for (int j = 0; j < player.getCards().size(); j++) {
					if (player.getCards().get(j).getType().equals("0")) {
						countC++;
					}
				}
				setBonusAgriculturalCooperative(countC * 3);
				break;
			case "法律事務所":
				setBonusLawOffice(player);;
				break;
			}
		}
	}

//	各々のボーナを調べるときのやつ
	public void each() {
		System.out.println("本社ビルのボーナス"+bonusHeadOfficeBuilding);
		System.out.println("鉄道会社"+bonusTrain);
		System.out.println("労働組合"+bonusUnion);
		System.out.println("不動産"+bonusRealEstate);
		System.out.println("農協"+bonusAgriculturalCooperative);
		System.out.println("法律事務所"+bonusLawOffice);
	}

//	－－－－－－－－－－－－－－－－－－ セッターゲッター －－－－－－－－－－－－－－－－－－

	//	本社
	public int getBonusHeadOfficeBuilding() {return bonusHeadOfficeBuilding;}
	public void setBonusHeadOfficeBuilding(int bonusHeadOfficeBuilding) {
		this.bonusHeadOfficeBuilding = bonusHeadOfficeBuilding;}
	//	鉄道
	public int getBonusTrain() {return bonusTrain;	}
	public void setBonusTrain(int bonusTrain) {this.bonusTrain = bonusTrain;}
	//	労働組合
	public int getBonusUnion() {return bonusUnion;}
	public void setBonusUnion(int bonusUnion) {this.bonusUnion = bonusUnion;}
	//	不動産
	public int getBonusRealEstate() {return bonusRealEstate;}
	public void setBonusRealEstate(int realEstate) {bonusRealEstate = realEstate;}
	public void plusBonusRealEstate(int realEstate) {bonusRealEstate += realEstate;}
	public void clearBonusRealEstate() {bonusRealEstate = 0;}
	//	農協
	public int getBonusAgriculturalCooperative() {return bonusAgriculturalCooperative;}
	public void setBonusAgriculturalCooperative(int bonusAgriculturalCooperative) {
		this.bonusAgriculturalCooperative = bonusAgriculturalCooperative;}
	//	倉庫

	//	社宅
	public int getBonusCompanyHousing() {return bonusCompanyHousing;	}
	public void setBonusCompanyHousing(int bonusCompanyHousing) {
		this.bonusCompanyHousing = bonusCompanyHousing;
	}
	/*法律事務所*/
	public int getBonusLawOffice() {
		return bonusLawOffice;
	}
	public void setBonusLawOffice(Player player) {
		if(player.getDebit() <= -15) {
			this.bonusLawOffice = 15;
		}else if(player.getDebit() < 0){
			this.bonusLawOffice = -player.getDebit();
		}else {
			this.bonusLawOffice = 0;
		}
		System.out.println("借金クリア"+bonusLawOffice);
	}

	//		合計ボーナス
	public int getAllBonus() {setAllBonus();
		return AllBonus;
	}

	public void setAllBonus() {
		AllBonus = bonusHeadOfficeBuilding+bonusTrain+bonusUnion+bonusRealEstate+
				bonusAgriculturalCooperative+bonusLawOffice;
	}

}