<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! int number1;%>
<%!  int number2;%>
<%!	double result; %>
<%! String option; %>

<%
int number1 = Integer.parseInt(request.getParameter("number1"));
int number2 = Integer.parseInt(request.getParameter("number2"));
if("Addition".equals(request.getParameter("add"))){
	result=number1+number2;
}
 else if("Subtract".equals(request.getParameter("sub"))){
	result=number1-number2;
}
 else if("Multiplicetion".equals(request.getParameter("mul"))){
	result=number1*number2;
}
 else if("Division".equals(request.getParameter("div"))){
	result=number1/number2;
}
 else if("Percentage".equals(request.getParameter("per"))){
	result=number1-number2;
}
%>
<h2>Result is <%=result

%></h2>
</body>
</html>