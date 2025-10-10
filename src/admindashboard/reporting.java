package admindashboard;
import java.util.ArrayList;


class charts{
	ArrayList<Double> pie_chart_percentages;
	ArrayList<Double> histograms;
	ArrayList<Long> histograms1;
	
	boolean make_pie_chart (double data[])
	{
		double max = 0;
		
		for (int i = 0; i < data.length; i++)
		{
			if (max < data[i])
				max = data[i];
		}
		
		for (int i = 0; i < data.length; i++)
			pie_chart_percentages.add(data[i]/max);
		
		return true;
	}
	
	boolean make_pie_chart (long data[])
	{
		double max = 0;
		
		for (int i = 0; i < data.length; i++)
		{
			if (max < data[i])
				max = data[i];
		}
		
		for (int i = 0; i < data.length; i++)
			pie_chart_percentages.add(data[i]/max);
		
		return true;
	}
	
	boolean make_histogram (double data[])
	{
		for (int i = 0; i < data.length; i++)
			histograms.add(data[i]);
		
		return true;
	}
	
	boolean make_histogram (long data[])
	{
		for (int i = 0; i < data.length; i++)
			histograms1.add(data[i]);
		
		return true;
	}
}

public class reporting{
	public static void main (String args[])
	{
		
	}
}