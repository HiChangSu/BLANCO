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

import work.crypt.BCrypt;
import work.crypt.SHA256;

public class SellerDBBean {
	//MngrDBBean 전역 객체 생성 <- 한개의 객체만 생성해서 공유
    private static SellerDBBean instance = new SellerDBBean();
    
    //MngrDBBean객체를 리턴하는 메소드
    public static SellerDBBean getInstance() {
        return instance;
    }
    
    private SellerDBBean() {}
    
    //커넥션 풀에서 커넥션 객체를 얻어내는 메소드
    private Connection getConnection() throws Exception {
        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        DataSource ds = (DataSource)envCtx.lookup("jdbc/jsptest");
        return ds.getConnection();
    }
    
    //관리자 인증 메소드
    public int userCheck(String id, String passwd){
		Connection conn = null;
        PreparedStatement pstmt = null;
		ResultSet rs= null;
		int x=-1;
        
//		SHA256 sha = SHA256.getInsatnce();
		try {
            conn = getConnection();
            
//            String orgPass = passwd;
//            String shaPass = sha.getSha256(orgPass.getBytes());
        	
            pstmt = conn.prepareStatement(
              "select s_pw from seller where s_id = ?");
            pstmt.setString(1, id);
            rs= pstmt.executeQuery();

			if(rs.next()){//해당 아이디가 있으면 수행
				String dbpasswd= rs.getString("s_pw"); 
				if(dbpasswd.equals(passwd))
					x= 1; //인증성공
				else
					x= 0; //비밀번호 틀림
			}else//해당 아이디 없으면 수행
				x= -1;//아이디 없음
			
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
		return x;
	}
    
    //책 등록 메소드
    public void insertItem(SellerDataBean item) 
    throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = getConnection();
            String sql = "insert into item(it_num,it_name,it_amount,it_company,it_deadline,it_cost)";
            sql += "values (?,?,?,?,?,?,?,?,?,?,?)";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, item.getIt_num());
            pstmt.setString(2, item.getIt_name());
            pstmt.setInt(3, item.getIt_amount());
            pstmt.setString(4, item.getIt_company());
            pstmt.setTimestamp(5, item.getIt_deadline());            
            pstmt.setInt(6, item.getIt_cost());
            
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
    
//    //이미등록된 책을 검증
//	public int registedBookconfirm(
//			String kind, String bookName, String author) 
//	throws Exception {
//		Connection conn = null;
//        PreparedStatement pstmt = null;
//		ResultSet rs= null;
//		int x=-1;
//        
//		try {
//            conn = getConnection();
//            
//            String sql = "select book_name from book ";
//            sql += " where book_kind = ? and book_name = ? and author = ?";
//            
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, kind);
//            pstmt.setString(2, bookName);
//            pstmt.setString(3, author);
//            
//            rs= pstmt.executeQuery();
//
//			if(rs.next())
//				x= 1; //해당 책이 이미 등록되어 있음
//			else
//				x= -1;//해당 책이 이미 등록되어 있지 않음	
//			
//        } catch(Exception ex) {
//            ex.printStackTrace();
//        } finally {
//			if (rs != null) 
//				try { rs.close(); } catch(SQLException ex) {}
//            if (pstmt != null) 
//            	try { pstmt.close(); } catch(SQLException ex) {}
//            if (conn != null) 
//            	try { conn.close(); } catch(SQLException ex) {}
//        }
//		return x;
//	}
    
	// 전체등록된 책의 수를 얻어내는 메소드
	public int getItemCount()
    throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        int x=0;

        try {
            conn = getConnection();
            
            pstmt = conn.prepareStatement("select count(*) from item");
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
	
	// 해당 분류의 책의 수를 얻어내는 메소드
	public int getItemCount(String store_category)
	throws Exception {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    int x=0;

	    try {
	        conn = getConnection();
	        String query = "select count(*) from store where store_category=" + store_category;
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
	
	//책의 제목을 얻어냄
	public String getItemName(String item_num){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String x="";

        try {
            conn = getConnection();
            
            pstmt = conn.prepareStatement("select item_name from item where item_num= "+item_num);
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
//	// 분류별또는 전체등록된 책의 정보를 얻어내는 메소드
//	public List<MngrDataBean> getBooks(String book_kind)
//    throws Exception {
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        List<MngrDataBean> bookList=null;
//        
//        try {
//            conn = getConnection();
//            
//            String sql1 = "select * from book";
//            String sql2 = "select * from book ";
//            sql2 += "where book_kind = ? order by reg_date desc";
//            
//            if(book_kind.equals("all")||book_kind.equals("")){
//            	 pstmt = conn.prepareStatement(sql1);
//            }else{
//                pstmt = conn.prepareStatement(sql2);
//                pstmt.setString(1, book_kind);
//            }
//        	rs = pstmt.executeQuery();
//            
//            if (rs.next()) {
//                bookList = new ArrayList<MngrDataBean>();
//                do{
//                	MngrDataBean book= new MngrDataBean();
//                     
//                     book.setBook_id(rs.getInt("book_id"));
//                     book.setBook_kind(rs.getString("book_kind"));
//                     book.setBook_title(rs.getString("book_title"));
//                     book.setBook_price(rs.getInt("book_price"));
//                     book.setBook_count(rs.getShort("book_count"));
//                     book.setAuthor(rs.getString("author"));
//                     book.setPublishing_com(rs.getString("publishing_com"));
//                     book.setPublishing_date(rs.getString("publishing_date"));
//                     book.setBook_image(rs.getString("book_image"));
//                     book.setDiscount_rate(rs.getByte("discount_rate"));
//                     book.setReg_date(rs.getTimestamp("reg_date"));
//                     
//                     bookList.add(book);
//			    }while(rs.next());
//			}
//        } catch(Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            if (rs != null) 
//            	try { rs.close(); } catch(SQLException ex) {}
//            if (pstmt != null) 
//            	try { pstmt.close(); } catch(SQLException ex) {}
//            if (conn != null) 
//            	try { conn.close(); } catch(SQLException ex) {}
//        }
//		return bookList;
//    }
	
	// 쇼핑몰 메인에 표시하기 위해서 사용하는 물품 목록을 얻어내는 메소드
	public SellerDataBean[] getItem(String it_num,int count)
    throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        SellerDataBean itemList[]=null;
        int i=0;
        
        try {
            conn = getConnection();
            
            String sql = "select * from item where it_num = ? ";
            sql += "order by it_deadline desc limit ?,?";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, it_num);
            pstmt.setInt(2, 0);
            pstmt.setInt(3, count);
        	rs = pstmt.executeQuery();

            if (rs.next()) {
                itemList = new SellerDataBean[count];
                do{
                	SellerDataBean item= new SellerDataBean();
                    item.setIt_num(rs.getString("it_num"));
                    item.setIt_name(rs.getString("it_name"));
                    item.setIt_amount(rs.getInt("it_amount"));
                    item.setIt_company(rs.getString("it_company"));
                    item.setIt_deadline(rs.getTimestamp("it_deadline"));
                    item.setIt_cost(rs.getInt("it_cost"));
                     
                    itemList[i]=item;
                     
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
		return itemList;
    }
	
	// 물품 넘버에 해당하는 책의 정보를 얻어내는 메소드로 
    //등록된 아이템을 수정하기 위해 수정폼으로 읽어들기이기 위한 메소드
	public SellerDataBean getItem(String it_num)
    throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        SellerDataBean item=null;
        
        try {
            conn = getConnection();
            
            pstmt = conn.prepareStatement(
            	"select * from item where it_num = ?");
            pstmt.setString(1, it_num);
            
            rs = pstmt.executeQuery();

            if (rs.next()) {
                item = new SellerDataBean();
                
                item.setIt_num(rs.getString("it_num"));
                item.setIt_name(rs.getString("it_name"));
                item.setIt_amount(rs.getInt("it_amount"));
                item.setIt_company(rs.getString("it_company"));
                item.setIt_deadline(rs.getTimestamp("it_deadline"));
                item.setIt_cost(rs.getInt("it_cost"));
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
		return item;
    }
    
    // 등록된 물품 정보를 수정시 사용하는 메소드
    public void updateBook(SellerDataBean item, String it_num)
    throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql;
        
        try {
            conn = getConnection();
            
            sql = "update item set it_name = ?,it_amount = ?,it_company = ?,it_deadline = ?,it_cost = ?";
            sql += " where it_num= ?";
            
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, item.getIt_name());
            pstmt.setInt(2, item.getIt_amount());
            pstmt.setString(3, item.getIt_company());
            pstmt.setTimestamp(4, item.getIt_deadline());
            pstmt.setInt(5, item.getIt_cost());
            pstmt.setString(6, it_num);
			
            
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
    
    // bookId에 해당하는 책의 정보를 삭제시 사용하는 메소드
    public void deleteItem(String it_num)
    throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        
        try {
			conn = getConnection();

            pstmt = conn.prepareStatement(
            	"delete from item where it_num=?");
            pstmt.setString(1, it_num);
            
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