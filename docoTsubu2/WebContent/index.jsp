<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Integer count = (Integer) application.getAttribute("count"); %>
<%@ include file="/common.jsp" %>
<%
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
	String today = sdf.format(date);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶへようこそ</h1>
<p><%=name %>さんこんにちは！<br>本日は、<%=today %>です</p>
<p>イベントリスナーから取得した値は、<%=count %></p>
<form action="/docoTsubu2/Login" method="post">
ユーザー名：<input type="text" name="name" ><br><br>
パスワード：<input type="password" name ="pass"><br><br>
<input type="submit" value="ログイン">
</form>
<jsp:include page="/footer.jsp" />
</body>
</html>