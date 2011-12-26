<head>
	<title>Despesa [index]</title>
</head>
<body>
	<h1>Listing Despesas</h1>

	<table>
		<tr>
			<th>Valor</th>
			<th></th>
			<th></th>
			<th></th>
		</tr>

		<c:forEach items="${despesaList}" var="despesa">
			<tr>
				<td>${despesa.valor}</td>
				<td><a href="${pageContext.request.contextPath}/despesas/${despesa.id}">show</a></td>
				<td><a href="${pageContext.request.contextPath}/despesas/${despesa.id}/edit">edit</a></td>
				<td>
					<form action="${pageContext.request.contextPath}/despesas/${despesa.id}" method="post">
						<input type="hidden" name="_method" value="delete"/>
						<button type="submit" onclick="return confirm('Are you sure?')">destroy</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

	<br />
	<a href="${pageContext.request.contextPath}/despesas/new">New Despesa</a> 
</body>