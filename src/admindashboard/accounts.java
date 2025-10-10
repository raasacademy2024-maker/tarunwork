package admindashboard;
import java.util.ArrayList;

class admin_accounts{
	ArrayList<String> account_names;
	ArrayList<String> account_passwords;
	
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
	
	ArrayList<String> account_names;
	ArrayList<String> account_passwords;
	
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

public class accounts{
	public static void main (String args[])
	{
		
	}
}