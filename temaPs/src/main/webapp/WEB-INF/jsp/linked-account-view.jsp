<%@ include file="../jsp/head.jsp"%>
<body>
	<%@include file="/WEB-INF/jsp/navBar.jsp"%>


	<table class="table" style="width: 60%; float: center;">
		<thead>
			<tr>
				<th>Id</th>
				<th>money</th>


				<th>Customer</th>
				<th>Links</th>
				<th>Operation limit</th>
				<th>Transaction Limit</th>
				<th>Number of operations done</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${linkedAccounts}" var="acc">
				<tr>
					<td>${acc.id}</td>
					<td>${acc.account.balance}</td>


					<td>${acc.id}${acc.firstName }${acc.lastName}</td>

					<td><c:forEach items="${acc.linkedCustomers}" var="customers">
						${customers.id} ${customers.firstName } ${customers.lastName }<br>
						</c:forEach></td>
					<td>${ acc.operationsLimit}</td>
					<td>${ acc.transactionLimit}</td>
					<td>${ acc.operations}</td>
					<td><a href="/linked-account-delete/${acc.id} ">Delete</a><br>
						<a href="/linked-account-edit/${acc.id} ">Edit</a><br> <a
						href="/linked-account-transfer/${acc.id} ">Transfer money</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>