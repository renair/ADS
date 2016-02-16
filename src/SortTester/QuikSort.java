package SortTester;

import java.util.Arrays;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

public class QuikSort extends testMethod
{
private static Student[] array;
	
	@BeforeClass
	public static void init()
	{
		Random r = new Random();
		array = new Student[50];
		for(int i = 0;i < 50;i++)
		{
			byte[] name = new byte[r.nextInt(6)];
			r.nextBytes(name);
			array[i] = new Student(new String(name), r.nextInt(50), r.nextInt(100));
		}
	}
	
	@Override
	@Test
	public void sortAsc()
	{
		Student[] arr = Arrays.copyOf(array, array.length);
		Sorter.QuickSort(arr,0,arr.length-1);
		org.junit.Assert.assertTrue(isSortedAsc(arr));
	}
	
	@Override
	@Test
	public void sortAscComp()
	{
		Student[] arr = Arrays.copyOf(array, array.length);
		Sorter.QuickSort((Student[])arr,0,arr.length-1,Student.GradeComparatorAscending);
		org.junit.Assert.assertTrue(isSortedAsc((Student[])arr,Student.GradeComparatorAscending));
	}
	
	@Override
	@Test
	public void sortDesc() {
		Student[] arr = Arrays.copyOf(array, array.length);
		Sorter.QuickSort((Student[])arr,0,arr.length-1,Student.GradeComparatorDescending);
		org.junit.Assert.assertTrue(isSortedAsc((Student[])arr,Student.GradeComparatorDescending));
	}
	
	@Override
	@Test
	public void sortDescComp() {
		Student[] arr = Arrays.copyOf(array, array.length);
		Sorter.QuickSort((Student[])arr,0,arr.length-1,Student.GradeComparatorDescending);
		for(int i = 0;i < array.length;i++)
		{
			System.out.println(arr[i]);
		}
		org.junit.Assert.assertTrue(isSortedAsc((Student[])arr,Student.GradeComparatorDescending));
	}
}