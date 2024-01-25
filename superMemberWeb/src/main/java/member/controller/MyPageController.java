package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/myPage.do")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		MemberService mService = new MemberService();
		//SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = memberId;
		//-> 쿼리스트링 필요
		//http://localhost:8887/member/myPage.do?memberId=memberId
		@SuppressWarnings("unused")
		HttpSession session = request.getSession();
		String memberId = request.getParameter("memberId");
		Member member = mService.selectOneById(memberId);
		System.out.println(member.getGender());
		request.setAttribute("member", member);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/member/myPage.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		doGet(request, response);
	}

}
