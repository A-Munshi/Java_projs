/*
Title: Employee Stack Implementation using Array in Java
Problem Statement: Write a Java program to implement a stack of employees using an array. The program should allow the user to:
•	Push (add) an employee to the stack.
•	Pop (remove) an employee from the stack.
•	Peek (view the top employee).
•	Display all employees in the stack.

The stack should hold Employee objects with:
•	id (int)
•	name (String)
•	salary (double)
*/

import java.util.Scanner;
class Employee
{
	int id;
	double salary;
	String name;
	Employee(int id, String name, double salary)
	{
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	void display()
	{
		System.out.println("ID: " + id + "\nName: " + name + "\nSalary: " + salary);
	}
}

class EmpStack
{
	Employee []stack;
	int s, top;
	EmpStack(int size)
	{
		stack = new Employee[size];
		s = size;
		top = -1;
	}
	
	void push(Employee emp)
	{
		if(top == s-1)
			System.out.println("Stack Overflow");
		
		else
		{
			stack[++top] = emp;
			System.out.println("Pushed " + emp.name + " into the stack");
		}
	}
	
	void pop()
	{
		if(top == -1)
			System.out.println("Stack Underflow");
		
		else
			System.out.println("Popped " + stack[top--].name + " out of the stack");
	}	
	
	void peek()
	{
		if(top == -1)
			System.out.println("Stack Underflow");
		
		else
			System.out.println("Topmost Employee: " + stack[top].name);
	}
	
	void displayAll()
	{
		if(top == -1)
			System.out.println("Stack Underflow");
		
		else
		{
			for(int i=top ; i>=0 ; i--)
			{
				stack[i].display();
				System.out.println("-----------------");
			}
		}
	}
}

class EmpStkMain 
{
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter max no of employees: ");
        int max = sc.nextInt();

        EmpStack stk = new EmpStack(max);

        while(true) 
		{
            System.out.println("\n--- Employee Stack Operations ---");
            System.out.println("1. PUSH Employee");
            System.out.println("2. POP Employee");
            System.out.println("3. PEEK Employee");
            System.out.println("4. Display Stack");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); 

            switch(ch) 
			{
                case 1: System.out.print("Enter Emp ID: ");
						int eid = sc.nextInt();
						sc.nextLine();
						
						System.out.print("Enter Emp Name: ");
						String ename = sc.nextLine();
						
						System.out.print("Enter Emp salary: ");
						double esal = sc.nextDouble();
						
						stk.push(new Employee(eid, ename, esal));
						break;
				
				case 2: stk.pop();	break;
				
				case 3: stk.peek(); break;
				
				case 4: stk.displayAll(); break;
				
				case 5: System.out.println("Exiting... Thank you!");
						System.exit(0);

                default: System.out.println("Invalid choice! Please try again.");
            }
		}
	}
}