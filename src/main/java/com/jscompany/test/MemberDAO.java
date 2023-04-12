package com.jscompany.test;

import java.sql.*;


public class MemberDAO {
	
	private String driverName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/jspdb";
	private String username = "root";
	private String password = "1234";
	
	public int insertMember(MemberDTO dto) {
		
		String sql = "INSERT INTO members (id, pass, email) VALUES (?,?,?)";
		int dbFlag=0; 
      	Connection conn = null;
     	PreparedStatement pstmt = null;
      
      try {
    	Class.forName(driverName);
		conn = DriverManager.getConnection(url, username, password);
			
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getPass());
		pstmt.setString(3, dto.getEmail());	
         
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
	
	
	public int loginCheck(String id, String pass) {
		String sql = "SELECT * FROM members WHERE id=? AND pass=? ";
		int dbFlag=0; 
      	Connection conn = null;
     	PreparedStatement pstmt = null;
     	ResultSet rs = null;
     	
      try {
    	Class.forName(driverName);
		conn = DriverManager.getConnection(url, username, password);
			
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pass);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			dbFlag = 1; // 로그인 성공
		} else {
			dbFlag = 0;
		}
			
				
		
      
         
      } catch(ClassNotFoundException e) {
    	  e.printStackTrace();   
      } catch(SQLException e) {
    	  e.printStackTrace();
      } finally {
         try {
        	 if(rs != null) {
                 rs.close();
              }
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
	
	public int deleteMember(String id) {
		String sql = "DELETE FROM members WHERE id=?";
		int dbFlag=0; 
      	Connection conn = null;
     	PreparedStatement pstmt = null;
      
      try {
    	Class.forName(driverName);
		conn = DriverManager.getConnection(url, username, password);
			
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
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
