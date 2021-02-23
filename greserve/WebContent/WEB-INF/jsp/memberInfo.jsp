<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account, model.Product, java.util.List" %>
<% Account account = (Account) session.getAttribute("account");
   List<Product> reserveList = (List<Product>) session.getAttribute("reservationList");
   int sumPrice = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報閲覧</title>
<jsp:include page="/head.jsp"></jsp:include>
</head>
<body class="bg-light">
<h1>会員情報閲覧</h1>
<div class="container">
<div class="table mx-auto row mb-5" >
  <table class="table table-bordered col-sm-10 m-auto bg-white mb-2">
    <tr><th>ユーザーID</th><td><%= account.getUserId() %></td></tr>
    <tr><th>お名前</th><td><%= account.getName() %></td></tr>
    <tr><th>メールアドレス</th><td>
    <% if( account.getMail() == null || account.getMail().length() == 0) { %>
    未登録
    <% } else { %>
    <%=account.getMail() %>
    <% } %>
    </td></tr>
  </table>
</div>
<div class="reservation-list row mb-4">
<h3 class="col-12">予約済商品</h3>
<% if(reserveList == null || reserveList.size() == 0){ %>
<p class="notreserved col-12 text-center text-secondary">予約済商品はありません</p>
<%} else { %>
  <% for(Product product : reserveList) { %>
  <div class="reservation-list_box mx-auto col-sm-10 border border p-0 mb-2 bg-white">
   <ul class="m-0 py-3 pl-4 pr-0">
     <li>品　　番：<%=product.getProductId() %></li>
     <li>品　　名：<%=product.getProductNm() %></li>
     <li>メーカー：<%=product.getMakerNm() %></li>
     <li>価　　格：<%=String.format("%,d", product.getPrice()) %> 円</li>
   </ul>
  </div>
  <% sumPrice += product.getPrice();  } %>
<p class="sumprice text-right mt-2 col-10 mx-auto alert alert-success"><span style="text-decoration: underline;">合計金額：<%= String.format("%,d", sumPrice) %> 円</span></p>
<%} %>
</div>
<div class="buttons">
	<p><a class="btn btn-outline-success mx-auto" href="/greserve/index.jsp">トップへ</a></p>
</div>
</div>
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>