<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Product" %>
<%
	String targetProductId = (String) request.getAttribute("targetProductId");
	Product targetProduct = (Product) session.getAttribute("targetProduct");
	String errMsg = (String) request.getAttribute("errMsg");
    String contextPath = request.getContextPath().toString();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報編集</title>
<jsp:include page="/head.jsp"></jsp:include>
</head>
<body class="adminscreen">
<h1>商品情報編集</h1>
<%if(targetProduct != null) { %>

<div class="container">
  <div class="row bg-white py-2">
    <div class="col-sm-4"><img class="card-img-top" style="max-width: 300px;" src="<%=contextPath %>/img/<%=targetProduct.getImgfileNm() %>" alt=""></div>
    <div class="col-sm-8 py-2 m0auto">
      <ul>
         <li class="card-text">型　　　　番　：<%= targetProduct.getProductId() %></li>
    	 <li class="card-text">品　　　　名　：<%= targetProduct.getProductNm() %></li>
    	 <li class="card-text">メ　ー　カー名：<%= targetProduct.getMakerNm() %></li>
    	 <li class="card-text">価　　　　格　：<%=String.format("%,d", targetProduct.getPrice()) %> 円</li>
    	 <ll class="card-text"i>画像ファイル名：<%= targetProduct.getImgfileNm() %></li>
      </ul>
    </div>
  </div>
<div class="form-wrapp">
<form class="my-3 form-login" action="/greserve/ProductEdit" method="post">
  <div class="form-group row">
  	<label for="productId" class="col-sm-4 col-form-label">商　品　ID：</label>
  	<div  class="col-sm-8">
  		<input type="text" id="productId" class="form-control" name="productId" value="<%= targetProduct.getProductId() %>">
  	</div>
  </div>

  <div class="form-group row">
  	<label for="productNm" class="col-sm-4 col-form-label">商　品　名：</label>
  	<div  class="col-sm-8">
  		<input type="text" id="productNm" class="form-control" name="productNm" value="<%= targetProduct.getProductNm() %>">
  	</div>
  </div>

  <div class="form-group row">
  	<label for="makerId" class="col-sm-4 col-form-label">メーカーID：</label>
  	<div  class="col-sm-8">
  		<input type="text" id="makerId" class="form-control" name="makerId" placeholder="1:Gibson 2:Fender 3:Rickenbacker....">
  	</div>
  </div>

  <div class="form-group row">
  	<label for="price" class="col-sm-4 col-form-label">販売価格：</label>
  	<div  class="col-sm-8">
  		<input type="text" id="price" class="form-control" name="price" value="<%= Integer.toString(targetProduct.getPrice()) %>">
  	</div>
  </div>

 <div class="form-group row">
	 <label for="imgfileNm" class="col-sm-4 col-form-label">画像ファイル名：</label>
	 <div  class="col-sm-8">
	 	<input type="text" id="imgfileNm" class="form-control" name="imgfileNm" value="<%= targetProduct.getImgfileNm() %>">
	 </div>
 </div>

  <% if(errMsg != null && errMsg.length() !=0) { %>
    <p class="alert alert-warning in-login"><%=errMsg %></p>
  <% } %>
<input class="btn btn-primary d-block mt-4" type="submit" value="更新">
</form>
</div>
<% } %>

  <div class="buttons">
  　<p><a class="btn btn-dark mx-auto" href="/greserve/ProductDelete">商品削除</a></p>
    <p><a class="btn btn-outline-success mx-auto" href="/greserve/ProductList">商品一覧へ</a></p>
	<p><a class="btn btn-outline-success mx-auto" href="/greserve/Admin">管理画面トップへ</a></p>
  </div>
</div>
  <jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>