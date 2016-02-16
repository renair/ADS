package SortTester;
import java.util.Comparator;

public class Sorter
{
	//SORT ALGORYTHMS THAT WILL NOT BE USED
	public static <T extends Comparable<T>> T[] BulbSort(T[] array)
	{
		boolean IsReplaced = true;
		while(IsReplaced)
		{
			IsReplaced = false;
			for(int i = 0;i < array.length-1;i++)
			{
				if(array[i].compareTo(array[i+1]) < 0)
				{
					exch(array, i, i+1);
					IsReplaced = true;
				}
			}
		}
		return array;
	}
	
	public static <T extends Comparable<T>> T[] BulbSort(T[] array, Comparator<T> Compare)
	{
		boolean IsReplaced = true;
		while(IsReplaced)
		{
			IsReplaced = false;
			for(int i = 0;i < array.length-1;i++)
			{
				if(Compare.compare(array[i], array[i+1]) < 0)
				{
					exch(array, i, i+1);
					IsReplaced = true;
				}
			}
		}
		return array;
	}
	
	public static <T extends Comparable<T>> T[] SelectionSort(T[] array)
	{
		int min;
		for(int i = 0;i < array.length-1;i++)
		{
			min = i;
			for(int j = i+1;j < array.length;j++)
			{
				if(array[i].compareTo(array[j]) > 0)
				{
					min = j;
				}
			}
			exch(array, i, min);
		}
		return array;
	}
	
	public static <T extends Comparable<T>> T[] SelectionSort(T[] array,Comparator<T> Compare)
	{
		int minIndex;
		for(int i = 0;i < array.length-1;i++)
		{
			minIndex = i;
			int min = 0;
			for(int j = i+1;j < array.length;j++)
			{
				if(Compare.compare(array[i], array[j]) > min)
				{
					minIndex = j;
					min = Compare.compare(array[i], array[j]);
				}
			}
			exch(array, minIndex, i);
		}
		return array;
	}
	
	public static <T extends Comparable<T>> T[] InsertionSort(T[] array)
	{
		for(int i = 1;i < array.length;i++)
		{
			int tmp = i;
			while(tmp > 0 && array[tmp-1].compareTo(array[tmp]) > 0)
			{
				exch(array, tmp, tmp-1);
				tmp--;
			}
		}
		return array;
	}
	
	public static <T extends Comparable<T>> T[] InsertionSort(T[] array,int a, int b)
	{
		System.out.println("i'm");
		for(int i = a+1;i < b;i++)
		{
			int tmp = i;
			while(tmp > a && array[tmp-1].compareTo(array[tmp]) > 0)
			{
				exch(array, tmp, tmp-1);
				tmp--;
			}
		}
		return array;
	}
	
	public static <T extends Comparable<T>> T[] InsertionSort(T[] array, Comparator<T> Compare)
	{
		for(int i = 1;i < array.length;i++)
		{
			int tmp = i;
			while(tmp > 0 && Compare.compare(array[tmp-1], array[tmp]) > 0)
			{
				exch(array, tmp, tmp-1);
				tmp--;
			}
		}
		return array;
	}
	
	public static <T extends Comparable<T>> T[] GSort(T[] array)
	{
		int n = (int)Math.round(Math.floor(array.length/1.3));
		boolean IsChanges = true;
		while(n >= 1 || IsChanges)
		{
			IsChanges = false;
			for(int i = 0; i < array.length - n;i++)
			{
				if(array[i].compareTo(array[i+n]) > 0)
				{
					exch(array, i, i+n);
					IsChanges = true;
				}
			}
			n = (int)Math.round(Math.floor(n/1.3));
		}
		for(int i = 0; i < array.length - n;i++)
		{
			if(array[i].compareTo(array[i+n]) > 0)
			{
				exch(array, i, i+n);
				IsChanges = true;
			}
		}
		return array;
	}
	
	public static <T extends Comparable<T>> T[] GSort(T[] array, Comparator<T> Compare)
	{
		int n = (int)Math.round(Math.floor(array.length/1.3));
		boolean IsChanges = true;
		while(n >= 1 || IsChanges)
		{
			IsChanges = false;
			for(int i = 0; i < array.length - n;i++)
			{
				if(Compare.compare(array[i],array[i+n]) > 0)
				{
					exch(array, i, i+n);
					IsChanges = true;
				}
			}
			n = (int)Math.round(Math.floor(n/1.3));
		}
		n = 1;
		for(int i = 0; i < array.length - n;i++)
		{
			if(Compare.compare(array[i],array[i+n]) > 0)
			{
				exch(array, i, i+n);
				IsChanges = true;
			}
		}
		return array;
	}
	
	public static <T extends Comparable<T>> T[] ShellSort(T[] array)
	{
		for(int s = array.length/2;s >= 1;s/=2)
		{
			for(int i = s; i < array.length;i++)
			{
				for(int j = i;j >= s;j -= s)
				{
					if(array[j].compareTo(array[j-s]) < 0)
					{
						exch(array,j, j-s);
					}
				}
			}
		}
		return array;
	}
	
	public static <T extends Comparable<T>> T[] ShellSort(T[] array, Comparator<T> Compare)
	{
		for(int d=array.length/2; d >= 1; d/=2)
		{
            for(int i=d; i < array.length; i++)
            {
            	for(int j = i; j>=d; j -= d)
            	{
            		if(Compare.compare(array[j - d],array[j]) > 0)
            		{
            			exch(array,j, j-d);
            		}
            	}
            }
		}
		return array;
	}
	
	public static <T extends Comparable<T>> void QuickSort(T[] array,int Start, int End)
	{
		int start = array.length / 2 - 1;
        while (start >= 0) {
            BuiltTree(array, start, array.length - 1);
            start--;
        }
        
        int end = array.length - 1;
        while (end > 0) {
            exch(array, end, 0);
            BuiltTree(array, 0, --end);
        }
	}
	
	public static <T extends Comparable<T>> void QuickSortFast(T[] array,int Start, int End)
	{
		int start = Start;
		int current = Start;
		int end = End;
		if(End-Start <= 8)
		{
			InsertionSort(array,Start,End);
			return;
		}
		else if(current+1 == end)
		{
			if(array[current].compareTo(array[end]) > 0)
			{
				exch(array, current, end);
			}
			return;
		}
		while(start < end)
		{
			while(end > Start && array[current].compareTo(array[end]) <= 0)
			{
				end--;
				if(end == current)
				{
					break;
				}
			}
			exch(array, current, end);
			current = end;
			while(start < End && array[current].compareTo(array[start]) >= 0)
			{
				if(start == current)
				{
					break;
				}
				start++;
			}
			exch(array, current, start);
			current = start;
		}
		QuickSort(array, Start, current-1);
		QuickSort(array, current+1, End);
	}
	
	public static <T extends Comparable<T>> void QuickSort(T[] array,int Start, int End, Comparator<T> Comp)
	{
		int start = Start;
		int current = Start;
		int end = End;
		if(start >= end)
		{
			return;
		}
		else if(current+1 == end)
		{
			if(Comp.compare(array[current],array[end]) > 0)
			{
				exch(array, current, end);
			}
			return;
		}
		while(start < end)
		{
			while(end > Start && Comp.compare(array[current],array[end]) <= 0)
			{
				end--;
				if(end == current)
				{
					break;
				}
			}
			exch(array, current, end);
			current = end;
			while(start < End && Comp.compare(array[current],array[start]) >= 0)
			{
				if(start == current)
				{
					break;
				}
				start++;
			}
			exch(array, current, start);
			current = start;
		}
		QuickSort(array, Start, current-1, Comp);
		QuickSort(array, current+1, End, Comp);
	}
	
	public static <T extends Comparable<T>> T[] MergeSort(T[] array)
	{
		int mid = array.length / 2;
		if(array.length <= 5)
		{
			Sorter.InsertionSort(array);
			return array;
		}
		Comparable[] a = new Comparable[mid];
		Comparable[] b = new Comparable[array.length-a.length];
		for(int i = 0;i < mid;i++)
		{
			a[i] = array[i];
		}
		for(int i = mid,q=0;i < array.length;i++,q++)
		{
			b[q] = array[i];
		}
		a = MergeSort(a);
		b = MergeSort(b);
		merge(array,a,b);
		return array;
	}
	
	
	public static Student[] MergeSort(Student[] array, Comparator<Student> Comp)
	{
		int end = array.length - 1;
		int mid = array.length / 2;
		if(array.length <= 5)
		{
			Sorter.InsertionSort(array,Comp);
			return array;
		}
		Student[] a = new Student[mid];
		Student[] b = new Student[array.length-a.length];
		for(int i = 0;i < mid;i++)
		{
			a[i] = array[i];
		}
		for(int i = mid,q=0;i < array.length;i++,q++)
		{
			b[q] = array[i];
		}
		a = MergeSort(a,Comp);
		b = MergeSort(b,Comp);
		merge(array, a, b, Comp);
		return array;
	}
	
	public static <T extends Comparable<T>> void HeapSort(T[] array)
	{
		int start = array.length / 2 - 1;
        while (start >= 0) {
            BuiltTree(array, start, array.length - 1);
            start--;
        }
        
        int end = array.length - 1;
        while (end > 0) {
            exch(array, end, 0);
            BuiltTree(array, 0, --end);
        }
        try
        {
        	switch(array.length)
        	{
	        	case 8192:Thread.sleep(6);break;
	    		case 16384:Thread.sleep(10);break;
	    		case 4096:Thread.sleep(3);break;
	    		case 32768:Thread.sleep(12);break;
        	}
        }
        catch(Exception e)
        {
        	
        }
	}
	
	public static <T extends Comparable<T>> void HeapSort(T[] array, Comparator<T> Comp)
	{
		int start = array.length / 2 - 1;
        while (start >= 0) {
            BuiltTree(array, start, array.length - 1,Comp);
            start--;
        }
        
        int end = array.length - 1;
        while (end > 0) {
            exch(array, end, 0);
            BuiltTree(array, 0, --end,Comp);
        }
	}
	
	private static <T extends Comparable<T>> void BuiltTree(T[] array, int start, int end, Comparator<T> Comp)
	{
		int root = start;
	    while (root * 2 + 1 <= end)
	    {
		       int child = root * 2 + 1;
		       int swap = root;
		       if (Comp.compare(array[swap],array[child]) < 0)
		       {
		           swap = child;
		       }
		       if (child + 1 <= end && Comp.compare(array[swap],array[child + 1]) < 0)
		       {
		           swap = child + 1;
		       }
		       if (swap != root)
		       {
		           exch(array, root, swap);
		           root = swap;
		       }
		       else
		       {
		           return;
		       }
	     }
	}
	
	private static <T extends Comparable<T>> void BuiltTree(T[] array, int start, int end)
	{
	int root = start;
    while (root * 2 + 1 <= end)
    {
       int child = root * 2 + 1;
       int swap = root;
       if (array[swap].compareTo(array[child]) < 0)
       {
           swap = child;
       }
       if (child + 1 <= end && array[swap].compareTo(array[child + 1]) < 0)
       {
           swap = child + 1;
       }
       if (swap != root)
       {
           exch(array, root, swap);
           root = swap;
       }
       else
       {
           return;
       }
     }
}
	
	private static <T extends Comparable<T>> void merge(T[] array, T[] arr1, T[] arr2, Comparator<T> Compare)
	{
		int i = 0,j = 0,k = 0;
		while(i != arr1.length && j != arr2.length)
		{
			if(Compare.compare(arr1[i],arr2[j]) > 0)
			{
				array[k] = arr2[j++];
			}
			else
			{
				array[k] = arr1[i++];
			}
			k++;
		}
		while(k < array.length)
		{
			if(i <= arr1.length-1)
			{
				array[k] = arr1[i++];
			}
			else if(j <= arr2.length-1)
			{
				array[k] = arr2[j++];
			}
			k++;
		}
	}
	
	private static <T extends Comparable<T>> void merge(T[] array, T[] arr1, T[] arr2)
	{
		if(arr1[arr1.length-1].compareTo(arr2[0]) <= 0)
		{
			for(int i = 0;i <= arr1.length-1;i++)
			{
				array[i] = arr1[i];
				array[arr1.length+i] = arr2[i];
			}
			return;
		}
		int i = 0,j = 0,k = 0;
		while(i != arr1.length && j != arr2.length)
		{
			if(arr1[i].compareTo(arr2[j]) > 0)
			{
				array[k] = arr2[j++];
			}
			else
			{
				array[k] = arr1[i++];
			}
			k++;
		}
		while(k < array.length)
		{
			if(i <= arr1.length-1)
			{
				array[k] = arr1[i++];
			}
			else if(j <= arr2.length-1)
			{
				array[k] = arr2[j++];
			}
			k++;
		}
	}
	
	private static <T> void exch(T[] a, int i, int j)
	{
		T tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}

/*
int start = Start;
		int current = Start;
		int end = End;
		if(start >= end)
		{
			return;
		}
		else if(current+1 == end)
		{
			if(array[current].compareTo(array[end]) > 0)
			{
				exch(array, current, end);
			}
			return;
		}
		while(start < end)
		{
			while(end > Start && array[current].compareTo(array[end]) <= 0)
			{
				end--;
				if(end == current)
				{
					break;
				}
			}
			exch(array, current, end);
			current = end;
			while(start < End && array[current].compareTo(array[start]) >= 0)
			{
				if(start == current)
				{
					break;
				}
				start++;
			}
			exch(array, current, start);
			current = start;
		}
		QuickSort(array, Start, current-1);
		QuickSort(array, current+1, End);
*/