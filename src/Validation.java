
public class Validation 
{

	public static boolean CheckUsernamePassword(String UserName, String Password) 
	{
		if(UserName.equals("Test") && Password.equals("123456")) return true;
		return false;
	}

}
