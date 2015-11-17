package exam3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbcp.DBConnectionMgr;
import dbcp.ZipDto;

public class ZipCommand implements Command {
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");
		
		String dong = req.getParameter("dong");		
		Vector vAddr = new Vector();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnectionMgr pool = null;
		
		try{
			pool = DBConnectionMgr.getInstance();
			con = pool.getConnection();
			String sql = "select * from tblzip where dong like '%" + dong + "%'";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				ZipDto dto = new ZipDto();
				dto.setBunji(rs.getString("bunji"));
				dto.setDong(rs.getString("dong"));
				dto.setGugun(rs.getString("gugun"));
				dto.setSido(rs.getString("sido"));
				dto.setZipcode(rs.getString("zipcode"));
				
				vAddr.add(dto);
			}
		}
		catch(Exception err){
			err.printStackTrace();
		}
		finally{
			pool.freeConnection(con, pstmt, rs);
		}
		
		req.setAttribute("addr", vAddr);
		return "/zip/zipSearch.jsp";
	}
}




