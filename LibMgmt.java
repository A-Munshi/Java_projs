/*
Title: Library Book Management System using Arrays in Core Java
Problem Statement: Write a Java program to manage books in a library using arrays. The program should allow the user to:
•	Add new books.
•	View all books.
•	Search for a book by ID.
•	Issue a book (mark as issued).
•	Return a book (mark as available).
•	The system should store a maximum of 100 books using arrays (no collections or database).

Requirements:
Create a Book class with:
•	bookId (int)
•	title (String)
•	author (String)
•	isIssued (boolean)
•	Use an array of Book objects in the main program.
•	Implement a menu-driven interface.
*/

import java.util.Scanner;
class LibBook
{
	int bookId;
	String title, author;
	boolean isIssued;
	LibBook(int bookId, String title, String author)
	{
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.isIssued = false;
	}
	
	public void issueBook() 
	{
        if (!isIssued) 
		{
            isIssued = true;
            System.out.println("Book issued successfully");
        } 
		else 
            System.out.println("Book already issued");
    }

    public void returnBook() 
	{
        if (isIssued) 
		{
            isIssued = false;
            System.out.println("Book returned successfully");
        } 
		else
            System.out.println("Book not issued.");
    }
	
	void display()
	{
		System.out.println("Book ID: " + bookId + "\nBook Title: " + title + "\nBook Author: " + author + "\n Status: " + (isIssued ? "Issued" : "Available"));
	}
}

class LibMgmt
{
	public static void main(String []args)
	{
        Scanner sc = new Scanner(System.in);
        LibBook[] lb = new LibBook[100];
        int count = 0;

        while(true) 
		{
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add new books\n2. View all books\n3. Search for a book\n4. Issue a book\n5. Return a book\n6. Exit");
			System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch(ch) 
			{
                case 1: if(count >= 100) 
						{
							System.out.println("Library full!");
							break;
						}
						System.out.print("Enter Book ID: ");
						int id = sc.nextInt();
						sc.nextLine();
						System.out.print("Enter Book Title: ");
						String title = sc.nextLine();
						System.out.print("Enter Book Author: ");
						String author = sc.nextLine();
						lb[count] = new LibBook(id, title, author);
						count++;
						System.out.println("Book added successfully");
						break;

                case 2: if(count == 0)
							System.out.println("No books in library");
                        else 
						{
							for (int i=0; i<count; i++) 
							{
								lb[i].display();
								System.out.println("-------------------");
							}
						}	break;

                case 3: System.out.print("Enter Book ID: ");
						int id4 = sc.nextInt();
						int flag1 = 0;
						for (int i=0; i<count; i++) 
						{
							if (lb[i].bookId == id4) 
							{
								System.out.println("Book Found");
								lb[i].display();
								flag1 = 1;	break;
							}
						}
						if (flag1 == 0)	
							System.out.println("Book not found!");	break;

                case 4: System.out.print("Enter Book ID to issue: ");
						int id2 = sc.nextInt();
						int flag2 = 0;
						for (int i=0; i<count; i++) 
						{
							if (lb[i].bookId == id2) 
							{
								lb[i].issueBook();
								flag2 = 1;	break;
							}
						}
						if (flag2 == 0) 
							System.out.println("Book not found!");	break;

                case 5: System.out.print("Enter Book ID to return: ");
						int id3 = sc.nextInt();
						int flag3 = 0;
						for (int i=0; i<count; i++) 
						{
							if (lb[i].bookId == id3) 
							{
								lb[i].returnBook();
								flag3 = 1;	break;
							}
						}
						if (flag3 == 0) 
							System.out.println("Book not found!");	break;

                case 6: System.out.println("Exiting... Thank you!");
						System.exit(0);

                default: System.out.println("Invalid choice! Please try again.");
            }
		}
	}
}
	