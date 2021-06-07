package nc20210515_card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import nc20210515_card.card_Agriculture.C_A_SlashAndBurn;
import nc20210515_card.card_Facilities.C_Faci_WareHouse;

class Alphabet{
	String name;

	public Alphabet() {
		super();
	}
	public Alphabet(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}

public class Main {
	static int num = 3;
	static boolean b1;

	public static void main(String[] args) {
		//		a(2);
		//
		//
		////		学校、高校、大学のIInvokeのテスト
		//		String s = null;
		//		s = "test";
		//		System.out.println(s);
		//
		//		Test name = new Test();
		////		name.plusA(1);
		////		name.plusB(1);
		////		name.plusC(1);
		////		name.plusA(1);
		////		name.plusB(1);
		////		name.plusC(1);
		////		name.plusA(1);
		////		name.setC();
		//		System.out.println(name.toString());
		//		System.out.println(name.getC());

		//		施設のテスト
		//		boolean b2 = true;
		//		if(b1) {
		//			System.out.println("b1 = " + b1);
		//		}
		//		if(!b1) {
		//			System.out.println("!b1 = " + b1);
		//		}
		//		if(b2) {
		//			System.out.println("b2 = " + b2);
		//		}
		//		if(!b2) {
		//			System.out.println("!b2 = " + b2);
		//		}

		//		int number = 9431;
		//		if(number <= 0) {
		//			board_empty=true;
		//		}
		//		if(1000) {
		//
		//		}

		List<Card> cards = new ArrayList<>();
		cards.add(new C_A_SlashAndBurn());
		cards.add(new C_A_SlashAndBurn());
		//		cards.add(new C_I_Factory());
		//		cards.add(new C_I_Factory());
		cards.add(new C_Faci_WareHouse());
		//		cards.add(new C_Faci_WareHouse());

		boolean board_empty = false;
		boolean AllFacility = true;
		boolean canSoldCard = false;

		//		if(cards.isEmpty()) {
		//			board_empty = true;
		//		}
		//		for (int i = 0; i < cards.size(); i++) {
		//
		////			施設じゃなかったら
		//			if(!cards.get(i).getType().equals("F")){
		//				AllFacility = false;
		//
		////				焼畑じゃなかったら
		//				if(!cards.get(i).getName().equals("焼畑")) {
		//					canSoldCard = true;
		//				}
		//			}
		//		}

		//		if((board_empty || AllFacility) || !canSoldCard) {
		//			System.out.println("売れない");
		//		}else {
		//			System.out.println("売れる");
		//		}
		//		System.out.println(cards.isEmpty());

//		kajoutest();
//		C_Faci_RealEstate f = new C_Faci_RealEstate();
//		C_A_LargeFarm a = new C_A_LargeFarm();
//
//		hh(f);
//		hh(a);

//		removeテスト
//		remove()もclear()もその前に同じ型のリストに参照をさせればインスタンスは消えない
		List<Alphabet> alph = new ArrayList<>();
		List<Alphabet> alph2 = new ArrayList<>();
		List<Integer> inte = new ArrayList<>();

		alph.add(new Alphabet("A"));
		alph.add(new Alphabet("B"));
		alph.add(new Alphabet("C"));
		alph.add(new Alphabet("D"));
		alph.add(new Alphabet("E"));
		alph.add(new Alphabet("F"));
		alph.add(new Alphabet("G"));


		for (int i = 0; i < 3; i++) {
			Random rr = new Random();
			int r = rr.nextInt(alph.size());
			inte.add(r);
			alph2.add(alph.remove(r));
			System.out.println(alph2.get(i));
		}
		System.out.println("-------------");
		
		for (int i = 0; i < alph.size(); i++) {
			System.out.println(alph.get(i));
		}
		
		for (int i = alph2.size()-1; i >= 0; i--) {
			alph.add(inte.get(i),alph2.remove(i));
		}
		System.out.println("-------------");
		for (int i = 0; i < alph.size(); i++) {
			System.out.println(alph.get(i));
		}
	}

//	-------------------------------------------------------------------------
//	-------------------------------------------------------------------------

	public static void hh(Card name) {
		String test = "〇";
		System.out.println("【"+name.getType()+":"+name.getName()+":"+name.getPrice()
		+":"+name.getCost()+":"+test+"】");
		if(name.getType().equals("施")) {
			test="✖";
		}
		System.out.println("【"+name.getType()+":"+name.getName()+":"+name.getPrice()
		+":"+name.getCost()+":"+test+"】");

		List<String> ssss= new ArrayList<>();
		ssss.add("A");
		ssss.add("B");
		ssss.add("C");
		ssss.add("D");
		ssss.add("E");
		Random rr = new Random();
		int r = rr.nextInt(5);
		System.out.println(r);
		ssss.remove(r);
		System.out.println(ssss.get(0));;
		System.out.println(ssss.get(1));;
		System.out.println(ssss.get(2));;
		System.out.println(ssss.get(3));;
	}



	public static int b(int num) {
		return num;
	}

	public static void a(int x) {
		int num2 = num + b(x);
		if (num2 >= 5) {
			System.out.println("num2 is over 3");
		} else {
			System.out.println("num2 is smaller than 3");
		}

	}

	public static void kajoutest() {
		int[] array = new int[10];

		Arrays.parallelSort(array);
		int count = 0;
		int countIka = 0;
		int one=0,two=0,three=0,four=0,five=0,six=0,seven=0,eight=0,nine=0,ten=0;
		while (count < 10000) {
			for (int i = 0; i < array.length; i++) {
				int r = new Random().nextInt(10) + 1;
				array[i] = r;
				if(array[i]==1) {
					one++;
				}
				if(array[i]==2) {
					two++;
				}
				if(array[i]==3) {
					three++;
				}
				if(array[i]==4) {
					four++;
				}
				if(array[i]==5) {
					five++;
				}
				if(array[i]==6) {
					six++;
				}
				if(array[i]==7) {
					seven++;
				}
				if(array[i]==8) {
					eight++;
				}
				if(array[i]==9) {
					nine++;
				}
				if(array[i]==10) {
					ten++;
				}
			}

//			１～１０の和は55だから５０は平均以下なので５０以下が少なくて当然
			int total = 0;
			for (int i = 0; i < array.length; i++) {
				int n = array.length - 1;
//				System.out.print("array[" + (n - i) + "]=" + array[n - i]);
				total += array[n - i];
				if (total > 55 && i < array.length) {
//					System.out.println();
//					System.out.println("５０以上");
//					System.out.println("配列数=" + i + " total=" + total);
//					System.out.println("-----");
					break;
				}
				if (total <= 55 && i == array.length - 1) {
//					System.out.println();
//					System.out.println("５０未満" + total);
//					System.out.println("-----");
					countIka++;
				}
			}
			count++;

		}
		System.out.println("未満のかず"+countIka);
		System.out.println(one);
		System.out.println(two);
		System.out.println(three);
		System.out.println(four);
		System.out.println(five);
		System.out.println(six);
		System.out.println(seven);
		System.out.println(eight);
		System.out.println(nine);
		System.out.println(ten);
	}
}
