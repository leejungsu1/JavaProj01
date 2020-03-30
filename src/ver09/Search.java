package ver09;

import java.sql.SQLException;

public class Search extends IConnectImpl{
	String name;
	String phoneNumber;
	String birthday;
	
	public Search(String name) {
		super("kosmo","1234");
		this.name = name;
	}
	@Override
	public void execute() {
		try {
			stmt = con.createStatement();
		
			String query = "SELECT * "
					+ " FROM phonebook_tb "
					+ " WHERE name LIKE '%'||"+ name +"||'%'";
			rs = stmt.executeQuery(query);
		
			while(rs.next()) {
				
				name = rs.getString("name");
				phoneNumber = rs.getString("phoneNumber");
				birthday = rs.getString("birthday");
				
				System.out.printf("%s %s %s\n", name , phoneNumber, birthday);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
}
