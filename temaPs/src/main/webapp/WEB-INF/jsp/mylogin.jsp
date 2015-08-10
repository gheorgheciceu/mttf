<%@ include file="../layout/taglib.jsp"%>
<link
	href="${pageContext.request.contextPath}/resources/css/mylogin.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/mylogin-responsive.css"
	rel="stylesheet">
<!-- Modal -->
<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
	tabindex="-1" id="myModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">A&#355i uitat parola ?</h4>
			</div>
			<div class="modal-body">
				<p>V&#259 rug&#259m introduce-&#355i adresa dumneavoastr&#259 de
					email</p>
				<input type="text" name="email" placeholder="Email"
					autocomplete="off" class="form-control placeholder-no-fix">

			</div>
			<div class="modal-footer">
				<button data-dismiss="modal" class="btn btn-default" type="button">Anulare</button>
				<button class="btn btn-primary" type="button">Trimite
					&raquo;</button>
			</div>
		</div>
	</div>
</div>
<!-- modal -->
<body class="login-body" onload='document.f.j_username.focus();'>
	<div class="container">
		<form class="form-signin" action="/j_spring_security_check"
			method="POST">
			<div class="form-signin-heading text-center">
				<h1 class="sign-title">
					<c:out value="Autentificare" />
				</h1>
				<img
					src="${pageContext.request.contextPath}/resources/images/autoRallyLogo.jpg"
					alt="" />
			</div>
			<div class="login-wrap">
				<input type="email" name='j_username' class="form-control"
					placeholder="Email" autofocus required> <input
					type="password" name='j_password' class="form-control"
					placeholder="Parol&#259" required>

				<button class="btn btn-lg btn-login btn-block" type="submit">
					<i class="fa fa-check"></i>
				</button>
				<div class="registration"></div>
				<label class="checkbox"> <span class="pull-right"> <a
						data-toggle="modal" href="#myModal">A&#355i uitat parola ?</a>
				</span>
				</label>
			</div>
		</form>

	</div>
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-1.10.2.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/modernizr.min.js"></script>

</body>

