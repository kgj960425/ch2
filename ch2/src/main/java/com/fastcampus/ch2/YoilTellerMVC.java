 package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


//parameter : year, month , day
//return : yoil
		
@Controller
public class YoilTellerMVC
{
	@RequestMapping("/getYoilMvc")//http://localhost/getYoilMvc?year=2022&month=11&day=21
	public String main(int year, int month, int day ,Model model) throws IOException {
		
		//1.유효성 검사
		if(!isValid(year, month, day))
			return "yoilError"; //WEB-INF/views/yoilError.jsp	,	servlet-context.xml에 설정되어 있음
				
		//2.요일 계산
		char yoil = getYoil(year, month, day);
		
		//3.출력 model을 쓰고 jsp로 발사하며, 반환 타입이 String이고 return할때 jsp파일 이름을 넣는다.
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		
		return "yoil"; //WEB-INF/views/yoil.jsp
	}

	//알아두면 좋은점. 위 getYoilMvc에서 return타입을 void로 바꿔주고 return을 없애주면 @requestmapping을 읽고 getYoilMvc.jsp로 보내준다. 값 또한 잘 보내준다.
	
	private boolean isValid(int year, int month, int day) {
		if(year == 0)
			return false;
		if(month == 0)
			return false;
		if(day == 0)
			return false;
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:일요일, 2:월요일...이라는데 
		
		return " 월화수목금토일".charAt(dayOfWeek);
	}
}
