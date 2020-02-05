package com.register.marriage.love;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Retrievehelperclass {
     public static void retrieve() throws IOException
     {
    	 Connection con=null;
 		Statement stmt=null;
 		ResultSet rs=null;
 		FileOutputStream output=null;
 		try
 		{
 			Driver driverref=new Driver();
 			DriverManager.registerDriver(driverref);
 			
 			String dburl = "jdbc:mysql://localhost:3306/marriage?user=root&password=root";
 			con = DriverManager.getConnection(dburl);
 			
 			String query="select photo from bride";
 			stmt=con.createStatement();
 			rs=stmt.executeQuery(query);
 			
 			File file = new File("photo.jpeg");
 			output = new FileOutputStream(file);
 			
 			while(rs.next())
 			{
 				InputStream input=rs.getBinaryStream("photo");
 				byte[] buffer=new  byte[1024];
 				while(input.read(buffer)>0)
 				{
 					output.write(buffer);
 				}
 			}
 			System.out.println("image retrieved");
 			
 		}catch(SQLException e)
 		{
 			e.printStackTrace();
 		}finally
 		{
 			try
 			{
 				if(con!=null)
 				{
 					con.close();
 				}
 				if(stmt!=null)
 				{
 					stmt.close();
 				}
 				if(rs!=null)
 				{
 					rs.close();
 				}
 				if(output!=null)
 				{
 					output.close();
 				}
 			}	
 				catch(SQLException e1)
 				{
 					e1.printStackTrace();
 				}
 			}
 	
 
     }
}
