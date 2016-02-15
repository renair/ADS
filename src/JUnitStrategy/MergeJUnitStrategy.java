package JUnitStrategy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import org.junit.Test;

import SortStrategy.MergeSortStrategy;
import main.Item;
import main.JUnitStrategy;

public class MergeJUnitStrategy<T> implements JUnitStrategy<T> {
	MergeSortStrategy<Integer> sort = new MergeSortStrategy<Integer>();
	
	Random generator = new Random();
	Item[] Mass = new Item[10];
	Item[] MassCopy;
	
	public void main() {
		for (int i = 0; i < Mass.length; i++) {
			Mass[i] = new Item(generator.nextInt(100), generator.nextInt(100),
					generator.nextInt(100));
		}
		
		MassCopy = Arrays.copyOf(Mass, Mass.length);
	}
	
	@Test
	@Override
	public void isSorter() {
		main();
		assertTrue(isSort(MassCopy));	
	}
	
	@Test
	@Override
	public void isNotSorter() {
		main();
		assertFalse(isSort(MassCopy));	
	}
	
	@Test
	public void isSorterWithComparator() {
		main();
		assertTrue(isSort(MassCopy, Item.BY_Horsepower));
		assertTrue(isSort(MassCopy, Item.BY_Curb_Weight));
	}
	
	@Test
	@Override
	public void isNotSorterWithComparator() {
		assertFalse(isSort(MassCopy, Item.BY_Horsepower));
		assertFalse(isSort(MassCopy, Item.BY_Curb_Weight));
	}
	
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
	private static <T> boolean isSort(Comparable<T>[] input, Comparator<T> comparator) {
		boolean check = true;
		for (int i = 0; i < (input.length - 1); i++) {
			if (comparator.compare((T)input[i], (T)input[i + 1]) > 0) {
				check = false;
				break;
			}
		}

		return check;
	}	
}