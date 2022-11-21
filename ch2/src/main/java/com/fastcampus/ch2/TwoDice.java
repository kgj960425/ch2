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
