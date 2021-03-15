package step7_01.classArray;

import java.util.Scanner;

class Subject8{
	String name;
	int score;
}


class Student8{
	Subject8[] subject8;
	String name;
}



public class ClassArrayEx08_문제 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// # 학생 추가 삭제 컨트롤러
		//   => 컨트롤러를 완성해 아래 3개의 정보를 추가하시오.
		//   김철수 : 과목3개 수학 50 국어50 영어 60 
		//   이만수 : 과목2개 수학 20 국어 30 
		//   이영희 : 과목1개 수학 100
		
		Student8 [] stdList = new Student8[3];
		int stdCnt = 0;	// 학생 수
		
		
		while (true) {
			//현재 학생과 과목출력
			for(int i = 0 ; i < stdCnt ; i++) {
				System.out.println("<<<<< "+stdList[i].name + "학생 >>>>> ");
				if(stdList[i].subject8 != null) {
				for(int j  = 0 ; j < stdList[i].subject8.length; j++) {
						if(stdList[i].subject8[j].score == 0) {
							System.out.println("[ " + stdList[i].name + " 학생의 등록된과목 ] :  "+ stdList[i].subject8[j].name + " -> " + "성적미등록");
						}
						else {
							System.out.println("[ " + stdList[i].name + " 학생의 등록된과목 ] :  "+ stdList[i].subject8[j].name + " -> " + stdList[i].subject8[j].score +"점");
						}
					}
				System.out.println();
				}
			}
			System.out.println();
			
			System.out.println("[1]학생 추가하기");		// 이름 입력받아 추가
			System.out.println("[2]과목 추가하기");		// 이름과 과목 입력받아 추가
			System.out.println("[3]성적 추가하기");		// 이름과 과목 그리고 성적 입력받아 추가
			System.out.println("[4]종료하기");
			int choice = scan.nextInt();
			
			//이름 입력받아 추가
			if		(choice == 1) {
				System.out.println();
				System.out.println("=================================");
				System.out.println("[학생추가하기]");
				System.out.println("이름을 입력하세요 : ");
				String newName = scan.next();

				//객체생성
				stdList[stdCnt] = new Student8();
				//이름 등록
				stdList[stdCnt].name = newName;
				stdCnt ++;
			}
			//이름과 과목 입력받아 추가 
			else if (choice == 2) {
				//현재 등록된 학생들 추가 
				if(stdCnt == 0) {
					System.out.println("============================================");
					System.out.println("[ 메세지 ] 현재 등록된 학생이 없습니다!");
					System.out.println("============================================");
					break;
				}
				
				for(int i = 0 ; i < stdCnt; i ++) {
					System.out.println("["+(i+1) + "] " + stdList[i].name + " 학생");
				}
				System.out.println();
				System.out.println("학생을 선택하세요(숫자)");
				int sel = scan.nextInt();
				
				System.out.println();
				if(stdList[sel-1].subject8 != null	) {
					for(int i = 0 ; i < stdList[sel - 1].subject8.length; i++) {
						System.out.println("[ " + stdList[sel - 1].name + "학생 현재 등재된 과목 ]  :  " + stdList[sel - 1].subject8[i].name );
					}
				}
				
				System.out.println();
				System.out.println("등록할 과목을 입력하세요 : ");
				String newSub = scan.next();
				
				//비어있을시 객체생성
				if(stdList[sel-1].subject8 == null) {
					stdList[sel-1].subject8 = new Subject8[1];
					stdList[sel-1].subject8[0] = new Subject8();
					stdList[sel-1].subject8[0].name = newSub;
				}
				else {
					int subSize = stdList[sel-1].subject8.length;
					Subject8[] temp = stdList[sel-1].subject8;
					stdList[sel-1].subject8 = new Subject8[subSize+1];
					for(int i = 0 ; i < subSize; i++) {
						stdList[sel-1].subject8[i] = temp[i];
					}
					//객체생성
					stdList[sel-1].subject8[subSize ] = new Subject8();
					stdList[sel-1].subject8[subSize].name = newSub;
					
					temp = null;
				}
			}
			//이름과 과목 그리고 성적 입력받아 추가 
			else if (choice == 3) {
				System.out.println("이름을 입력하세요 : " );
				String newName = scan.next();
				int findIndex = 0;
				//해당이름의 인덱스 찾기
				for(int i = 0 ; i < stdCnt; i++) {
					if(stdList[i].name.compareTo(newName)==0) {
						findIndex = i;
					}
				}
				newName = null;
				System.out.println();
				//해당이름 현재 입력된 과목들 출력
				System.out.println("===========================================");
				System.out.println("[ 성적입력 가능한 과목 ]");
				System.out.println();
				if(stdList[findIndex].subject8 != null) {
					for(int i = 0 ; i < stdList[findIndex].subject8.length; i++) {
						System.out.println("[" + (i+1) + "] " + stdList[findIndex].subject8[i].name);
					}
					System.out.println("===========================================");
					System.out.println();
					System.out.println("성적을 입력할 과목을 선택하세요 : ");
					int sel = scan.nextInt();
					
					System.out.println("성적을 입력하세요 : ");
					int newScore = scan.nextInt();
					stdList[findIndex].subject8[sel-1].score = newScore;
				}
			}
			else if( choice == 4) {
				System.out.println();
				System.out.println("===================================");
				System.out.println("          [시스템 종료]");
				System.out.println("===================================");
				break;
				
			}
			
		}


	}

}
