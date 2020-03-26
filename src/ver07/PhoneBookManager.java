package ver07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookManager implements SubMenuItem{
	
	private HashSet<PhoneInfo> person;
	
	public PhoneBookManager() {
		person = new HashSet<PhoneInfo>();
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
		String name, phoneNumber;
		
		System.out.println("데이터를 입력을 시작합니다.");
		System.out.println("1.일반, 2.동창, 3.회사");
		int chioce = scan.nextInt();
		System.out.print("선택>>>"+ chioce +"\n");
		System.out.print("이름:");
		name = scan.next();
		System.out.print("전화번호:");
		phoneNumber = scan.next();
	
		if(num==SubMenuItem.일반) {
			person.add(new PhoneInfo(name, phoneNumber));
		}
		else if(num==SubMenuItem.학교동창) {
			System.out.print("전공:");
			String major = scan.next();
			System.out.print("학년:");
			int year = scan.nextInt();
			person.add(new PhoneSchoolInfo(name, phoneNumber, major, year));
		}
		else if(num==SubMenuItem.회사동료) {
			System.out.print("회사명:");
			String company = scan.next();
			person.add(new PhoneCompanyInfo(name, phoneNumber,company));
		}
		
		System.out.println("데이터를 입력을 완료되었습니다.");
	}
	public void dataSearch() {
		Scanner scan = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다.");
		System.out.print("이름:");
		String SearchName = scan.next();
		boolean searchFlag = false;
		Iterator<PhoneInfo> itr = person.iterator();
		while(itr.hasNext()) {
			PhoneInfo p = itr.next();
			if(SearchName.equals(p.name)) {
				searchFlag = true;
				System.out.println();
			}
		}
		if(searchFlag==true) {
			System.out.println("데이터 검색이 완료되었습니다.");
		}
		else {
			System.out.println("검색할 데이터가 없습니다.");
		}
		
	}
	public void dataDelete() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름:");
		String deleteName = scan.nextLine();
		System.out.println("데이터 삭제를 시작합니다.");
		person.remove(deleteName);
		System.out.println("데이터 삭제가 완료되었습니다");
	}
	public void dataAllShow() {
		System.out.println("주소록 출력을 시작합니다.");
		for(PhoneInfo per : person){
			System.out.println(per.toString());	
		}
		System.out.println("주소록 출력이 완료되었습니다.");
	}
}
