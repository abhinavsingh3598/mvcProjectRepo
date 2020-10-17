<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta charset="ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>

<style>
body {
    background-image:
        url('https://www.framestr.com/wp-content/uploads/2017/08/report-templates.png');
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: cover;
    background-size: 100% 150%;
}
</style>

<body>
	<div align="center" class="container">




		<table class="table table-dark table-striped">

			<tr>
				<th>Zone Name</th>
				<th>Property Type</th>
				<th>Amount collected</th>

			</tr>

			<c:forEach var="pro" items="${zoneList}">
				<tr>
					<td rowspan="2">${pro.zoneName}</td>
					<td>Owner</td>

					<c:forEach var="report" items="${report}">

						<c:forEach var="report1" items="${report.value}">

							<c:if test="${report.key == pro.zoneName}">

						
								<c:if test="${report1.key == 'Owner'}">
									<td>${report1.value}</td>
								</c:if>
							</c:if>

						</c:forEach>
					</c:forEach>

				</tr>
				<tr>
					<td>Tenated</td>

					<c:forEach var="report" items="${report}">

						<c:forEach var="report1" items="${report.value}">

							<c:if test="${report.key  == pro.zoneName}">
								
								<c:if test="${report1.key  == 'Tenated'}">
									<td>${report1.value}</td>
								</c:if>
							</c:if>
						</c:forEach>
					</c:forEach>

				</tr>
			</c:forEach>





		</table>
	</div>

	
	

</body>
<script type="text/javascript">

	</script>
</html>
