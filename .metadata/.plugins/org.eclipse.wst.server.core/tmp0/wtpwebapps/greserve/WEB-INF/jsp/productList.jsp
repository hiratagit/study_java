<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Product, java.util.List" %>
<%
    List<Product> productList = (List<Product>) session.getAttribute("productList");
    String contextPath = request.getContextPath().toString();
    String adminLoginId = (String) session.getAttribute("adminLoginId");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧ページ</title>
<jsp:include page="/head.jsp"></jsp:include>

</head>
<body class="productscreen">

<div class="container">

<h1>商品一覧</h1>

<% if(productList != null) { %>

<% for(Product product : productList) { %>
  <div class="product-wrapp row mx-1 mb-3 pw-2 py-4">
    <div class="product-img col-sm-3">
      <img src="<%=contextPath %>/img/<%=product.getImgfileNm() %>" alt="">
      <% if(product.getReservation() > 0) { %>
        <p class="text-soldout">Sold Out</p>
      <%} %>
    </div>

    <div class="product-text col-sm-7">
    <%=product.getProductNm() %><br><%=product.getMakerNm() %><br><%=String.format("%,d", product.getPrice()) %> 円
    <% if(product.getReservation() > 0) { %>
        <p class="text-soldout">Sold Out</p>
    <%} %>
    </div>
    <div class="product-link col-sm-2" >
      <a class="text-white btn btn-info btn-lg" href="/greserve/ProductReserve?productId=<%=product.getProductId() %>">More</a>
    </div>
  </div>
<% } %>
<%} %>

<% if(adminLoginId != null && adminLoginId.length() > 0) {%>
  <div class="buttons mt-5">
    <p><a class="btn btn-outline-success mx-auto" href="/greserve/ProductRegister">商品登録</a></p>
	<p><a class="btn btn-outline-success mx-auto" href="/greserve/ReservationStatus">予約状況確認</a></p>
	<p><a class="btn btn-outline-success mx-auto" href="/greserve/Admin">管理画面トップへ</a></p>
  </div>
<%} else { %>
  <div class="buttons mt-5">
	<p><a class="btn btn-outline-success mx-auto" href="/greserve/index.jsp">トップへ</a></p>
  </div>
<%} %>
</div>
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>