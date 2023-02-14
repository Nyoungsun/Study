package inheritance;

class AA {
	public int a = 3;
	public void disp() {
		a += 5;
		System.out.println("AA: " + a + " ");
	}
}


class BB extends AA {
	public int a = 8; // field, override 개념 X
	public void disp() {
		this.a +=5;
		System.out.println("BB: " + a + " ");
	}
}


public class OverrideMain {

	public static void main(String[] args) {
		BB aa = new BB();
		aa.disp(); // BB: 13
		System.out.println("aa: " + aa.a); // aa: 13
		
		AA bb = new BB();
		bb.disp(); // BB: 13
		System.out.println("bb: " + bb.a); // cc: 3 - override - field 적용 X
		// Override 시, child class 기준으로 적용
		
		BB cc = (BB) bb; // BB class casting
		cc.disp(); // BB: 18
		System.out.println("cc: " + cc.a); // 18
		
		AA dd = new AA();
		dd.disp(); // AA: 8
		System.out.println("dd: " + dd.a); // dd: 8
		
		
		
	}
}
