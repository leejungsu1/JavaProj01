package ver07;

public class PhoneSchoolInfo extends PhoneInfo{
	
	String major;
	int year;
	
	public PhoneSchoolInfo(String name, String phoneNumber, String major, int year) {
		super(name, phoneNumber);
		this.major = major;
		this.year = year;
	}
}
