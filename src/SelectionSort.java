import java.util.Comparator;


public class SelectionSort implements SortStrategy {
	public <T extends Comparable<T>> void Sort(T[] array) {
		// TODO Auto-generated method stub
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
	}

	@Override
	public <T extends Comparable<T>> void Sort(T[] array, Comparator<T> compare) {
		// TODO Auto-generated method stub
		int minIndex;
		for(int i = 0;i < array.length-1;i++)
		{
			minIndex = i;
			int min = 0;
			for(int j = i+1;j < array.length;j++)
			{
				if(compare.compare(array[i], array[j]) > min)
				{
					minIndex = j;
					min = compare.compare(array[i], array[j]);
				}
			}
			exch(array, minIndex, i);
		}

	}
	
	private static <T> void exch(T[] a, int i, int j)
	{
		T tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

}
