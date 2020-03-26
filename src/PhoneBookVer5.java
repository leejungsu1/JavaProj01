import java.util.Scanner;

import ver05.MenuItem;
import ver05.PhoneBookManager;
import ver05.PhoneInfo;

public class PhoneBookVer5 implements MenuItem {

	public static void main(String[] args) {
		
		PhoneBookManager phoneBook = new PhoneBookManager(100);
		
		while(true) {
			PhoneBookManager.printMenu();
			
			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();
			System.out.println("선택:"+ num);
			if(num==MenuItem.데이터입력) {
				PhoneBookManager.dataInput(num);
			}
			else if(num==MenuItem.데이터검색) {
				PhoneBookManager.dataSearch();
			}
			else if(num==MenuItem.데이터삭제) {
				PhoneBookManager.dataDelete();
			}
			else if(num==4) {
				PhoneBookManager.dataAllShow();
			}
			else if(num==MenuItem.프로그램종료) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}
