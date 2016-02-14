import java.util.Arrays;
import java.util.Comparator;


public class MergeSort implements SortStrategy {

	@Override
	public <T extends Comparable<T>> void Sort(T[] array) {
		MSort(array);
	}

	@Override
	public <T extends Comparable<T>> void Sort(T[] array, Comparator<T> compare) {
		MSort(array, compare);
	}
	
	public static <T extends Comparable<T>> T[] MSort(T[] array)
	{
		int mid = array.length / 2;
		if(array.length <= 5)
		{
			Sorter.InsertionSort(array);
			return array;
		}
		merge(array,
				MSort(Arrays.copyOfRange(array, 0, mid)),
				MSort(Arrays.copyOfRange(array, mid, array.length)));
		return array;
	}
	
	public static <T extends Comparable<T>> T[] MSort(T[] array, Comparator<T> Comp)
	{
		int mid = array.length / 2;
		if(array.length <= 5)
		{
			for(int i = 1;i < array.length;i++)
			{
				int tmp = i;
				while(tmp > 0 && Comp.compare(array[tmp-1],array[tmp]) > 0)
				{
					exch(array, tmp, tmp-1);
					tmp--;
				}
			}
			return array;
		}
		merge(array,
				MSort(Arrays.copyOfRange(array, 0, mid),Comp), 
				MSort(Arrays.copyOfRange(array, mid, array.length),Comp),
				Comp);
		return array;
	}
	
	private static <Y extends Comparable<Y>> void merge(Y[] array, Y[] arr1, Y[] arr2, Comparator<Y> Compare)
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
