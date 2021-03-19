package step7_01.classArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

class StudentEx {

	String id = "";
	String pw = "";

	void set_data(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	void print_data() {
		System.out.println("이름 : " + id + " 비밀번호 : " + pw);
	}

}

class Manager {

	StudentEx[] list = null;
	int stdCnt = 0;

	// 학생 등록
	void add_StudentEx(StudentEx st) {
		// 학생 0명일때 객체생성
		if (stdCnt == 0) {
			list = new StudentEx[1];
		}
		// 학생 존재할때 복사후 새로생성
		else if (stdCnt > 0) {
			// temp 에 복사
			StudentEx temp[] = list;
			// 1명 늘려서 객체 새로생성
			list = new StudentEx[stdCnt + 1];
			// temp값 복사
			for (int i = 0; i < stdCnt; i++) {
				list[i] = temp[i];
			}
			// 1명추가
			list[stdCnt] = st;
			stdCnt++;
		}
	}

	StudentEx remove_StudentEx(int index) {
		StudentEx del_st = list[index];
		// 학생 1명이면 null로 초기화
		if (stdCnt == 0) {
			list = null;
		}
		// 학생이 0 명이 아닐때
		else if (stdCnt > 0) {
			StudentEx temp[] = list;
			// 객체 한명 줄여서 list 만들기
			list = new StudentEx[stdCnt - 1];

			for (int i = 0; i < index; i++) {
				list[i] = temp[i];
			}
			for (int i = index; i < stdCnt - 1; i++) {
				list[i] = temp[i + 1];
			}
			temp = null;
		}
		stdCnt--;
		return del_st;
	}

	int check_id(StudentEx st) {
		// 중복 없는 조건 check = -1;
		int check = -1;
		// 중복검사 시작
		for (int i = 0; i < stdCnt; i++) {
			if (list[i].id.equals(st.id)) {
				// 같은거 찾으면 check = 1
				check = i;
				break;
			}
		}
		return check;
	}

	void print_StudentEx() {
		for (int i = 0; i < stdCnt; i++) {
			list[i].print_data();
		}
	}

	String out_data() {
		String data = "";
		if (stdCnt == 0) {
			return data;
		}
		data += stdCnt;
		data += "\n";
		for (int i = 0; i < stdCnt; i++) {
			data += list[i].id;
			data += ",";
			data += list[i].pw;
			if (stdCnt - 1 != i) {
				data += "\n";
			}
		}
		return data;
	}

	void sort_data() {
		for (int i = 0; i < stdCnt; i++) {
			for (int j = 0; j < stdCnt; j++) {
				if (list[i].id.compareTo(list[j].id) > 0) {
					StudentEx temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
	}

	void load_StudentEx(StudentEx[] temp, int count) {
	}

}

public class ClassArrayEx13_문제 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Manager manager = new Manager();
		// Manager manager = new Manager();

		while (true) {

			System.out.println("1.가입 2.탈퇴 3.정렬 4.출력 5.저장 6.로드 7.종료");
			int sel = scan.nextInt();

			// [1] 가입하기 : ID 중복검사 구현
			if (sel == 1) {
				// 객체생성
				StudentEx temp = new StudentEx();
				System.out.println("[회원가입] id를 입력하세요 : ");
				temp.id = scan.next();
				// StudentEx 형 temp 보내서 중복검사
				int check = manager.check_id(temp);

				// 중복 없을때 비번 입력 시작 check == -1 일때
				if (check == -1) {
					System.out.println("[회원가입] pw를 입력하세요 : ");
					temp.pw = scan.next();
					// 가입완료 학생등록 => add_StudentEx() ;
					manager.add_StudentEx(temp);
				} else {
					System.out.println("아이디가 중복되었습니다.");
					break;
				}
			}
			// [2] 탈퇴하기 : ID를 입력받아 탈퇴
			else if (sel == 2) {
				// 기존 회원들 출력
				manager.print_StudentEx();
				StudentEx temp = new StudentEx();
				System.out.println("[회원탈퇴] id를 입력하세요 : ");
				temp.id = scan.next();
				// id 확인
				int check = manager.check_id(temp);
				if (check == -1) {
					System.out.println("없는 아이디입니다.");
				} else {
					StudentEx del_st = manager.remove_StudentEx(check);
					System.out.println("[회원탈퇴]" + del_st.id + "님 '탈퇴완료'");
				}

			}
			// [3] 정렬하기 : 이름을 국어사전 순으로 정렬
			else if (sel == 3) {
				manager.sort_data();
				manager.print_StudentEx();
			}
			// [4] 출력하기 : 데이터들을 화면에 출력
			else if (sel == 4) {
				manager.print_StudentEx();
			}
			// [5] 저장하기 : 아래와 같은 형식으로 저장
			else if (sel == 5) {
				if (manager.stdCnt == 0)
					System.out.println("[저장실패] 저장할 데이터가 없습니다.");
				try {
					FileWriter fw = new FileWriter("StudentEx_manager.txt");
					String data = manager.out_data();
					if (!data.equals("")) {
						fw.write(data);
						System.out.println(data);
					}
					fw.close();
				} catch (Exception e) {
				}
			}
			// [6] 불러오기 : 파일에 저장된 내용을 불러오기
			else if (sel == 6) {

				try {

					File file = new File("StudentEx_manager.txt");

					if (file.exists()) {

						FileReader fr = new FileReader(file);
						BufferedReader br = new BufferedReader(fr);

						String line = br.readLine();
						int count = Integer.parseInt(line);
						StudentEx[] temp = new StudentEx[count];

						for (int i = 0; i < count; i++) {
							temp[i] = new StudentEx();
							line = br.readLine();
							String value[] = line.split(",");
							temp[i].id = value[0];
							temp[i].pw = value[1];
						}

						fr.close();
						br.close();

						manager.load_StudentEx(temp, count);

					}

					manager.print_StudentEx();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			// [7] 종료하기 : 반복문을 종료
			else if (sel == 7) {
				break;
			}

		}
		scan.close();

	}

}
