package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

@WebServlet("/member/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//URL로 회원가입 페이지 이동시 사용, WEB-INF 폴더 내 자원들은 직접접근이 불가능하다.
		//RequestDispatcher 객체를 이용해서 페이지 이동을 할 수 있다.
		//변수없이 RequestDispatcher 객체를 이용해서 페이지 이동을 해보면 다음과 같다.
		//메소드 채이닝 방식으로 forward를 호출해야 이동이 되며, 경로상 오타를 조심해야 한다.
		request.getRequestDispatcher("/WEB-INF/views/member/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		/*
		 * 회원가입은 페이지에서 입력받은 값을 서버로 전달받아 Mybatis를 이용해 수행
		 * 입력받은 값을 서버에서는 객체 저장하도록 처리한다.(Member VO 클래스가 완성되어야한다.)
		 * 만들어진 쿼리 스트링을 request객체의 getParameter()메소드를 이용해 가져온다.
		 * getParameter()메소드의 전달받은 값은 register.jsp의 input태그 name의 속성값
		 * 오타 주의!
		 * 9개의 변수에 저장한 값은 하나의 변수로 다루기 위해 매개변수 있는 생성자로 Member 인스턴스 생성
		 * int형과 char형이 있기 때문에 자료형에 맞게 자료형을 변환해준다.
		 */
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		String memberName = request.getParameter("member-name");
		int age = Integer.parseInt(request.getParameter("age"));
		char gender = request.getParameter("gender").charAt(0);
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String hobby = request.getParameter("hobby");
		
		Member member = new Member(memberId, memberPw, memberName, gender, age, email, phone, address, hobby);
		MemberService mService = new MemberService();
		int result = mService.insertMember(member);
		if(result > 0) {
			response.sendRedirect("/");
		}
		else {
			request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp")
			.forward(request, response);
		}
	}

}
