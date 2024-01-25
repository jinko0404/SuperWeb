package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		
		Member member = new Member(memberId, memberPw);
		MemberService mService = new MemberService();
		Member mOne = mService.selectLoginCheck(member);
		out.println("응답페이지 : " + memberId + ", " + memberPw);
		if(mOne != null) {
//			RequestDispatcher view
//			= request.getRequestDispatcher("WEB-INF/views/common/serviceSuccess.jsp");
//			view.forward(request, response);
			HttpSession session = request.getSession();
			session.setAttribute("memberId", mOne.getMemberId());
			session.setAttribute("memberName", mOne.getMemberName());
			response.sendRedirect("/myPage.do?memberId=" + memberId);
			
		}
		else {
			RequestDispatcher view
			= request.getRequestDispatcher("WEB-INF/views/common/serviceFailed.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
