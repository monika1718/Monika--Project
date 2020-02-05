package com.register.marriage.love;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class Updatehelperclass {
	public static void update(String[] args) {
		Connection con=null;
		PreparedStatement Pstmt=null;
		try
		{
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		String dburl = "jdbc:mysql://localhost:3306/marriage?user=root&password=root";
		con = DriverManager.getConnection(dburl);
		String query = " update bride "
				+ " set name=? "
				+ " where job = ? ";
		
		Pstmt =con.prepareStatement(query);
		
		Pstmt.setString(1,(args[0]));
		Pstmt.setString(2,(args[1]));
	
		
		int res = Pstmt.executeUpdate();
		if(res!=0)
		{
			System.out.println("Record updated");
		}
	

	    }
		catch(Exception e)
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
				if(Pstmt!=null)
				{
					Pstmt.close();
				}
				
			}	
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
    }
	}

