package SortTester;

import java.util.Comparator;

public abstract class testMethod
{
	public static <T extends Comparable<T>> boolean isSortedAsc(T[] array)
	{
		for(int i = 1;i < array.length;i++)
		{
			if(array[i-1].compareTo(array[i]) > 0)
			{
				return false;
			}
		}
		return true;
	}
	
	public static <T extends Comparable<T>> boolean isSortedDesc(T[] array)
	{
		for(int i = 1;i < array.length;i++)
		{
			if(array[i-1].compareTo(array[i]) < 0)
			{
				return false;
			}
		}
		return true;
	}
	
	public static <T extends Comparable<T>> boolean isSortedAsc(T[] array,Comparator<T> C)
	{
		for(int i = 1;i < array.length;i++)
		{
			if(C.compare(array[i-1],array[i]) > 0)
			{
				return false;
			}
		}
		return true;
	}
	
	public static <T extends Comparable<T>> boolean isSortedDesc(T[] array,Comparator<T> C)
	{
		for(int i = 1;i < array.length;i++)
		{
			if(C.compare(array[i-1],array[i]) < 0)
			{
				return false;
			}
		}
		return true;
	}
	
	abstract public <T extends Comparable<T>> void sortAsc();
	abstract public <T extends Comparable<T>> void sortDesc();
	abstract public <T extends Comparable<T>> void sortAscComp();
	abstract public <T extends Comparable<T>> void sortDescComp();
}
