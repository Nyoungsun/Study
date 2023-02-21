package inheritance;

import java.util.*;

class Shape {
	protected double area;
	protected Scanner scan = new Scanner(System.in);
	
	public Shape() {System.out.println("Shape Default Constructor");}
	public void calcArea() {System.out.println("도형을 계산합니다.");}
	public void dispArea() {System.out.println("도형을 출력합니다.");}
}


class Triangle extends Shape { // area, calcArea(), dipArea() 사용 가능
	protected int base, height;
	
	public Triangle() {
		System.out.println("Triangle Default Constructor");
		System.out.print("Base: ");
		base = scan.nextInt();
		System.out.print("Height: ");
		height = scan.nextInt();
	}
	
	// @ Annotation
	@Override
	public void calcArea() {
		area = base * height / 2.0;
	}
	
	@Override
	public void dispArea() {
		System.out.println("Triangle area: " + area);
	}
}

class Square extends Shape {
	protected int width, height;
	
	public Square() {
		System.out.println("Square Default Constructor");
		System.out.print("Width: ");
		width = scan.nextInt();
		System.out.print("Height: ");
		height = scan.nextInt();		
	}
	
	// @ Annotation
	@Override
	public void calcArea() {
		area = width * height;
	}

	@Override
	public void dispArea() {
		System.out.println("Square area: " + area);
	}

}

class Trapezoid extends Shape {
	protected int top, bottom, height;
	
	public Trapezoid() {
		System.out.println("Trapezoid Default Constructor");
		System.out.print("Top: ");
		top = scan.nextInt();
		System.out.print("Bottom: ");
		bottom = scan.nextInt();
		System.out.print("Height: ");
		height = scan.nextInt();		
	}

	@Override
	public void calcArea() {
		area = (top+bottom) * height / 2.0;
	}

	@Override
	public void dispArea() {
		System.out.println("Trapezoid area: " + area);
	}
	
}


public class ShapeMain {

	public static void main(String[] args) {
		/*
		Triangle triangle = new Triangle();
		// Shape Default Constructor
		// Triangle Default Constructor
		triangle.calcArea();
		triangle.dispArea();
		
		System.out.println();
		
		Square square = new Square();
		square.calcArea();
		square.dispArea();

		System.out.println();

		Trapezoid trapezoid = new Trapezoid();
		trapezoid.calcArea();
		trapezoid.dispArea();
		*/
		
		// 다형성: 부모 참조변수는 자식 객체를 참조할 수 있음
		Shape shape; // Parent remote controller create
		shape = new Triangle();
		shape.calcArea();
		shape.dispArea();
		System.out.println();

		
		shape = new Square();
		shape.calcArea();
		shape.dispArea();
		System.out.println();
		
		
		shape = new Trapezoid();
		shape.calcArea();
		shape.dispArea();
		System.out.println();
	}
}
