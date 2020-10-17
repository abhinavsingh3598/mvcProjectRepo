<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
   
<style>
* {
  text-align: center;
  color: blue;
  background-color: pink;
  
  body {
	background-image:
		url('https://patch.com/img/cdn20/shutterstock/23735283/20200219/023951/styles/patch_image/public/shutterstock-1104660482___19143846627.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	background-size: 100% 100%;
}
  
}
h1.center {
  text-align: center;
  color: red;
}
</style>
<body>
<h1>ApplicationName: ${ApplicationName}</h1>
<h4>Status: ${Status}</h4>
<h4>ErrorMessage: ${ErrorMessage}</h4>

</body>
</html>