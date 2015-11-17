package exam3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		String url="";
		String cmd = req.getParameter("command");
		
		if(cmd.equals("REGFORM")){
			url = "/WEB-INF/exam3/regForm.html";
		}
		else if(cmd.equals("REGCONFIRM")){
			// 입력값 확인
			// 아이디 중복과 같은 예외 처리 등
			url = "/WEB-INF/exam3/regConfirm.jsp";
		}
		else if(cmd.equals("REGCOMPLETE")){
			// DB연동(저장)
			url = "/WEB-INF/exam3/regComplete.jsp";
		}
		else if(cmd.equals("MAIN")){
			url = "/index.html";
		}
		else{
			// 정상적인 요청이 아니라는 메시지를 출력할수있게 처리
		}
		
		RequestDispatcher view = req.getRequestDispatcher(url);
		view.forward(req, resp);
		*/
		
		/*
		// Command패턴을 이용한 방식
		String url="";
		String cmd = req.getParameter("command");
		Command command = null;
		
		if(cmd.equals("REGFORM")){
			command = new RegFormCommand();
		}
		else if(cmd.equals("REGCONFIRM")){
			command = new RegConfirmCommand();
		}
		else if(cmd.equals("REGCOMPLETE")){
			command = new RegCompleteCommand();
		}
		else if(cmd.equals("MAIN")){
			command = new MainCommand();
		}
		else{
			// 정상적인 요청이 아니라는 메시지를 출력할수있게 처리
		}
		
		url = (String)command.processCommand(req, resp);
		RequestDispatcher view = req.getRequestDispatcher(url);
		view.forward(req, resp);
		*/
		
		// Factory패턴을 이용한 방식
		req.setCharacterEncoding("euc-kr");
		
		String url="";
		String cmd = req.getParameter("command");
		CommandFactory factory = CommandFactory.newInstance();
		Command command = factory.createCommand(cmd);
		HttpSession session = req.getSession();
		String state = (String)session.getAttribute("current_state");
		
		if(state != null && state.equals("REGCOMPLETE")){
			url = "/WEB-INF/exam3/alreadyRegister.jsp";
		}
		else{
			url = (String)command.processCommand(req, resp);
		}
		
		RequestDispatcher view = req.getRequestDispatcher(url);
		view.forward(req, resp);
	}
}
