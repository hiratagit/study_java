<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フォーム演習</title>
</head>
<body>
<h2>お問い合わせフォーム</h2>

<form action="/example/Form" method="post">
お名前：<br>
<input type="text" name="name" ><br><br>
お問い合わせの種類：<br>
<select name="qtype">
  <option value="company">会社について</option>
  <option value="product">製品について</option>
  <option value="support">アフターサポートについて</option>
</select><br><br>
<textarea name="body" ></textarea><br><br>
<input type="submit" value="送信">
</form>
</body>
</html>