package step7_01.classArray;

/*
 * # 생성자 오버로딩
 *  - 생성자도 메서드이기 때문에 메서드 오버로딩 기법이 적용 가능하다.
 *  - 생성자 오버로딩을 구현하기 위해서는 메서드와 마찬가지로
 *  - 파라메타의 개수나 타입을 다르게 정의 하면 된다.
 * */
	//생성자의 경우 public 은 써도 되고 안써도 된다.

class Fruit2{
	String name;
	int price;
	//	String contact;
	//	String email;
	//	String content;
	//	String user;
	//	int protectShield;
	//	int mapField;
	
	//source -> Generate Constructor using Field -> generage 하면 한번에 생성됨
	//	public Fruit2(String name, int price, String contact, String email, String content, String user, int protectShield,
	//			int mapField) {
	//		super();
	//		this.name = name;
	//		this.price = price;
	//		this.contact = contact;
	//		this.email = email;
	//		this.content = content;
	//		this.user = user;
	//		this.protectShield = protectShield;
	//		this.mapField = mapField;
	//	}
	
	// 생성자 오버로딩
	Fruit2(){
	}
	
	Fruit2(String name){
		this.name = name;
	}
	
	Fruit2(String name, int price){
		this.name = name;
		this.price = price;
	}

}
public class ClassArrayEx16 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// METHOD OVERIDING
		// 같은 생성자 호출해도 전달해주는 인자에 따라서 실행되는 함수가 달라진다. - > 좀더 유연한 코딩가능
		new Fruit2(); 					//이름모를 객체1 : 아무것도 안함
		new Fruit2("사과");				//이름모를 객체2 : this.name = 사과를 대입함
		new Fruit2("포도", 50000);		//이름모를 객체3 : this.name = 포도 this.price = 50000을 대입함
		// -> 이름없는 세개의 객체가 생성되고 각각 운영되는것
		
		
	}
}
