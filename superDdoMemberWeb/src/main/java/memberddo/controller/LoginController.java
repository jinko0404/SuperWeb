package memberddo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import memberddo.model.service.MemberDdoService;
import memberddo.model.vo.MemberDdo;

@WebServlet("/memberDdo/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		@SuppressWarnings("unused")
		PrintWriter out = response.getWriter();
		
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		MemberDdo member = new MemberDdo(memberId, memberPw);
		MemberDdoService mdService = new MemberDdoService();
		MemberDdo mdDao = null;
		try {
			mdDao = mdService.selectLoginCheck(member);
			if(mdDao != null) {
				//성공
				RequestDispatcher view
				= request.getRequestDispatcher("/WEB-INF/views/common/serviceSuccess.jsp");
				HttpSession session = request.getSession();
				session.setAttribute("memberId", mdDao.getMemberId());
				session.setAttribute("memberName", mdDao.getMemberName());
				view.forward(request, response);
			}
			else {
				//실패
				RequestDispatcher view
				= request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp");
				view.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
