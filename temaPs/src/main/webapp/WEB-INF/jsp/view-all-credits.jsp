<%@ include file="../jsp/head.jsp"%>
<body>
	<%@include file="/WEB-INF/jsp/navBar.jsp"%>
	<div align="center">
		<div align="center">
			

			<table class="table" style="width: 60%; float: center;">
				
				<thead>
				<caption>Loans</caption>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Value</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${loans}" var="loan">
						<tr>
							<td>${loan.customer.firstName}</td>
							<td>${loan.customer.lastName}</td>
							<td>${loan.ammountTaken}</td>
							<td><a href="repay/${loan.id} ">repay</a><br></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>


			<br> <br> <br> <br>
			
			<table class="table" style="width: 60%; float: center;">
				
				<thead>
				<caption>Cash Credits</caption>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Value</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cashCredits}" var="loan">
						<tr>
							<td>${loan.customer.firstName}</td>
							<td>${loan.customer.lastName}</td>
							<td>${loan.ammountTaken}</td>
							<td><a href="repay/${loan.id} ">repay</a><br></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>


			<br> <br> <br> <br>

			<table class="table" style="width: 60%; float: center;">
				
				<thead>
				<caption>Overdrafts</caption>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Value</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${overdrafts}" var="loan">
						<tr>
							<td>${loan.customer.firstName}</td>
							<td>${loan.customer.lastName}</td>
							<td>${loan.limit}</td>
							<td><a href="repay/${loan.id} ">repay</a><br></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>