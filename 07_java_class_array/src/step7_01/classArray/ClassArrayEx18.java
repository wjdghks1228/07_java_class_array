package step7_01.classArray;
/*
# static
- 정적 필드와 정적 메소드는 객체(인스턴스)에 소속된 멤버가 아니라 클래스에 고정된 멤버이다.
- static 키워드를 통해 생성된 정적멤버들은 Heap영역이 아닌 Static영역에 할당한다.
- static 영역에 할당된 메모리는 모든 객체가 공유하여 하나의 멤버를 어디서든지 참조할 수 있다.
- Garbage Collector의 관리 영역 밖에 존재하기에 Static영역에 있는 멤버들은 프로그램의 종료시까지 메모리가 할당된 채로 존재한다.

*/

class Character { 							//캐릭터가 여러명일때 static 변수 바꾸면 해당 클래스 캐릭터들이 다같이 값이 바뀐다.
	static int level = 1;
	int hp = 100;
	int mana = 30;
	static int moveSpeed = 5;
	
	void showStatus() {
		System.out.println("[ level ] : " + level);
		System.out.println("[ h   p ] : " + hp);
		System.out.println("[ m   p ] : " + mana);
		System.out.println("[ speed ] : " + moveSpeed);
		System.out.println();
	}
	
	static void speedUp() {
		moveSpeed += 30;
	}
}
public class ClassArrayEx18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//캐릭터1 객체 생성
		Character c1 = new Character();
		c1.hp = 0;
		//c1.moveSpeed = 100; 									//노란줄 에러 
		//스테틱을 쓰는 올바른 방법 : 클래스명 + . + 스태틱변수 = 값 ;
		//스테틱 붙으면 굳이 객체이름 찍을 필요 없음 --> 클래스명 + . + 함수 / 변수 ;
		Character.moveSpeed = 1000;
		Character.speedUp();
		c1.showStatus();
		
		//캐릭터2 객체 생성
		Character c2 = new Character();
		c2.hp -= 50;
		c2.showStatus();
		
		//캐릭터3 객체 생성
		Character c3 = new Character();
		c3.showStatus();
		
	}

}
