import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.sql.Time;
import java.util.Arrays;
import java.util.Random;
import java.io.*;

public class Main
{
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args)
	{
		try
		{
			File f = new File("log.txt");
			if(!f.exists())
			{
				f.createNewFile();
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		FileWriter writer;
		BufferedReader reader;
		File f;
		String s;
		Stopwatch timer = new Stopwatch();
		Random r = new Random();
		Integer[] arr;
		for(int i = 1024;i <= 32768;i*=2)
		{
			try
			{
				writer = new FileWriter("log.txt",true);
				reader = new BufferedReader(new FileReader("files\\"+i+"_sortedAsc.txt"));
				arr = new Integer[i];
				int counter = 0;
				while(counter < i-1)
				{
					String sq = reader.readLine();
					arr[counter++] = Integer.parseInt(sq);
				}
				writer.write(compareSorter(arr,"ASCENDING"));
				writer.flush();
				
				System.out.println("continue "+i);
				reader = new BufferedReader(new FileReader("files\\"+i+"_sortedDesc.txt"));
				arr = new Integer[i];
				counter = 0;
				while(counter < i-1)
				{
					String sq = reader.readLine();
					arr[counter++] = Integer.parseInt(sq);
				}
				writer.write(compareSorter(arr,"DESCENDING"));
				writer.flush();
				
				reader = new BufferedReader(new FileReader("files\\"+i+"_equal.txt"));
				arr = new Integer[i];
				counter = 0;
				while(counter < i-1)
				{
					String sq = reader.readLine();
					arr[counter++] = Integer.parseInt(sq);
				}
				writer.write(compareSorter(arr,"EQUAL"));
				writer.flush();
				
				reader = new BufferedReader(new FileReader("files\\"+i+"_random.txt"));
				arr = new Integer[i];
				counter = 0;
				while(counter < i-1)
				{
					String sq = reader.readLine();
					arr[counter++] = Integer.parseInt(sq);
				}
				writer.write(compareSorter(arr,"RANDOM"));
				writer.write("\n\n");
				writer.flush();
			}
			catch(IOException e)
			{
				System.out.println("error " + e.getLocalizedMessage());
			}
		}
	}
	
	private static String compareSorter(Integer[] array,String type)
	{
		Stopwatch s = new Stopwatch();
		String result = "\t======"+type+"======\n";
		Integer[] tmp;
		
		tmp = Arrays.copyOf(array, array.length-1);
		s.startTime();
		Sorter.QuickSort(tmp, 0, tmp.length-1);
		result += "Quick sort on " + array.length + " elements:\t" + s.stopTimer() + "s\n";
		
		tmp = Arrays.copyOf(array, array.length-1);
		s.startTime();
		Sorter.QuickSortFast(tmp, 0, tmp.length-1);
		result += "QuickFast sort on " + array.length + " elements:\t" + s.stopTimer() + "s\n";
		
		tmp = Arrays.copyOf(array, array.length-1);
		s.startTime();
		Sorter.MergeSort(tmp);
		result += "Merge sort on " + array.length + " elements:\t" + s.stopTimer() + "s\n";
		
		/*
		tmp = Arrays.copyOf(array, array.length-1);
		s.startTime();
		Sorter.HeapSort(tmp);
		result += "Heap sort on " + array.length + " elements:\t" + s.stopTimer() + "s\n";
		*/
		
		result += "\n\n";
		return result;
	}
}
