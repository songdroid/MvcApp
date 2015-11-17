package exam1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getParameter("param");
		String url = null;
		ArrayList list = new ArrayList();
		
		if(param.equals("DEPART")){
			url = "/WEB-INF/exam1/department.html";
		}
		else{
			url = "/WEB-INF/exam1/result.jsp";
			String choice = req.getParameter("depart");
			list = new DepartBean().getAdvice(choice);
			req.setAttribute("result", list);
		}
		
		RequestDispatcher view = req.getRequestDispatcher(url);
		view.forward(req, resp);
	}
}



















