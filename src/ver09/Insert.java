package ver09;

import java.util.Scanner;

public class Insert extends IConnectImpl{
	
	String name;
	String phoneNumber;
	String birthday;
	
	public Insert(String name, String phoneNumber, String birthday) {
		super("kosmo","1234");
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	@Override
	public void execute() {
		try {
			String query = "INSERT INTO phonebook_tb VALUES (seq_phonebook.nextval, ?, ?, ?)";
			psmt = con.prepareStatement(query);
			
			psmt.setString(1, name);
			psmt.setString(2, phoneNumber);
			psmt.setString(3, birthday);
			
			int affected = psmt.executeUpdate();
			System.out.println(affected+"행이 입력되었습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

}
