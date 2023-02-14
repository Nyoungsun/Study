package inheritance;

public class SubMain extends Super{
	private String name;
	private int age;
	
	SubMain(){System.out.println("SubMain Class Default Constuctor");}
	
	SubMain(String name, int age, double weight, double height){
		this.name = name;
		this.age = age;
		super.weight = weight; // 부모의 참조값을 따로 나타내기위해 super 사용
		this.height = height; // parent class varialbe this.v로 사용 가능
	}

	public void output() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		this.disp(); // 부모 class 호출은 this, super 모두 가능
	}

	public static void main(String[] args) {
		// main -> static, this 사용 X

		SubMain aa = new SubMain("홍길동", 25, 73.5, 182.6);
		// 부모 클래스의 기본 생성자까지 호출
		// Super Class Default Constructor
		// SubMain Class Default Constuctor
		// aa를 통해서 Super, SubMain class에 접근 가능

		aa.disp(); // parenet method 출력
		System.out.println("----------------");
		aa.output();

		System.out.println("================");
		Super bb = new SubMain("코난", 13, 53.5, 156.6);
//		bb.output(); Error
		bb.disp();
	
	}
}

// child class memory allocation 시, parent & child class 모두 memory allocation됨
// 자식 클래스 사용 시, 부모+자식 객체 생성
// 자식 클래스에 의해 부모 클래스의 객체가 만들어질 경우, 기본 생성자를 기본적으로 사용
// 그러므로 부모 클래스의 기본 생성자가 있는지 확인 필요(생성자가 1개 이상 있을 경우, 자동 생성 X)
// 부모 클래스를 상속받을 때, 오류가 나는 것을 사전에 방지하기 위해서 기본 생성자 미리 작성
// Implicit super constructor Super() is undefined for default constructor. Must define an explicit constructor