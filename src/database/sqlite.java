package database;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.lang.SecurityException;

class sqlitedriver{
	
	boolean write_to_log_file (File log_file, String log_stream)
	{
		boolean done = false;
		try {
			
			FileOutputStream file_writer = new FileOutputStream(log_file);
			FileInputStream file_reader = new FileInputStream(log_file);
			int char_value = 0, file_index = 0;
			int file_store[] = new int[10000];
			String file_stream_string = "";
			
			while (file_index <= log_file.length())
			{
				int i = 0;
				
				for (i = file_index; i < file_index + 10000; i++)
				{
					file_store[i%10000] = file_reader.read();
					file_stream_string = file_stream_string.concat(String.valueOf(file_store[i%10000]));
				}
				
				file_index = i + 10000;
			}
			
			String log_title = "#"+LocalDateTime.now()+"\n";
			
			for (int i = 0; i < log_stream.length(); i++)
			{
				char_value = log_stream.charAt(i) - '0';
				file_stream_string = file_stream_string + char_value;
			}
			
			for (int i = 0; i < file_stream_string.length(); i++)
			{
				char_value = file_stream_string.charAt(i) - '0';
				file_writer.write(char_value);
			}
			
			for (int i = 0; i < 10000; i++)
				file_store[i] = 0;
			file_index = 0;
			char_value = 0;
			
			for (int i = 0; i < file_stream_string.length(); i++)
				file_stream_string.replace(file_stream_string.charAt(i), '\0');
			file_reader.close();
			file_writer.close();
			
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(SecurityException e)
		{
			e.printStackTrace();
		}
		
		return done;
	}
	
	boolean create_database_file(File database_file)
	{
		try {
			
			boolean file_created = database_file.createNewFile();
			
			if (file_created == true)
			{
				FileOutputStream output_stream = new FileOutputStream(database_file);
				String header = "SQLite format 3\000";
				int number = 0;
				
				for (int i = 0; i < header.length(); i++)
				{
					number = header.charAt(i) - '0';
					output_stream.write(number);
				}
				
				output_stream.close();
			}
			
			else {
				System.out.println("File not created");
			}
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("");
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		
		return true;
	}
	
	String query (File database_file, String query_string)
	{
		int char_value = 0, file_index = 0;
		String query_result = "";
		char text_window[] = new char[1024];
		
		try {
				FileInputStream file_stream = new FileInputStream(database_file);
				byte file_contents[] = file_stream.readAllBytes();
				System.out.println(file_contents.length);
				int page_size = file_contents[1] + file_contents[2];
		}catch(FileNotFoundException e)
		{
			File file_log = new File("../../Logs/sqlite/file_log"+LocalDateTime.now()+".md");
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String stack_trace = sw.toString();
			String log = "#"+LocalDateTime.now()+"\n";
			boolean done = write_to_log_file(file_log,log);
			
			try{
				sw.close();
				pw.close();
			}catch(IOException e1)
			{
				e1.printStackTrace();
			}
			
			if (done == true)
				System.out.println("File log written");
			else
				System.out.println("File log not written");
		}
		catch (IOException e)
		{
			File io_log = new File("../../Logs/sqlite/io_log"+LocalDateTime.now()+".md");
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String stack_trace = sw.toString();
			String log = "#"+LocalDateTime.now()+"\n"+stack_trace;
			boolean done = write_to_log_file(io_log,log);
			
			try{
				sw.close();
				pw.close();
			}catch(IOException e1)
			{
				e1.printStackTrace();
			}
			
			if (done == true)
				System.out.println("IO log written");
			else
				System.out.println("IO log not written");
		}
		catch(SecurityException e)
		{
			File security_log = new File("../../Logs/sqlite/io_log"+LocalDateTime.now()+".md");
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String stack_trace = sw.toString();
			String log = "#"+LocalDateTime.now()+"\n"+stack_trace;
			boolean done = write_to_log_file(security_log,log);
			
			
			try{
				sw.close();
				pw.close();
			}catch(IOException e1)
			{
				e1.printStackTrace();
			}
			
			if (done == true)
				System.out.println("Security log written");
			else
				System.out.println("Security log not written");
		}
		
		return query_result;
	}
}

public class sqlite{
	public static void main (String args[])
	{
		sqlitedriver driver = new sqlitedriver();
		File database_file = new File("development.sqlite3");
		driver.query(database_file, null);
	}
}