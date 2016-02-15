package main;
import java.util.Comparator;

public interface SortStrategy<T> {
	void SorterASC(Comparable<T>[] input);
	void SorterASC(Comparable<T>[] input, Comparator<T> comparator);
}
