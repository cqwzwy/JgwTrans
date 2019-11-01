<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
	
		${pageContext.request.requestURL}<br />
		${pageContext.request.servletPath}<br />
		${pageContext.request.servletContext}
		<% 
			out.println("include"+request.getAttribute("ida"));
			out.println(request.getServletPath());
			request.setAttribute("ids", "xwws");
			pageContext.setAttribute("hh", "pageContext");
			
		%>
		
	</p>
</body>
</html>