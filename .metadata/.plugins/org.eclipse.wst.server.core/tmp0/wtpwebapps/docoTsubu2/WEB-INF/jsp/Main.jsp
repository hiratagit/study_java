<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User, model.Mutter, java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>どこつぶメイン</h1>

<p><c:out value="${ loginUser.name }"/>さんログイン中</p>
<c:choose>
  <c:when test="${loginUser.name.equals(\"平田信和\")}" >
    <P>あなたは、確かに<c:out value="${loginUser.name }"/>さんです</P>
  </c:when>
  <c:otherwise>
    <P>あなたは、<c:out value="${loginUser.name }"/>さんではありません</P>
  </c:otherwise>
</c:choose>
<a href="/docoTsubu2/Logout">ログアウト</a>
<p><a href="/docoTsubu2/Main">更新</a></p>
<form action="/docoTsubu2/Main" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">

<c:if test="${not empty errorMsg }">
<p><c:out value="${ errorMsg }"/></p>
</c:if>

<c:forEach var="mutter" items="${mutterList}">
 <p>[ <c:out value="${mutter.userName}"  /> ] :
       <c:out value="${ mutter.text}"/>
 </p>

</c:forEach>
</form>
</body>
</html>