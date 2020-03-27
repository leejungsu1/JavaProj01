import java.util.Scanner;

import ver09.PhoneBookManager;
import ver09.PhoneInfo;

public class PhoneBookVer9 {

	public static void main(String[] args) {
		
		PhoneBookManager phoneBook = new PhoneBookManager(100);
		
		while(true) {
			phoneBook.printMenu();
			
			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();
			System.out.println("선택:"+ num);
			if(num==1) {
				phoneBook.dataInput(num);
			}
			else if(num==2) {
				phoneBook.dataSearch();
			}
			else if(num==3) {
				phoneBook.dataDelete();
			}
			else if(num==4) {
				phoneBook.dataAllShow();
			}
			else if(num==5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}
