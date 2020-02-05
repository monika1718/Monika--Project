package com.register.marriage.love;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.mysql.jdbc.Driver;

public class Inserthelperclass {

	public static void insert(Bride bride) throws FileNotFoundException, IOException
	{
		Connection con = null;
		PreparedStatement Pstmt=null;
		FileInputStream inputstream=null;
		try {
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
			
			String dburl="jdbc:mysql://localhost:3306/marriage?user=root&password=root";
			con =DriverManager.getConnection(dburl);
			
			String query=" insert into bride "
					       + " values(?,?,?,?) ";
			
			inputstream=new FileInputStream(bride.getPhoto());
			
			Pstmt=con.prepareStatement(query);
			
			Pstmt.setString(1,bride.getName());
			Pstmt.setLong(2,bride.getContact());
			Pstmt.setString(3,bride.getJob());
			Pstmt.setBinaryStream(4,inputstream); 
			
			int res=Pstmt.executeUpdate();
			if(res!=0)
			{
				System.out.println("profile updated");
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			try {
				if(con!=null)
				{
					con.close();
				}
				if(Pstmt!=null)
				{
					Pstmt.close();
				}
				if(inputstream!=null)
				{
					inputstream.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
