import java.util.Comparator;

public class Student implements Comparable<Student>{
	public String Name = "noname";
	public int age = 0;
	public int grade = 0;
	public boolean IsContract;
	
	public Student(String Name,int Age, int Grade) {
		this.Name = Name;
		this.age = Age;
		this.grade = Grade;
	}
	
	public static Comparator<Student> AgeComparatorAscending = new Comparator<Student>(){
		@Override
		public int compare(Student o1, Student o2) {
			if(o1.age > o2.age)
			{
				return o1.age - o2.age;
			}
			else if(o1.age < o2.age)
			{
				return o1.age - o2.age;
			}
			else
			{
				return 0;
			}
		}
	};
	
	public static Comparator<Student> AgeComparatorDescending = new Comparator<Student>(){
		@Override
		public int compare(Student o1, Student o2) {
			if(o1.age > o2.age)
			{
				return o2.age - o1.age;
			}
			else if(o1.age < o2.age)
			{
				return o2.age - o1.age;
			}
			else
			{
				return 0;
			}
		}
	};
	
	public static Comparator<Student> GradeComparatorAscending = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			if(o1.grade > o2.grade)
			{
				return o1.grade - o2.grade;
			}
			else if(o1.grade < o2.grade)
			{
				return o1.grade - o2.grade;
			}
			return 0;
		}
	};
	
	public static Comparator<Student> GradeComparatorDescending = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			if(o1.grade > o2.grade)
			{
				return o2.grade - o1.grade;
			}
			else if(o1.grade < o2.grade)
			{
				return o2.grade - o1.grade;
			}
			return 0;
		}
	};
	
	@Override
	public int compareTo(Student o) {
		if(this.Name.length() > o.Name.length())
		{
			return 1;
		}
		else if(this.Name.length() < o.Name.length())
		{
			return -1;
		}
		return 0;
	}
	
	public String toString()
	{
		//System.out.println(this.Name + "\t" + this.age + " " + this.grade);
		return this.Name + "\t" + this.age + " " + this.grade;
	}
}
