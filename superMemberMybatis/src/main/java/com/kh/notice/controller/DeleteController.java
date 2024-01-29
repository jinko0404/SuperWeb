package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.service.NoticeService;

@WebServlet("/notice/delete.do")
public class DeleteController  extends HttpServlet{
	private static final long serialVersionUID = -527802428095427837L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		NoticeService nService = new NoticeService();
		int result = nService.deleteNotice(noticeNo);
		if(result > 0) {
			response.sendRedirect("http://localhost:9999/notice/list.do");
		}
		else {
			request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp")
			.forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request,response);
	}
}
