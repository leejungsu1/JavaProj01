import java.util.InputMismatchException;
import java.util.Scanner;

import ver08.MenuItem;
import ver08.MenuSelectException;
import ver08.PhoneBookManager;
import ver08.PhoneInfo;

public class PhoneBookVer8 {

	public static void main(String[] args) {
		
		PhoneBookManager phoneBook = new PhoneBookManager(100);
		phoneBook.readData();
		while(true) {
			try {
				phoneBook.printMenu();
				int num = chioceNum();
			
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
					phoneBook.saveData();
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
