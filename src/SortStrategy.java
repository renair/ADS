import java.util.*;

public interface SortStrategy {
	public <T extends Comparable<T>> void Sort(T[] array);
	public <T extends Comparable<T>> void Sort(T[] array, Comparator<T> compare);
}
