package inheritance;

public class ChildMain extends Super {
	private String name;
	private int age;
	
	ChildMain(){System.out.println("ChildMain Class Default Constuctor");}
	
	ChildMain(String name, int age, double weight, double height){
		// 부모 class 생성자 호출 시, 최상단에 입력 필
//		super(); // 부모 클래스 기본 생성자 호출, 자동 방식 -> 생략 가능
		super(weight, height); // 부모 클래스 인자 2개받는 생성자 호출
		
		this.name = name;
		this.age = age;
		super.weight = weight; // 부모의 참조값을 따로 나타내기위해 super 사용
		this.height = height; // parent class varialbe this.v로 사용 가능
	}
	
	public void disp() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
//		this.disp(); // this.disp() -> 자기 자신을 호출
		super.disp(); // parent class disp() 호출
	}
	
	
	public static void main(String[] args) {
		ChildMain aa = new ChildMain("홍길동", 25, 73.5, 182.7);
		aa.disp(); // 자손: 이름, 나이 // 조상: 몸무게, 키
		
		System.out.println("================");
		Super bb = new ChildMain("코난", 13, 53.5, 156.6);
		bb.disp(); // 조상: 몸무게, 키 // 

	}
	
	
		
}
