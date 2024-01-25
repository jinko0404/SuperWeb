package member.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModifyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet = 수정할 정보를 출력하는 용도
		MemberService mService = new MemberService();
		String memberId = request.getParameter("memberId");
		System.out.println(memberId);
		Member member = mService.selectOneById(memberId);
		if(member != null) {
			request.setAttribute("member", member);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/modify.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수정된 정보를 UPDATE하는 용도
		//UPDATE MEMBER_TBL SET MEMBER_PWD=?,EMAIL=?,PHONE=?,ADDRESS=?
		//,HOBBY = ? WHERE MEMBER_ID=?
		request.setCharacterEncoding("UTF-8");
		
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		String email 	= request.getParameter("email");
		String phone 	= request.getParameter("phone");
		String address 	= request.getParameter("address");
		String hobby 	= request.getParameter("hobby");
		Member member = new Member(memberId, memberPw, email, phone, address, hobby);
		MemberService mService = new MemberService();
		int result = mService.updateMember(member);
		if(result > 0) {
			response.sendRedirect("http://localhost:8887/myPage.do?memberId=" + memberId);
		}
		else {
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/serviceFailed.jsp");
			view.forward(request, response);
		}
	}

}
