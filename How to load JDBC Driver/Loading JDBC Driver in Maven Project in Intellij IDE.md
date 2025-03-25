## Step 1: Create a New Maven Project

1. **Open IntelliJ IDEA** and click "New Project"
2. **Select "Maven"** 
3. **Choose JDK version** (Java 8 or higher recommended)
4. Advanced Setting (Optio) :
   - **GroupId**: com.yourcompany (e.g., com.example)
   - **ArtifactId**: jdbc-demo (your project name)
   - **Version**: 1.0-SNAPSHOT (default)
5. Click "Next" then "Finish"

## Step 2: Add JDBC Dependency

1. Open the `pom.xml` file in your project root
2. Add the JDBC driver dependency inside the `<dependencies>` section:

```xml
<dependencies>
    <!-- MySQL Connector (example) -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.33</version>
    </dependency>
    
    <!-- For other databases:
    PostgreSQL:
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.6.0</version>
    </dependency>
    
    Oracle:
    <dependency>
        <groupId>com.oracle.database.jdbc</groupId>
        <artifactId>ojdbc8</artifactId>
        <version>21.9.0.0</version>
    </dependency>
    -->
</dependencies>
```

1. **Save the file** - IntelliJ will automatically download the dependency (you'll see a notification)

## Step 3: Create JDBC Connection Class

1. Right-click on `src/main/java`
2. Select "New" → "Java Class"
3. Name it `JdbcDemo` or similar
4. Add the following code:

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class JdbcDemo {
    // Database configuration - should be in properties file in real projects
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to database successfully!");
            
            // Create statement
            try (Statement statement = connection.createStatement()) {
                
                // Execute query
                ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table LIMIT 5");
                
                // Process results
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id") + 
                                     ", Name: " + resultSet.getString("name"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Database connection failed!");
            e.printStackTrace();
        }
    }
}
```

## Step 4: Configure Database Connection

1. Replace the connection parameters in the code:
   - `URL`: `jdbc:mysql://host:port/database_name`
   - `USER`: Your database username
   - `PASSWORD`: Your database password
   - Update the SQL query to match your table structure

## Step 5: Run the Application

1. Right-click on your `JdbcDemo` class
2. Select "Run 'JdbcDemo.main()'"
3. Check the output:
   - Success: "Connected to database successfully!" followed by query results
   - Failure: Error message with stack trace

## Optional: Add Logging (Recommended)

Add SLF4J to your `pom.xml`:

```xml
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>2.0.7</version>
</dependency>
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.4.7</version>
</dependency>
```

## Project Structure

Your final project structure should look like:

```bash
jdbc-demo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── JdbcDemo.java
│   │   └── resources/
│   │       └── (optional config files)
├── target/
├── pom.xml
```

## Troubleshooting

1. **"No suitable driver found"**:

   - Verify the dependency is in `pom.xml`
   - Right-click project → Maven → Reimport
   - Check "External Libraries" for the driver JAR

2. **Connection failures**:

   - Verify database is running
   - Check credentials
   - Test connection with database tools first

3. **For older JDBC versions**:
   You might need to explicitly load the driver:

   ```java
   Class.forName("com.mysql.cj.jdbc.Driver"); // Before getConnection()
   ```