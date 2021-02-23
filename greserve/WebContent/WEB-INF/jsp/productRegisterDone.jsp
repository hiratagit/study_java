<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  String registeredId = (String) session.getAttribute("registeredProductId");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品登録完了</title>
<jsp:include page="/head.jsp"></jsp:include>
</head>
<body class="adminscreen">
<h1>新規商品登録完了</h1>
<div class="container">
<p class="text-center"><span class="registered-id"><%=registeredId %></span>の登録が完了しました</p>

  <div class="buttons">
    <p><a class="btn btn-outline-success mx-auto" href="/greserve/ProductList">商品一覧へ</a></p>
	<p><a class="btn btn-outline-success mx-auto" href="/greserve/Admin">管理画面トップへ</a></p>
  </div>

</div>
</body>
</html>