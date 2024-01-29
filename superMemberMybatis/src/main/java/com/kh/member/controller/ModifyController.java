package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

@WebServlet("/member/Modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModifyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		//세션에서 memberId 가져온다.
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		MemberService mService = new MemberService();
		if(memberId != null) {
			Member member = mService.selectOneById(memberId);
			if(member != null)
			{
				request.setAttribute("member", member);
				request.getRequestDispatcher("/WEB-INF/views/member/modify.jsp")
				.forward(request, response);				
			}
			else {
				request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp")
				.forward(request, response);
			}
		}else {
			request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp")
			.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");  // 요청의 문자 인코딩 설정
	    response.setContentType("text/html; charset=UTF-8");
		doGet(request, response);
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		String email 	= request.getParameter("email");
		String phone 	= request.getParameter("phone");
		String address 	= request.getParameter("address");
		String hobby 	= request.getParameter("hobby");
		Member member = new Member(memberId, memberPw, email, phone, address, hobby);
		MemberService mService = new MemberService();
		int result = mService.modifyMember(member);
		if(result > 0) {
			response.sendRedirect("http://localhost:9999/member/mypage.do?memberId=" + memberId);
		}
		else {
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/serviceFailed.jsp");
			view.forward(request, response);
	}

	}
}
