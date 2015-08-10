<%@ include file="../jsp/head.jsp"%>
<body>
	<%@include file="/WEB-INF/jsp/navBar.jsp"%>
	<div align="center">
		<form class="cd-form" method="post">

			<h4 class="formTitle">Transfer</h4>

			<p class="fieldset">
				<input class="fa fa-user" placeholder="From Accunt Id" name="from" />
			</p>
			<p class="fieldset">
				<input class="fa fa-user" placeholder="To Accunt Id" name="to" />
			</p>
			<p class="fieldset">
				<input class="fa fa-user" placeholder="Ammount" name="ammount" />
			</p>
			<p class="fieldset">
				<input class="full-width" type="submit" value="Transfer">
			</p>
		</form>
	</div>
</body>
