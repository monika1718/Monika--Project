package com.register.marriage.love;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class Deletehelperclass {
	public static void delete(String[] args) {
		Connection con=null;
		PreparedStatement Pstmt=null;
		try
			{
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
		
			String dburl = "jdbc:mysql://localhost:3306/marriage?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String query = " delete from bride "
				+ " where name=? ";
		
			Pstmt =con.prepareStatement(query);
		
			Pstmt.setString(1,(args[0]));
			int res = Pstmt.executeUpdate();
			if(res!=0)
				{
					System.out.println("Record updated");
				}
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
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
