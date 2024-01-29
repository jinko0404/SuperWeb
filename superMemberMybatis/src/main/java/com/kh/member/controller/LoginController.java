package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

@WebServlet("/member/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		Member member = new Member(memberId, memberPw);
		MemberService mService = new MemberService();
		member = mService.selectCheckLogin(member);
		if(member != null) {
			//세션에 정보 저장 후
			HttpSession session = request.getSession();
			session.setAttribute("memberId", member.getMemberId());
			session.setAttribute("memberName", member.getMemberName());
			response.sendRedirect("/");
		}
		else {
			request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp")
			.forward(request, response);
		}
	}

}
