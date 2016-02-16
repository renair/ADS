package SortTester;

import org.junit.BeforeClass;
import org.junit.Test;
import java.util.*;

public class BulbSort extends testMethod
{
private static Student[] array;
	
	@BeforeClass
	public static void init()
	{
		Random r = new Random();
		array = new Student[50];
		for(int i = 0;i < 50;i++)
		{
			byte[] name = new byte[r.nextInt(70)];
			r.nextBytes(name);
			array[i] = new Student(new String(name), r.nextInt(50), r.nextInt(100));
		}
	}
	
	@Override
	@Test
	public void sortAsc()
	{
		Student[] arr = Arrays.copyOf(array, array.length);
		Sorter.BulbSort(arr);
		org.junit.Assert.assertTrue(isSortedDesc(arr));
	}
	
	@Override
	@Test
	public void sortAscComp()
	{
		Student[] arr = Arrays.copyOf(array, array.length);
		Sorter.BulbSort((Student[])arr,Student.GradeComparatorAscending);
		org.junit.Assert.assertFalse(isSortedAsc((Student[])arr,Student.GradeComparatorAscending));
	}
	
	@Override
	@Test
	public void sortDesc() {
		Student[] arr = Arrays.copyOf(array, array.length);
		Sorter.BulbSort((Student[])arr,Student.GradeComparatorDescending);
		org.junit.Assert.assertTrue(isSortedDesc((Student[])arr,Student.GradeComparatorDescending));
	}
	
	@Override
	@Test
	public void sortDescComp() {
		Student[] arr = Arrays.copyOf(array, array.length);
		Sorter.BulbSort((Student[])arr,Student.GradeComparatorDescending);
		org.junit.Assert.assertFalse(isSortedAsc((Student[])arr,Student.GradeComparatorDescending));
	}
}
