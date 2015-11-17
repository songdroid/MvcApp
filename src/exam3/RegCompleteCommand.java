package exam3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegCompleteCommand implements Command {
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// DB연동(저장)
		HttpSession session = req.getSession();
		session.setAttribute("current_state", "REGCOMPLETE");
		return "/WEB-INF/exam3/regComplete.jsp";
	}
}
