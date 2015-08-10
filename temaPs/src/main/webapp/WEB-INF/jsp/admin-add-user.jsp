<%@ include file="../jsp/head.jsp"%>
<body>
<%@include file="/WEB-INF/jsp/navBar.jsp"%>
	<div align="center">
	<form:form class="cd-form" modelAttribute="user" method="post">

		<h4 class="formTitle">Register User</h4>

		<p class="fieldset">
			<label class="image-replace cd-email" for="signin-email"><i
				class="fa fa-user"></i></label>
			<form:input path="firstName"
				class="full-width has-padding has-border" id="signin-email"
				type="text" placeholder="User first name" />
			
		</p>

		<p class="fieldset">
			<label class="image-replace cd-password" for="signin-password"><i
				class="fa fa-user"></i></label>
			<form:input path="lastName" class="full-width has-padding has-border"
				id="signin-password" type="text"
				placeholder="User Last Name" />
			
		</p>

		<p class="fieldset">
			<label class="image-replace cd-email" for="signin-email"><i
				class="fa fa-envelope-o"></i></label>
			<form:input path="username" class="full-width has-padding has-border"
				id="signin-email" type="email"
				placeholder="Email address" />
			
		</p>

		<p class="fieldset">
			
			<form:input path="password" class="full-width has-padding has-border"
				id="signin-email" type="text"
				placeholder="Parola" />
			
		</p>


		<!-- 
		<div class="checkbox">
			<label><input type="checkbox"> A </label> <label><input
				type="checkbox"> A </label> <label><input type="checkbox">
				A </label>
		</div> -->
		<%-- <div class="checkbox">
			<c:forEach items="${categories}" var="category" varStatus="status">

				<form:checkbox path="categories" value="${category.id}"
						label=""  />
						<c:out value="${category.categoryName}" /><br>
				<label>
				<input type="checkbox" name="categories" value="${category.id}" />${category.type}</label>
				<br>


			</c:forEach>
		</div> --%>

		<p class="fieldset">
			<input class="full-width" type="submit" value="INREGISTRARE">
		</p>
	</form:form>
	</div>
</body>
