<%@ include file="../jsp/head.jsp"%>
<body>
	<%@include file="/WEB-INF/jsp/navBar.jsp"%>
	<div align="center">
			<form class="cd-form" method="post">

			<h4 class="formTitle">Transfer</h4>

			<p class="fieldset">
			<label class="image-replace cd-password" for="signin-password"><i
					class="fa fa-user">Account to which the money is transfered</i></label>
				<select id="id2" name="id2" >
					<c:forEach var="accounts" items="${accounts}">
						<option value="${accounts.id}">${accounts.id}</option>
					</c:forEach>
				</select>
			</p>

			
			<p class="fieldset">
				<input class="fa fa-user" placeholder="Ammount" name="amount" />
			</p>
			<p class="fieldset">
				<input class="full-width" type="submit" value="Transfer">
			</p>
		</form>
	</div>
</body>
