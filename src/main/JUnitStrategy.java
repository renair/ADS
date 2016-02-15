package main;

public interface JUnitStrategy<T> {
	void isSorter();
	void isNotSorter();
	void isSorterWithComparator();
	void isNotSorterWithComparator();
}
