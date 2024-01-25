package com.kh.radio;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/radioResult.do")
public class RadioBtnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public RadioBtnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html; charset=utf-8");
//		PrintWriter out = response.getWriter();
		
		String gender = request.getParameter("gender");
		String checkValue = request.getParameter("check-mail");
		
		request.setAttribute("gender", gender);
		request.setAttribute("checkValue", checkValue);
		RequestDispatcher view =
				request.getRequestDispatcher("/views/radioBox/radioResult.jsp");
		view.forward(request, response);
//		out.println("<html><head><title>라디오 체크 결과</title></head><body>");
//		out.println("성별 : " + gender + "<br>");
//		out.println("메일 수신 여부 : " + checkValue + "<br>");
//		out.println("</body></html>");
		
	}

}
