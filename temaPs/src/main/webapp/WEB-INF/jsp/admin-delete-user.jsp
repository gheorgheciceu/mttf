<%@ include file="../jsp/head.jsp"%>
<body>
<%@include file="/WEB-INF/jsp/navBar.jsp" %>
	<div align="center">
		<p>DELETE</p>
		
		<table class="table" style="width:60%; float:center;">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Password</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userList}" var="user">
					<tr>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.username}</td>
						<td>${user.password}</td>
						<td><a href="admin-delete-users/${user.id} ">Delete</a><br>
						<a href="admin-edit-user/${user.id} ">Edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
