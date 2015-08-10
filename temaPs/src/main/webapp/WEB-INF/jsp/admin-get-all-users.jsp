
	<%@ include file="../jsp/head.jsp"%>
<body>
<%@include file="/WEB-INF/jsp/navBar.jsp" %>
	<div align="center">
		<ul>
			<c:forEach items="${userList}" var="user">
				<li>${user.firstName} </li>
			</c:forEach>

			
		</ul>
	</div>
</body>
</html>