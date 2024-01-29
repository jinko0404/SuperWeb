package com.kh.notice.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

@WebServlet("/notice/register.do")
public class NoticeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이지 출력용
		request.getRequestDispatcher("/WEB-INF/views/notice/insert.jsp")
		.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//데이터 등록용
	    request.setCharacterEncoding("UTF-8");
		NoticeService nService = new NoticeService();
		String noticeSubject = request.getParameter("notice-subject");
		String noticeContent = request.getParameter("notice-content");
		Notice notice = new Notice(noticeSubject, noticeContent);
		int result = nService.insertNotice(notice);
		if(result > 0) {
			//등록성공
			response.sendRedirect("/notice/list.do");
		}
		else {
			//등록실패
			request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp")
			.forward(request, response);
		}
	}
}
