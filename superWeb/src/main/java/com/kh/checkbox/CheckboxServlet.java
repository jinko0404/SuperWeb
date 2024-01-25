package com.kh.checkbox;

import java.io.IOException;
import java.util.ArrayList;
//import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckResult.do")
public class CheckboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckboxServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] places = request.getParameterValues("place");
		//response.setContentType("text/html; charset=utf-8");
		//PrintWriter out = response.getWriter();
		//String place = "";
		Map<String, String> nameMap = new HashMap<String, String>();
		nameMap.put("hawaii", "하와이");
		nameMap.put("swiss", "스위스");
		nameMap.put("italy", "이태리");
		nameMap.put("france", "프랑스");
		nameMap.put("usa", "미국");
		List<String> nameList = new ArrayList<String>();
		for(String place : places) {
			nameList.add(nameMap.get(place));
		}
		request.setAttribute("places", nameList);
		RequestDispatcher view =
				request.getRequestDispatcher("/views/checkBox/checkBox.jsp");
		view.forward(request, response);
//		out.println("<h1>선택 결과</h1>");
//		out.print("선택한 관광지는 ");
//		for(int i = 0; i < places.length;i++) {
//			place = nameMap.get(places[i]);
//			out.println(place);
//			if(i != places.length - 1) {
//				out.print(", ");
//			}
//			
//		}
//		out.println("");
	}

//	private String engToKor(String place) {
//		if("hawaii".equalsIgnoreCase(place))
//			place = "하와이";
//		else if("swiss".equalsIgnoreCase(place))
//			place = "스위스";
//		else if("italy".equalsIgnoreCase(place))
//			place = "이태리";
//		else if("france".equalsIgnoreCase(place))
//			place = "프랑스";
//		else if("usa".equalsIgnoreCase(place))
//			place = "미국";
//		return place;
//	}
}
