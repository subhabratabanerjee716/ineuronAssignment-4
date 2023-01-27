import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Dao;
import com.student.manage.Student;

public class Start {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Student Management App");
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			
			System.out.println("Press 1 to add student");
			System.out.println("Press 2 to delete student");
			System.out.println("Press 3 to display student");
			System.out.println("Press 4 to exit app");
			
			int c= Integer.parseInt(br.readLine());
			
			if(c==1) {
				
				
				//add Student
				
				System.out.println("Enter user Name :");
				String name=br.readLine();
				System.out.println("Enter user Phone :");
				String phone=br.readLine();
				System.out.println("Enter user City :");
				String city=br.readLine();
				
				//create student object to store student
				
				Student st = new Student(name,phone,city);
				
				//System.out.println(st);
				
			boolean answer=	Dao.insertStudentToDb(st);
				
			if(answer) {
				
				System.out.println("Student is added successfully...");
				
			}else {
				
				System.out.println("Something went wrong..");
				
			}
			
				
			}else if(c==2) {
				
				
				//delete student
				
				System.out.println("Enter student id to delete");
				
				int userId=Integer.parseInt(br.readLine());
				boolean f =Dao.deleteStudent(userId);
				
				if(f) {
					
					System.out.println("Deleted "+userId);
					
					
				}else {
					
					System.out.println("something went wrong");
					
				}
				
			}else if(c==3) {
				
				
				//display students
				
				System.out.println("Show all students");
				
				Dao.showStudents();
				
				
			}else if(c==4) {
				
				break;
				
			}else {
				
				
				
			}
			
		}
		
		System.out.println("Thankyou for using the application !");
	}

}
