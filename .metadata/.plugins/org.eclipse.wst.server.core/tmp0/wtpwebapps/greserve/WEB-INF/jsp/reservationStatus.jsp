<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.Reservation, java.util.List, java.util.ArrayList" %>
<%
	List<Reservation> reservationList = (List<Reservation>) session.getAttribute("reservationList");
	String contextPath = request.getContextPath().toString();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約状況確認</title>
<jsp:include page="/head.jsp"></jsp:include>
</head>
<body class="adminscreen">
<h1>予約状況確認</h1>
<div class="container">

<% if(reservationList == null || reservationList.size() == 0) { %>
<p class="notreserve text-center">予約はありません</p>
<% } else { %>
  <!--  <div class="reservation-status">-->
  <div class="card-deck row mb-5">
  <% for(Reservation reserve : reservationList) { %>

  <div class="card col-6">
    <img class="card-img-top mt-2" src="<%=contextPath %>/img/<%=reserve.getImgfileNm() %>" alt="">
    <div class="card-body">
      <ul>
          <li class="card-title text-warning"><u>購入者ID：<%= reserve.getUserId() %></u></li>
    	  <li class="card-text">型番：<%= reserve.getProductId() %></li>
    	  <li class="card-text">品名：<%= reserve.getProductNm() %></li>
    	  <li class="card-text">メーカー：<%= reserve.getMakerNm() %></li>
    	  <li class="card-text">価格：<%=String.format("%,d", reserve.getPrice()) %> 円</li>
      </ul>
    </div>
  </div>

  <%} %>
  </div>
<% } %>

  <div class="buttons">
    <p><a class="btn btn-outline-success mx-auto" href="/greserve/ProductList">商品一覧へ</a></p>
	<p><a class="btn btn-outline-success mx-auto" href="/greserve/Admin">管理画面トップへ</a></p>
  </div>
</div>
</body>
</html>