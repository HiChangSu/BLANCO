package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainAction {
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		return "home.jsp";
	}
}
