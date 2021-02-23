<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User, model.Mutter, java.util.List" %>
<% User loginUser = (User) session.getAttribute("loginUser");
   List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
   String errMsg = (String) request.getAttribute("errMsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶメイン</title>
</head>
<body>

<p><%=loginUser.getName() %>さん、ログイン中</p>
<a href="/docoTsubu3/Logout">ログアウト</a>
<a href="/docoTsubu3/Main">更新</a>

<form action="" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく" >
</form>
<% if(errMsg != null && errMsg.length() != 0) { %>
<p><%= errMsg %></p>
<% } %>


<% for(Mutter mutter : mutterList){ %>
<p><%= mutter.getUserName() %>:<%= mutter.getText() %></p>
<%} %>


</body>
</html>