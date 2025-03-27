1)Batch Processing: Implement Data Insertion from CSV
•	Scenario: You have a CSV file containing employee data (id, name, salary).
•	Task: Write a Java program that reads the data from the CSV file and inserts it into an employees table in your database using JDBC batch processing.


-----------------------

2)2.Create table with name:
           Customer7(cid,cname,city,mid,phno)
    Create and execute stored-Procedure to insert details
     Create and execute Stored-function to retrieve phone number based on cid







**1.** What does setAutoCommit(false) do?

| (a)  | commits transaction after each  query                       |
| ---- | ----------------------------------------------------------- |
| (b)  | explicitly commits transaction                              |
| (c)  | does not commit transaction  automatically after each query |
| (d)  | never commits transaction                                   |

 

**2.** ______ is method of JDBC batch process.

| (a)  | removeBatch() |
| ---- | ------------- |
| (b)  | addBatch()    |
| (c)  | setBatch()    |
| (d)  | deleteBatch() |

 

**3.** Which type of JDBC driver is the fastest one?

| (a)  | Type-1 |
| ---- | ------ |
| (b)  | Type-2 |
| (c)  | Type-3 |
| (d)  | Type-4 |

 

**4.** What causes "No suitable driver" error?

| (a)  | Due to failing to load the  appropriate JDBC drivers before calling the getConnection(). |
| ---- | ------------------------------------------------------------ |
| (b)  | it can be specifying an invalid  JDBC URL, one that is not recognized by JDBC driver. |
| (c)  | This error can occur if one or  more the shared libraries needed by the bridge cannot be loaded. |
| (d)  | All of these                                                 |

 

**5.** What is the use of blob, clob datatypes in JDBC?

| (a)  | to store byte array                                          |
| ---- | ------------------------------------------------------------ |
| (b)  | to store large amount of data into  database like images, movie |
| (c)  | to store arrived packets like UDP  packets                   |
| (d)  | to store char array                                          |

**6.** The interface ResultSet has a method, getMetaData(), that returns…

| (a)  | Object |
| ---- | ------ |
| (b)  | Value  |
| (c)  | Tuple  |
| (d)  | Result |

 

**7.** ______ Methods returns a stream that simply provides the raw bytes from the database without any conversion?

| (a)  | getCharacterStream |
| ---- | ------------------ |
| (b)  | getBinaryStream    |
| (c)  | getAsciiStream     |
| (d)  | getUnicodeStream   |

 

**8.** In ______ ResultSet, the cursor can scroll forwards and backwards, and the result set is sensitive to changes made by others to the database that occur after the result set was created?

| (a)  | ResultSet.TYPE_FORWARD_ONLY       |
| ---- | --------------------------------- |
| (b)  | ResultSet.TYPE_SCROLL_SENSITIVE   |
| (c)  | ResultSet.TYPE_SCROLL_INSENSITIVE |
| (d)  | None of the above                 |

 

  **9.**UDA means______.             (a)            Unified    Data Access                  (b)            Universal    Data Access                  (c)            Universal    Digital Access                  (d)            Uniform    Data Access                

**10.** What is the correct order to close database resources?

| (a)  | Connection then Statement then  ResultSet |
| ---- | ----------------------------------------- |
| (b)  | ResultSet then Statement then  Connection |
| (c)  | Statement then Connection then  ResultSet |
| (d)  | Statement then ResultSet then  Connection |

 

**11.** Which method Drops all changes made since the previous commit/rollback?

| (a)  | rollback() |
| ---- | ---------- |
| (b)  | commit()   |
| (c)  | close()    |
| (d)  | close()    |

 

**12.** Which of following statement is false for PreparedStatement ?

| (a)  | PreparedStatement is used to  execute the parameterized query. |
| ---- | ------------------------------------------------------------ |
| (b)  | Query is compiled only once.                                 |
| (c)  | PreparedStatement is used when we  need to provide input parameters to the query at runtime. |
| (d)  | In the PreparedStatement, the  query is compiled each time we run the program. |

 

**13.** The executeUpdate method can be used with ____________.

| (a)  | Statements(Select and Update both)                |
| ---- | ------------------------------------------------- |
| (b)  | Select statement.                                 |
| (c)  | Update/delete/insert operations in  the database. |
| (d)  | Only insert operation.                            |

 

**14.** Which of following is use of absolute() method of ResultSet object ?

| (a)  | Moves the cursor to the specified  row.                      |
| ---- | ------------------------------------------------------------ |
| (b)  | Moves the cursor forward one row  from its current position. |
| (c)  | Moves the cursor the given number  of rows forward or backward, from where it is currently pointing. |
| (d)  | Moves the cursor to the first row.                           |

 

**15.** Which of following interface is used to get driver name ?

| (a)  | DatabaseMetadata  |
| ---- | ----------------- |
| (b)  | ResultSetMetaData |
| (c)  | MetaData          |
| (d)  | ResultSet         |

 

  **16.**Which of following is  return type of executeBatch() ?             (a)            int[]                  (b)            Integer                  (c)            Integer[]                  (d)            int           

 

**17.** Which of the following prevent dirty reads, non-repeatable reads, and phantom reads in JDBC ?

| (a)  | TRANSACTION_READ_COMMITTED   |
| ---- | ---------------------------- |
| (b)  | TRANSACTION_READ_UNCOMMITTED |
| (c)  | TRANSACTION_REPEATABLE_READ  |
| (d)  | TRANSACTION_SERIALIZABLE     |

 

**18.Connection interface extends from _____**

**(a)Statement and PreparedStatement**

**(b)Wrapper and AutoCloseable**

**(c)PreparedStatement and CallableStatement**

**(d)None**

 

**19.We use the following to retrieve Column names from ResultSet**

**(a)DatabaseMetaData**

**(b)ResultSetMetaData**

**(c)ParameterMetaData**

**(d)RowSetMetaData**

 

**20.WebRowSet extends from____**

**(a)RowSet**

**(b)ResultSet**

**(c)CachedRowSet**

**(d)JdbcRowSet**

**Answers:**

Here are the correct answers:

1. **(c)**     does not commit transaction automatically after each query
2. **(b)**     addBatch()
3. **(d)**     Type-4
4. **(d)** All     of these
5. **(b)** to     store large amounts of data into database like images, movies
6. **(d)**     ResultSetMetaData
7. **(b)**     getBinaryStream
8. **(b)**     ResultSet.TYPE_SCROLL_SENSITIVE
9. **(b)**     Universal Data Access
10. **(b)**     ResultSet then Statement then Connection
11. **(a)**     rollback()
12. **(d)** In     the PreparedStatement, the query is compiled each time we run the program.     *(False statement)*
13. **(c)**     Update/delete/insert operations in the database.
14. **(a)**     Moves the cursor to the specified row.
15. **(a)**     DatabaseMetadata
16. **(a)**     int[]
17. **(d)**     TRANSACTION_SERIALIZABLE
18. **(b)**     Wrapper and AutoCloseable
19. **(b)**     ResultSetMetaData
20. **(a)**     RowSet