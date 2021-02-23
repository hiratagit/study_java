<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String random = request.getParameter("random");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>これは、Forwarded.jspファイルです</h2>
<p>取得した乱数の値は、<%= random %>でした</p>
</body>
</html>