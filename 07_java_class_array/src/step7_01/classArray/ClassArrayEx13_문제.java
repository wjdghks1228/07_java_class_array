package step7_01.classArray;

import java.util.Scanner;


class StudentEx{
	
	String id = "";
	String pw = "";
	
	void set_data(String id , String  pw) {
		this.id = id; 
		this.pw = pw;
	}
	
	
	void print_data() {
		System.out.println("이름 : " + id + " 비밀번호 : " + pw);
	}
	
}

class Manager{
	
	StudentEx[] list = null;
	int stdCnt = 0;
	
	void add_StudentEx(StudentEx st) {
		//list null status
		if(stdCnt == 0) {
			list = new StudentEx[1];
		}
		else { //not null
			StudentEx[] temp = list;
			//list 객체 한칸늘려서 새로생성
			list = new StudentEx[stdCnt + 1];
			//list에 temp 복사
			for(int i = 0 ; i < stdCnt; i++) {
				list[i] = temp[i];
			}
			temp = null;
		}
		list[stdCnt] = st;
		stdCnt++;
	}
	
	StudentEx remove_StudentEx (int index) {}
	
	//기존 것에 id 있는지 화인 											returnCheck == 1 아이디 존재  returnCheck == 0 아이디 없음 
	int check_id(StudentEx inputId) {
		int returnCheck = -1;
		//기존 회원 0명일때
		if(stdCnt == 0) {
			returnCheck = 0;
			return returnCheck;
		}
		else {
			//회원 체크
			for(int i = 0 ; i < stdCnt ; i++) {
				if(this.list[i].name.compareTo(inputId.id) == 0) {
					returnCheck = 1;
				}
			}
			return returnCheck;
		}
	}
	
	void print_StudentEx() {}	
	
	String out_data() {}
	
	void sort_data() {}
	
	void load_StudentEx (StudentEx [] temp , int count) {}
	
}


public class ClassArrayEx13_문제 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Manager manager = new Manager();
		
		// Manager manager = new Manager();
		
		while (true) {
			
			System.out.println("1.가입 2.탈퇴 3.정렬 4.출력 5.저장 6.로드 7.종료");
			int sel = scan.nextInt();
			
			/*
			 * [1] 가입하기 : ID 중복검사 구현
			 * [2] 탈퇴하기 : ID를 입력받아 탈퇴
			 * [3] 정렬하기 : 이름을 국어사전 순으로 정렬
			 * [4] 출력하기 : 데이터들을 화면에 출력
			 * [5] 저장하기 : 아래와 같은 형식으로 저장
			 * [6] 불러오기 : 파일에 저장된 내용을 불러오기
			 * [7] 종료하기 : 반복문을 종료
			 * 
			 * 			예) 
			 * 			2				// 회원 수
			 *			qwer,1234		// id,pw	
			 *			abcd,1111		// id, pw
			 */
			
			//가입하기
			if		(sel == 1) {
				System.out.println("[회원 가입 메뉴]");
				System.out.println("ID를 입력하세요 : ");
				//id 객체 생성
				StudentEx inputId = new StudentEx();
				inputId.id = scan.next();
				//기존아이디에 있는지 확인
				int check = manager.check_id(inputId);
				if(check == 1) {
					System.out.println("아이디 존재 , 다른 아이디를 입력해주세요");
				}
				else {
					System.out.println("PW를 입력하세요 : ");
					inputId.pw = scan.next();
					System.out.println();
					System.out.println("=============================================================");
					System.out.println("[회원가입 성공]");
					System.out.println("=============================================================");
					System.out.println();
					//데이터 입력
					manager.add_StudentEx(inputId);
				}
			}
			//탈퇴
			else if (sel == 2) {
				System.out.println("[탈퇴 메뉴]");
				System.out.println("탈퇴 ID를 입력하세요 : ");
			}
			else if (sel == 3) {}
			else if (sel == 4) {}
			else if (sel == 5) {}
			else if (sel == 6) {}
			else if (sel == 7) { 
				break; 
			}
			
		}

	}

}
