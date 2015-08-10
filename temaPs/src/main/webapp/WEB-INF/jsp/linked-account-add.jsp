<%@ include file="../jsp/head.jsp"%>
<body>
	<%@include file="/WEB-INF/jsp/navBar.jsp"%>
	<div align="center">
		<form:form class="cd-form" modelAttribute="account" method="post">

			<h4 class="formTitle">Register Linked Account</h4>

			
			
			<p class="fieldset">
			<label ><i
					class="fa fa-user">Client</i></label>
				<select id="clientId" name="clientId">
					<c:forEach var="customer" items="${customer}">
						<option value="${customer.id}">${customer.firstName} ${customer.lastName}</option>
					</c:forEach>
				</select>
			</p>

			<!-- Linked member id's -->

			<%-- 	<form:select path="link1">
			
    			<form:options items="${customer}" />
			</form:select> --%>
			<!-- 	<p class="fieldset">Linked member Id
				<input class="fa fa-user" placeholder="Linked member Id" name="link1"value=0 />
			</p> -->
			<p class="fieldset">
			<label class="image-replace cd-password" for="signin-password"><i
					class="fa fa-user">Linked Client</i></label>
				<select id="link1" name="link1">
					<c:forEach var="customer" items="${customer}">
						<option value="${customer.id}">${customer.firstName} ${customer.lastName}</option>
					</c:forEach>
				</select>
			</p>

			<p class="fieldset">
			<label class="image-replace cd-password" for="signin-password"><i
					class="fa fa-user">Linked Client</i></label>
				<select id="link2" name="link2">
					<c:forEach var="customer" items="${customer}">
						<option value="${customer.id}">${customer.firstName} ${customer.lastName}</option>
					</c:forEach>
				</select>
			</p>

			<p class="fieldset">
			<label class="image-replace cd-password" for="signin-password"><i
					class="fa fa-user">Linked Client</i></label>
				<select id="link3" name="link3">
					<c:forEach var="customer" items="${customer}">
						<option value="${customer.id}">${customer.firstName} ${customer.lastName}</option>
					</c:forEach>
				</select>
			</p>

			<p class="fieldset">
			<label class="image-replace cd-password" for="signin-password"><i
					class="fa fa-user">Linked Client</i></label>
				<select id="link4" name="link4" class=>
					<c:forEach var="customer" items="${customer}">
						<option value="${customer.id}">${customer.firstName} ${customer.lastName}</option>
					</c:forEach>
				</select>
			</p>


			<!--  -->
			<!-- operatin and transaction limits -->

			<p class="fieldset">
				Operation Limit <input class="fa fa-user"
					placeholder="Operation Limit" name="operationLimit" value=0 />
			</p>

			<p class="fieldset">
				Maximum transferable ammount <input class="fa fa-user"
					placeholder="Maximum transferable ammount" name="transactionLimit"
					value=0 />
			</p>
			<!--  -->



			<p class="fieldset">
				<label class="image-replace cd-password" for="signin-password"><i
					class="fa fa-user">Account balance</i></label>
				<form:input path="balance" class="full-width has-padding has-border"
					id="signin-password" type="text" placeholder="Account ballance" />

			</p>


			<p class="fieldset">
				<input class="full-width" type="submit" value="INREGISTRARE">
			</p>
		</form:form>
	</div>
</body>
