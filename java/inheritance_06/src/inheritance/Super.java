package inheritance;

public class Super extends Object { // extends Object 생략된 상태
	protected double weight, height;

	public Super() {System.out.println("Super Class Default Constructor");}
	
	public Super(double weight, double height) {
		this.weight = weight;
		this.height = height;
	}
	
	public void disp() {
		System.out.println("Weight: " + weight);
		System.out.println("Height: " + height);
	}
}
