<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Product" %>
<% Product product = (Product) session.getAttribute("product");
   String adminLoginId = (String) session.getAttribute("adminLoginId");
   String contextPath = request.getContextPath().toString();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品予約</title>
<jsp:include page="/head.jsp"></jsp:include>

</head>
<body class="productscreen">
<div class="container">
<h1>商品詳細＆予約</h1>
<div class="product-img reserve-img"><img src="<%=contextPath %>/img/<%=product.getImgfileNm() %>" alt=""></div>
<div class="spec">
  <ul>
    <li>商品コード：<%=product.getProductId() %></li>
    <li>商　品　名：<%=product.getProductNm() %></li>
    <li>メーカー　：<%=product.getMakerNm() %></li>
    <li>価　格　　：<%=String.format("%,d", product.getPrice()) %> 円</li>
    <% if(product.getReservation() != 0) { %>
    <li class="soldout">Sold Out</li>
    <% } %>
  </ul>
</div>
     <% if(product.getReservation() == 0 && (adminLoginId == null || adminLoginId.length() == 0)) { %>
       <form action="/greserve/ProductReserve" method="post">
       <input type="hidden" name="productId" value="<%=product.getProductId() %>">
       <input class="btn btn-warning d-block mt-4" type="submit" value="予約する">
       </form>
     <% } %>
  <div class="buttons">
    <p><a class="btn btn-outline-success mx-auto" href="/greserve/ProductList">商品一覧へ</a></p>
    <% if(adminLoginId == null || adminLoginId.length() == 0){ %>
	<p><a class="btn btn-outline-success mx-auto" href="/greserve/index.jsp">トップへ</a></p>
	<% } else { %>
	   <% if(product.getReservation() == 0){ %>
	      <p><a class="btn btn-outline-success mx-auto" href="/greserve/ProductEdit?productId=<%=product.getProductId() %>" >編集/削除</a></p>
	   <% } %>
	<p><a class="btn btn-outline-success mx-auto" href="/greserve/Admin">管理画面トップへ</a></p>
	<% } %>
  </div>
</div>
 <jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>