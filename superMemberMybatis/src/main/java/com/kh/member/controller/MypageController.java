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

@WebServlet("/member/mypage.do")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MypageController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();//세션 인스턴스 생성
		String memberId = (String) session.getAttribute("memberId");//세션에서 아이디 가져오기
		//getAttribute() 메소드는 object형을 리턴하고 있으므로 강제 형변환이 필요하다.
		MemberService mService = new MemberService();
		Member member = mService.selectOneById(memberId);
		if(member != null) {
			request.setAttribute("member", member);
			request.getRequestDispatcher("/WEB-INF/views/member/myPage.jsp")
			.forward(request, response);
		}
		else {
			request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp")
			.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
