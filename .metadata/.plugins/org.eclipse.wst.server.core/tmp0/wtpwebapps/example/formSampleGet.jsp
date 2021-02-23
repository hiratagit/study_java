<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/example/FormSampleServletGet" method="GET">

名前：<br>
<input type="text" name= "name"><br>
性別：<br>
男<input type="radio" name="gender" value="0">
女<input type="radio" name="gender" value="1">
<input type="hidden" name ="hideparam" value="隠れた値なのだ">
<input type="submit" value="送信">
</form>

</body>
</html>