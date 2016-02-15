package SortStrategy;
import java.util.Comparator;

import main.SortStrategy;

public class HeapSortStrategy<T> implements SortStrategy<T> {

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

	@Override
	public void SorterASC(Comparable<T>[] input) {
		if (isSort(input) == false) {
			heapifyASC(input, input.length);
			int end = input.length - 1;
			while (end > 0) {
				Swap(input, end, 0);
				siftDownASC(input, 0, --end);
			}
		}
	}

	@Override
	public void SorterASC(Comparable<T>[] input, Comparator<T> comparator) {
		if (isSort(input) == false) {
			heapifyASC(input, input.length, comparator);
			int end = input.length - 1;
			while (end > 0) {
				Swap(input, end, 0);
				siftDownASC(input, 0, --end, comparator);
			}
		}
	}

	private static <T> void heapifyASC(Comparable<T>[] input, final int count) {
		int start = count / 2 - 1;

		while (start >= 0) {
			siftDownASC(input, start, count - 1);
			start--;
		}
	}

	private static <T> void heapifyASC(Comparable<T>[] input, final int count,
			Comparator<T> comparator) {
		int start = count / 2 - 1;

		while (start >= 0) {
			siftDownASC(input, start, count - 1, comparator);
			start--;
		}
	}

	@SuppressWarnings("unchecked")
	private static <T> void siftDownASC(Comparable<T>[] mass, final int start,
			final int end) {
		int root = start;

		while (root * 2 + 1 <= end) {
			int child = root * 2 + 1;
			int swap = root;
			if (mass[swap].compareTo((T) mass[child]) < 0) {
				swap = child;
			}
			if ((child + 1 <= end)
					&& (mass[swap].compareTo((T) mass[child + 1]) < 0)) {
				swap = child + 1;
			}
			if (swap != root) {
				Swap(mass, root, swap);
				root = swap;
			} else {
				return;
			}
		}
	}

	@SuppressWarnings({ "unchecked" })
	private static <T> void siftDownASC(Comparable<T>[] mass, final int start,
			final int end, Comparator<T> comparator) {
		int root = start;

		while (root * 2 + 1 <= end) {
			int child = root * 2 + 1;
			int swap = root;
			if (comparator.compare((T) mass[swap], (T) mass[child]) < 0) {
				swap = child;
			}
			if ((child + 1 <= end)
					&& (comparator.compare((T) mass[swap], (T) mass[child + 1]) < 0)) {
				swap = child + 1;
			}
			if (swap != root) {
				Swap(mass, root, swap);
				root = swap;
			} else {
				return;
			}
		}
	}
}