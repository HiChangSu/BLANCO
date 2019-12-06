package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SellerMainAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		//관리자를 구분할 때 사용
		request.setAttribute("type", new Integer(0));
		return "/seller/sellerMain.jsp";//응답페이지
	}
}