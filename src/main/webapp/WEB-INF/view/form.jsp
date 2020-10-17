<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

</head>
<style>
.errors {
	color: red;
}

.ml1 {
	font-weight: 900;
	font-size: 3.5em;
	margin-left: 40px;
	margin-bottom: 15px;
	margin-top: 15px;
}

.ml1 .letter {
	display: inline-block;
	line-height: 1em;
}

.ml1 .text-wrapper {
	position: relative;
	display: inline-block;
	padding-top: 0.1em;
	padding-right: 0.05em;
	padding-bottom: 0.15em;
}

.ml1 .line {
	opacity: 0;
	position: absolute;
	left: 0;
	height: 3px;
	width: 100%;
	background-color: #fff;
	transform-origin: 0 0;
}

.ml1 .line1 {
	top: 0;
}

.ml1 .line2 {
	bottom: 0;
}

body {
	background-image:
		url('https://patch.com/img/cdn20/shutterstock/23735283/20200219/023951/styles/patch_image/public/shutterstock-1104660482___19143846627.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	background-size: 100% 100%;
}

H1 {
	font-size: 40px;
	color: black;
}

label {
	font-family: verdana;
	font-weight: bold;
}

.h1class {
	color: white;
}
</style>

<h1 class="ml1">
	<span class="text-wrapper"> <span class="line line1"></span> <span
		class="letters">Self Assessment of Property Tax Form</span> <span
		class="line line2"></span>
	</span>
</h1>


<div class="container">
	
	<form action="addproperty" id="options" method="post"
		onsubmit="return validate()">
		<div class="form-group">
			<label for="propertyYearOfAssessment" class="control-label col-sm-2">Year
				of Assessment:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"
					id="propertyYearOfAssessment" name="propertyYearOfAssessment"
					required="required">
			</div>

		</div>
		<div class="form-group">
			<label for="propertyOwnerName" class="control-label col-sm-2">Name
				of the Owner:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="propertyOwnerName"
					name="propertyOwnerName" required="required">
			</div>

		</div>


		<div class="form-group">
			<label for="propertyOwnerEmailAddress" class="control-label col-sm-2">Email:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"
					id="propertyOwnerEmailAddress" name="propertyOwnerEmailAddress"
					required="required">
			</div>
		</div>

		<div class="form-group">
			<label for="propertyAddress" class="control-label col-sm-2">Address
				of Property:</label>
			<div class="col-sm-10">

				<textarea id="propertyAddress" name="propertyAddress" rows="3"
					cols="40" required="required" class="form-control"></textarea>

			</div>

		</div>

		<div class="form-group">
			<label for="propertyZone" class="control-label col-sm-2">Zonal
				classification: </label> <select name="propertyZone" id="propertyZone"
				class="btn btn-primary dropdown-toggle" data-toggle="dropdown">

				<c:forEach var="zone" items="${zoneList}">

					<option value="${zone.zoneId}">${zone.zoneName}</option>

				</c:forEach>
			</select>


		</div>

		<div class="form-group">
			<label for="propertyDescription" class="control-label col-sm-2">Description
				of the property: </label> <select name="propertyDescription"
				id="propertyDescription" class="btn btn-primary dropdown-toggle"
				data-toggle="dropdown">

				<c:forEach var="desc" items="${descList}">

					<option value="${desc.descriptionId}">${desc.descriptionType}</option>

				</c:forEach>
			</select>
		</div>

		<div class="form-group">
			<label for="propertyStatus" class="control-label col-sm-2">Status:
			</label> <select name="propertyStatus" id="propertyStatus"
				class="btn btn-primary dropdown-toggle" data-toggle="dropdown">

				<option>Owner
				<option>Tenated
			</select>
		</div>



		<div class="form-group">
			<label for="propertyYearOfConstruction"
				class="control-label col-sm-2">Building constructed year:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"
					id="propertyYearOfConstruction" name="propertyYearOfConstruction"
					required="required">
			</div>

		</div>


		<div class="form-group">
			<label for="propertyAreaInSquareFoot" class="control-label col-sm-2">
				Building up Area (Square feet):</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"
					id="propertyAreaInSquareFoot" name="propertyAreaInSquareFoot"
					required="required">
			</div>
		</div>

		<div class="form-group">
			<label for="propertyTotalPayableTaxAmount"
				class="control-label col-sm-2"> Total Tax Payable:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"
					id="propertyTotalPayableTaxAmount"
					name="propertyTotalPayableTaxAmount" required="required" value=""
					readonly="readonly">
			</div>
		</div>


		<input type="submit" value="Pay Tax" class="btn btn-primary">

		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <a
			href="cancel"><button type="button" class="btn btn-primary">Cancel</button></a><br>

	</form>
</div>

<script type="text/javascript">
	$(document).ready(
			function() {
				$('#propertyTotalPayableTaxAmount').focus(
						function() {
							var area = $('#propertyAreaInSquareFoot').val();
							if(area>1)
								{
							debugger;
							
							var age = $('#propertyYearOfAssessment').val()
									- $('#propertyYearOfConstruction').val();
							$.ajax({
								type : 'GET',
								url : window.location.origin
										+ '/rest/loadtotalprice/' + area + '/'
										+ age,
								success : function(result) {
									$('#propertyTotalPayableTaxAmount').val(
											result);
								}
							});
						}
						});
			});
</script>



<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/additional-methods.min.js"
	integrity="sha256-vb+6VObiUIaoRuSusdLRWtXs/ewuz62LgVXg2f1ZXGo="
	crossorigin="anonymous"></script>




<script>




	$.validator.addMethod("agevalidation", function(value, element) {
		var YearOfAssessment = $('#propertyYearOfAssessment').val();
		var YearOfConstruction = $('#propertyYearOfConstruction').val();
		if (YearOfAssessment <= YearOfConstruction) {
			return false;
		}
		return true;

	}, "Construction Year Should be Less than Assessment Year");
	
	
	 $.validator.addMethod("yearvalidation", function (value, element) {
		var currentDate = new Date();
		 var currentYear = currentDate.getFullYear();
		var inputYear = $('#propertyYearOfAssessment').val();
	
		if (inputYear > currentYear) {
			return false;
		} 
		
		return true;
	}, "Don't enter future date ...!");
	 

	$.validator.addMethod("emailvalidation", function(value, element) {

		var email_pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if (!($('#propertyOwnerEmailAddress').val().match(email_pattern))) {
			return false;
		}
		return true;
	}, "Enter the valid email.....!");
	
 $.validator.addMethod("namevalidation", function(value, element) {

		var name_pattern=/^[a-zA-Z\s]+$/;
		if (!($('#propertyOwnerName').val().match(name_pattern)) && $('#propertyOwnerName').val().length>25 ) {
			return false;
		}
		return true;
	}, "Enter the Valid Name......!"); 
 
 $.validator.addMethod("namelength", function(value, element) {

		
		if ($('#propertyOwnerName').val().length>25) {
			return false;
		}
		return true;
	}, "Length should be less than 25......!"); 
 
 
 $.validator.addMethod("areavalidation", function(value, element) {

		
		if (($('#propertyAreaInSquareFoot').val())<=0) {
			return false;
		}
		return true;
	}, "Enter the Valid Area......!"); 

	
	
	
	$("form").validate({
		errorClass: 'errors',
		rules : {
			propertyYearOfAssessment : {
				required : true,
				minlength : 4,
				maxlength : 4,
				yearvalidation:true,
				number : true
			},
			propertyOwnerName : {
				required : true,
				namevalidation:true,
				maxlength:25
			},
			propertyStatus : {
				required : true		
			},
			propertyOwnerEmailAddress : {
				required : true,
				emailvalidation : true
			},
			propertyAddress : {
				required : true
			},
			propertyZone : {
				required : true
			},
			propertyDescription : {
				required : true
			

			},
			propertyYearOfConstruction : {
				required : true,
				minlength : 4,
				maxlength : 4,
				number : true,
				agevalidation : true
			},
			propertyAreaInSquareFoot : {
				required : true,
				areavalidation:true,
				number : true
			},
			propertyTotalPayableTaxAmount : {
				required : true,
			}

		}
	,
	
	 messages: {
		 propertyYearOfAssessment : {
				
				minlength : "length should be equal to 4",
				maxlength : "length should be equal to 4"
			},
		 
		propertyYearOfConstruction : {
				minlength : "length should be equal to 4",
				maxlength : "length should be equal to 4"
			},
			
	     propertyOwnerName : {	
				maxlength:"length should be less than and equal to 25"
			}
	    } 
	})
</script>

<script src="js/custom.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/animejs/2.0.2/anime.min.js"></script>
<script>

var textWrapper = document.querySelector('.ml1 .letters');
textWrapper.innerHTML = textWrapper.textContent.replace(/\S/g, "<span class='letter'>$&</span>");

anime.timeline({loop: true})
  .add({
    targets: '.ml1 .letter',
    scale: [0.3,1],
    opacity: [0,1],
    translateZ: 0,
    easing: "easeOutExpo",
    duration: 600,
    delay: (el, i) => 70 * (i+1)
  }).add({
    targets: '.ml1 .line',
    scaleX: [0,1],
    opacity: [0.5,1],
    easing: "easeOutExpo",
    duration: 700,
    offset: '-=875',
    delay: (el, i, l) => 80 * (l - i)
  }).add({
    targets: '.ml1',
    opacity: 0,
    duration: 1000,
    easing: "easeOutExpo",
    delay: 1000
  });
</script>



</html>