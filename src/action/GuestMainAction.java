package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuestMainAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		//κ΄?λ¦¬μλ₯? κ΅¬λΆ?  ? ?¬?©
		request.setAttribute("type", new Integer(0));
		return "/guest/guestMain.jsp";//??΅??΄μ§?
	}
}