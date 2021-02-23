<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User, model.Mutter, java.util.List" %>
<% User loginUser = (User) session.getAttribute("loginUser"); %>
<% List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList"); %>
<% String errorMsg = (String) request.getAttribute("errorMsg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>どこつぶメイン</h1>
<p><%= loginUser.getName() %>さんログイン中</p>
<a href="/docoTsubu/Logout">ログアウト</a>
<p><a href="/docoTsubu/Main">更新</a></p>
<form action="/docoTsubu/Main" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">
<% if(errorMsg != null) { %>
<p><%= errorMsg %></p>
<% } %>
<% for(Mutter mutter : mutterList) { %>
<p><%= mutter.getUserName() %> : <%= mutter.getText() %></p>
<%} %>
</form>
</body>
</html>