<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<style>
body {
	background-image:
		url('https://d27p8o2qkwv41j.cloudfront.net/wp-content/uploads/2016/07/shutterstock_262923179-e1500871070126.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	background-size: 100% 100%;
}

div {
	font-weight: bold;
	font-family: verdana;
	color: red;
	font-size: 40px;
}

.ml15 {
	font-weight: 800;
	font-size: 3.8em;
	text-transform: uppercase;
	letter-spacing: 0.5em;
}

.ml15 .word {
	display: inline-block;
	line-height: 1em;
}

h1 {
	color: white;
}
</style>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/animejs/2.0.2/anime.min.js"></script>
<body>
	<c:if test="${valid != null}">
		<h1 class="ml15">
			<span class="word">Data</span> <span class="word">Saved</span>
		</h1>

	</c:if>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<a href="form"><button type="button"
			class="btn btn-secondary btn-lg btn-block"><spring:message code = "self-assessment" /></button></a>
	<br>
	<br>
	<br>
	<br>
	<a href="report"><button type="button"
			class="btn btn-secondary btn-lg btn-block"><spring:message code = "zone-wise report" /></button></a>
	<br>
	

</body>

<script>anime.timeline({loop: true})
  .add({
    targets: '.ml15 .word',
    scale: [14,1],
    opacity: [0,1],
    easing: "easeOutCirc",
    duration: 800,
    delay: (el, i) => 800 * i
  }).add({
    targets: '.ml15',
    opacity: 0,
    duration: 1000,
    easing: "easeOutExpo",
    delay: 1000
  });</script>
</html>