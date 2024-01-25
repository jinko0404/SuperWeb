package com.kh.taste;

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

@WebServlet("/tasteResult.do")
public class tasteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public tasteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		String[] food = request.getParameterValues("food");
//		response.setContentType("text/html; charset=utf-8");
//		PrintWriter out = response.getWriter();
		Map<String, String> map = new HashMap<>();
		map.put("red", "빨강색");
		map.put("blue", "파랑색");
		map.put("yellow", "노랑색");
		map.put("green", "초록색");
		
		map.put("dog", "강아지");
		map.put("cat", "고양이");
		map.put("lizard", "도마뱀");
		map.put("turtle", "거북이");
		
		map.put("jjajang", "짜장면");
		map.put("jjambbong", "짬뽕");
		map.put("tangsuyuk", "탕수육");
		map.put("yangjyangpi", "양장피");
		map.put("palbochae", "팔보채");
		
		String colorKo = map.get(color);
		String animalKo = map.get(animal);
		request.setAttribute("name", name);
		request.setAttribute("colorKo", colorKo);
		request.setAttribute("animalKo", animalKo);
		List<String> foodList = new ArrayList<String>();
		for(String foodName : food) {
			foodList.add(map.get(foodName));
		}
		request.setAttribute("food", foodList);
		RequestDispatcher view =
				request.getRequestDispatcher("/views/taste/tasteResult.jsp");
		view.forward(request, response);
//		String mappedFood = "";
		
//		out.println("<html><head><title>개인 취향 테스트 결과</title></head><body>");
//		out.print(name + "님의 개인 취향은 색깔은 " + colorKo 
//				+ "을 좋아하고 "
//				+ "동물은 "+ animalKo +"를 좋아하고 음식은");
//		for(int i = 0; i < food.length; i++) {
//			mappedFood = map.get(food[i]);
//            out.print(mappedFood);
//			if(i != food.length - 1) {
//				out.print(", ");
//			}
//		}
//		out.println("입니다.");
//		out.println("</body></html>");
	}

}












