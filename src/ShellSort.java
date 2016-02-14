import java.util.Comparator;


public class ShellSort implements SortStrategy {

	@Override
	public <T extends Comparable<T>> void Sort(T[] array) {
		// TODO Auto-generated method stub
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
	}

	@Override
	public <T extends Comparable<T>> void Sort(T[] array, Comparator<T> compare) {
		// TODO Auto-generated method stub
		for(int s = array.length/2;s >= 1;s/=2)
		{
			for(int i = s; i < array.length;i++)
			{
				for(int j = i;j >= s;j -= s)
				{
					if(compare.compare(array[j],array[j-s]) < 0)
					{
						exch(array,j, j-s);
					}
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
