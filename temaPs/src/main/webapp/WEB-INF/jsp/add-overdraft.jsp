<%@ include file="../jsp/head.jsp"%>
<body>
	<%@include file="/WEB-INF/jsp/navBar.jsp"%>

overdraft
	<div align="center">
		<form:form class="cd-form" modelAttribute="overdraft" method="post">

			<h4 class="formTitle">Give Overdraft</h4>

			<p class="fieldset">
				<input class="fa fa-user" placeholder="Client Id" name="clientId" />
			</p>
			
			<p class="fieldset">
				<label class="image-replace cd-email" for="signin-email"><i
					class="fa fa-user">Limit          </i></label>
				<form:input path="limit" class="full-width has-padding has-border"
					id="signin-email" type="text" placeholder="Limit" />

			</p>

			<p class="fieldset">
				<label class="image-replace cd-password" for="signin-password"><i
					class="fa fa-user">Interest Rate</i></label>
				<form:input path="interestRate" class="full-width has-padding has-border"
					id="signin-password" type="text" placeholder="interest rate" />

			</p>
			<p class="fieldset">
				<label class="image-replace cd-password" for="signin-password"><i
					class="fa fa-user">Amount Granted </i></label>
				<p class="fieldset">
				<input class="fa fa-user" placeholder="Ammount Granted" name="ammountGranted" />
			</p>

			</p>


			<p class="fieldset">
				<input class="full-width" type="submit" value="INREGISTRARE">
			</p>
		</form:form>
	</div>
</body>
</html>