package memberddo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import memberddo.model.service.MemberDdoService;
import memberddo.model.vo.MemberDdo;


@WebServlet("/memberDdo/Mypage.do")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MypageController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		MemberDdoService mdService = new MemberDdoService();
		@SuppressWarnings("unused")
		HttpSession session = request.getSession();
		String memberId = request.getParameter("memberId");
		MemberDdo member;
		member = mdService.selectOneById(memberId);
		request.setAttribute("member", member);
		if(member != null) {
			RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/views/member/myPage.jsp");
			view.forward(request, response);				
		}
		else {
			RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
