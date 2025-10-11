package admindashboard;

import java.util.ArrayList;

class sales{
	ArrayList<String> account_holder_names = new ArrayList<String>();
	ArrayList<Long> sale_value = new ArrayList<Long>();
	ArrayList<String> bank_account_numbers = new ArrayList<String>();
	ArrayList<String> regional_bank_codes = new ArrayList<String>();
	ArrayList<String> courses_sold = new ArrayList<String>();
	
	boolean add_account_details (String account_holder_name, long sale_amount, String bank_account_number_1, String bank_regional_code, String course_sold)
	{
		account_holder_names.add(account_holder_name);
		sale_value.add(sale_amount);
		bank_account_numbers.add(bank_account_number_1);
		regional_bank_codes.add(bank_regional_code);
		courses_sold.add(course_sold);
		
		return true;
	}
	
	boolean close_account (String account_holder_name)
	{
		for (int i = 0; i < account_holder_names.size(); i++)
		{
			if  (account_holder_names.get(i) == account_holder_name)
			{
				account_holder_names.remove(i);
				sale_value.remove(i);
				bank_account_numbers.remove(i);
				regional_bank_codes.remove(i);
			}
		}
		
		return true;
	}
	
	boolean clear_list ()
	{
		account_holder_names.clear();
		sale_value.clear();
		bank_account_numbers.clear();
		regional_bank_codes.clear();
		
		return true;
	}
}


public class accounting{
	
	public static void main (String args[])
	{
		sales s = new sales();
		boolean done = s.add_account_details("Tarun", 500, "500102010", "500010020", "Astrology");
		done = s.clear_list();
	}
}