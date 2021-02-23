<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String errMsg = (String) request.getAttribute("errMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者追加登録</title>
<jsp:include page="/head.jsp"></jsp:include>
</head>
<body class="adminscreen">
<h1>管理者追加登録</h1>
<div class="form-wrapp">
<form  class="my-2 form-login" action="/greserve/RegisterAdmin" method="post">
 <div class="form-group row">
     <label for="adminId" class="col-sm-4 col-form-label">管理者ID:</label>
     <div  class="col-sm-8">
    	 <input type="text" id="adminId" class="form-control" name="adminId">
     </div>
 </div>
 <div class="form-group row">
	<label for="password" class="col-sm-4 col-form-label">パスワード:</label>
	<div  class="col-sm-8">
		<input type="password" id="password" class="form-control" name="pass">
	</div>
</div>
<div class="form-group row">
	<label for="name" class="col-sm-4 col-form-label">名前:</label>
	<div  class="col-sm-8">
		<input type="text" id="name" class="form-control" name="name">
	</div>
</div>
<% if( errMsg != null && errMsg.length() > 0) { %>
<p class="alert alert-warning in-login"><%=errMsg %></p>
<% } %>
<input class="btn btn-success d-block mt-4" type="submit" value="登録する">
</form>
</div>
<div class="buttons">
	<p><a class="btn btn-outline-success mx-auto" href="/greserve/Admin">管理画面トップへ</a></p>
</div>

</body>
</html>