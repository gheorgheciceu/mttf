<%@ include file="../jsp/head.jsp"%>
<body>
	<%@include file="/WEB-INF/jsp/navBar.jsp"%>
	<div align="center">
		<form:form class="cd-form"  method="post">

			<h4 class="formTitle">Reset Password</h4>

			<!-- <p class="fieldset">
				<input class="fa fa-user" placeholder="Email" name="email" />
			</p> -->
			<p class="fieldset">
				<input class="fa fa-user" placeholder="New password" name="password" />
			</p>
			
			<%-- <p class="fieldset">
				<label class="image-replace cd-email" for="signin-email"><i
					class="fa fa-user"></i></label>
				<form:input path="type" class="full-width has-padding has-border"
					id="signin-email" type="text" placeholder="Account type" />

			</p>

			<p class="fieldset">
				<label class="image-replace cd-password" for="signin-password"><i
					class="fa fa-user"></i></label>
				<form:input path="balance" class="full-width has-padding has-border"
					id="signin-password" type="text" placeholder="Account ballance" />

			</p>
 --%>

			<p class="fieldset">
				<input class="full-width" type="submit" value="INREGISTRARE">
			</p>
		</form:form>
	</div>
</body>
