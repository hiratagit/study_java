<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ商店</title>
<style>
h5 {margin-bottom : 0; padding-left: 1em;}
table td {
padding: .5em;
border-top: 1px solid #ddd;
border-left: 1px solid #ddd;
border-right: 1px solid #ddd;
}

table tr:last-child td {
border-bottom : 1px solid #ddd;
}

table {margin-bottom: 2em;}
</style>
</head>
<body>
<p>ようこそ<c:out value=" ${userId}" />さん</p>

<h5>【　会員情報　】</h5>
<table>
<c:forEach var="account" items="${sessionScope.accountList }" >
<tr>
  <td>ID：${account.userId }</td>
  <td>メール：${ account.mail }</td>
  <td>名前：${account.name }</td>
  <td>年齢：${ account.age }</td>

</tr>
</c:forEach>
</table>
<a href="/login/Logout">ログアウト</a><br><br>
<a href="/login/WelcomeServlet">トップへ</a>
</body>
</html>