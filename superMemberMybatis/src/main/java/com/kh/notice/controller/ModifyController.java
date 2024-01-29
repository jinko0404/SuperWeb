package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

@WebServlet("/notice/modify.do")
public class ModifyController extends HttpServlet{
	private static final long serialVersionUID = -527802428095427837L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		NoticeService nService = new NoticeService();
		Notice notice = nService.selectOneByNo(noticeNo);
		if(notice != null) {
			request.setAttribute("notice", notice);
			request.getRequestDispatcher("/WEB-INF/views/notice/modify.jsp")
			.forward(request, response);
		}
		else {
			request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp")
			.forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int noticeNo = Integer.parseInt(request.getParameter("notice-no"));
		String noticeSubject = request.getParameter("notice-subject");
		String noticeContent = request.getParameter("notice-content");
		Notice notice = new Notice(noticeNo, noticeSubject, noticeContent);
		NoticeService nService = new NoticeService();
		int result = nService.updateNotice(notice);
		if(result > 0) {
			response.sendRedirect("/notice/detail.do?noticeNo=" + noticeNo);
		} else {
			request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp")
			.forward(request, response);
		}
	}
}









