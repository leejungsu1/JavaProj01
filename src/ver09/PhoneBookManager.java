package ver09;

import java.util.Scanner;
import ver09.PhoneInfo;

public class PhoneBookManager {
	
	private PhoneInfo[] person;
	private int numOfPerson;
	String name, phoneNumber, birthday;

	public PhoneBookManager(int num) {
		person = new PhoneInfo[num];
		numOfPerson = 0;
	}
	public void printMenu() {
		System.out.println("선택하세요.");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
	}
	public void  dataInput (int num) {
		Scanner scan = new Scanner(System.in);
		String name, phoneNumber, birthday;
		
		System.out.println("데이터를 입력을 시작합니다.");
		System.out.print("이름:");
		name = scan.next();
		System.out.print("전화번호:");
		phoneNumber = scan.next();
		System.out.print("생년월일:");
		birthday = scan.next();
		
		new Insert(name, phoneNumber, birthday).execute();
		person[numOfPerson++] = new PhoneInfo(name, phoneNumber, birthday);
		
		System.out.println("데이터 입력을 완료되었습니다.");
	}
	public void dataSearch() {
		Scanner scan = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다.");
		System.out.print("이름:");
		String SearchName = scan.next();
		
		for(int i=0; i<numOfPerson ; i++) {
			
			if(SearchName.compareTo(person[i].name)==0) {
				person[i].showPhoneInfo();
				new Search(SearchName).execute();;
				System.out.println("데이터 검색이 완료되었습니다.");
			}
		}
	}
	public void dataDelete() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름:");
		String deleteName = scan.next();
		
		int deleteIndex = -1;
		
		for(int i=0 ; i<numOfPerson ; i++) {
			if(deleteName.compareTo(person[i].name)==0) {
				new Delete(deleteName).execute();
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
	public void dataAllShow() {
		for(int i=0 ; i<numOfPerson ; i++) {
			person[i].showPhoneInfo();
		}
		System.out.println("주소록 출력이 완료되었습니다.");
	}
}
