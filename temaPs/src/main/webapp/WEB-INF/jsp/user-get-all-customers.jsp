	<%@ include file="../jsp/head.jsp"%>
<body>
<%@include file="/WEB-INF/jsp/navBar.jsp" %>
	<div align="center">
		<div align="center">
			<p>View Customers</p>

			<table class="table" style="width: 60%; float: center;">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Id</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${customerList}" var="customer">
						<tr>
							<td>${customer.firstName}</td>
							<td>${customer.lastName}</td>
							<td>${customer.id}</td>
							<td>
								<a href="user-edit-customer/${customer.id} ">Edit</a><br>
								<a href="${customer.id} ">View Acconts</a>
								</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>