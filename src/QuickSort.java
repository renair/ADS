import java.util.Comparator;


public class QuickSort implements SortStrategy {

	@Override
	public <T extends Comparable<T>> void Sort(T[] array) {
		// TODO Auto-generated method stub
		QSort(array,0,array.length-1);
	}

	@Override
	public <T extends Comparable<T>> void Sort(T[] array,
			Comparator<T> compare) {
		// TODO Auto-generated method stub
		QSort(array,0,array.length-1,compare);
	}
	
	public <T extends Comparable<T>> void QSort(T[] array,int Start, int End)
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
		QSort(array, Start, current-1);
		QSort(array, current+1, End);
	}
	
	public static <T extends Comparable<T>> void QSort(T[] array,int Start, int End, Comparator<T> Comp)
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
		QSort(array, Start, current-1, Comp);
		QSort(array, current+1, End, Comp);
	}

	private static <T> void exch(T[] a, int i, int j)
	{
		T tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
