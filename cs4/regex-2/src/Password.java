// Score: 90

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password
{
	private String pass;
	public Password(String pass)
	{
		this.pass = pass;
	}
	private boolean validate(){
		Pattern p = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W])[a-zA-Z\\d\\W]{6,20}$");
		//positive lookahead + ending matching length
		Matcher matcher = p.matcher(pass);
		return matcher.find();
	}

	public String toString()
	{
		return String.format("%s is %s\n", pass, validate()?"valid":"invalid");
	}
}