<%@ include file="../jsp/head.jsp"%>
<body>
<script>
	function Validate() {
		var image = document.getElementById("image").value;
		if (image != '') {
			var checkimg = image.toLowerCase();
			if (!checkimg.match(/(\.jpg|\.png|\.JPG|\.PNG|\.jpeg|\.JPEG)$/)) {
				alert("Please enter Image File Extensions .jpg,.png,.jpeg");
				document.getElementById("image").focus();
				return false;
			}
		}
		return true;
	}
</script>
<%@include file="/WEB-INF/jsp/navBar.jsp"%>
	<%-- 	<%
		if (session.getAttribute("uploadFile") != null
				&& !(session.getAttribute("uploadFile")).equals("")) {
	%>
	<h3>Uploaded File</h3>
	<br>
	<img src="<%=session.getAttribute("uploadFile")%>" alt="Upload Image" />

	<%
		session.removeAttribute("uploadFile");
		}
	%> --%>
	<c:if test="${not empty ok}">
		<img src="data:image/jpg;base64,${image}" alt="..." width="200"
			height="200">`
</c:if>



	<form:form name="frm" method="post" enctype="multipart/form-data"
		onSubmit="return Validate();">
		<fieldset>
			<legend>Upload File</legend>
			<table>
				<tr>
					<td>File<br />
					</td>
					<td><input id="image" name="fileData" type="file" /></td>
				</tr>
				<tr>
					<td><br /></td>
					<td><input type="submit" value="Upload" /></td>
				</tr>
			</table>
		</fieldset>
	</form:form>
</body>
</html>