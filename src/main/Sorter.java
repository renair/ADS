package main;
import java.util.Comparator;

public class Sorter<T> {

	private SortStrategy<T> currentSortStrategy;
	
	public Sorter() {
		
	}
	
	public Sorter(SortStrategy<T> currentSortStrategy) {
		this.currentSortStrategy = currentSortStrategy;
	}

	public void setCurrentSortStrategy(SortStrategy<T> currentSortStrategy) {
		this.currentSortStrategy = currentSortStrategy;
	}
	
	public void SorterASC(Comparable<T>[] input) {
		currentSortStrategy.SorterASC(input);
	}
	
	public void SorterASC(Comparable<T>[] input, Comparator<T> comparator) {
		currentSortStrategy.SorterASC(input, comparator);
	}
}
