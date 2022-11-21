package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTeller
{
	@RequestMapping("/getYoil")//http://localhost:8080/getYoil?year=2022&month=11&day=21
	public Calendar main(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//return type란이 void 이고 parameter를 HttpServletResponse response를 추가해줬을 때 
		//response.setContentType("text/html");, response.setCharacterEncoding("urf-8");를 추가해서
		//화면에 결과가 나오게 한다.
		
		//1.입력
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
				
				//2.작업
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		//공부1.Integer.parseInt()
		
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm -1, dd);
		//공부2.Calendar, Calendar.getInstance();
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:일요일, 2:월요일...이라는데 
		char yoil = " 월화수목금토일".charAt(dayOfWeek);
		//공부3.Calendar.DAY_OF_WEEK의 로직
		
		//3.출력
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter(); //response객체에서 브라우저로의 출력 스트림을 얻는다.
		out.print(year+"년 "+month+"월 "+day+"일 은 ");
		out.print(yoil+"요일 입니다..");
		//바로 위에 적혀진 방법은 화면에 값을 출력하기 위한 방식. 외워둘것.
		
		System.out.print(year+"년 "+month+"월 "+day+"일은 ");
		System.out.print(yoil+"요일입니다.");
		
		return cal;
	}
}
