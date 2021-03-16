package step7_01.classArray;
//private + getter/setter
//getter : private 을 가져올수있는 것
//setter : private 값을 바꿀수 있는 것

class PrivateTest{
	private int a;
	public int b;
	int c; 						//아무것도 안붙이면 default
	
	//get&set 문법 : get + 변수명();
	//getter/setter 자동완성 : Source > Generate Getters and Setter > Generate
	int getA() { //외부에서 private값을 가져올수 있는 getter
		return this.a;
	}
	void setA(int a) {  //외부에서 private a 의 값을 바꿀수 있는 setter
		this.a = a;
	}
}

public class ClassArrayEx17 {
	//접근 제어자 : public, private + getter/setter
	//	public : 모두 공유
	//	default : 같은 패키지 내부
	//	protected : 부모 자식간만
	//	private : 나만 가능
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrivateTest obj = new PrivateTest();
		//obj.a = 100; //private 이므로 접근 불가능 ( is not visible )
		obj.b = 200;
		obj.c = 300;
		System.out.println(obj.b);
		System.out.println(obj.c);
		
		System.out.println("[ 기존 PRIVATE 값 ]" + obj.getA());
		obj.setA(1000);
		System.out.println("[ 바뀐 PRIVATE 값 ]" + obj.getA());
	}
}
