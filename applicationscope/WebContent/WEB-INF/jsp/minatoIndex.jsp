<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.SiteEv" %>
<% SiteEv siteEv = (SiteEv) application.getAttribute("siteEv"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>湊くんのページ</title>
</head>
<body>
<h1>湊くんのページへようこそ</h1>
<a href="/applicationscope/MinatoIndex?action=like">よいね</a>
<%= siteEv.getLike() %>
<a href="/applicationscope/MinatoIndex?action=dislike">よくないね</a>
<%= siteEv.getDislike() %>
</body>
</html>