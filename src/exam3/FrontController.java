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
			// �Է°� Ȯ��
			// ���̵� �ߺ��� ���� ���� ó�� ��
			url = "/WEB-INF/exam3/regConfirm.jsp";
		}
		else if(cmd.equals("REGCOMPLETE")){
			// DB����(����)
			url = "/WEB-INF/exam3/regComplete.jsp";
		}
		else if(cmd.equals("MAIN")){
			url = "/index.html";
		}
		else{
			// �������� ��û�� �ƴ϶�� �޽����� ����Ҽ��ְ� ó��
		}
		
		RequestDispatcher view = req.getRequestDispatcher(url);
		view.forward(req, resp);
		*/
		
		/*
		// Command������ �̿��� ���
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
			// �������� ��û�� �ƴ϶�� �޽����� ����Ҽ��ְ� ó��
		}
		
		url = (String)command.processCommand(req, resp);
		RequestDispatcher view = req.getRequestDispatcher(url);
		view.forward(req, resp);
		*/
		
		// Factory������ �̿��� ���
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
