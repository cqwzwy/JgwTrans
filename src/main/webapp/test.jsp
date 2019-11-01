<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="1.js"></script>
</head>
<body>

	<p>
		<% out.println(new Date());
			request.setAttribute("ida", "xsq");
			out.println(request.getAttribute("ids"));
			out.println(pageContext.getAttribute("hh"));
		%>
		
		<jsp:forward page="/jsp/incl.jsp"></jsp:forward>
	</p>

<p> 
	<%! int a=1;int b=2; %>
	<%! public static int add(int a,int b){ 
		System.out.println(a+b);	
		return a+b;
	}
	%>
	
	<% 	int sum=add(a,b);
		out.println("sum"+sum);
	%>



</p>
<script>
</script>
</body>
</html>