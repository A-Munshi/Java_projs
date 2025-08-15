/*
Title: Bank Account Management System using Arrays in Core Java
Problem Statement: Write a Java program to manage bank accounts using arrays. The program should allow the user to:
•	Create new bank accounts.
•	View all bank accounts.
•	Deposit money into an account.
•	Withdraw money from an account (if balance is sufficient).
•	Search for an account by account number.
•	The system should store a maximum of 100 accounts using arrays (no collections or database).

Requirements:
Use a BankAccount class with:
•	accountNumber (int)
•	accountHolderName (String)
•	balance (double)
•	Use an array of BankAccount objects in the main program.
•	Implement a simple menu-driven interface.
*/

import java.util.Scanner;
class BankAccount 
{
    int accountNum;
    double balance;
    String accountHolder;
	/*
    Constructor: Creates a new bank account with the given account number,
    account holder's name, and initial balance. */
    BankAccount(int accountNum, String accountHolder, double balance) 
	{
        this.accountNum = accountNum;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
	//Adds the specified deposit amount to the account balance.
    void deposit(double dep) 
	{
        balance += dep;
        System.out.println("Deposited: " + dep + "\nCurrent balance: " + balance);
    }
	//Deducts the specified amount from the balance if sufficient funds are available.
    void withdraw(double with) 
	{
        if (with <= balance) 
		{
            balance -= with;
            System.out.println("Withdrawn: " + with + "\nCurrent balance: " + balance);
        } 
		else
            System.out.println("Insufficient balance");
    }
	//Shows the account's number, holder's name, and current balance.
    void display() 
	{
        System.out.println("Account No: " + accountNum + "\nName: " + accountHolder + "\nBalance: " + balance);
    }
}

class AccMgmt 
{
    //Entry point of the program. Provides a menu-driven interface
	public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        BankAccount[] ac = new BankAccount[100];
        int count = 0;
        while(true) 
		{
            System.out.println("\n===== Bank Menu =====");
            System.out.println("1. Create New Account\n2. View All Accounts\n3. Deposit Money\n4. Withdraw Money\n5. Search Account\n6. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) 
			{
                // Create new account
				case 1: if (count >= 100) 
						{
							System.out.println("Account limit reached!");
							break;
						}
						System.out.print("Enter account number: ");
						int accNum1 = sc.nextInt();
						sc.nextLine();
						System.out.print("Enter Account Holder Name: ");
						String name = sc.nextLine();
						System.out.print("Enter Initial Balance: ");
						double bal = sc.nextDouble();
						ac[count] = new BankAccount(accNum1, name, bal);
						count++;
						System.out.println("Account created successfully!");
						break;

                // View all accounts
				case 2: if (count == 0)
							System.out.println("No accounts available.");
                        else 
						{
							for (int i = 0; i < count; i++) 
							{
								ac[i].display();
								System.out.println("-------------------");
							}
						}	break;

                // Deposit money into an account
				case 3: System.out.print("Enter account number: ");
						int accNum2 = sc.nextInt();
						System.out.print("Enter deposit amount: ");
						double dep = sc.nextDouble();
						int flag1 = 0;
						for (int i=0; i<count; i++) 
						{
							if (ac[i].accountNum == accNum2) 
							{
								ac[i].deposit(dep);
								flag1 = 1;	break;
							}
						}
						if (flag1 == 0)	
							System.out.println("Account not found!");	break;

                // Withdraw money from an account
				case 4: System.out.print("Enter account number: ");
						int accNum3 = sc.nextInt();
						System.out.print("Enter withdrawal amount: ");
						double w = sc.nextDouble();
						int flag2 = 0;
						for (int i = 0; i < count; i++) 
						{
							if (ac[i].accountNum == accNum3) 
							{
								ac[i].withdraw(w);
								flag2 = 1;	break;
							}
						}
						if (flag2 == 0) 
							System.out.println("Account not found!");	break;

                // Search for an account
				case 5: System.out.print("Enter account number: ");
						int accNum4 = sc.nextInt();
						int flag3 = 0;
						for (int i = 0; i < count; i++) 
						{
							if (ac[i].accountNum == accNum4) 
							{
								ac[i].display();
								flag3 = 1;	break;
							}
						}
						if (flag3 == 0) 
							System.out.println("Account not found!");	break;

                // Exit program
				case 6: System.out.println("Exiting... Thank you!");
						System.exit(0);

                default: System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
