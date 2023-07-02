package Homework4_Inheritance;



public class PersonController {
	
	//EVENT ROLE INDEX
	private final static int EVT_ROLE_STUDENT_IDX = 0;
	private final static int EVT_ROLE_EMPLOYEE_IDX = 1;
	
	//value
	private Student[] student_manager = new Student[3];
	private Employee[] employee_manager = new Employee[10];
	
	//role index value
	private int student_index = 0;
	private int employee_index = 0;

	
	public int[] personCount()
	{
		int[] size_count_arr = new int[2];
		
		//enrollment check student size 
		//https://hunamkyu.tistory.com/12
		for(int i=0;i<student_manager.length;i++)
		{
			if(student_manager[i] == null)
			{
				continue;
			}
			
			++size_count_arr[EVT_ROLE_STUDENT_IDX];
			
		}
		
		//enrollment check employee size
		for(int i=0;i<employee_manager.length;i++)
		{
			if(employee_manager[i] == null)
			{
				continue;
			}
			
			++size_count_arr[EVT_ROLE_EMPLOYEE_IDX];
			
		}	
		
		
		return size_count_arr;
			
	}
	
	public void insertStudent(String name,int age,double height,double weight,int grade,String major)
	{
		for(student_index = 0;student_index < student_manager.length;student_index++)
		{
			if(student_manager[student_index] == null)
			{
				student_manager[student_index] = new Student(name,age,height,weight,grade,major);
				break;
			}
			
			
		}
	}
	
	public Student[] printStudent()
	{
		return student_manager;
	}
	
	public void insertEmployee(String name,int age,double height,double weight,int salary,String dept)
	{
		for(employee_index = 0;employee_index < employee_manager.length;employee_index++)
		{
			if(employee_manager[employee_index] == null)
			{
				employee_manager[employee_index] = new Employee(name,age,height,weight,salary,dept);
				break;
			}
			
			
		}
	}
	
	public Employee[] printEmployee()
	{
		return employee_manager;
	}
	
	
}
