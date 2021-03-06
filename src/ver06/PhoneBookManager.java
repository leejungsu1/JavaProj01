package ver06;

import java.util.Scanner;

public class PhoneBookManager implements SubMenuItem{
	
	static PhoneInfo[] person;
	static int numOfPerson;

	public PhoneBookManager(int num) {
		person = new PhoneInfo[num];
		numOfPerson = 0;
	}
	public static void printMenu() {
		System.out.println("선택하세요.");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
	}
	public static void  dataInput (int num) {
		Scanner scan = new Scanner(System.in);
		String name, phoneNumber;
		
		System.out.println("데이터를 입력을 시작합니다.");
		System.out.println("1.일반, 2.동창, 3.회사");
		num = scan.nextInt();
		System.out.print("선택>>>"+ num +"\n");
		System.out.print("이름:");
		name = scan.next();
		System.out.print("전화번호:");
		phoneNumber = scan.next();
		
		if(num==SubMenuItem.일반) {
			person[numOfPerson++] = new PhoneInfo(name, phoneNumber);
		}
		else if(num==SubMenuItem.학교동창) {
			System.out.print("전공:");
			String major = scan.next();
			System.out.print("학년:");
			int year = scan.nextInt();
			person[numOfPerson++] = new PhoneSchoolInfo(name, phoneNumber, major, year);
		}
		else if(num==SubMenuItem.회사동료) {
			System.out.print("회사명:");
			String company = scan.next();
			person[numOfPerson++] = new PhoneCompanyInfo(name, phoneNumber,company);
		}
		
		System.out.println("데이터를 입력을 완료되었습니다.");
	}
	public static void dataSearch() {
		Scanner scan = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다.");
		System.out.print("이름:");
		String SearchName = scan.next();
		
		for(int i=0; i<numOfPerson ; i++) {
			
			if(SearchName.compareTo(person[i].name)==0) {
				dataAllShow();
				System.out.println("데이터 검색이 완료되었습니다.");
			}
		}
	}
	public static void dataDelete() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름:");
		String deleteName = scan.nextLine();
		
		int deleteIndex = -1;
		
		for(int i=0 ; i<numOfPerson ; i++) {
			if(deleteName.compareTo(person[i].name)==0) {
				person[i] = null;
				
				deleteIndex = i;
				
				numOfPerson--;
			}
		}
		if(deleteIndex==-1) {
			System.out.println("삭제할 데이터가 없습니다.");
		}
		else {
			for(int i=deleteIndex ; i<numOfPerson ; i++) {
				person[i] = person[i+1];
			}
			System.out.println("데이터 삭제가 완료되었습니다.");
		}
	}
	public static void dataAllShow() {
		for(int i=0 ; i<numOfPerson ; i++) {
			person[i].showPhoneInfo();
		}
		System.out.println("주소록 출력이 완료되었습니다.");
	}
}
