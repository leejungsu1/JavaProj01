package ver08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager implements SubMenuItem{
	
	private HashSet<PhoneInfo> person;
	private int num;
	
	public PhoneBookManager(int num) {
		person = new HashSet<PhoneInfo>();
		this.num = 0;
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
		num = scan.nextInt();
		System.out.print("선택>>>"+ num +"\n");
		System.out.print("이름:");
		name = scan.next();
		System.out.print("전화번호:");
		phoneNumber = scan.next();
		
		
		if(num==SubMenuItem.일반) {
			Iterator<PhoneInfo> itr = person.iterator();
			
			while(itr.hasNext()) {
				PhoneInfo p = new PhoneInfo(name, phoneNumber);
				PhoneInfo i = itr.next();
				if(i.equals(p)==true) {
					System.out.println("동일한 정보가 있습니다.");
					System.out.print("덮어쓸려면 1, 덮어쓰지않을려면 2를 입력하세요.");
					int write = scan.nextInt();
					if(write==1) {
						person.remove(i);
						person.add(p);
					}
					else {
						num = 0;
					}
				}
				break;
			}
			if(num!=0) {
				person.add(new PhoneInfo(name, phoneNumber));
			}
		}
		else if(num==SubMenuItem.학교동창) {
			System.out.print("전공:");
			String major = scan.next();
			System.out.print("학년:");
			int year = scan.nextInt();
			
			Iterator<PhoneInfo> itr = person.iterator();
			while(itr.hasNext()) {
				PhoneInfo p = new PhoneSchoolInfo(name, phoneNumber,major, year);
				PhoneInfo i = itr.next();
				if(i.equals(p)==true) {
					System.out.println("동일한 정보가 있습니다.");
					System.out.print("덮어쓸려면 1, 덮어쓰지않을려면 2를 입력하세요.");
					int write = scan.nextInt();
					if(write==1) {
						person.remove(i);
						person.add(p);
					}
					else {
						num = 0;
					}
				}
				break;
			}
			if(num!=0) {
				person.add(new PhoneSchoolInfo(name, phoneNumber, major, year));
			}
		}
		else if(num==SubMenuItem.회사동료) {
			System.out.print("회사명:");
			String company = scan.next();
			
			Iterator<PhoneInfo> itr = person.iterator();
			
			while(itr.hasNext()) {
				PhoneInfo p = new PhoneCompanyInfo(name, phoneNumber, company);
				PhoneInfo i = itr.next();
				if(i.equals(p)==true) {
					System.out.println("동일한 정보가 있습니다.");
					System.out.print("덮어쓸려면 1, 덮어쓰지않을려면 2를 입력하세요.");
					int write = scan.nextInt();
					if(write==1) {
						person.remove(i);
						person.add(p);
					}
					else {
						num = 0;
					}
				}
				break;
			}
			if(num!=0) {
				person.add(new PhoneCompanyInfo(name, phoneNumber,company));
			}
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
				p.showPhoneInfo();
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
		boolean search = false;
		Iterator<PhoneInfo> itr = person.iterator();
		
		while(itr.hasNext()) {
			PhoneInfo p = itr.next();
			if(deleteName.equals(p.name)) {
				search = true;
				person.remove(p);
				break;
			}
		}
		if(search==true) {
			System.out.println("데이터 삭제가 완료되었습니다");
		}
		else {
			System.out.println("삭제할 데이터가 없습니다.");
		}
	}
	public void dataAllShow() {
		System.out.println("주소록 출력을 시작합니다.");
		for(PhoneInfo per : person){
			per.showPhoneInfo();
		}
		System.out.println("주소록 출력이 완료되었습니다.");
	}
	public void saveData() {
		
		try {
			ObjectOutputStream out = 
					new ObjectOutputStream(new FileOutputStream("src/ver08/PhoneBook.obj"));
			
			out.writeObject(person);
			out.writeObject(null);
			out.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void readData() {
		try {
			ObjectInputStream in =
					new ObjectInputStream(new FileInputStream("src/ver08/PhoneBook.obj"));
			while(true) {
				HashSet<PhoneInfo> p = (HashSet<PhoneInfo>)in.readObject();
				if(p==null)break;
				person = p;
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
