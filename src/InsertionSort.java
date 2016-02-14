import java.util.Comparator;


public class InsertionSort implements SortStrategy {

	@Override
	public <T extends Comparable<T>> void Sort(T[] array) {
		// TODO Auto-generated method stub
		for(int i = 1;i < array.length;i++)
		{
			int tmp = i;
			while(tmp > 0 && array[tmp-1].compareTo(array[tmp]) > 0)
			{
				exch(array, tmp, tmp-1);
				tmp--;
			}
		}
	}

	@Override
	public <T extends Comparable<T>> void Sort(T[] array,
			Comparator<T> compare) {
		// TODO Auto-generated method stub
		for(int i = 1;i < array.length;i++)
		{
			int tmp = i;
			while(tmp > 0 && compare.compare(array[tmp-1], array[tmp]) > 0)
			{
				exch(array, tmp, tmp-1);
				tmp--;
			}
		}

	}
	
	private static <T> void exch(T[] a, int i, int j)
	{
		T tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

}
