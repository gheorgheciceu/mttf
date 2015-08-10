<%@ include file="../jsp/head.jsp"%>
<body>
	<%@include file="/WEB-INF/jsp/navBar.jsp"%>

	<table class="table" style="width: 60%; float: center;">
		<thead>
			<tr>
				<th>Id</th>
				<th>money</th>
				<th>Type</th>
				<th>Creation Date</th>
				<th>Customer</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${acountList}" var="acc">
				<tr>
					<td>${acc.id}</td>
					<td>${acc.balance}</td>
					<td>${acc.type}</td>
					<td>${acc.creationDate}</td>
					<td>${acc.customer.id}  ${acc.customer.firstName }
						${acc.customer.lastName}</td>
					<td><a href="account-delete/${acc.id} ">Delete</a><br>
					<a href="account-edit/${acc.id} ">Edit</a>

					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>