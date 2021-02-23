<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Product" %>
<%
	Product deleteProduct = (Product) session.getAttribute("targetProduct");
	String contextPath = request.getContextPath().toString();
	String errMsg = (String) request.getAttribute("errMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品削除確認</title>
<jsp:include page="/head.jsp"></jsp:include>
</head>
<body class="adminscreen">
<div class="container">
<h1>商品削除確認</h1>
<p style="text-align:center;">下記商品をほんとうに削除しますか？</p>
<div class="reservation-status">
  <div class="reservation-status_box">
    <ul>
    	<li>型　　　　番　：<%= deleteProduct.getProductId() %></li>
    	<li>品　　　　名　：<%= deleteProduct.getProductNm() %></li>
    	<li>メ　ー　カー名：<%= deleteProduct.getMakerNm() %></li>
    	<li>価　　　　格　：<%=String.format("%,d", deleteProduct.getPrice()) %> 円</li>
    	<li>画像ファイル名：<%= deleteProduct.getImgfileNm() %></li>
    </ul>
  </div>
</div>

<form class="my-5 form-login" action="/greserve/ProductDelete"method="post">
  <input type="hidden" name="deleteProductId" value="<%= deleteProduct.getProductId() %>">
  <% if(errMsg != null && errMsg.length() > 0) { %>
  <p class="alert alert-warning in-login"><%=errMsg %></p>
  <% } %>
  <input class="btn btn-dark d-block mt-4" type="submit" value="削除">
</form>

  <div class="buttons">
    <p><a class="btn btn-outline-success mx-auto" href="/greserve/ProductList">商品一覧へ</a></p>
	<p><a class="btn btn-outline-success mx-auto" href="/greserve/Admin">管理画面トップへ</a></p>
  </div>
 </div>
</body>
</html>