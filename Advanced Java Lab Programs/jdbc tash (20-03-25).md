Program01::Write a jdbc program as follows:
===========
Table Name:Employee_Info.
Table Columns:-empId,empName,empSalary,empAddress,empMailId,empPhNo.
Note::-Using Batch Processing you have to execute following querries.
       1.Insert data into Employee Table.
       2.Update employee salary with the help of eid.
       3.delete employee who is getting maximum salary.  

Program_02::Write a jdbc program which proves that PreparedStatement is faster as compared to Statement. 

Program_03:Write a JDBC program to read the data from CSV file(excel sheet) and insert data into database table. 

```java
//solution 


InsufficientFundsException.java:
================================

package test;
public class InsufficientFundsException extends Exception {

	public InsufficientFundsException(String msg)
	{
		super(msg);
	}
}

OnlineBankingSystem.java:
=========================

package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OnlineBankingSystem {

	public static Connection con=null;
	public static long senderAccount=12345,receiverAccount=54321;
	public static double tAmount=10000;
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
			con.setAutoCommit(false);
			PreparedStatement ps=con.prepareStatement("select * from accounts where accno=?");
			PreparedStatement ps1=con.prepareStatement
					("update accounts set balance=balance+? where accno=?");
			ps.setLong(1, senderAccount);
			ResultSet rs = ps.executeQuery();
			rs.next();
			double bal = rs.getDouble("balance");
			if(bal>=tAmount)
			{
			ps1.setDouble(1, -tAmount);
			ps1.setLong(2, senderAccount);
			int k1 = ps1.executeUpdate();
			ps1.setDouble(1, tAmount);
			ps1.setLong(2, receiverAccount);
			int k2 = ps1.executeUpdate();
			if(k1==1&&k2==1)
			{
				System.out.println("Transaction Successfull");
				con.commit();
				
			}
			}
			else {
				try {
					con.rollback();
					throw new InsufficientFundsException("Insufficient Fund......");
				
				}
				catch (InsufficientFundsException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}

```

