<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.Admin, model.Account" %>
<%
  List<Admin> adminList = (List<Admin>) session.getAttribute("adminList");
  List<Account> accountList = (List<Account>) session.getAttribute("accountList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員/管理者情報一覧</title>
<jsp:include page="/head.jsp"></jsp:include>
</head>
<body class="adminscreen">
<div class="container">

<h1>会員/管理者情報一覧</h1>

<h2>●管理者一覧</h2>
<div class="row">
<table class="table table-bordered col-sm-10 m-auto bg-white mb-2">
<tr><th>管理者ID</th><th>名前</th></tr>
<% for(Admin admin : adminList) { %>
<tr><td><%=admin.getAdminId() %></td><td><%=admin.getName() %></td><tr>
<% } %>
</table>
</div>
<h2 class="mt-5">●会員情報一覧</h2>
<div class="row mb-4">
<table class="table table-bordered col-sm-10 m-auto bg-white mb-2">
<tr><th>ユーザーID</th><th>名前</th><th>Mail</th></tr>
<% for(Account account : accountList ) { %>
<tr><td><%=account.getUserId() %></td><td><%=account.getName() %></td><td><%=account.getMail() %></td></tr>
<%} %>
</table>
</div>
<div class="buttons">
	<p><a class="btn btn-outline-success mx-auto" href="/greserve/Admin">管理画面トップへ</a></p>
</div>
</div>
</body>
</html>