package exam2;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FrontController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");
		
		HttpSession session = req.getSession();
		String param = req.getParameter("param");
		String url = null;
		Vector bookList = (Vector)session.getAttribute("bookList");
		
		if(param.equals("CHKOUT")){
			url="/WEB-INF/exam2/checkout.jsp";
			int sum = 0;
			for(int i=0; i<bookList.size(); i++){
				BookDto dto = (BookDto)bookList.get(i);
				sum += dto.getPrice() * dto.getQuantity();
			}
			session.setAttribute("sum", sum);
		}
		else{
			url = "/WEB-INF/exam2/bookShop.jsp";
			
			if(param.equals("CART")){
				if(bookList == null){
					bookList = new Vector();
				}
				
				bookList.add(getBook(req));
			}
			else if(param.equals("DEL")){
				int idx = Integer.parseInt(req.getParameter("idx"));
				bookList.remove(idx);
			}
		}
		
		session.setAttribute("bookList", bookList);
		RequestDispatcher view = req.getRequestDispatcher(url);
		view.forward(req, resp);
	}
	
	public BookDto getBook(HttpServletRequest req){
		String book = req.getParameter("book");
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		StringTokenizer token = new StringTokenizer(book, "/");
		
		String title = token.nextToken().trim();
		String author = token.nextToken().trim();
		String price = token.nextToken().trim();
		
		BookDto dto = new BookDto();
		dto.setAuthor(author);
		dto.setPrice(Integer.parseInt(price));
		dto.setQuantity(quantity);
		dto.setTitle(title);
		
		return dto;
	}
}
