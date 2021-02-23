 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String userId = (String) session.getAttribute("userId");
  String adminLoginId = (String) session.getAttribute("adminLoginId");
  String errMsg = (String) request.getAttribute("errMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Greserveログインページ</title>
<jsp:include page="/head.jsp"></jsp:include>

</head>
<body class="bg-light">
<h1>Greserve</h1>
<div class="slider-container">
   <ul id="slider" class="slider">
   	  <li class="slide"><img src="/greserve/img//product_fender01.jpg" alt=""></li>
   	  <li class="slide"><img src="/greserve/img//product_rickenbacker01.jpg" alt=""></li>
   	  <li class="slide"><img src="/greserve/img//product_gibson01.jpg" alt=""></li>
   	  <li class="slide"><img src="/greserve/img//product_mosrite.jpg" alt=""></li>
   	  <li class="slide"><img src="/greserve/img//product_gretsch.jpg" alt=""></li>
   	  <li id="last_clone" class="slide"><img src="/greserve/img//product_fender01.jpg" alt=""></li>
   </ul>
</div>
<div class="container">
<% if(userId == null && adminLoginId == null) { %>
<div class="form-wrapp">
  <form class="my-3 form-login" action= "/greserve/LoginServlet" method="post">
    <div class="form-group row">
      <label for="userId" class="col-sm-3 col-form-label">ユーザーID :</label>
      <div class="col-sm-9">
     	 <input type="text" id="userId" class="form-control" name="userId">
      </div>
   </div>
   <div class="form-group row">
     <label for="password" class="col-sm-3 col-form-label" >パスワード :</label>
     <div class="col-sm-9">
    	<input type="password" id="password" class="form-control" name="pass">
     </div>
   </div>
    <% if(errMsg != null && errMsg.length() > 0 ) { %>
    <p class="alert alert-danger in-login"><%=errMsg %></p>
    <% } %>
    <input class="btn btn-success d-block mt-4" type="submit" value="ログイン">
  </form>
 </div>
  <div class="buttons">
   <p><a class="btn btn-outline-success mx-auto" href="/greserve/Register">新規会員登録</a></p>
   <p><a class="btn btn-outline-success mx-auto" href="/greserve/Admin">管理者専用ページ</a></p>
  </div>
<%}else if(adminLoginId != null && adminLoginId.length() > 0){/*管理者ログイン中*/ %>
 <p class="alert alert-success in-login">管理人：<%=adminLoginId %>さんログイン中</p>
  <div class="buttons">
   <p><a class="btn btn-outline-success mx-auto" href="/greserve/ProductList">商品一覧へ</a></p>
   <p><a class="btn btn-outline-success mx-auto" href="/greserve/Admin">管理者専用ページ</a></p>
  </div>
<%} else { /*ユーザーログイン中*/%>
  <p class="alert alert-success in-login"><%=userId %>さんログイン中</p>
  <div class="buttons">
   <p><a class="btn btn-outline-success mx-auto" href="/greserve/ProductList">商品一覧へ</a></p>
   <p><a class="btn btn-outline-success mx-auto" href="/greserve/MemberInfo">会員情報</a></p>
   <p><a class="btn btn-outline-success mx-auto" href="/greserve/Logout">ログアウト</a></p>
  </div>
<% } %>

</div>

<jsp:include page="/footer.jsp"></jsp:include>

<script>

window.addEventListener('DOMContentLoaded', () => {
	const slider = document.getElementById('slider');
	const slide = document.querySelectorAll('.slide');
	console.log(slide.length);

	let slideCount = 0;
	setInterval(() => {
		slideCount++;
		slider.style.transition = "transform .5s ease-in-out";
		slider.style.transform = "translateX(-" + 100 * slideCount + "%)";
	}, 2000);

	slider.addEventListener('transitionend', () => {
		if(slide[slideCount].id === "last_clone") {
			slideCount = 0;
			slider.style.transition = "none";
			slider.style.transform = "translateX(0%)";
		}
	})

});

</script>
</body>
</html>