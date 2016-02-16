package SortTester;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	BulbSort.class,
	GSort.class,
	HeapSort.class,
	InsertionSort.class,
	MergeSort.class,
	QuikSort.class,
	SelectionSort.class,
	ShellSort.class
})

public class AllUnitsTest {

}
