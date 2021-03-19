package step7_01.classArray;

import java.util.HashMap;

public class ClassArrayEx20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		
		//put(key,value) : HashMap 에 데이터를 추가한다 (순서상관 없음, key값이 중요)
		hmap.put("data1", 1000);
		hmap.put("data2", 2000);
		hmap.put("data3", 3000);
		System.out.println(hmap);
		System.out.println("====================================");
		
		//put()메서드는 존재하지 않는 key를 넣어주면 데이터 추가
		//존재하는 key값을 넣어주면 데이터 수정
		hmap.put("data1", 10000);
		hmap.put("data2", 20000);
		System.out.println(hmap);
		System.out.println("====================================");
		
		//size() : HashMap의 데이터의 개수를 반환한다.
		System.out.println(hmap.size());
		
		//get() : HashMap의 key에 할당된 value를 얻어온다.
		System.out.println(hmap.get("data1"));
		System.out.println(hmap.get("data2"));
		System.out.println(hmap.get("data3"));
		System.out.println("====================================");
		
		//keySet() : HashMap에 key만 얻어온다
		System.out.println(hmap.keySet());
		System.out.println("====================================");
		
		//호출 : HashMap의 경우 key값이 중요하기 때문에 key값으로 for문 돌려야함
		for (String key : hmap.keySet()) {
			System.out.println(hmap.get(key));
		}
		System.out.println("====================================");
		// remove(key) : HashMap 의 key에 해당되는 값을 제거한다.
		hmap.remove("data2");
		hmap.remove("data3");
		System.out.println(hmap);
		System.out.println("====================================");
		//clear() : HashMap의 모든 값을 제거한다.
		hmap.clear();
	}
}
