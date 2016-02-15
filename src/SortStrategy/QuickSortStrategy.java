package SortStrategy;
import java.util.Comparator;

import main.SortStrategy;

public class QuickSortStrategy<T> implements SortStrategy<T> {
	
	@SuppressWarnings("unchecked")
	private static <T> boolean isSort(Comparable<T>[] input) {
		boolean check = true;
		for (int i = 0; i < (input.length - 1); i++) {
			if (input[i].compareTo((T) input[i + 1]) > 0) {
				check = false;
				break;
			}
		}

		return check;
	}
	
	private static <T> void Swap(Comparable<T>[] input, int a, int b) {
		Comparable<T> e = input[a];
		input[a] = input[b];
		input[b] = e;
	}

	@Override
	public void SorterASC(Comparable<T>[] input) {
		if (isSort(input) == false) {
			int i = 0;
			int j = input.length - 1;
			qSortASC(input, i, j);
		}
	}

	@Override
	public void SorterASC(Comparable<T>[] input, Comparator<T> comparator) {
		if (isSort(input) == false) {
			int i = 0;
			int j = input.length - 1;
			qSortASC(input, i, j, comparator);
		}
	}
	
	@SuppressWarnings("unchecked")
	private static <T> void qSortASC(Comparable<T>[] input, int low, int high) {
		int i = low;
		int j = high;
		Comparable<T> x = input[low + (high - low) / 2];
		do {
			while (input[i].compareTo((T) x) < 0) {
				++i;
			}
			while (input[j].compareTo((T) x) > 0) {
				--j;
			}
			if (i <= j) {
				Swap(input, i, j);
				i++;
				j--;
			}
		} while (i <= j);
		if (low < j)
			qSortASC(input, low, j);
		if (i < high)
			qSortASC(input, i, high);
	}

	@SuppressWarnings("unchecked")
	private static <T> void qSortASC(Comparable<T>[] input, int low, int high,
			Comparator<T> comparator) {
		int i = low;
		int j = high;
		Comparable<T> x = input[low + (high - low) / 2];
		do {
			while (comparator.compare((T) input[i], (T) x) < 0) {
				++i;
			}
			while (comparator.compare((T) input[j], (T) x) > 0) {
				--j;
			}
			if (i <= j) {
				Swap(input, i, j);
				i++;
				j--;
			}
		} while (i <= j);
		if (low < j)
			qSortASC(input, low, j, comparator);
		if (i < high)
			qSortASC(input, i, high, comparator);
	}
}