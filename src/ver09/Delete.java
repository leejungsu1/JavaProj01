package ver09;

public class Delete extends IConnectImpl{
	String name;
	
	public Delete(String name) {
		super("kosmo","1234");
		this.name = name;
	}
	
	@Override
	public void execute() {
		try {
			String query = "DELETE FROM phonebook_tb WHERE name=?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, name);
			System.out.println(psmt.executeUpdate()+"행이 삭제되었습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
}
