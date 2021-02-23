<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  String adminLoginId = (String) session.getAttribute("adminLoginId");
	String errMsg = (String) request.getAttribute("errMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理画面トップ</title>
<jsp:include page="/head.jsp"></jsp:include>
</head>
<body class="adminscreen">
<div class="container">
<h1>Greserve</h1>
<h2>管理画面</h2>

<% if(adminLoginId == null) { %>
<div class="form-wrapp">
<form class="my-3 form-login" action= "/greserve/Admin" method="post">
 <div class="form-group row">
	<label for="userId" class="col-sm-3 col-form-label">管理人ID :</label>
	<div class="col-sm-9">
		<input type="text" id="userId" class="form-control" name="adminId">
	</div>
</div>
 <div class="form-group row">
    <label for="password" class="col-sm-3 col-form-label" >パスワード :</label>
    <div class="col-sm-9">
    	<input type="password" id="password" class="form-control" name="pass">
    </div>
  </div>
<% if(errMsg != null && errMsg.length() > 0 ) { %>
<p class="alert alert-warning in-login"><%=errMsg %></p>
<% } %>
<input class="btn btn-success d-block" type="submit" value="ログイン">
</form>
</div>
<div class="buttons">
 <p><a class="btn btn-outline-success mx-auto" href="/greserve/">トップへ</a></p>
</div>

<%} else { %>
<p class="alert alert-secondary in-login">管理人：<%=adminLoginId %>さんログイン中</p>
<div class="admin__buttons-wrapp">
  <div class="buttons">
   <p><a class="btn btn-dark mx-auto" href="/greserve/ProductList">商品一覧へ</a></p>
   <p><a class="btn btn-dark mx-auto"  href="/greserve/MemberAdminList">会員/管理者情報閲覧</a></p>
   <p><a class="btn btn-dark mx-auto" href="/greserve/RegisterAdmin">管理者追加登録</a></p>
   <p><a class="btn btn-dark mx-auto"  href="/greserve/">トップへ</a></p>
  </div>
</div>
<div class="buttons">
<p><a class="btn btn-outline-dark mx-auto" href="/greserve/LogoutAdmin">ログアウト</a></p>
</div>
<% } %>
</div>
</body>
</html>