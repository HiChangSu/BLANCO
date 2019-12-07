package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class GuestDBBean {
	
    private static GuestDBBean instance = new GuestDBBean();
    
    public static GuestDBBean getInstance() {
        return instance;
    }
    
    private GuestDBBean() {}
    
    private Connection getConnection() throws Exception {
        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        DataSource ds = (DataSource)envCtx.lookup("jdbc/jsp_gimal_project");
        return ds.getConnection();
    }
 
    public void insertMember(GuestDataBean member){
        Connection conn = null;
        PreparedStatement pstmt = null;
      
        try {
            conn = getConnection();
            
            pstmt = conn.prepareStatement(
            	"insert into member values (?,?,?,?,?,?)");
            pstmt.setString(1, member.getId());
            pstmt.setString(2,  member.getPasswd());
            pstmt.setString(3, member.getName());
            pstmt.setTimestamp(4, member.getReg_date());
            pstmt.setString(5, member.getAddress());
            pstmt.setString(6, member.getTel());		
            pstmt.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
 
    public int userCheck(String id, String passwd){
		Connection conn = null;
        PreparedStatement pstmt = null;
		ResultSet rs= null;
		int x=-1;
        
	
		try {
            conn = getConnection();
            
      
            
        	
            pstmt = conn.prepareStatement(
            	"select passwd from member where id = ?");
            pstmt.setString(1, id);
            rs= pstmt.executeQuery();

			if(rs.next()){
				String dbpasswd= rs.getString("passwd"); 
				if(passwd.equals(dbpasswd))
					x= 1; 
				else
					x= 0;
			}else
				x= -1;
			
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
		return x;
	}
    
	public int confirmId(String id) {
		Connection conn = null;
        PreparedStatement pstmt = null;
		ResultSet rs= null;
		int x=-1;
        
		try {
            conn = getConnection();
            
            pstmt = conn.prepareStatement(
            	"select id from member where id = ?");
            pstmt.setString(1, id);
            rs= pstmt.executeQuery();

			if(rs.next())
				x= 1; 
			else
				x= -1;
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
		return x;
	}

	public GuestDataBean getMember(String id){
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    GuestDataBean member=null;
	        
	    try {
	        conn = getConnection();
	            
	        pstmt = conn.prepareStatement(
	        	"select * from member where id = ?");
	        pstmt.setString(1, id);
	        rs = pstmt.executeQuery();
	     
	       if (rs.next()) {
	            	member = new GuestDataBean();
	                member.setId(rs.getString("id"));
					member.setName(rs.getString("name"));
	                member.setReg_date(rs.getTimestamp("reg_date"));
	                member.setAddress(rs.getString("address"));
	                member.setTel(rs.getString("tel"));
	       }
	    } catch(Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	        if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	        if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	    }
		return member;
	}
	
    public GuestDataBean getMember(String id, String passwd){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        GuestDataBean member=null;
        
 
        try {
            conn = getConnection();
            
            pstmt = conn.prepareStatement(
            	"select * from member where id = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
     
            if (rs.next()) {
            	String dbpasswd= rs.getString("passwd");
				if(passwd.equals(dbpasswd)){
                  member = new GuestDataBean();
                  member.setId(rs.getString("id"));
				  member.setName(rs.getString("name"));
                  member.setReg_date(rs.getTimestamp("reg_date"));
                  member.setAddress(rs.getString("address"));
                  member.setTel(rs.getString("tel"));
				}
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
		return member;
    }
    
   
    @SuppressWarnings("resource")
	public int updateMember(GuestDataBean member){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        int x=-1;
        

        try {
            conn = getConnection();
            
            String passwd = member.getPasswd();
                  
            pstmt = conn.prepareStatement(
                	"select passwd from member where id = ?");
            pstmt.setString(1, member.getId());
            rs = pstmt.executeQuery();
                
            if(rs.next()){
				String dbpasswd= rs.getString("passwd"); 
				if(passwd.equals(dbpasswd)){
                    pstmt = conn.prepareStatement(
                     "update member set name=?,address=?,tel=? "+
                     "where id=?");
                    pstmt.setString(1, member.getName());
                    pstmt.setString(2, member.getAddress());
                    pstmt.setString(3, member.getTel());
                    pstmt.setString(4, member.getId());
                    pstmt.executeUpdate();
                    x= 1;
				}else
					x= 0;
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
        	if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return x;
    }
    
    
    @SuppressWarnings("resource")
	public int deleteMember(String id, String passwd){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        int x=-1;
        

        try {
			conn = getConnection();
			
        
            pstmt = conn.prepareStatement(
            	"select passwd from member where id = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            
			if(rs.next()){
				String dbpasswd= rs.getString("passwd"); 
				if(passwd.equals(dbpasswd)){
					pstmt = conn.prepareStatement(
            	      "delete from member where id=?");
                    pstmt.setString(1, id);
                    pstmt.executeUpdate();
					x= 1;
				}else
					x= 0;
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
		return x;
    }
}