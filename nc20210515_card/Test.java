package nc20210515_card;

public class Test {
	private int a = 10;
	private int b = 100;
	private int c;

	public Test() {
		super();

	}

//c=a+b を常に保つ設定
	public int getA() {
		return a;
	}
	public void plusA(int a) {
		this.a += a;
//		this.c += a;
	}
	public int getB() {
		return b;
	}
	public void plusB(int b) {
		this.b += b;
//		this.c += b;
	}
	public int getC() {
		return c;
	}
	public void plusC(int c) {
		this.c += c;
	}
	public void setC() {
		this.c = a+b;
	}

	@Override
	public String toString() {
		return "Test [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
}
