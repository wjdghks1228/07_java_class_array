package step7_01.classArray;
/*
 *  # 생성자 ( Constructor ) 
 * 
 * 	1. 생성자는 반드시 클래스의 이름과 같아야 한다.
 *  2. 생성자는 리턴타입을 가지지 않고 return도 사용하지 않는다.
 *     ( 생성자도 하나의 메서드이지만 기존 메서드와의 차이점이 있다. )
 *  3. 생성자는 인스턴스를 생성할때 ( new 클래스명(); ) 호출된다.
 *  	3-1) 반드시 실행된다.
 *  	3-2) 가장 먼저 실행된다.
 *  
 *  4. 생성자를 정의하지 않으면 , 컴파일러가 자동으로 기본 생성자를 만든다.
 *  5. 기본 생성자란, 클래스이름과 같으며 매개변수에 아무것도 없는 생성자를 의미한다.
 *  6. 생성자를 새로 정의하면 기본 생성자는 자동으로 만들어지지 않는다.
 * 
 * */

class ConstructorTest{
	ConstructorTest(){//생성자 생성 :  클래스 이름과 동일하게 메서드를 만든다.
		System.out.println("생성자 실행");
		System.out.println("- 메서드를 호출하지 않아도 실행");
		System.out.println("- 가장 먼저 실행");
		System.out.println("- 인스턴스가 생성되는 시점에 1번 실행");
	}
	
	void method1() {
		System.out.println("#method 1");
	}
	
	void method2() {
		System.out.println("#method 2");
	}
	
	void method3() {
		System.out.println("#method 3");
	}
}

public class ClassArrayEx14 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//생성자는 객체를 생성안해도 무조건 실행 된다.
		System.out.println("=============================CASE1=================================");
		new ConstructorTest();
		System.out.println();
		
		System.out.println("=============================CASE2=================================");
		ConstructorTest ct = new ConstructorTest();//인스턴스(객체)를 생성할때 기본 생성자가 실행된다.
		
		//메서드 호출해야 메서드가 동작한다.
		ct.method3(); 
		ct.method1();
		ct.method2();
		System.out.println();
		
		System.out.println("=============================CASE3=================================");
		ConstructorTest ct2 = new ConstructorTest();
		
	}

}
