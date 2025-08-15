/*
Title: Student Admission System using Arrays in Core Java
Problem Statement: Write a Java program to manage student admissions in a college using arrays. The program should allow the user to:
•	Add new student details.
•	View all student records.
•	Search for a student by roll number.
•	Update student details.
•	Delete a student record.
•	The system should store a maximum of 100 students using arrays (no collections or database).

Requirements:
Create a Student class with:
•	rollNumber (int)
•	name (String)
•	course (String)
•	year (int)
•	Use an array of Student objects in the main program.
•	Implement a menu-driven interface.
*/

import java.util.Scanner;
class Student 
{
    int roll, year;
	String course, name;
	//Initialises a new student with given name, roll, year and course
    Student(String name, int roll, int year, String course) 
	{
        this.roll = roll;
        this.year = year;
        this.course = course;
		this.name = name;
    }
	//Updates student details
    void update(String name, int year, String course) 
	{
        this.name = name;
        this.year = year;
        this.course = course;
	}
	//Displays student record
    void display() 
	{
        System.out.println("Name: " + name + "\nRoll: " + roll + "\nYear: " + year + "\nCourse: " + course);
    }
}

class StMgmt 
{
    //Entry point of the program. Provides a menu-driven interface
	public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        Student[] st = new Student[100];
        int count = 0;
        while(true) 
		{
            System.out.println("\n===== Student Admission System =====");
			System.out.println("1. Add new student details\n2. View all student records\n3. Search for a student\n4. Update student details\n5. Delete a student record\n6. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) 
			{
                // Create new student
				case 1: if (count >= 100) 
						{
							System.out.println("Admission limit reached");
							break;
						}
						System.out.print("Enter name: ");
						String n1 = sc.nextLine();
						System.out.print("Enter Roll: ");
						int r = sc.nextInt();
						System.out.print("Enter Year: ");
						int yr = sc.nextInt();
						sc.nextLine();
						System.out.print("Enter Course: ");
						String c = sc.nextLine();
						
						st[count] = new Student(n1, r, yr, c);
						count++;
						System.out.println("Student added successfully");
						break;

                // View all student records
				case 2: if (count == 0)
							System.out.println("No student record available");
                        else 
						{
							for (int i=0; i<count; i++) 
							{
								st[i].display();
								System.out.println("-------------------");
							}
						}	break;

                // Search for a student
				case 3: System.out.print("Enter student roll: ");
						int r1 = sc.nextInt();
						int flag = 0;
						for (int i=0; i<count; i++) 
						{
							if (st[i].roll == r1) 
							{
								st[i].display();
								flag = 1;	break;
							}
						}
						if (flag == 0) 
							System.out.println("Student record not found");	break;

                // Update student details
				case 4: System.out.print("Enter Roll Number to Update: ");
						int r2 = sc.nextInt();
						sc.nextLine();
						int flag2 = 0;
						for (int i=0; i<count; i++) 
						{
							if (st[i].roll == r2) 
							{
								System.out.print("Enter New Name: ");
								String n2 = sc.nextLine();
								//sc.nextLine();
								System.out.print("Enter New Course: ");
								String c2 = sc.nextLine();
								System.out.print("Enter New Year: ");
								int yr2 = sc.nextInt();
								st[i].update(n2, yr2, c2);
								System.out.println("Student details updated successfully!");
								flag2 = 1;	break;
							}
						}
						if (flag2 == 0) 
							System.out.println("Student record not found!");	break;

                // Delete student record
				case 5: System.out.print("Enter Roll Number to Delete: ");
						int r3 = sc.nextInt();
						int flag3 = 0;
						for (int i=0; i<count; i++) 
						{
							if (st[i].roll == r3) 
							{
								for (int j = i; j < count - 1; j++) 
									st[j] = st[j + 1];
								
								st[count - 1] = null;
								count--;
								System.out.println("Student record deleted successfully!");
								flag3 = 1;	break;
							}
						}
						if (flag3 == 0) 
							System.out.println("Student record not found!");	break;

                // Exit program
				case 6: System.out.println("Exiting... Thank you!");
						System.exit(0);

                default: System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
