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
		// �Է°� Ȯ��
		// ���̵� �ߺ�(DB����)�� ���� ���� ó�� ��
		return "/WEB-INF/exam3/regConfirm.jsp";
	}
}
