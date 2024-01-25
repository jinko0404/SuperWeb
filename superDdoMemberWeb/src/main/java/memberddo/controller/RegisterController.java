package memberddo.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberddo.model.service.MemberDdoService;
import memberddo.model.vo.MemberDdo;

@WebServlet("/memberDdo/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/enroll.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		
		try {
			String memberId = request.getParameter("member-id");
			String memberPw = request.getParameter("member-pw");
			String memberName = request.getParameter("member-name");
			int age = Integer.parseInt(request.getParameter("age"));
			char gender = request.getParameter("gender").charAt(0);
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String hobby = request.getParameter("hobby");
			
			MemberDdo mDdo = new MemberDdo(memberId, memberPw, memberName, gender, age, email, phone, address, hobby);
			MemberDdoService mdService = new MemberDdoService();
			int result = mdService.insertMemberDdo(mDdo);
			if(result > 0) {
				response.sendRedirect("/");
			}
			else {
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp");
				view.forward(request, response);
			}
		} catch (SQLException e) {
			request.setAttribute("msg", e.getMessage());
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp");
			view.forward(request, response);
		}
	}

}
