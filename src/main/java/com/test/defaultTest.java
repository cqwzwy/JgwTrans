package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class defaultTest
 */
@WebServlet("/defaultTest")
public class defaultTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public defaultTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.append("Context路径: ").append(request.getContextPath());
		/*
		 * String rn=request.getServerName(); pw.println("默认缺省\n serverName: "+rn
		 * +"\n serverPort: "+request.getServerPort()
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
		System.out.println("TestS/dis");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
