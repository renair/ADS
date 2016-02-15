package main;
import java.util.Arrays;
import java.util.Random;

import SortStrategy.BubbleSortStrategy;
import SortStrategy.CombSortStrategy;
import SortStrategy.HeapSortStrategy;
import SortStrategy.InsertSortStrategy;
import SortStrategy.MergeSortStrategy;
import SortStrategy.QuickSortStrategy;
import SortStrategy.SelectionSortStrategy;
import SortStrategy.ShellSortStrategy;

public class Test {

	public static void main(String[] args) {

		Random generator = new Random();
		Integer[] Mass = new Integer[10];
		Integer[] MassCopy;

		// ���������� ����������//
		System.out.println("BubbleSort");
		for (int i = 0; i < Mass.length; i++) {
			Mass[i] = new Integer(generator.nextInt(100));
		}

		BubbleSortStrategy<Integer> sort1 = new BubbleSortStrategy<Integer>();
		MassCopy = Arrays.copyOf(Mass, Mass.length);

		System.out.println("Before sort:");
		System.out.println(Arrays.toString(MassCopy));

		sort1.SorterASC(MassCopy);

		System.out.println("After sort:");
		System.out.println(Arrays.toString(MassCopy));
		System.out.println("");

		// ���������� �������//
		System.out.println("SelectionSort");
		for (int i = 0; i < Mass.length; i++) {
			Mass[i] = new Integer(generator.nextInt(100));
		}
		
		SelectionSortStrategy<Integer> sort2 = new SelectionSortStrategy<Integer>();
		MassCopy = Arrays.copyOf(Mass, Mass.length);

		System.out.println("Before sort:");
		System.out.println(Arrays.toString(MassCopy));

		sort2.SorterASC(MassCopy);

		System.out.println("After sort:");
		System.out.println(Arrays.toString(MassCopy));
		System.out.println("");

		// ���������� ��������//
		System.out.println("InsertSort");
		for (int i = 0; i < Mass.length; i++) {
			Mass[i] = new Integer(generator.nextInt(100));
		}

		InsertSortStrategy<Integer> sort3 = new InsertSortStrategy<Integer>();
		MassCopy = Arrays.copyOf(Mass, Mass.length);

		System.out.println("Before sort:");
		System.out.println(Arrays.toString(MassCopy));

		sort3.SorterASC(MassCopy);

		System.out.println("After sort:");
		System.out.println(Arrays.toString(MassCopy));
		System.out.println("");
		System.out.println("");

		// ���������� ��������//
		System.out.println("�ombSort");
		for (int i = 0; i < Mass.length; i++) {
			Mass[i] = new Integer(generator.nextInt(100));
		}

		CombSortStrategy<Integer> sort4 = new CombSortStrategy<Integer>();
		MassCopy = Arrays.copyOf(Mass, Mass.length);

		System.out.println("Before sort:");
		System.out.println(Arrays.toString(MassCopy));

		sort4.SorterASC(MassCopy);

		System.out.println("After sort:");
		System.out.println(Arrays.toString(MassCopy));
		System.out.println("");

		// ���������� ����//
		System.out.println("ShellSort");
		for (int i = 0; i < Mass.length; i++) {
			Mass[i] = new Integer(generator.nextInt(100));
		}
		
		ShellSortStrategy<Integer> sort5 = new ShellSortStrategy<Integer>();
		MassCopy = Arrays.copyOf(Mass, Mass.length);

		System.out.println("Before sort:");
		System.out.println(Arrays.toString(MassCopy));

		sort5.SorterASC(MassCopy);

		System.out.println("After sort:");
		System.out.println(Arrays.toString(MassCopy));
		System.out.println("");

		// ������ ����������//
		System.out.println("QuickSort");
		for (int i = 0; i < Mass.length; i++) {
			Mass[i] = new Integer(generator.nextInt(100));
		}

		QuickSortStrategy<Integer> sort6 = new QuickSortStrategy<Integer>();
		MassCopy = Arrays.copyOf(Mass, Mass.length);

		System.out.println("Before sort:");
		System.out.println(Arrays.toString(MassCopy));

		sort6.SorterASC(MassCopy);

		System.out.println("After sort:");
		System.out.println(Arrays.toString(MassCopy));
		System.out.println("");

		// ���������� �����//
		System.out.println("HeapSort");
		for (int i = 0; i < Mass.length; i++) {
			Mass[i] = new Integer(generator.nextInt(100));
		}

		HeapSortStrategy<Integer> sort7 = new HeapSortStrategy<Integer>();
		MassCopy = Arrays.copyOf(Mass, Mass.length);

		System.out.println("Before sort:");
		System.out.println(Arrays.toString(MassCopy));

		sort7.SorterASC(MassCopy);

		System.out.println("After sort:");
		System.out.println(Arrays.toString(MassCopy));
		System.out.println("");

		// C��������� �������//
		System.out.println("MergeSort");
		for (int i = 0; i < Mass.length; i++) {
			Mass[i] = new Integer(generator.nextInt(100));
		}

		MergeSortStrategy<Integer> sort8 = new MergeSortStrategy<Integer>();
		MassCopy = Arrays.copyOf(Mass, Mass.length);

		System.out.println("Before sort:");
		System.out.println(Arrays.toString(MassCopy));

		sort8.SorterASC(MassCopy);

		System.out.println("After sort:");
		System.out.println(Arrays.toString(MassCopy));
		System.out.println("");
	}
}