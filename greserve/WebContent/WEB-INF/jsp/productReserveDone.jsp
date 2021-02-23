<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String errMsg = (String) request.getAttribute("errMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ご予約完了画面</title>
<jsp:include page="/head.jsp"></jsp:include>
</head>
<body class="productscreen">
<div class="container">
<h1>ご予約完了</h1>
<% if(errMsg != null) { %>
<p class="text-center"><%=errMsg %></p>
<%} else { %>
<p class="text-center">ご予約が完了しました</p>
<%} %>
  <div class="buttons">
    <p><a class="btn btn-outline-success mx-auto" href="/greserve/ProductList">商品一覧へ</a></p>
	<p><a class="btn btn-outline-success mx-auto" href="/greserve/index.jsp">トップへ</a></p>
  </div>
</div>
 <jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>