<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<% User loginUser = (User) session.getAttribute("loginUser"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>どこつぶログイン</h1>
<% if(loginUser != null){ %>
<p>ログインに成功しました</p>
<P>ようこそ、<%= loginUser.getName() %>さん</P>
<a href="/docoTsubu/Main">つぶやき・投稿閲覧へ</a>
<% } else { %>
<p>ログインに失敗しました</p>
<a href="/docoTsubu/">トップへ</a>
<% } %>
</body>
</html>