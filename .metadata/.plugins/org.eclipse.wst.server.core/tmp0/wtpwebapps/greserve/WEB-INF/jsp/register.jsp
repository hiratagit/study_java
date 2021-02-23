<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String errMsg = (String) request.getAttribute("errMsg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員登録</title>
<jsp:include page="/head.jsp"></jsp:include>
</head>
<body class="bg-light">
<h1>新規会員登録</h1>
<div class="form-wrapp">
<form class="my-3 form-login" action="/greserve/Register" method="post">
 <div class="form-group row">
     <label for="userId" class="col-sm-4 col-form-label">ユーザーID:</label>
     <div  class="col-sm-8">
    	 <input type="text" id="userId" class="form-control" name="userId">
     </div>
 </div>
 <div class="form-group row">
	<label for="password" class="col-sm-4 col-form-label">パスワード:</label>
	<div  class="col-sm-8">
		<input type="password" id="password" class="form-control" name="pass">
	</div>
</div>
<div class="form-group row">
	<label for="name" class="col-sm-4 col-form-label">お名前:</label>
	<div  class="col-sm-8">
		<input type="text" id="name" class="form-control" name="name">
	</div>
</div>
<div class="form-group row">
	<label for="mail" class="col-sm-4 col-form-label">メールアドレス:</label>
	<div  class="col-sm-8">
		<input type="text"  id="mail" class="form-control"  name="mail">
	</div>
</div>

<% if( errMsg != null && errMsg.length() > 0) { %>
<p class="alert alert-danger in-login"><%=errMsg %></p>
<% } %>
<input class="btn btn-success d-block mt-4" type="submit" value="登録する">
</form>
</div>
<div class="buttons">
	<p><a class="btn btn-outline-success mx-auto" href="/greserve/index.jsp">トップへ</a></p>
</div>
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>