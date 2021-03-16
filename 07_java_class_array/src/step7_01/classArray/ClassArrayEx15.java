package step7_01.classArray;

//생성자를 언제활용하냐 ? 생성자 활용법
//생성자를 이용한 멤버 변수 초기화

class Fruit{
	String name;
	int price;
	
	//생성자 : 클래스 이름과 똑같은 METHOD
	
	Fruit(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	void printData() {
		System.out.println("[과일등록]");
		System.out.println("이름 : " + this.name);
		System.out.println("가격 : " + this.price);
		System.out.println();
	}
}

public class ClassArrayEx15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fruit apple = new Fruit("사과", 800); //생성자를 이용한 멤버변수 초기화
		apple.printData(); 
		//작동원리
		//1. apple이라는 객체생성 (타입은 Fruit)
		//2. apple.printData 를 실행하자마자 Fruit라는 생성자 강제 우선 실행
		//3. Fruit METHOD기능 : this.name / this.price 에 값 대입
		//4. 이후 원래대로 printData(); 실행 
		//5. 그러므로 결과값 도출
		
		Fruit banana = new Fruit("바나나", 2500);
		banana.printData();
	}

}
