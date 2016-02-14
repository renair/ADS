import java.util.Comparator;


public class GSort implements SortStrategy {

	@Override
	public <T extends Comparable<T>> void Sort(T[] array) {
		// TODO Auto-generated method stub
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
	}

	@Override
	public <T extends Comparable<T>> void Sort(T[] array,
			Comparator<T> compare) {
		// TODO Auto-generated method stub
		int n = (int)Math.round(Math.floor(array.length/1.3));
		boolean IsChanges = true;
		while(n >= 1 || IsChanges)
		{
			IsChanges = false;
			for(int i = 0; i < array.length - n;i++)
			{
				if(compare.compare(array[i],array[i+n]) > 0)
				{
					exch(array, i, i+n);
					IsChanges = true;
				}
			}
			n = (int)Math.round(Math.floor(n/1.3));
		}
	}
	
	private static <T> void exch(T[] a, int i, int j)
	{
		T tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

}
