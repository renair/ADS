package SortStrategy;
import java.util.Comparator;

import main.SortStrategy;

public class SelectionSortStrategy<T> implements SortStrategy<T> {

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

	private static <T> void Swap(Comparable<T>[] mass, Comparable<T> min,
			int a, int b) {
		Comparable<T> e = mass[a];
		mass[a] = min;
		mass[b] = e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void SorterASC(Comparable<T>[] input) {
		if (isSort(input) == false) {
			for (int i = 0; i < (input.length - 1); i++) {
				Comparable<T> min = input[i];
				int pos = i;
				for (int j = i; j < input.length; j++) {
					if (input[j].compareTo((T) min) < 0) {
						min = input[j];
						pos = j;
					}
				}
				Swap(input, min, i, pos);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void SorterASC(Comparable<T>[] input, Comparator<T> comparator) {
		if (isSort(input) == false) {
			for (int i = 0; i < (input.length - 1); i++) {
				Comparable<T> min = input[i];
				int pos = i;
				for (int j = i; j < input.length; j++) {
					if (comparator.compare((T) input[i], (T) input[i + 1]) < 0) {
						min = input[j];
						pos = j;
					}
				}
				Swap(input, min, i, pos);
			}
		}
	}
}