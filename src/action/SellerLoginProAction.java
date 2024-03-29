package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SellerDBBean;

public class SellerLoginProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");//한글 인코딩
        
        //넘어온 요청의 데이터를 얻어냄
        String id = request.getParameter("sid");
	    String passwd  = request.getParameter("spw");
	    System.out.println(id+"/"+passwd);

	    //DB와 연동해서 사용자의 인증을 처리
	    SellerDBBean dbPro = SellerDBBean.getInstance();
        int check = dbPro.userCheck(id,passwd);

        //해당 뷰(응답페이지)로 보낼 내용을 request속성에 지정
		request.setAttribute("check", new Integer(check));
		request.setAttribute("sid", id);
		
		return "/seller/logon/sLoginPro.jsp";
	}
}