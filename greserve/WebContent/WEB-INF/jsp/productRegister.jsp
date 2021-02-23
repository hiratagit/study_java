<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  String errMsg = (String) request.getAttribute("errMsg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品登録</title>
<jsp:include page="/head.jsp"></jsp:include>
</head>
<body class="adminscreen">
<h1>新規商品登録</h1>
<div class="container">

<form class="my-5 form-login" action="/greserve/ProductRegister" method="post">

  <div class="form-group row">
  	<label for="productId" class="col-sm-4 col-form-label">商　品　ID：</label>
  	<div  class="col-sm-8">
  		<input type="text" id="productId" class="form-control" name="productId" >
  	</div>
  </div>

  <div class="form-group row">
  	<label for="productNm" class="col-sm-4 col-form-label">商　品　名：</label>
  	<div  class="col-sm-8">
  		<input type="text" id="productNm" class="form-control" name="productNm">
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
  		<input type="text" id="price" class="form-control" name="price" >
  	</div>
  </div>

 <div class="form-group row">
	 <label for="imgfileNm" class="col-sm-4 col-form-label">画像ファイル名：</label>
	 <div  class="col-sm-8">
	 	<input type="text" id="imgfileNm" class="form-control" name="imgfileNm">
	 </div>
 </div>

<% if(errMsg != null && errMsg.length() !=0) { %>
<p class="alert alert-warning in-login"><%=errMsg %></p>
<% } %>
<input class="btn btn-success d-block mt-4" type="submit" value="登録">
</form>

  <div class="buttons">
    <p><a class="btn btn-outline-success mx-auto" href="/greserve/ProductList">商品一覧へ</a></p>
	<p><a class="btn btn-outline-success mx-auto" href="/greserve/Admin">管理画面トップへ</a></p>
  </div>

</div>
</body>
</html>
