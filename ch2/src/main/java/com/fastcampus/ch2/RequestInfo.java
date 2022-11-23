package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RequestInfo {
    @RequestMapping("/requestInfo")
    //    public static void main(String[] args) {
    public void main(HttpServletRequest request) {
        System.out.println("request.getCharacterEncoding()="+request.getCharacterEncoding()); // ��û ������ ���ڵ�
        System.out.println("request.getContentLength()="+request.getContentLength());  // ��û ������ ����. �˼� ���� ���� -1
        System.out.println("request.getContentType()="+request.getContentType()); // ��û ������ Ÿ��. �� �� ���� ���� null

        System.out.println("request.getMethod()="+request.getMethod());      // ��û ���
        System.out.println("request.getProtocol()="+request.getProtocol());  // ���������� ������ ���� HTTP/1.1
        System.out.println("request.getScheme()="+request.getScheme());      // ��������

        System.out.println("request.getServerName()="+request.getServerName()); // ���� �̸� �Ǵ� ip�ּ�
        System.out.println("request.getServerPort()="+request.getServerPort()); // ���� ��Ʈ
        System.out.println("request.getRequestURL()="+request.getRequestURL()); // ��û URL
        System.out.println("request.getRequestURI()="+request.getRequestURI()); // ��û URI

        System.out.println("request.getContextPath()="+request.getContextPath()); // context path
        System.out.println("request.getServletPath()="+request.getServletPath()); // servlet path
        System.out.println("request.getQueryString()="+request.getQueryString()); // ���� ��Ʈ��

        System.out.println("request.getLocalName()="+request.getLocalName()); // ���� �̸�
        System.out.println("request.getLocalPort()="+request.getLocalPort()); // ���� ��Ʈ

        System.out.println("request.getRemoteAddr()="+request.getRemoteAddr()); // ���� ip�ּ�
        System.out.println("request.getRemoteHost()="+request.getRemoteHost()); // ���� ȣ��Ʈ �Ǵ� ip�ּ�
        System.out.println("request.getRemotePort()="+request.getRemotePort()); // ���� ��Ʈ
    }
}
/*
 * [������] http://localhost:8080/ch2/requestInfo?year=2021&month=10&day=1
 * request.getCharacterEncoding()=UTF-8 request.getContentLength()=-1
 * request.getContentType()=null request.getMethod()=GET
 * request.getProtocol()=HTTP/1.1 request.getScheme()=http
 * request.getServerName()=localhost request.getServerPort()=8080
 * request.getRequestURI()=http://localhost:8080/ch2/requestInfo
 * request.getRequestURI()=/ch2/requestInfo request.getContextPath()=/ch2
 * request.getServletPath()=/requestInfo
 * request.getQueryString()=year=2021&month=10&day=1
 * request.getLocalName()=localhost request.getLocalPort()=8080
 * request.getRemoteAddr()=0:0:0:0:0:0:0:1 <--- AWS�� ����(deploy)�� ������ �����ϸ�, ����
 * ip�ּҸ� Ȯ���� �� ����. request.getRemoteHost()=0:0:0:0:0:0:0:1 <--- AWS�� ����(deploy)��
 * ������ �����ϸ�, ���� ip�ּҸ� Ȯ���� �� ����. request.getRemotePort()=54855
 */