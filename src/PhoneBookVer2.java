import java.util.Scanner;

import ver02.PhoneInfo;

public class PhoneBookVer2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("선택하세요.");
			System.out.println("1. 데이터 입력");
			System.out.println("2. 프로그램 종료");
			int exit = scan.nextInt();
			System.out.println("선택:"+ exit);
			if(exit==1) {
				System.out.print("이름:");
				String name = scan.next();
				System.out.print("전화번호:");
				String phone = scan.next();
				System.out.print("생년월일:");
				String birth = scan.next();
				System.out.println("입력된 정보 출력");
				System.out.println("name:"+ name);
				System.out.println("phone:"+ phone);
				System.out.println("birth:"+ birth);
			}
			else if(exit==2) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}
