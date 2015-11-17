package exam3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegConfirmCommand implements Command {
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 입력값 확인
		// 아이디 중복(DB연동)과 같은 예외 처리 등
		return "/WEB-INF/exam3/regConfirm.jsp";
	}
}
