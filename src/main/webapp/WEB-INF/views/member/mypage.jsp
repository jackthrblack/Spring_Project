<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link
	href="${pageContext.request.contextPath}/https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="${pageContext.request.contextPath}/resources/css/styles.css"
	rel="stylesheet" />
<title>MyPage</title>

</head>

<body id="page-top">
	<!-- Navigation-->
	<nav
		class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="/">병원이름</a>
		</div>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ms-auto">

				<li class="nav-item mx-0 mx-lg-1"><a
					class="nav-link py-3 px-0 px-lg-3 rounded"
					href="/reservation/rList?m_number=${loginNumber}">회원목록</a></li>

			</ul>
		</div>
	</nav>

	<section class="page-section" id="contact">
		<div class="container">
			<!-- Contact Section Heading-->
			<h2
				class="page-section-heading text-center text-uppercase text-secondary mb-0"
				style="margin-top: 30px">My page</h2>
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

					<form data-sb-form-api-token="API_TOKEN">
						<!-- Id input-->
						<div class="form-floating mb-3">
							<input class="form-control" value="${mypage.m_id}" type="text"
								readonly> <label for="id">아이디</label>
						</div>

						<!-- Password input-->
						<div class="form-floating mb-3">
							<input class="form-control" type="text" value="${mypage.m_pw}"
								readonly> <label>비밀번호</label>
						</div>

						<!-- Name input-->
						<div class="form-floating mb-3">
							<input class="form-control" type="text" value="${mypage.m_name}"
								readonly> <label>이름</label>
						</div>

						<!-- Date input-->
						<div class="form-floating mb-3">
							<input class="form-control" type="text" value="${mypage.m_date}"
								readonly> <label>생년월일</label>
						</div>

						<!-- Phone input-->
						<div class="form-floating mb-3">
							<input class="form-control" type="text" value="${mypage.m_phone}"
								readonly> <label>핸드폰번호</label>
						</div>

						<!-- Gender input-->
						<div class="form-floating mb-3">
							<input class="form-control" type="text"
								value="${mypage.m_gender}" readonly> <label>성별</label>
						</div>


						<!-- Submit Button-->
						<a href="/member/pwcheck?m_number=${mypage.m_number}"> <input
							type="button" class="btn btn-primary btn-xl" style="float: right"
							value="수정"></input></a>
					</form>

				</div>
			</div>
		</div>
	</section>


	<footer class="footer text-center">
		<div class="container">
			<div class="row">
				<!-- Footer Location-->
				<div class="col-lg-4 mb-5 mb-lg-0">
					<h4 class="text-uppercase mb-4">Location</h4>
					<p class="lead mb-0">
						2215 John Daniel Drive <br /> Clark, MO 65243
					</p>
				</div>
				<!-- Footer Social Icons-->
				<div class="col-lg-4 mb-5 mb-lg-0">
					<h4 class="text-uppercase mb-4">Around the Web</h4>
					<a class="btn btn-outline-light btn-social mx-1" href="#!"><i
						class="fab fa-fw fa-facebook-f"></i></a> <a
						class="btn btn-outline-light btn-social mx-1" href="#!"><i
						class="fab fa-fw fa-twitter"></i></a> <a
						class="btn btn-outline-light btn-social mx-1" href="#!"><i
						class="fab fa-fw fa-linkedin-in"></i></a> <a
						class="btn btn-outline-light btn-social mx-1" href="#!"><i
						class="fab fa-fw fa-dribbble"></i></a>
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
</html>