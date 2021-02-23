<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "model.User" %>
<% User loginUser = (User) session.getAttribute("loginUser"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶログイン</title>
</head>
<body>

<% if(loginUser != null) {%>
<p>ログインに成功しました</p>
<p>ようこそ、<%=loginUser.getName() %></p>
<a href="/docoTsubu3/Main">つぶやき・投稿画面へ</a>
<% }else{ %>
<p>ログインに失敗しました</p>
<a href="/docoTsubu3/">トップへ</a>
<% } %>
</body>
</html>