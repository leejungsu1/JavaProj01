package ver07;

public class PhoneCompanyInfo extends PhoneInfo{
	
	String company;

	public PhoneCompanyInfo(String name, String phoneNumber, String company) {
		super(name, phoneNumber);
		this.company = company;
	}
}
