package com.jscompany.test;

import java.sql.*;

public class MemberDAO {
	
	private String driverName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/jspdb";
	private String username = "root";
	private String password = "1234";
	
	public int insertMember(String id, String pw, String email) {
		
		String sql = "INSERT INTO members (id, pass, email) VALUES (?,?,?)";
		int dbFlag=0; 
      	Connection conn = null;
     	PreparedStatement pstmt = null;
      
      try {
    	Class.forName(driverName);
		conn = DriverManager.getConnection(url, username, password);
			
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		pstmt.setString(3, email);	
         
        dbFlag=pstmt.executeUpdate();
      
         
      } catch(ClassNotFoundException e) {
    	  e.printStackTrace();   
      } catch(SQLException e) {
    	  e.printStackTrace();
      } finally {
         try {
        	 if(pstmt != null) {
                 pstmt.close();
              }
            if(conn != null) {
               conn.close();
            }
         } catch(Exception e) {
            e.printStackTrace();
         }
      }
     	
	return dbFlag;
		
		
	}
}
