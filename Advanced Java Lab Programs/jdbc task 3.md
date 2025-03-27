Program01: 
==========
You are given a task to retrieve data from an Oracle database table orders with the columns: order_id, customer_name, order_date, and total_amount.

Establish a JDBC connection to Oracle.
Execute a query to retrieve order_id, customer_name, order_date, and total_amount from the orders table.
Convert the ResultSet into a list of Order objects. 
->Filter the orders where the total_amount is greater than 1000.
->Sort the orders by order_id in ascending order. 
->Group the orders by customer_name. 
->Print the grouped orders, showing each customer’s name and the order details. 

Program02:
==========
Write a Java program to perform below operations:
Note:
-create table departments.
-Table's properties: id, name, location, and manager_id.
-Insert 5 records from sql command line.

Task to perform:Retrieves id, name, location, and manager_id from an Oracle database departments table.
Establishes a JDBC connection to Oracle.
Retrieves the department details from the departments table.
Converts the ResultSet into a list of Department objects.
1.Filters departments located in a specific city (e.g., "New York").
2.Sorts the departments by name in ascending order.
3.Limits the results to the top 3 departments based on manager_id.
4.Prints the list of top 3 departments with their details.



Program03:
=========
Write a Java program to perform below operations:
Note:
-create table emp_info
-Table's properties: id, name, salary, and department.
-Insert 5 records from sql command line.

Establish a JDBC connection to Oracle.
Retrieve the employee details from the employees table.
Convert the ResultSet into a list of Employee objects.
->Filter employees whose salary is greater than 50,000.
->Sort the employees by salary in descending order.
->Limit the results to the top 5 employees based on salary.
->Print the list of top 5 employees with their details.
                                                                       