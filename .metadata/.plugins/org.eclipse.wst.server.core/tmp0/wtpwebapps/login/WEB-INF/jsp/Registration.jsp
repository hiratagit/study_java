<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ商店</title>
</head>
<body>
<h2>会員登録</h2>

<form action="/login/Registration" method="post">
<table>
<tr><td>ユーザーID:</td><td><input type="text" name="userId"></td></tr>
<tr><td>パスワード:</td><td><input type="password" name="pass"></td></tr>
<tr><td>メール:</td><td><input type="text" name="mail"></td></tr>
<tr><td>名前：</td><td><input type="text" name="name"></td></tr>
<tr><td>年齢：</td><td><input type="number" name="age"></td></tr>
</table>
<br>
<input type="submit" value="登録する">
</form>
</body>
</html>