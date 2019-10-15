<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="emp/get.action?empno=7788&ename=tomcat">点击链接查询雇员信息---get</a><br/><br/>
	
	<form action="emp/get.action" method="post">
		<input type="submit" value="点击链接查询雇员信息---post">
	</form>
</body>
</html>