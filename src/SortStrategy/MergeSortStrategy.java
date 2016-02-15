package SortStrategy;
import java.util.Comparator;

import main.SortStrategy;

public class MergeSortStrategy<T> implements SortStrategy<T> {

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

	@SuppressWarnings("unchecked")
	@Override
	public void SorterASC(Comparable<T>[] input) {
		if (isSort(input) == false) {
			Comparable<T>[] tmpArray = new Comparable[input.length];
			MergeASC(input, tmpArray, 0, input.length - 1);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void SorterASC(Comparable<T>[] input, Comparator<T> comparator) {
		if (isSort(input) == false) {
			Comparable<T>[] tmpArray = new Comparable[input.length];
			MergeASC(input, tmpArray, 0, input.length - 1, comparator);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static <T> void MergeASC(Comparable<T>[] input,
			Comparable[] tmpArray, int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			MergeASC(input, tmpArray, left, center);
			MergeASC(input, tmpArray, center + 1, right);
			MergeSortASC(input, tmpArray, left, center + 1, right);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static <T> void MergeASC(Comparable<T>[] input,
			Comparable[] tmpArray, int left, int right, Comparator<T> comparator) {
		if (left < right) {
			int center = (left + right) / 2;
			MergeASC(input, tmpArray, left, center, comparator);
			MergeASC(input, tmpArray, center + 1, right, comparator);
			MergeSortASC(input, tmpArray, left, center + 1, right, comparator);
		}
	}

	@SuppressWarnings("unchecked")
	private static <T> void MergeSortASC(Comparable<T>[] input,
			Comparable<T>[] tmpArray, int leftPos, int rightPos, int rightEnd) {
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;
		while (leftPos <= leftEnd && rightPos <= rightEnd)
			if (input[leftPos].compareTo((T) input[rightPos]) <= 0) {
				tmpArray[tmpPos++] = input[leftPos++];
			} else {
				tmpArray[tmpPos++] = input[rightPos++];
			}
		while (leftPos <= leftEnd) {
			tmpArray[tmpPos++] = input[leftPos++];
		}
		while (rightPos <= rightEnd) {
			tmpArray[tmpPos++] = input[rightPos++];
		}

		for (int i = 0; i < numElements; i++, rightEnd--)

			input[rightEnd] = tmpArray[rightEnd];
	}

	@SuppressWarnings("unchecked")
	private static <T> void MergeSortASC(Comparable<T>[] input,
			Comparable<T>[] tmpArray, int leftPos, int rightPos, int rightEnd,
			Comparator<T> comparator) {
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;
		while (leftPos <= leftEnd && rightPos <= rightEnd)
			if (comparator.compare((T) input[leftPos], (T) input[rightPos]) <= 0) {
				tmpArray[tmpPos++] = input[leftPos++];
			} else {
				tmpArray[tmpPos++] = input[rightPos++];
			}
		while (leftPos <= leftEnd) {
			tmpArray[tmpPos++] = input[leftPos++];
		}
		while (rightPos <= rightEnd) {
			tmpArray[tmpPos++] = input[rightPos++];
		}

		for (int i = 0; i < numElements; i++, rightEnd--)

			input[rightEnd] = tmpArray[rightEnd];
	}
}