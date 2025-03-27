Program02_Solution:
===================


Dapartment.java:
================

package com.jdbc;
public class Department {

	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getManager_Id() {
		return manager_Id;
	}
	public void setManager_Id(String manager_Id) {
		this.manager_Id = manager_Id;
	}
	private String name,location,manager_Id;
	public Department(int id, String name, String location, String manager_Id) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.manager_Id = manager_Id;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", location=" + location + ", manager_Id=" + manager_Id
				+ "]";
	}

}




JdbcUsingStream.java:
=====================
package com.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class JdbcUsingStream {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
			PreparedStatement ps=con.prepareStatement("select * from department");
			ResultSet rs = ps.executeQuery();
			List<Department> list=new ArrayList<Department>();
			while(rs.next())
			{
				list.add(new Department
				(rs.getInt("id"), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		System.out.println("====================Filtering Location===============");
		list.stream().filter(dept->dept.getLocation().equalsIgnoreCase("mumbai")).forEach(System.out::println);
		System.out.println("==========Sorting the dept based on dname========");
		list.stream().sorted((d1,d2)->d2.getName().compareTo(d1.getName())).forEach(System.out::println);
		System.out.println("==============Top 3 Departments based manager id============");
		list.stream().
		sorted((d1,d2)->d2.getManager_Id().compareTo(d1.getManager_Id())).limit(3).forEach(System.out::println);
		System.out.println("list of top 3 departments with their details.\r\n"
				+ "");
		list.stream().limit(3).forEach(System.out::println);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}