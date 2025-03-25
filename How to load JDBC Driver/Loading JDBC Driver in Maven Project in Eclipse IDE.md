# Loading JDBC Driver in Maven Project Using Eclipse IDE

## 1. Create Maven Project

1. In Eclipse: **File → New → Maven Project**
2. Select:
   - "Create a simple project" (skip archetype selection)
   - Group ID: `com.yourcompany`
   - Artifact ID: `jdbc-demo`
   - Packaging: `jar`
3. Click **Finish**

## 2. Add JDBC Dependency

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

## 3. Create Connection Class

1. Right-click `src/main/java` → **New → Class**
2. Name: `JdbcConnectionDemo`
3. Add code:

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcConnectionDemo {
    public static void main(String[] args) {
        // Database configuration
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "username";
        String password = "password";
        
        // Try-with-resources for automatic resource management
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT 1")) {
            
            System.out.println("Database connection successful!");
            
            // Process result set
            while (rs.next()) {
                System.out.println("Test query result: " + rs.getInt(1));
            }
            
        } catch (Exception e) {
            System.err.println("Connection failed!");
            e.printStackTrace();
        }
    }
}
```

## 4. Configure Database Connection

Modify these values in the code:

- `url`: JDBC connection string for your database
  - MySQL: `jdbc:mysql://host:port/database`
  - Oracle: `jdbc:oracle:thin:@//host:port/service_name`
  - PostgreSQL: `jdbc:postgresql://host:port/database`
- `user`: Database username
- `password`: Database password

## 5. Run the Application

1. Right-click `JdbcConnectionDemo.java`
2. Select **Run As → Java Application**
3. Check Console output for connection status

## Troubleshooting

### Common Issues:

1. **"No suitable driver found"**

   - Right-click project → **Maven → Update Project**
   - Verify dependency appears in "Maven Dependencies" folder
   - Check JDBC URL format

2. **Dependency not downloading (Oracle)**

   - Add Oracle Maven repository (shown above)

   - Alternatively, manually install the JAR:

     bash

     Copy

     ```
     mvn install:install-file -Dfile=ojdbc8.jar -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=21.9.0.0 -Dpackaging=jar
     ```

3. **Connection refused**

   - Verify database server is running
   - Check firewall settings
   - Test connection with database client tools first

## Best Practices

1. **Externalize Configuration**:

   - Move credentials to `src/main/resources/application.properties`:

     properties

     Copy

     ```
     db.url=jdbc:mysql://localhost:3306/mydb
     db.user=admin
     db.password=secret
     ```

   - Read using:

     java

     Copy

     ```
     Properties props = new Properties();
     props.load(getClass().getResourceAsStream("/application.properties"));
     ```

2. **Use Connection Pooling** (for production):

   xml

   Copy

   ```
   <dependency>
       <groupId>com.zaxxer</groupId>
       <artifactId>HikariCP</artifactId>
       <version>5.0.1</version>
   </dependency>
   ```

   

   Run HTML

3. **Logging**:

   xml

   Copy

   ```
   <dependency>
       <groupId>ch.qos.logback</groupId>
       <artifactId>logback-classic</artifactId>
       <version>1.4.7</version>
   </dependency>
   ```

   

   Run HTML