DB Table : BookDetails72
            (bcode,bname,bauthor,bprice,bqty)
             primary key : bcode

  Construct JDBC Application to insert 5 book details
 
```java
public static void main(String[] args) {  
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";  
        String username = "mayur";  
        String password = "mayur123";  
  
        Connection connection = null;  
        Statement statement = null;  
        Scanner scanner = new Scanner(System.in);  
  
  
        try (scanner) {  
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            connection = DriverManager.getConnection(jdbcUrl, username, password);  
            statement = connection.createStatement();  
            System.out.println("Enter Book Code: ");  
            String bcode = scanner.nextLine();  
  
            System.out.println("Enter Book Name: ");  
            String bname = scanner.nextLine();  
  
  
            System.out.println("Enter Book Author name : ");  
            String bauthor = scanner.nextLine();  
  
            System.out.println("Enter Book Price : ");  
            double bprice = Double.parseDouble(scanner.nextLine());  
  
            System.out.println("Enter Book quantity: ");  
            int bqty = scanner.nextInt();  
  
            String sqlQuery = "insert into bookdetails values('" + bcode + "','" + bname + "','" + bauthor + "'," + bprice + "," + bqty + ")";  
  
  
            int k = statement.executeUpdate(sqlQuery);  
  
            if (k > 0) System.out.println("Book details add successfully...");  
  
  
            connection.close();  
        } catch (Exception e) {  
            System.out.println("An error occurred.");  
            e.printStackTrace();  
        }  
    }  

```
 
Construct JDBC Application to display all book details  

```java

public static void main(String[] args) {  
    String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";  
    String username = "mayur";  
    String password = "mayur123";  
  
    Connection connection = null;  
    Statement statement = null;  
    ResultSet resultSet = null;  
    Scanner scanner = new Scanner(System.in);  
  
  
    try (scanner) {  
        Class.forName("oracle.jdbc.driver.OracleDriver");  
        connection = DriverManager.getConnection(jdbcUrl, username, password);  
        statement = connection.createStatement();  
        String sqlQuery = "SELECT * FROM  BookDetails";  
        resultSet = statement.executeQuery(sqlQuery);  
  
  
        while (resultSet.next()) {  
            String bookCode = resultSet.getString(1);  
            String bookName = resultSet.getString(2);  
            String author = resultSet.getString(3);  
            double bookPrice = resultSet.getDouble(4);  
            int bookQuantity = resultSet.getInt(5);  
  
            System.out.println("bookCode: " + bookCode + ", bookName: " + bookName + ", Author: " + author + ", bookPrice: ₹" + bookPrice + ", bookQuantity: " + bookQuantity);  
        }  
        connection.close();  
    } catch (Exception e) {  
        System.out.println("An error occurred.");  
        e.printStackTrace();  
    }  
}
```

program-3 : Construct JDBC Application to display book details based on bookCode

```java

public static void main(String[] args) {  
    String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";  
    String username = "mayur";  
    String password = "mayur123";  
  
    Connection connection = null;  
    Statement statement = null;  
    ResultSet resultSet = null;  
    Scanner scanner = new Scanner(System.in);  
  
  
    try (scanner) {  
        Class.forName("oracle.jdbc.driver.OracleDriver");  
        connection = DriverManager.getConnection(jdbcUrl, username, password);  
        statement = connection.createStatement();  
        System.out.print("Enter Book Code to view Details:  ");  
        String bcode = scanner.nextLine();  
  
  
        String sqlQuery = "SELECT * FROM  BookDetails where bcode='" + bcode + "'";  
  
        resultSet = statement.executeQuery(sqlQuery);  
  
  
        while (resultSet.next()) {  
            String bookCode = resultSet.getString(1);  
            String bookName = resultSet.getString(2);  
            String author = resultSet.getString(3);  
            double bookPrice = resultSet.getDouble(4);  
            int bookQuantity = resultSet.getInt(5);  
  
            System.out.println("bookCode: " + bookCode + ", bookName: " + bookName + ", Author: " + author + ", bookPrice: ₹" + bookPrice + ", bookQuantity: " + bookQuantity);  
        }  
        connection.close();  
  
  
        connection.close();  
    } catch (Exception e) {  
        System.out.println("An error occurred.");  
        e.printStackTrace();  
    }  
}
```