<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<form action="users/import" method="post" enctype="multipart/form-data">
		<input type="file" name="file" />
		<input type="submit" value="import one file" />
	</form>
	<form action="users/imports" method="post"	enctype="multipart/form-data">
		<input type="file" name="file1" /> 
		<input type="file" name="file1" />
		<input type="submit" value="import more file" />
	</form>
</body>
</html>
