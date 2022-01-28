<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="/css/styles.css"  />
</head>
<body>

<form action="/login.do" method="post">
<div>
<label>User Name</label>
<input type="text" name="username" />
</div>
<br>
<div>
<label>Password</label>
<input type="password" name="psd" />
</div>
<br>
<input type="submit" value="login" />
</form>
</body>
</html>