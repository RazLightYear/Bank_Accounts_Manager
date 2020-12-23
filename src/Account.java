
public class Account 
{
	private String AccountNumber,PinNumber,IdNum,First_Name,Last_Name,Date_Of_Birth,Gender,Address,Phone,Email;
	private double AccountBalance=0;
	private double SavingsBalance=0;
	
	public Account()
	{
		
	}
	
	public Account(String AccountNumber,String PinNumber,String ID,String FirstName,String LastName,
			String DateOfBirth,String Gender,String address,String phone,String email)
	{
		this.setAccountNumber(AccountNumber);
		this.setPinNumber(PinNumber);
		this.setIdNum(ID);
		this.setFirst_Name(FirstName);
		this.setLast_Name(LastName);
		this.setDate_Of_Birth(DateOfBirth);
		this.setGender(Gender);
		this.setAddress(address);
		this.setPhone(phone);
		this.setEmail(email);
	}

	public String getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}

	public String getPinNumber() {
		return PinNumber;
	}

	public void setPinNumber(String pinNumber) {
		PinNumber = pinNumber;
	}

	public String getIdNum() {
		return IdNum;
	}

	public void setIdNum(String idNum) {
		IdNum = idNum;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

	public String getDate_Of_Birth() {
		return Date_Of_Birth;
	}

	public void setDate_Of_Birth(String date_Of_Birth) {
		Date_Of_Birth = date_Of_Birth;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public double getAccountBalance() {
		return AccountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		AccountBalance = accountBalance;
	}

	public double getSavingsBalance() {
		return SavingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		SavingsBalance = savingsBalance;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	
	
}
