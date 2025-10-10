package admindashboard;
import java.util.ArrayList;

class sales{
	ArrayList<String> account_holder_names;
	ArrayList<Long> sale_value;
	ArrayList<String> bank_account_number;
	ArrayList<String> regional_bank_code;
	ArrayList<String> courses_sold;
	
	boolean add_account_details (String account_holder_name, long sale_amount, String bank_account_number_1, String bank_regional_code, String course_sold)
	{
		account_holder_names.add(account_holder_name);
		sale_value.add(sale_amount);
		bank_account_number.add(bank_account_number_1);
		regional_bank_code.add(bank_regional_code);
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
				bank_account_number.remove(i);
				regional_bank_code.remove(i);
			}
		}
		
		return true;
	}
	
	boolean clear_list ()
	{
		account_holder_names.clear();
		sale_value.clear();
		bank_account_number.clear();
		regional_bank_code.clear();
		
		return true;
	}
}


public class accounting{
	
	public static void main (String args[])
	{
		sales s = new sales();
		long sale_value = 500;
		String bank_account_number = "500020001";
		boolean done = s.add_account_details("Tarun", sale_value, bank_account_number, "500010020", "Astrology");
		
	}
}