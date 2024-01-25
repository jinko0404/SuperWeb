package com.kh.calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calculator.do")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstNum = request.getParameter("first-num");
		String operator = request.getParameter("operator");
		String secondNum = request.getParameter("second-num");
		String answer = "";
		switch(operator.charAt(0)) {
		case '+':
			answer = String.valueOf(Integer.parseInt(firstNum) + Integer.parseInt(secondNum));
			break;
		case '-':
			answer = String.valueOf(Integer.parseInt(firstNum) - Integer.parseInt(secondNum));
			break;
		case 'X':
			answer = String.valueOf(Integer.parseInt(firstNum) * Integer.parseInt(secondNum));
			break;
		case '/':
			answer = String.valueOf(Integer.parseInt(firstNum) / Integer.parseInt(secondNum));
			break;
		case '%':
			answer = String.valueOf(Integer.parseInt(firstNum) % Integer.parseInt(secondNum));
			break;
		}
		
		request.setAttribute("firstNum", firstNum);
		request.setAttribute("operator", operator);
		request.setAttribute("secondNum", secondNum);
		request.setAttribute("answer", answer);
		RequestDispatcher view =
				request.getRequestDispatcher("/views/calculator/calcResult.jsp");
		view.forward(request, response);//누락주의 발사버튼
//		response.setContentType("text/html; charset=utf-8");
		//PrintWriter 설정 전에 utf-8을 설정해줘야한다.
//		PrintWriter out = response.getWriter();
//		out.println("firstNum : " + firstNum);
//		out.println("secondNum : " + secondNum);
//		out.println("operator : " + operator);
//		out.println("answer : " + answer);
//		out.println("<html><head><title>입력값에 대한 계산결과</title></head>");
//		out.println("<body><h1>계산결과<h1>");
//		out.println("<h1>" + firstNum + " " + operator + " " + secondNum
//				+ " = " + answer + "</h1>");
//		out.println("</body></html>");
	}

}
