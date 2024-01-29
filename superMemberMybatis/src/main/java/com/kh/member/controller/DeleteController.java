package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;

@WebServlet("/member/delete.do")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		MemberService mService = new MemberService();
		int result = mService.deleteMember(memberId);
		
		if(result > 0) {
			response.sendRedirect("/member/logout.do");
		}
		else {
			request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp")
			.forward(request, response);
		}
	}

}
