# Loading JDBC Driver Manually in Intellij IDE

## Step 1: Create Java Project

1. Open IntelliJ IDEA
2. **File → New → Project**
3. Select "Java" (not Maven/Gradle)
4. Choose Project SDK (Java 8 or later recommended)
5. Click "Next" then "Finish"

## Step 2: Download JDBC Driver

1. Download the appropriate JDBC driver:
   - [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)
   - [PostgreSQL JDBC](https://jdbc.postgresql.org/download/)
   - [Oracle JDBC](https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html)
2. Save the `.jar` file (e.g., `mysql-connector-java-8.0.33.jar`)

## Step 3: Add JDBC Driver to Project

1. In IntelliJ:
   - Right-click project → **Open Module Settings** (F4)
   - Navigate to **Libraries** → Click **+** → **Java**
   - Select the downloaded JDBC driver `.jar` file
   - Click **OK** to add it to your project

## Step 4: Create Connection Class

1. Right-click `src` folder → **New → Java Class**
2. Name it (e.g., `ManualJdbcDemo`)
3. Add connection code:

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ManualJdbcDemo {
    public static void main(String[] args) {
        // Database configuration
        String driverClass = "com.mysql.cj.jdbc.Driver"; // MySQL example
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";
        
        // Explicitly load JDBC driver (optional for JDBC 4.0+)
        try {
            Class.forName(driverClass);
            System.out.println("JDBC driver loaded successfully");
        } catch (ClassNotFoundException e) {
            System.err.println("Failed to load JDBC driver");
            e.printStackTrace();
            return;
        }
        
        // Establish connection
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT 1")) {
            
            System.out.println("Database connection successful!");
            
            // Process results
            while (rs.next()) {
                System.out.println("Test query result: " + rs.getInt(1));
            }
            
        } catch (Exception e) {
            System.err.println("Database connection failed!");
            e.printStackTrace();
        }
    }
}
```

## Step 5: Configure for Your Database

Modify these values in the code:

1. **Driver Class**:
   - MySQL: `com.mysql.cj.jdbc.Driver`
   - PostgreSQL: `org.postgresql.Driver`
   - Oracle: `oracle.jdbc.OracleDriver`
2. **Connection URL**:
   - MySQL: `jdbc:mysql://host:port/database?useSSL=false`
   - PostgreSQL: `jdbc:postgresql://host:port/database`
   - Oracle: `jdbc:oracle:thin:@//host:port/service_name`
3. **Credentials**:
   - Update username and password

## Step 6: Run the Application

1. Right-click `ManualJdbcDemo.java`
2. Select **Run 'ManualJdbcDemo.main()'**
3. Check output:
   - Success: "Database connection successful!"
   - Failure: Error stack trace

## Key Notes

1. **JDBC 4.0+**: Modern drivers auto-load (no need for `Class.forName()`)
2. **Legacy Systems**: Keep `Class.forName()` for older JDBC versions
3. **Connection Management**: Always close resources (try-with-resources helps)

## Troubleshooting

| Issue                      | Solution                                          |
| :------------------------- | :------------------------------------------------ |
| **ClassNotFoundException** | Verify JAR is properly added to project libraries |
| **No suitable driver**     | Check URL format and driver class name            |
| **Connection refused**     | Verify database server is running                 |
| **Access denied**          | Check username/password                           |

## Project Structure

```bash
jdbc-demo/
├── lib/
│   └── mysql-connector-java-8.0.33.jar
├── src/
│   └── ManualJdbcDemo.java
└── out/ (generated classes)
```