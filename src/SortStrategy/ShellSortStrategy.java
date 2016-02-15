package SortStrategy;
import java.util.Comparator;

import main.SortStrategy;

public class ShellSortStrategy<T> implements SortStrategy<T> {

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
			for (int d = (input.length / 2); d >= 1; d /= 2) {
				for (int i = d; i < input.length; i++) {
					for (int j = i; j >= d; j -= d) {
						if (input[j - d].compareTo((T) input[j]) > 0) {
							Swap(input, j, j - d);
						}
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void SorterASC(Comparable<T>[] input, Comparator<T> comparator) {
		if (isSort(input) == false) {
			for (int d = (input.length / 2); d >= 1; d /= 2) {
				for (int i = d; i < input.length; i++) {
					for (int j = i; j >= d; j -= d) {
						if (comparator.compare((T) input[j - d], (T) input[j]) > 0) {
							Swap(input, j, j - d);
						}
					}
				}
			}
		}
	}
}
