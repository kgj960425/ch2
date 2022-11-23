package com.fastcampus.ch2;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

public class MethodInfo {
	@RequestMapping("/requestInfo")
    public void main(HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	//public static void main(String[] args) throws Exception{
		
//		매개변수 이름 얻어오기
//		1.reflection api
//			parameters 옵션을 넣고 쓰기
//		2.classfile 직접 읽기
//			navigater	
		
		//1.YoilTeller클래스의 객체를 생성
		Class clazz = Class.forName("com.fastcampus.ch2.YoilTeller");
		Object obj = clazz.newInstance();
		
		//2.모든 메서드의 정보를 가져와서 배열에 저장
		Method[] methodArr = clazz.getDeclaredMethods();
		
		for(int i = 0; i<methodArr.length; i++) {
			//배열이라 그런가 length다. 아까 보니까 length()이걸로 넣었다가 안됐는데. 기억해놓자 맨날 이런 실수해 고쳐. 그리고 반복문 안에서 methodArr(i)가 아니라 methodArr[i]야 이것도 좀 기억해라 이제 좀
			System.out.println("methodArr ["+i+"] : "+methodArr[i]);
		}
		
		for(Method m : methodArr) {
			System.out.println("methodArr ["+m+"] : "+m);
		}
		
		for(Method m : methodArr) {
			//향상된 for문 문법
			String name = m.getName(); //메서드의 이름
			Parameter[] paramArr = m.getParameters();//매개변수 목록
//			Class[] paramTypeArr = m.getParameterTypes();
			Class returnType = m.getReturnType();
			
			StringJoiner paramList = new StringJoiner(", ", "(", ")");
			
			for(Parameter param : paramArr) {
				String paramName = param.getName();
				Class  paramType = param.getType();
				
				paramList.add(paramType.getName() + " " + paramName);
			}
			
			System.out.printf("%s %s%s%n", returnType.getName(), name, paramList);
		}
	} // main
}

/* [실행결과]
java.lang.String main(java.lang.String year, java.lang.String month, java.lang.String day, org.springframework.ui.Model model)
boolean isValid(int year, int month, int day)
*/