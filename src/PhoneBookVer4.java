import java.util.Scanner;

import ver04.PhoneBookManager;
import ver04.PhoneInfo;

public class PhoneBookVer4 {

	public static void main(String[] args) {
		
		PhoneBookManager phoneBook = new PhoneBookManager(100);
		
		while(true) {
			PhoneBookManager.printMenu();
			
			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();
			System.out.println("선택:"+ num);
			if(num==1) {
				PhoneBookManager.dataInput(num);
			}
			else if(num==2) {
				PhoneBookManager.dataSearch();
			}
			else if(num==3) {
				PhoneBookManager.dataDelete();
			}
			else if(num==4) {
				PhoneBookManager.dataAllShow();
			}
			else if(num==5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}
