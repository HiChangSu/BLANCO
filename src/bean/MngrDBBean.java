package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MngrDBBean {
	//MngrDBBean ? ?­ κ°μ²΄ ??± <- ?κ°μ κ°μ²΄λ§? ??±?΄? κ³΅μ 
    private static MngrDBBean instance = new MngrDBBean();
    
    //MngrDBBeanκ°μ²΄λ₯? λ¦¬ν΄?? λ©μ?
    public static MngrDBBean getInstance() {
        return instance;
    }
    
    private MngrDBBean() {}
    
    //μ»€λ₯? ???? μ»€λ₯? κ°μ²΄λ₯? ?»?΄?΄? λ©μ?
    private Connection getConnection() throws Exception {
        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        DataSource ds = (DataSource)envCtx.lookup("jdbc/shoppingmall");
        return ds.getConnection();
    }
    
    //κ΄?λ¦¬μ ?Έμ¦? λ©μ?
    public int userCheck(String id, String passwd){
		Connection conn = null;
        PreparedStatement pstmt = null;
		ResultSet rs= null;
		int x=-1;
        

		try {
            conn = getConnection();
            
      
        	
            pstmt = conn.prepareStatement(
              "select managerPasswd from manager where managerId = ?");
            pstmt.setString(1, id);
            rs= pstmt.executeQuery();

			if(rs.next()){//?΄?Ή ??΄?κ°? ??Όλ©? ??
				String dbpasswd= rs.getString("managerPasswd"); 
				if(passwd.equals(dbpasswd))
					x= 1; //?Έμ¦μ±κ³?
				else
					x= 0; //λΉλ?λ²νΈ ??λ¦?
			}else//?΄?Ή ??΄? ??Όλ©? ??
				x= -1;//??΄? ??
			
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
		return x;
	}
    
    //?? ?±λ‘? λ©μ?
    public void insertPrd(MngrDataBean prd) 
    throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = getConnection();
            String sql = "insert into prd(prd_kind,prd_name,prd_price,";
            sql += "prd_count,prd_image,";
            sql += "prd_content,reg_date, end_time) values (?,?,?,?,?,?,?,?)";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, prd.getPrd_kind());
            pstmt.setString(2, prd.getPrd_name());
            pstmt.setInt(3, prd.getPrd_price());
            pstmt.setShort(4, prd.getPrd_count());
			pstmt.setString(5, prd.getPrd_image());
			pstmt.setString(6, prd.getPrd_content());
			pstmt.setTimestamp(7, prd.getReg_date());
			pstmt.setTimestamp(8, prd.getEnd_time());
			
            pstmt.executeUpdate();
            
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) 
            	try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) 
            	try { conn.close(); } catch(SQLException ex) {}
        }
    }
    
    //?΄λ―Έλ±λ‘λ ??? κ²?μ¦?
	public int registedPrdconfirm(
			String kind, String prdName) 
	throws Exception {
		Connection conn = null;
        PreparedStatement pstmt = null;
		ResultSet rs= null;
		int x=-1;
        
		try {
            conn = getConnection();
            
            String sql = "select prd_name from prd ";
            sql += " where prd_kind = ? and prd_name = ?";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, kind);
            pstmt.setString(2, prdName);
            
            rs= pstmt.executeQuery();

			if(rs.next())
				x= 1; //?΄?Ή ???΄ ?΄λ―? ?±λ‘λ?΄ ??
			else
				x= -1;//?΄?Ή ???΄ ?΄λ―? ?±λ‘λ?΄ ?μ§? ??	
			
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
			if (rs != null) 
				try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) 
            	try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) 
            	try { conn.close(); } catch(SQLException ex) {}
        }
		return x;
	}
    
	// ? μ²΄λ±λ‘λ ??? ?λ₯? ?»?΄?΄? λ©μ?
	public int getPrdCount()
    throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        int x=0;

        try {
            conn = getConnection();
            
            pstmt = conn.prepareStatement("select count(*) from prd");
            rs = pstmt.executeQuery();

            if (rs.next()) 
               x= rs.getInt(1);
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) 
            	try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) 
            	try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) 
            	try { conn.close(); } catch(SQLException ex) {}
        }
		return x;
    }
	
	// ?΄?Ή λΆλ₯? ??? ?λ₯? ?»?΄?΄? λ©μ?
	public int getPrdCount(String prd_kind)
	throws Exception {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    int x=0;
	    int kind  = Integer.parseInt(prd_kind);

	    try {
	        conn = getConnection();
	        String query = "select count(*) from prd where prd_kind=" + kind;
	        pstmt = conn.prepareStatement(query);
	        rs = pstmt.executeQuery();

	        if (rs.next()) 
	            x= rs.getInt(1);
	    } catch(Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        if (rs != null) 
	           try { rs.close(); } catch(SQLException ex) {}
	        if (pstmt != null) 
	           try { pstmt.close(); } catch(SQLException ex) {}
	        if (conn != null) 
	           try { conn.close(); } catch(SQLException ex) {}
	    }
		return x;
	}
	
	//??? ? λͺ©μ ?»?΄?
	public String getPrdName(int prd_id){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String x="";

        try {
            conn = getConnection();
            
            pstmt = conn.prepareStatement("select prd_name from prd where prd_id = "+prd_id);
            rs = pstmt.executeQuery();

            if (rs.next()) 
               x= rs.getString(1);
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try{ rs.close(); }catch(SQLException ex) {}
            if (pstmt != null) try{ pstmt.close(); }catch(SQLException ex) {}
            if (conn != null) try{ conn.close(); }catch(SQLException ex) {}
        }
		return x;
    }
	// λΆλ₯λ³λ? ? μ²΄λ±λ‘λ ??? ? λ³΄λ?? ?»?΄?΄? λ©μ?
	public List<MngrDataBean> getPrds(String prd_kind)
    throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<MngrDataBean> prdList=null;
        
        try {
            conn = getConnection();
            
            String sql1 = "select * from prd";
            String sql2 = "select * from prd ";
            sql2 += "where prd_kind = ? order by reg_date desc";
            
            if(prd_kind.equals("all")||prd_kind.equals("")){
            	 pstmt = conn.prepareStatement(sql1);
            }else{
                pstmt = conn.prepareStatement(sql2);
                pstmt.setString(1, prd_kind);
            }
        	rs = pstmt.executeQuery();
            
            if (rs.next()) {
                prdList = new ArrayList<MngrDataBean>();
                do{
                	MngrDataBean prd= new MngrDataBean();
                     
                     prd.setPrd_id(rs.getInt("prd_id"));
                     prd.setPrd_kind(rs.getString("prd_kind"));
                     prd.setPrd_name(rs.getString("prd_name"));
                     prd.setPrd_price(rs.getInt("prd_price"));
                     prd.setPrd_count(rs.getShort("prd_count"));
                     prd.setPrd_image(rs.getString("prd_image"));
                     prd.setReg_date(rs.getTimestamp("reg_date"));
                     prd.setEnd_time(rs.getTimestamp("end_time"));
                     
                     prdList.add(prd);
			    }while(rs.next());
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) 
            	try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) 
            	try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) 
            	try { conn.close(); } catch(SQLException ex) {}
        }
		return prdList;
    }
	
	// ?Ό?λͺ? λ©μΈ? ???κΈ? ??΄? ?¬?©?? λΆλ₯λ³? ? κ°μ?λͺ©λ‘? ?»?΄?΄? λ©μ?
	public MngrDataBean[] getPrds(String prd_kind,int count)
    throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        MngrDataBean prdList[]=null;
        int i=0;
        
        try {
            conn = getConnection();
            
            String sql = "select * from prd where prd_kind = ? ";
            sql += "order by reg_date desc limit ?,?";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, prd_kind);
            pstmt.setInt(2, 0);
            pstmt.setInt(3, count);
        	rs = pstmt.executeQuery();

            if (rs.next()) {
                prdList = new MngrDataBean[count];
                do{
                	MngrDataBean prd= new MngrDataBean();
                    prd.setPrd_id(rs.getInt("prd_id"));
                    prd.setPrd_kind(rs.getString("prd_kind"));
                    prd.setPrd_name(rs.getString("prd_name"));
                    prd.setPrd_price(rs.getInt("prd_price"));
                    prd.setPrd_count(rs.getShort("prd_count"));
                    prd.setPrd_image(rs.getString("prd_image"));
                    prd.setReg_date(rs.getTimestamp("reg_date"));
                    prd.setEnd_time(rs.getTimestamp("end_time"));
                     
                    prdList[i]=prd;
                     
                    i++;
			    }while(rs.next());
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) 
            	try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) 
            	try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) 
            	try { conn.close(); } catch(SQLException ex) {}
        }
		return prdList;
    }
	
	// prdId? ?΄?Ή?? ??? ? λ³΄λ?? ?»?΄?΄? λ©μ?λ‘? 
    //?±λ‘λ ??? ?? ?κΈ? ??΄ ?? ?Ό?Όλ‘? ?½?΄?€κΈ°μ΄κΈ? ?? λ©μ?
	public MngrDataBean getPrd(int prdId)
    throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        MngrDataBean prd=null;
        
        try {
            conn = getConnection();
            
            pstmt = conn.prepareStatement(
            	"select * from prd where prd_id = ?");
            pstmt.setInt(1, prdId);
            
            rs = pstmt.executeQuery();

            if (rs.next()) {
                prd = new MngrDataBean();
                
                prd.setPrd_kind(rs.getString("prd_kind"));
                prd.setPrd_name(rs.getString("prd_name"));
                prd.setPrd_price(rs.getInt("prd_price"));
                prd.setPrd_count(rs.getShort("prd_count"));
                prd.setPrd_image(rs.getString("prd_image"));
                prd.setPrd_content(rs.getString("prd_content"));
                prd.setEnd_time(rs.getTimestamp("end_time"));
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) 
            	try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) 
            	try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) 
            	try { conn.close(); } catch(SQLException ex) {}
        }
		return prd;
    }
    
    // ?±λ‘λ ??? ? λ³΄λ?? ?? ? ?¬?©?? λ©μ?
    public void updatePrd(MngrDataBean prd, int prdId)
    throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql;
        
        try {
            conn = getConnection();
            
            sql = "update prd set prd_kind=?,prd_name=?,prd_price=?";
            sql += ",prd_count=?,author=?,publishing_com=?,publishing_date=?";
            sql += ",prd_image=?,prd_content=?,discount_rate=?";
            sql += " where prd_id=?";
            
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, prd.getPrd_kind());
            pstmt.setString(2, prd.getPrd_name());
            pstmt.setInt(3, prd.getPrd_price());
            pstmt.setShort(4, prd.getPrd_count());
			pstmt.setString(5, prd.getPrd_image());
			pstmt.setString(6, prd.getPrd_content());
			pstmt.setInt(7, prdId);
            
            pstmt.executeUpdate();
            
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) 
            	try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) 
            	try { conn.close(); } catch(SQLException ex) {}
        }
    }
    
    // prdId? ?΄?Ή?? ??? ? λ³΄λ?? ?­? ? ?¬?©?? λ©μ?
    public void deletePrd(int prdId)
    throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        
        try {
			conn = getConnection();

            pstmt = conn.prepareStatement(
            	"delete from prd where prd_id=?");
            pstmt.setInt(1, prdId);
            
            pstmt.executeUpdate();
            
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) 
            	try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) 
            	try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) 
            	try { conn.close(); } catch(SQLException ex) {}
        }
    }
}