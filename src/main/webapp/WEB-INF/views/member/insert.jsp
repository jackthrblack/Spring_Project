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
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	function idDp() {
		const id = document.getElementById("m_id").value;
		const Ch = document.getElementById("idCh");

		$.ajax({
			type : 'post',
			url : '/member/idDp',
			data : {
				'm_id' : id
			},
			datatype : 'text',
			success : function(result) {
				if (result == "ok") {
					Ch.style.color = 'green';
					Ch.innerHTML = 'GOOD';
				} else {
					Ch.style.color = 'red';
					Ch.innerHTML = '이미 있는 아이디 입니다.';
				}
			},
			erroe : function() {
				console.log("이러지마 제발");
			}
		});

	}
</script>
</head>

<body id="page-top">
	<!-- Navigation-->
	<nav
		class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="/">병원이름</a>
			<button
				class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded"
				type="button" data-bs-toggle="collapse"
				data-bs-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
		</div>
	</nav>

	<section class="page-section" id="contact">
		<div class="container">
			<!-- Contact Section Heading-->
			<h2
				class="page-section-heading text-center text-uppercase text-secondary mb-0"
				style="margin-top: 30px">회원가입</h2>
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
					<form action="/member/insert" method="post"
						data-sb-form-api-token="API_TOKEN">
						<!-- Id input-->
						<div class="form-floating mb-3">
							<input class="form-control" name="m_id" id="m_id" type="text" onblur="idDp()" > 
							<label for="id">아이디</label> 
							<span id="idCh"> </span> <br>
						</div>

						<!-- Password input-->
						<div class="form-floating mb-3">
							<input class="form-control" name="m_pw" id="m_pw" type="password"> 
							<label for="pw">비밀번호</label>
						</div>

						<!-- Name input-->
						<div class="form-floating mb-3">
							<input class="form-control" name="m_name" type="text"> 
							<label for="name">이름</label>
						</div>

						<!-- Date input-->
						<div class="form-floating mb-3">
							<input class="form-control" name="m_date" type="date"> 
							<label for="date">생년월일</label>
						</div>

						<!-- Phone input-->
						<div class="form-floating mb-3">
							<input class="form-control" name="m_phone" type="text"> 
							<label for="phone">핸드폰번호</label>
						</div>

						<!-- Gender input-->
						<div class="form-floating mb-3">
							<div>
								<label class="form-label" id="label_font"
									style="font-size: 15px;">성별</label> <br>
								<div class="btn-group btn-group-lg" role="group"
									aria-label="Basic radio toggle button group">
									
										<input type="radio" class="btn-check" value="남자" name="m_gender" id="success-outlined" autocomplete="off" checked>
										<label class="btn btn-outline-success" for="success-outlined">남자</label>
										
										<input type="radio" class="btn-check" value="여자" name="m_gender" id="success-outlined2" autocomplete="off">
										<label class="btn btn-outline-success" for="success-outlined2">여자</label>
										
										<input type="radio" class="btn-check" value="x" name="m_gender" id="success-outlined3" autocomplete="off">
										<label class="btn btn-outline-success" for="success-outlined3">선택안함</label>
									
								</div>
							</div>
						</div>

						<!-- Submit Button-->

						<button class="btn btn-primary btn-xl" id="submitButton"
							type="submit">Join</button>

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
            <div class="container"><small>Copyright &copy; Your Website 2021</small></div>
        </div>
</body>
</html>