package admindashboard;
import java.util.ArrayList;

class StringLongerThanExpectedException extends Exception{
	StringLongerThanExpectedException()
	{
		System.out.println("String is longer than expected");
	}
}

class admin_accounts{
	ArrayList<String> account_names = new ArrayList<String>();
	ArrayList<String> account_passwords = new ArrayList<String>();
	
	boolean add_account(String account_name, String account_password)
	{
		account_names.add(account_name);
		account_passwords.add(account_password);
		
		return true;
	}
	
	boolean remove_account (String account_name)
	{
		for (int i = 0; i < account_names.size(); i++)
		{
			if (account_names.get(i) == account_name)
			{
				account_names.remove(i);
				account_passwords.remove(i);
			}
		}
		
		return true;
	}
	
	String[] return_account_data (String account_name)
	{
		String account_data[] = new String[2];
		
		for (int i = 0; i < account_names.size(); i++)
		{
			if (account_names.get(i) == account_name)
			{
				account_data[0] = account_name;
				account_data[1] = account_passwords.get(i);
			}
		}
		
		return account_data;
	}
	
	boolean clear_list ()
	{
		account_names.clear();
		account_passwords.clear();
		
		return true;
	}
}

class promoter_accounts{
	
	ArrayList<String> account_names = new ArrayList<String>();
	ArrayList<String> account_passwords = new ArrayList<String>();
	
	boolean add_account(String account_name, String account_password)
	{
		account_names.add(account_name);
		account_passwords.add(account_password);
		
		return true;
	}
	
	boolean remove_account (String account_name)
	{
		for (int i = 0; i < account_names.size(); i++)
		{
			if (account_names.get(i) == account_name)
			{
				account_names.remove(i);
				account_passwords.remove(i);
			}
		}
		
		return true;
	}
	
	String[] return_account_data (String account_name)
	{
		String account_data[] = new String[2];
		
		for (int i = 0; i < account_names.size(); i++)
		{
			if (account_names.get(i) == account_name)
			{
				account_data[0] = account_name;
				account_data[1] = account_passwords.get(i);
			}
		}
		
		return account_data;
	}
	
	boolean clear_list ()
	{
		account_names.clear();
		account_passwords.clear();
		
		return true;
	}
}

class student_accounts{
	
	ArrayList<String> name = new ArrayList<String>();
	ArrayList<String> phone_number = new ArrayList<String>();
	ArrayList<String> email_id = new ArrayList<String>();
	ArrayList<String> brief_description = new ArrayList<String>();
	ArrayList<String> university_or_college_name = new ArrayList<String>();
	
	boolean add_account (String name1, String phone_number1, String email_id1, String brief_description1, String university_or_college_name1) throws StringLongerThanExpectedException
	{
		boolean done = false;
		
		if (brief_description1.length() > 250)
			throw new StringLongerThanExpectedException();
		
		else if (brief_description1.length() <= 250)
		{
			name.add(name1);
			phone_number.add(phone_number1);
			email_id.add(email_id1);
			brief_description.add(brief_description1);
			university_or_college_name.add(university_or_college_name1);
			
			done = true;
		}
		
		return done;
		
	}
	
	boolean remove_account (String account_name)
	{
		boolean done = false;
		
		for (int i = 0; i < name.size(); i++)
		{
			if (name.get(i) == account_name)
			{
				name.remove(i);
				phone_number.remove(i);
				email_id.remove(i);
				brief_description.remove(i);
				university_or_college_name.remove(i);
				
				done = true;
			}
		}
		
		return done;
	}
	
	String[] return_account_data (String account_name)
	{
		String account_data[] = new String[5];
		
		for (int i = 0; i < name.size(); i++)
		{
			if (name.get(i) == account_name)
			{
				account_data[0] = name.get(i);
				account_data[1] = phone_number.get(i);
				account_data[2] = email_id.get(i);
				account_data[3] = brief_description.get(i);
				account_data[4] = university_or_college_name.get(i);
			}
		}
		
		return account_data;
	}
	
	boolean clear_list()
	{
		boolean done = false;
		
		name.clear();
		phone_number.clear();
		email_id.clear();
		brief_description.clear();
		university_or_college_name.clear();
		
		done = true;
		
		return done;
	}
	
}

public class accounts{
	public static void main (String args[])
	{
		student_accounts s = new student_accounts();
		
		try{
			
			boolean done = s.add_account("Tarun", "+91 9849088200", "catchtherainbow6@protonmail.com", "My name is Tarun", "Manipal Institute of Technology");
		}catch(StringLongerThanExpectedException e)
		{
			e.printStackTrace();
			System.out.println();
		}
		
		String account_data[] = s.return_account_data("Tarun");
		
		System.out.println("Username : " + account_data[0]);
		System.out.println("Phone number : " + account_data[1]);
		System.out.println("Email id : " + account_data[2]);
		System.out.println("Brief description of the person : " + account_data[3]);
		System.out.println("University name : " + account_data[4]);
		
		account_data[0] = "";
		account_data[1] = "";
		account_data[2] = "";
		account_data[3] = "";
		account_data[4] = "";
		
		s.remove_account("Tarun");
		
		s.clear_list();
	}
}