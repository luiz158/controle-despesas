<head>
	<title>Funcionario [index]</title>
</head>
<body>
	<h1>Listing Funcionarios</h1>

	<table>
		<tr>
			<th>Cpf</th>
			<th>Nome</th>
			<th>Rg</th>
			<th>Matricula</th>
			<th></th>
			<th></th>
			<th></th>
		</tr>

		<c:forEach items="${funcionarioList}" var="funcionario">
			<tr>
				<td>${funcionario.cpf}</td>
				<td>${funcionario.nome}</td>
				<td>${funcionario.rg}</td>
				<td>${funcionario.matricula}</td>
				<td><a href="${pageContext.request.contextPath}/funcionarios/${funcionario.id}">show</a></td>
				<td><a href="${pageContext.request.contextPath}/funcionarios/${funcionario.id}/edit">edit</a></td>
				<td>
					<form action="${pageContext.request.contextPath}/funcionarios/${funcionario.id}" method="post">
						<input type="hidden" name="_method" value="delete"/>
						<button type="submit" onclick="return confirm('Are you sure?')">destroy</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

	<br />
	<a href="${pageContext.request.contextPath}/funcionarios/new">New Funcionario</a> 
</body>