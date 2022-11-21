package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TwoDice {
	
	@RequestMapping("/rollDice")
	public void main(HttpServletResponse response) throws IOException {
		//랜덤 메소드
		//int idx1 = (int)(Math.random()*6)+1;
		//Math.random()는 0~1 사이의 실수를 리턴합니다. (1 미포함) double 사용
		//Math.random()*6이면 0~6사이의 실수를 리턴합니다. (6 미포함이겠죠?) double 사용하지만 앞에 '(int)'로 형변환을 해주면 아주 좋습니다.
		//Math.random()*10을 하면 0~ 9.99999...의 범위가 되고 Math.floor(Math.random()*10)의 결과는 0~9범위의 정수입니다. +1을 해준다면 1~10이고 *11을 해준다면 0~10까지의 범위를 얻습니다. 
		double result1 = Math.random();
		int result2 = (int)result1;
		int result3 = result2*6;
		int idx1 = result3+1;
		//int idx2 = (int)(Math.random()*6)+1;
		double result4 = Math.random();
		int result5 = (int)result4;
		int result6 = result5*6;
		int idx2 = result6+1;
				
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("result1.double : "+result1+" \n");
		out.println("result2.int : "+result2+" \n");
		out.println("result3.int*6 : "+result3+" \n");
		out.println("<img src='/resources/img/dice"+idx1+".jpg'>");
		out.println("result4.double : "+result4+" \n");
		out.println("result5.int : "+result5+" \n");
		out.println("result6.int*6 : "+result6+" \n");
		out.println("<img src='/resources/img/dice"+idx2+".jpg'>");
		out.println("</body>");
		out.println("</html>");
	}
}
