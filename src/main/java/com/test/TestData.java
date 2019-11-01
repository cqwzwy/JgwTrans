package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestData
 */
@WebServlet("/TestData")
public class TestData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.append("Served at: ").append(request.getContextPath());
		pw.println(request.getAttribute("ids"));
		String rn=request.getServerName();
		Cookie[] cookies=request.getCookies();
		String time=null;
		for(int i=0;cookies!=null&&i<cookies.length;i++) {
			
			if(cookies[i].getName()=="Time") {
				time=cookies[i].getValue();
			}
			
		}
		
		if(time==null) {
			
			pw.println("初次访问   "+new Date());
		}else {
			pw.println("Last : "+time);
		}
		String ct=new SimpleDateFormat("yyyy 年 mm 月 dd 天  hh:mm:ss").format(new Date());
		Cookie c=new Cookie("Time",""+ct);
		response.addCookie(c);
		/*
		 * pw.println("t2\n serverName: "+rn +"\n serverPort: "+request.getServerPort()
		 * +"\n Uri: "+request.getRequestURI() +"\n Url: "+request.getRequestURL()
		 * +"\n servletContext: "+request.getServletContext()
		 * +"\n contextPath: "+request.getContextPath()
		 * +"\n method: "+request.getMethod()
		 * +"\n encoding: "+request.getCharacterEncoding()
		 * +"\n contentType: "+request.getContentType()
		 * +"\n cookies: "+request.getCookies() +"\n Headers: "+request.getHeaderNames()
		 * +"\n localAddr: "+request.getLocalAddr()
		 * +"\n localName: "+request.getLocalName()
		 * +"\n localPort: "+request.getLocalPort()
		 * +"\n authType: "+request.getAuthType()
		 * +"\n contentLength: "+request.getContentLength()
		 * 
		 * 
		 * +"\n pathInfo: "+request.getPathInfo()
		 * +"\n pathTranslated: "+request.getPathTranslated()
		 * +"\n protocol: "+request.getProtocol() +"\n query: "+request.getQueryString()
		 * +"\n session: "+request.getSession()
		 * +"\n sessionId: "+request.getRequestedSessionId()
		 * 
		 * +"\n remoteAddr: "+request.getRemoteAddr()
		 * +"\n remoteHost: "+request.getRemoteHost()
		 * +"\n remoteUser: "+request.getRemoteUser()
		 * +"\n remotePort: "+request.getRemotePort()
		 * +"\n attributes: "+request.getAttributeNames()
		 * +"\n class: "+request.getClass()
		 * +"\n dispatcherType: "+request.getDispatcherType()
		 * +"\n scheme: "+request.getScheme() );
		 */
		System.out.println("TestD/dis"+request.getAttribute("ids"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
