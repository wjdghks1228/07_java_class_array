package step7_01.classArray;

import java.util.ArrayList;
import java.util.Scanner;


class StudentVO {
	String id;
	String pw;
	
	void set_data(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	void print_data() {
		System.out.println("이름 : " + id + "비밀번호 : " + pw);
	}
}

class StudentManager {
	ArrayList<StudentVO> studentList = new ArrayList<StudentVO>();
	void add_student(StudentVO st) {
		studentList.add(st);
	}
	
	StudentVO remove_student(int index) {
		StudentVO del_st = studentList.get(index);
		studentList.remove(index);
		return del_st;
	}
	
	int check_id(StudentVO st) {
		int check = -1;
		for(int i = 0 ; i  < studentList.size(); i++) {
			if(studentList.get(i).equals(st)) {
				check = i;
			}
		}
		return check;
	}
	
	void print_student() {
		System.out.println();
		System.out.println("======================================================");
		for(int i = 0 ; i < studentList.size(); i++) {
			System.out.print(studentList.get(i) + " ");
		}
	}
	
	String out_data() {
		
	}
	
	void sort_data() {
		int listSize = studentList.size();
		for(int i = 0 ; i < listSize; i++) {
			for(int j = 0 ; j < listSize; j++) {
				if(studentList.get(i).id.compareTo(studentList.get(j).id) > 0) {
					StudentVO temp  = studentList.get(i);
					//studentList.get(i) = studentList.get(j);
					studentList.set(i, studentList.get(j));
					studentList.set(j, temp);
				}
			}
		}
	}
	
	int get_size() {
		return studentList.size();
	}
	
}


public class ClassArrayEx23_문제 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		StudentManager manager = new StudentManager();
		//StudentManager manager = new StudentManager();
		
		while (true) {
			
			System.out.println("1.가입 2.탈퇴 3.정렬 4.출력 5.저장 6.로드 7.종료");
			int sel = scan.nextInt();
			
			//회원가입
			if 		(sel == 1) {
				System.out.println();
				System.out.println("[회원가입] 회원가입을 진행하겠습니다");
				//객체생성
				StudentVO temp = new StudentVO();
				//아이디 입력
				System.out.println("[회원가입] : ID를 입력하세요 : ");
				temp.id = scan.next();
				//중복검사
				int check = manager.check_id(temp);
				if(check == -1) {    //아이디 중복X
					//비밀번호 입력
					System.out.println("[회원가입] : PW를 입력하세요 : ");
					temp.pw = scan.next();
					//비밀번호 등록
					manager.add_student(temp);
					System.out.println("[회원가입 성공]" + temp.id + "님 회원가입 감사합니다.");
				}
				else if(check != -1 ) {
					System.out.println("[메세지] 중복된 아이디 검출, 다시 시도하세요");
				}
				
				
				
			} 
			//회원탈퇴
			else if (sel == 2) {
				System.out.println();
				System.out.println("[회원탈퇴] 회원탈퇴를 진행하겠습니다.");
				System.out.println("[회원탈퇴] ID를 입력해주세요 : ");
				StudentVO temp = new StudentVO();
				temp.id = scan.next();
				//아이디 존재하는지 확인
				int check = manager.check_id(temp);
				if(check != -1) { //아이디 존재
					System.out.println("[회원탈퇴] 비밀번호를 입력하세요 : ");
					temp.pw = scan.next();
					//회원탈퇴 진행
					StudentVO del_st = manager.remove_student(check);
					System.out.println("[회원탈퇴]" + del_st + "님 회원탈퇴 완료하였습니다.");
				}
				else if(check == -1){ //해당아이디 없음
					System.out.println("[메세지] 입력하신 ID정보를 찾을수가 없습니다. 다시 진행해주세요");
				}
			}
			//정렬
			else if (sel == 3) {
				System.out.println();
				System.out.println("[회원정렬] 회원정렬를 진행하겠습니다.");
				System.out.println("[기존회원]");
				manager.print_student();
				System.out.println("======================================================");
				System.out.println();
				manager.sort_data();
				manager.print_student();
				System.out.println("[회원정렬] 회원정렬를 마쳤습니다.");
				System.out.println("======================================================");
				System.out.println();
			}
			//출력
			else if (sel == 4) {
				System.out.println();
				System.out.println("[회원조희] 회원조희를 진행하겠습니다.");
				manager.print_student();
				System.out.println();
			}
			//저장
			else if (sel == 5) {
				System.out.println("[회원저장] 회원목록 저장을 시작하겠습니다.");
				if(manager.get_size() == 0) {
					System.out.println("[메세지] 저장할 회원이 없습니다. 다시 진행해주세요");
				}
				else {
					
				}
			}
			//로드
			else if (sel == 6) {}
			//종료
			else if (sel == 7) {}
			
		}

	}

}
