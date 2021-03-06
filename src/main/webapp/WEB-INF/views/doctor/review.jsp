<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />

<!-- Favicon-->
<link rel="icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/resources/assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<!-- <link
	href="${pageContext.request.contextPath}/https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" /> -->
<!-- Core theme CSS (includes Bootstrap)-->
<link href="${pageContext.request.contextPath}/resources/css/styles.css"
	rel="stylesheet" />
<title>Doctor Review</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<style>
        	#myform fieldset{
        		display: inline-block;
        		direction: rtl;
        		border:0;
        	}
        	#myform fieldset legend{
        		text-align: left;
        	}
        	#myform input[type=radio]{
        		display: none;
        	}
        	#myform label{
        		font-size: 3em;
        		color: transparent;
        		text-shadow: 0 0 0 #f0f0f0;
        	}
        	#myform label:hover{
        		text-shadow: 0 0 0 #a00;
        	}
        	#myform label:hover ~ label{
        		text-shadow: 0 0 0 #a00;
        	}
        	#myform input[type=radio]:checked ~ label{
        		text-shadow: 0 0 0 #a00;
        	}
        </style>
</head>

<body id="page-top">
	<!-- Navigation-->
	<nav
		class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="/">????????????</a>
		</div>
	</nav>

	<section class="page-section" id="contact" style="margin-top:50px">
		<div class="container">
			<!-- Contact Section Heading-->
			<h2
				class="page-section-heading text-center text-uppercase text-secondary mb-0"
				style="margin-top: 30px">????????????</h2>
			<!-- Icon Divider-->
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<!-- Contact Section Form-->
			<div class="row justify-content-center">
				<div class="col-lg-8 col-xl-7">
					<!-- * * * * * * * * * * * * * * *-->
					<!-- * * SB Forms Contact Form * *-->
					<!-- * * * * * * * * * * * * * * *-->
					<!-- This form is pre-integrated with SB Forms.-->
					<!-- To make this form functional, sign up at-->
					<!-- https://startbootstrap.com/solution/contact-forms-->
					<!-- to get an API token!-->
					<c:choose>
					<c:when test="${sessionScope.loginId != null}">
                          
                    	<h2>??????:</h2><h1>${avg}</h1>
                    	
                   
					<div id="comment-writer">
					<form name="myform" id="myform">
                                    	<fieldset>
                                    		<input type="radio" name="c_star" value="5" id="rate1"><label for="rate1">???</label>
                                    		<input type="radio" name="c_star" value="4" id="rate2"><label for="rate2">???</label>
                                    		<input type="radio" name="c_star" value="3" id="rate3"><label for="rate3">???</label>
                                    		<input type="radio" name="c_star" value="2" id="rate4"><label for="rate4">???</label>
                                    		<input type="radio" name="c_star" value="1" id="rate5"><label for="rate5">???</label>
                                    	</fieldset><br>
											<input type="hidden" id="d_number" name="d_number" value="${review.d_number}">
											<input type="text" id="c_id" name="c_id" value="${sessionScope.loginId}" readonly>
											<textarea type="text" id="c_contents"  name="c_contents" row="15px" placeholder="??????"></textarea>
											<button id="comment-write-btn">????????????</button>
                                    </form>
					</div>
					</c:when>
					</c:choose>
					<div id="comment-list">
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">ID</th>
								<th scope="col">NAME</th>
								<th scope="col">BIRTH</th>
								<th scope="col">PHONE NUMBER</th>
								<th scope="col">GENDER</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${commentList}" var="comment" varStatus="status">
							<tr style="text-center">
								<th scope="row">${status.count}</th>
								<td>${comment.c_id}</td>
								<td>${comment.c_contents}</td>
								<td>???${comment.c_star}</td>
								<td>${comment.c_date}</td>
								<c:choose>
									<c:when test="${sessionScope.loginId eq 'admin'}">
										<td><a href="delete?c_number=${comment.c_number}">??????</a></td>
									</c:when>
									
									<c:when test="${sessionScope.loginId eq comment.c_id}">
										<td><a href="/comment/delete?c_number=${comment.c_number}&d_number=${comment.d_number}">??????</a></td>
									</c:when>
								</c:choose>
							</tr>
							</c:forEach>
						</tbody>
					</table>
					</div>
		
				<!-- Footer About Text-->
				<div class="col-lg-4">
					<h4 class="text-uppercase mb-4">About Freelancer</h4>
					<p class="lead mb-0">
						Freelance is a free to use, MIT licensed Bootstrap theme created
						by <a href="http://startbootstrap.com">Start Bootstrap</a> .
					</p>
				</div>
			</div>
		</div>
	</footer>
	<div class="copyright py-4 text-center text-white">
		<div class="container">
			<small>Copyright &copy; Your Website 2021</small>
		</div>
	</div>
</body>

<script>
	$("#comment-write-btn").click(function() {
		const writer = document.getElementById('c_id').value;
		const commentContents = document.getElementById('c_contents').value;
		const doctorNumber = document.getElementById('d_number').value;
		const star = $('input:radio[name=c_star]:checked').val();
		console.log(star);
		console.log(writer);
		/* var formData = $("#myform").serialize(); */
		$.ajax({
			type : 'post',
			url : '/comment/insert',
			data : {"c_id":writer, "c_contents": commentContents, "d_number":doctorNumber,"c_star":star},
			/* data : formData, */
			dataType : "json",
			success : function(result) {
				let output = "<table>";
				output += "<tr><th>????????????</th>";
				output += "<th>?????????</th>";
				output += "<th>??????</th>";
				output += "<th>????????????</th></tr>";
				for ( let i in result) {
					output += "<tr>";
					output += "<td>" + result[i].c_number + "</td>";
					output += "<td>" + result[i].c_id + "</td>";
					output += "<td>" + result[i].c_contents + "</td>";
					output += "<td>" + result[i].c_date + "</td>";
					output += "<td>" + result[i].c_star + "</td>";
					output += "</tr>";
				}
				output += "</table>";
				document.getElementById('comment-list').innerHTML = output;
				document.getElementById('c_contents').value = '';
			},
			error : function() {
				console.log('?')
			}
		});
	});
</script>
</html>