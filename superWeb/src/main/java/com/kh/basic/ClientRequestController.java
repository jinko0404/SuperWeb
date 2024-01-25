package com.kh.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/show/me.something")
public class ClientRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ClientRequestController() {}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트 요청에 따른 응답을 하도록 프로그래밍 하였다.
		// 서블릿 컨테이너에서 서블릿 객체를 사용하며 프로그래밍 함
		// 서블릿 컨테이너는 톰캣이다.
		// 톰캣이 연결되어야 서블릿 컨테이너를 사용할 수 있고 그 후 에 서버 프로그래밍도 할 수 있는 것이다.
		PrintWriter out = response.getWriter();
		out.println("this is an answer");
	}

}
