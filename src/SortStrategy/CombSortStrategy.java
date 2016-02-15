package SortStrategy;
import java.util.Comparator;

import main.SortStrategy;

public class CombSortStrategy<T> implements SortStrategy<T> {

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

	private static int newGap(int gap) {
		gap = gap * 10 / 13;
		if (gap == 9 || gap == 10) {
			gap = 11;
		}

		if (gap < 1) {
			return 1;
		}

		return gap;
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
			int gap = input.length;
			boolean note;
			do {
				note = false;
				gap = newGap(gap);
				for (int i = 0; i < (input.length - gap); i++) {
					if (input[i].compareTo((T) input[i + gap]) > 0) {
						note = true;
						Swap(input, i, i + gap);
					}
				}
			} while (gap > 1 || note);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void SorterASC(Comparable<T>[] input, Comparator<T> comparator) {
		if (isSort(input) == false) {
			int gap = input.length;
			boolean note;
			do {
				note = false;
				gap = newGap(gap);
				for (int i = 0; i < (input.length - gap); i++) {
					if (comparator.compare((T) input[i], (T) input[i + gap]) > 0) {
						note = true;
						Swap(input, i, i + gap);
					}
				}
			} while (gap > 1 || note);
		}
	}
}