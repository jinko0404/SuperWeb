package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

@WebServlet("/notice/detail.do")
public class DetailController extends HttpServlet{
	private static final long serialVersionUID = -527802428095427837L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noticeNo = request.getParameter("noticeNo");
		NoticeService nService = new NoticeService();
		Notice notice = nService.selectOneByNo(Integer.parseInt(noticeNo));
		if(notice != null) {
			request.setAttribute("notice", notice);
			request.getRequestDispatcher("/WEB-INF/views/notice/detail.jsp")
			.forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp")
			.forward(request, response);
		}
	}
	
	@Override
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}
}
