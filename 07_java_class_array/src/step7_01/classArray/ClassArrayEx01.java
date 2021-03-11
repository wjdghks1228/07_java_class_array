package step7_01.classArray;

class Product {
		String name;
		int price;
	}

public class ClassArrayEx01 {
	public static void main(String[] args) {
		// TODO Auto-generated method
		
			Product[] productList = new Product[3];
			productList[0] = new Product();
			productList[1] = new Product();
			productList[2] = new Product();

			productList[0].name = "기계식 키보드";
			productList[0].price = 45000;
			productList[1].name = "무소음 마우스";
			productList[1].price = 35000;
			productList[2].name = "장패드";
			productList[2].price = 10000;

			// 엘리먼트 조회
			for (int i = 0; i < productList.length; i++) {
				System.out.println("name : " + productList[i].name);
				System.out.println("price : " + productList[i].price);
				System.out.println();
			}
			
			Product[] temp1 = productList;
			Product temp2 = productList[1];
			String temp3 = productList[1].name;
			int temp4 = productList[0].price;
			
			System.out.println("========================================================");
			Product temp = productList[2];
			System.out.println("temp : " + temp);
			System.out.println("productList[2] : " + productList[2]);
			
			temp.name = "장패드1";
			System.out.println("temp.name : " + temp.name);
			System.out.println("productList[2].name : " + productList[2].name);
			
			productList[2].name = "장패드2";
			System.out.println("temp.name : " + temp.name);
			System.out.println("productList[2].name : " + productList[2].name);

			
			
			
		}

}

