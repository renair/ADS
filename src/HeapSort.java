import java.util.Comparator;


public class HeapSort implements SortStrategy {

	@Override
	public <T extends Comparable<T>> void Sort(T[] array)
	{
		HSort(array);
	}

	@Override
	public <T extends Comparable<T>> void Sort(T[] array, Comparator<T> compare)
	{
		HSort(array, compare);
	}
	
	private static <T extends Comparable<T>> void HSort(T[] array)
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

	private static <T extends Comparable<T>> void HSort(T[] array, Comparator<T> Comp)
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
    
    private static <T> void exch(T[] a, int i, int j)
	{
		T tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
