import java.util.InputMismatchException;
import java.util.Scanner;

import ver07.MenuItem;
import ver07.MenuSelectException;
import ver07.PhoneBookManager;
import ver07.PhoneInfo;

public class PhoneBookVer7 {

	public static void main(String[] args) {
		
		PhoneBookManager phoneBook = new PhoneBookManager(100);
		
		while(true) {
			try {
				PhoneBookManager.printMenu();
				int num = chioceNum();
			
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
			catch(MenuSelectException e) {
				System.out.println("[예외발생]"+ e.getMessage());
				
			}
			catch(InputMismatchException e) {
				System.out.println("[예외발생]"+ e.getMessage());
			}
			catch(NullPointerException e) {
				System.out.println("[예외발생]"+ e.getMessage());
			}
		}
	}
	public static int chioceNum() throws MenuSelectException{
		Scanner scan = new Scanner(System.in);
		int num =0;
		try {
			num = scan.nextInt();
		}
		catch(InputMismatchException e) {
			e.printStackTrace();
			System.exit(0);
		}
		if(!(num==1 || num==2 || num==3 || num==4 || num==5)) {
			MenuSelectException ex = new MenuSelectException();
			throw ex;
		}
		return num;
	}
}
