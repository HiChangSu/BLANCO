package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.GuestDBBean;

public class GuestLoginProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String passwd  = request.getParameter("passwd");

		GuestDBBean manager = GuestDBBean.getInstance();
		int check= manager.userCheck(id,passwd);
		
		request.setAttribute("id", id);
		request.setAttribute("check", new Integer(check));
		return "/guest/logon/gLoginPro.jsp";
	}
}