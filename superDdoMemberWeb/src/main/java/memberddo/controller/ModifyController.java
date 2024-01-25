package memberddo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberddo.model.service.MemberDdoService;
import memberddo.model.vo.MemberDdo;

@WebServlet("/memberDdo/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModifyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDdoService mdService = new MemberDdoService();
		String memberId = request.getParameter("memberId");
		MemberDdo member = mdService.selectOneById(memberId);
		if(member != null) {
			request.setAttribute("member", member);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/modify.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		String email 	= request.getParameter("email");
		String phone 	= request.getParameter("phone");
		String address 	= request.getParameter("address");
		String hobby 	= request.getParameter("hobby");
		MemberDdo member = new MemberDdo(memberId, memberPw, email, phone, address, hobby);
		MemberDdoService mdService = new MemberDdoService();
		int result = mdService.updateMemberDdo(member);
		if(result > 0) {
			response.sendRedirect("http://localhost:9998/memberDdo/Mypage.do?memberId=" + memberId);
		}
		else {
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/serviceFailed.jsp");
			view.forward(request, response);
		}
	}

}
