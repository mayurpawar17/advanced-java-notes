Program_01:
===========
Title: Simulating Fund Transfer Transactions in an Online Banking System using JDBC.

Description:
------------
In this exercise, you will develop a Java program to simulate fund transfer transactions within an online banking system. The program will interact with an Oracle database using JDBC to perform various operations such as checking account balances, deducting funds from sender accounts, crediting funds to receiver accounts, and handling transaction consistency. Additionally, error scenarios like insufficient funds and transaction rollbacks will be addressed.

Step-by-Step Guide with Table Structure:
----------------------------------------
Database Table Structure:
-------------------------
Create an Oracle database schema named banking_system with a table named accounts to store bank account information.
The accounts table should have the following columns:
account_number (NUMBER): Primary key representing the account number.
balance (NUMBER): The current balance of the account.                                 

1.Setting Up Database Connection:
---------------------------------
Define a Java class OnlineBankingSystem with a main method.
Set up the JDBC URL, username, and password to establish a connection with the Oracle database.

2.Initialize Transfer Parameters:
---------------------------------
Declare variables senderAccount, receiverAccount, and transferAmount to represent the sender's account number, receiver's account number, and the amount to be transferred, respectively.
Assign sample values to these variables (e.g., senderAccount = 123456, receiverAccount = 654321, transferAmount = 500.0).

3.Establish Database Connection:
--------------------------------
Inside the main method, use DriverManager.getConnection to establish a connection to the Oracle database using the JDBC URL, username, and password.

4.Start Transaction and Error Handling:
---------------------------------------
Set the auto-commit mode of the database connection to false to begin a transaction.
Implement a try-catch block to handle SQL exceptions. Print stack traces for any caught exceptions.

5.Check Sender's Balance:
--------------------------
Implement the getAccountBalance method to retrieve the balance of a specified bank account from the database using a prepared statement.
Pass the sender's account number to getAccountBalance and store the returned balance in the senderBalance variable.

6.Insufficient Funds Check:
---------------------------
Compare the senderBalance with the transferAmount to ensure that the sender has sufficient funds for the transfer.
If the sender's balance is less than the transfer amount, print "Insufficient funds in the sender's account." and exit the program.

7.Deduct Transfer Amount:
--------------------------
Implement the updateAccountBalance method to deduct the transfer amount from the sender's account balance in the database.
Pass the sender's account number and the new balance (calculated as senderBalance - transferAmount) to updateAccountBalance.

8.Credit Transfer Amount:
-------------------------
Retrieve the balance of the receiver's account using getAccountBalance and store it in the receiverBalance variable.
Add the transfer amount to the receiver's balance using updateAccountBalance.

9.Commit Transaction:
---------------------
If all operations are successful, commit the transaction using connection.commit(). Print "Transfer successful!".

10.Handle Transaction Rollback:
-------------------------------
In the catch block, print "Transaction failed. Rolling back changes...".
Use a nested try-catch block to handle potential rollback failures and print stack traces for any caught exceptions.
Roll back the transaction by calling connection.rollback().

11.Close Database Connection:
-----------------------------
Add a finally block to close the database connection using connection.close(). Handle any potential SQLExceptions using another nested try-catch block.
This step-by-step breakdown guides the implementation of the program, covering database connection, transaction management, error handling, and database operations necessary for simulating fund transfer transactions in an online banking system.



Program_02:
Step01=>Create Table:emp_info
Columns:empId,empFirstName,empLastName,empAddress,empSalary,empPhNo.
Step02=>Write a jdbc program to retrieve all record from Emp_Info table and store into a map in such a way that employee first name will be key and number of character available in that first name will be the value.