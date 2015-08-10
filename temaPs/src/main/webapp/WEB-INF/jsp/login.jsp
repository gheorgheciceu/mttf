<%@ include file="../jsp/head.jsp"%>


<html>
<head>

<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">


<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/resources/css/logIn.css"
	rel="stylesheet">

<style type="text/css">
.password {
	margin-left: 61%;
	color: #515151;
}

.password:hover {
	text-decoration: underline;
	color: #515151;
}

.modal-backdrop {
	z-index: 0;
}

.btn {
	text-shadow: none;
}
</style>
</head>


<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
	tabindex="-1" id="myModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">A&#355i uitat parola ?</h4>
			</div>

			<form class="form-horizontal" method="post"
				action="/forgotten-password">
				<div class="modal-body">
					<p>V&#259 rug&#259m introduce-&#355i adresa dumneavoastr&#259
						de email</p>
					<input type="text" name="email" placeholder="Email"
						autocomplete="off" class="form-control placeholder-no-fix">

				</div>
				<div class="modal-footer">
					<button data-dismiss="modal" class="btn btn-default" type="button">Anulare</button>
					<button type="submit" class="btn btn-primary" type="button">Trimite
						&raquo;</button>
				</div>
			</form>
		</div>
	</div>
</div>

<body onload='document.f.j_username.focus();'>

	<div class="container">

		<header>

			<!-- <h1>
				<strong>PS ASSIGMENT 1</strong>
			</h1>
			<h2>
				Este necesar&#259 <strong>autentificarea</strong> pentru a continua
			</h2> -->

			<br>
			<br>
			<br>
			<br>
		</header>

		<form class="form-signin" name='f' action='/j_spring_security_check'
			method='POST'>
			<c:if test="${param.failed eq true}">
				<div class="alert alert-danger alertPoz">Authentication failed
					! Invalid credentials</div>

			</c:if>

			<c:if test="${param.forgotten eq true}">
				<div class="alert alert-success alertPoz">The password has
					been reset successfully ! Please check your email to see your new
					password</div>
			</c:if>

			<c:if test="${param.forgotten eq false}">
				<div class="alert alert-danger alertPoz">The email address
					isn't registered !</div>
			</c:if>

			<p class="field">
				<input type="text" name='j_username' class="form-control"
					placeholder="adresa de email" required autofocus> <i
					class="fa fa-user fa-4x"></i>
			</p>

			<p class="field">
				<input type="password" name='j_password' class="form-control"
					placeholder="parola" required> <i class="fa fa-lock fa-4x"></i>
			</p>
			<button class="btn btn-lg btn-primary btn-block" type="submit">AUTENTIFICARE</button>
		</form>

		<!-- <a data-toggle="modal" href="#myModal" class="password">Forgotten
			password ?</a> -->

	</div>
</html>