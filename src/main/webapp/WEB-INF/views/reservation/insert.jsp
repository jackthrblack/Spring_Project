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
<link
	<%-- href="${pageContext.request.contextPath}/https://fonts.googleapis.com/css?family=Montserrat:400,700" --%>
	rel="stylesheet" type="text/css" />
<link
	<%-- href="${pageContext.request.contextPath}/https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" --%>
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="${pageContext.request.contextPath}/resources/css/styles.css"
	rel="stylesheet" />
<title>Reservation</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

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
				style="margin-top: 30px">예약</h2>
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
					<div>
					<form action="/reservation/insert" method="post"
						data-sb-form-api-token="API_TOKEN">
						<!-- 예약자이름 input-->
						<div class="form-floating mb-3">
						<input type="hidden" name="m_number" value="${rname.m_number}">
							<input class="form-control" name="r_name" type="text" value="${rname.m_name}" readonly> 
							<label for="r_name">예약자 이름</label>
						</div>
						
						<!-- 질병 input-->
						<div class="form-floating mb-3">
							<label>질병</label><br><br>
						</div>
						
						<div class="form-floating mb-3">
							<select name="r_dsName" id="sym" onchange="sym2()">
									<option>선택하세요</option>
									<c:forEach items="${di}" var="di">
										<option value="${di.ds_id}">${di.ds_id}</option>
									</c:forEach>
							</select>
						</div>
						<div id="sys2">
						</div><br>
						
						<%-- <!-- 의사선택 -->
						<div class="form-floating mb-3">
							<label>의사</label><br><br>
						</div>
						
						<div class="form-floating mb-3">
							<select name="d_number" id="d_number">
								<option>선택하세요</option>
								<c:forEach items="${dname}" var="d">
									<option value="${d.d_number}">${d.d_name}</option>
								</c:forEach>
							</select>
						</div> --%>
						
						<!-- 의사선택 -->
						<div class="form-floating mb-3">
							<label>의사</label><br><br>
						</div>
						
						<div class="form-floating mb-3">
							<select name="d_number" id="d_number">
								<option>선택하세요</option>
								<c:forEach items="${dname}" var="d">
									<option value="${d.d_number}">${d.d_name}</option>
								</c:forEach>
							</select>
						</div>
						
						<!-- Date input-->
						<div id="datetime">
						<div class="form-floating mb-3">
							<input class="form-control" id="r_date" name="r_date" type="date"> 
							<label for="date">예약날짜</label>
						</div>
						
						
						<!-- time input -->
						<fieldset>
						<legend>예약시간</legend><br>
								
								<input type="radio" class="btn-check" name="r_time" id="option" value="10:00" autocomplete="off">
								<label class="btn btn-outline-secondary" for="option">10:00</label>
							
								<input type="radio" class="btn-check" name="r_time" id="option1" value="10:30" autocomplete="off">
								<label class="btn btn-outline-secondary" for="option1">10:30</label>
								
								<input type="radio" class="btn-check" name="r_time" id="option2" value="11:00" autocomplete="off">
								<label class="btn btn-outline-secondary" for="option">11:00</label>
								
								<input type="radio" class="btn-check" name="r_time" id="option3" value="11:30" autocomplete="off">
								<label class="btn btn-outline-secondary" for="option3">11:30</label>
								
								<input type="radio" class="btn-check" name="r_time" id="option4" value="14:00" autocomplete="off">
								<label class="btn btn-outline-secondary" for="option4">14:00</label><br>
								
								<input type="radio" class="btn-check" name="r_time" id="option5" value="14:30" autocomplete="off">
								<label class="btn btn-outline-secondary" for="option5">14:30</label>
								
								<input type="radio" class="btn-check" name="r_time" id="option6" value="15:00" autocomplete="off">
								<label class="btn btn-outline-secondary" for="option6">15:00</label>
								
								<input type="radio" class="btn-check" name="r_time" id="option7" value="15:30" autocomplete="off">
								<label class="btn btn-outline-secondary" for="option7">15:30</label>
								
								<input type="radio" class="btn-check" name="r_time" id="option8" value="16:00" autocomplete="off">
								<label class="btn btn-outline-secondary" for="option8">16:00</label>
								
								<input type="radio" class="btn-check" name="r_time" id="option9" value="16:30" autocomplete="off">
								<label class="btn btn-outline-secondary" for="option9">16:30</label>
								
						</fieldset></div><br>
                          	<button class="btn btn-primary btn-xl" id="submitButton"
							type="submit" >예약하기</button>
                     </form>
                    </div>
				</div>
			</div>
		</div>
		
	</section>



	<footer class="footer text-center">
		<div class="container" >
			<div class="row">
				<!-- Footer Location-->
				<div class="col-lg-4 mb-5 mb-lg-0" >
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

<script>
	function sym2(){
		const select = $("#sym option:selected").val();
		const view = document.getElementById('sys2');
		
		console.log(select)
		$.ajax({
			type:"post",
			url : '/symptom/sym',
			data: {"ds_id":select},
			dataType:'json',
			success : function(result){
				
				let output = "<form action = \"/reservation/insert\", method=\"post\">";
				$.each(result, function(i){  
					
					output += "<input name=\"r_symptom\" type=\"checkbox\" value=\""+result[i].s_id+"\">" + result[i].s_id;
				})
				
				output += "</form>";
				view.innerHTML = output;
				
			},
			error:function(){
				console.log('?')
				
			}
		})
		};
</script>

<script>
	$("#datetime").click(function(){
	
		const rdate = document.getElementById('r_date').value;
		const rtime = $('input:radio[name=r_time]:checked').val();
		const dnum = $("#d_number").val();
		console.log(rdate);
		console.log(rtime);
		console.log(dnum);
	
		$.ajax({
			type : 'post',
			url : '/reservation/check',
			data : { 
				"r_date":rdate, 
				"r_time":rtime,
				"d_number":dnum
				},
			dataType : 'text',
			success : function(result){
				if(result=="ok"){
					alert('예약 가능한 시간입니다.');
				}else{
					alert("이미 예약된 시간입니다.");
				}
			},
			error : function(){
				console.log("?");
			}
		})
});
	
</script>
</html>