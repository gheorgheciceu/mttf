
<%@ include file="../jsp/head.jsp"%>
<body>
	<%@include file="/WEB-INF/jsp/navBar.jsp"%>
	<div align="center">
		<form:form class="cd-form" modelAttribute="customer" method="post">

			<h4 class="formTitle">Register New Customer</h4>
			<form:input path="id" class="full-width has-padding has-border"
				id="signin-email" type="text" placeholder="Customer first name"
				/>
			<p class="fieldset">
				<label class="image-replace cd-email" for="signin-email"><i
					class="fa fa-user"></i></label>
				<form:input path="firstName"
					class="full-width has-padding has-border" id="signin-email"
					type="text" placeholder="Customer first name" />

			</p>

			<p class="fieldset">
				<label class="image-replace cd-password" for="signin-password"><i
					class="fa fa-user"></i></label>
				<form:input path="lastName"
					class="full-width has-padding has-border" id="signin-password"
					type="text" placeholder="Customer Last Name" />

			</p>

			<p class="fieldset">
				<label class="image-replace cd-email" for="signin-email"><i
					class="fa fa-envelope-o"></i></label>
				<form:input path="email" class="full-width has-padding has-border"
					id="signin-email" type="email" placeholder="Customer email address" />

			</p>

			<p class="fieldset">
				<label class="image-replace cd-password" for="signin-password"><i
					class="fa fa-user"></i></label>

				<form:input path="cnp" class="full-width has-padding has-border"
					id="signin-email" type="text" placeholder="Customer id" />

			</p>
			<p class="fieldset">
				<label class="image-replace cd-password" for="signin-password"><i
					class="fa fa-user"></i></label>
				<form:input path="adress" class="full-width has-padding has-border"
					id="signin-password" type="text" placeholder="Customer address" />

			</p>




			<p class="fieldset">
				<input class="full-width" type="submit" value="UPDATE CUSTOMER!">
			</p>
		</form:form>
	</div>
</body>
