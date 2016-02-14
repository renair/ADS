import java.util.Comparator;


public class BulbSort implements SortStrategy {

	@Override
	public <T extends Comparable<T>> void Sort(T[] array) {
		// TODO Auto-generated method stub
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
	}

	@Override
	public <T extends Comparable<T>> void Sort(T[] array, Comparator<T> compare) {
		boolean IsReplaced = true;
		while(IsReplaced)
		{
			IsReplaced = false;
			for(int i = 0;i < array.length-1;i++)
			{
				if(compare.compare(array[i], array[i+1]) < 0)
				{
					exch(array, i, i+1);
					IsReplaced = true;
				}
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
