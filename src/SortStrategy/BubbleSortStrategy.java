package SortStrategy;
import java.util.Comparator;

import main.SortStrategy;

public class BubbleSortStrategy<T> implements SortStrategy<T> {

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
	
	private static <T> void Swap(Comparable<T>[] mass, int a, int b) {
		Comparable<T> e = mass[a];
		mass[a] = mass[b];
		mass[b] = e;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void SorterASC(Comparable<T>[] input) {
		if (isSort(input) == false) {
			boolean note = true;
			for (int i = 0; i < (input.length - 1); i++) {
				if (input[i].compareTo((T) input[i + 1]) > 0) {
					Swap(input, i, i + 1);
					note = false;
				}
			}

			if (note == false) {
				SorterASC(input);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void SorterASC(Comparable<T>[] input, Comparator<T> comparator) {
		if (isSort(input) == false) {
			boolean note = true;
			for (int i = 0; i < (input.length - 1); i++) {
				if (comparator.compare((T) input[i], (T) input[i + 1]) > 0) {
					Swap(input, i, i + 1);
					note = false;
				}
			}

			if (note == false) {
				SorterASC(input, comparator);
			}
		}
	}
}
