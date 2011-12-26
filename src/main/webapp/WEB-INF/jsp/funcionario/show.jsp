<head>
	<title>Funcionario [show]</title>
</head>
<body>
	<p>
		<b>Cpf:</b>
		${funcionario.cpf}
	</p>
	<p>
		<b>Nome:</b>
		${funcionario.nome}
	</p>
	<p>
		<b>Rg:</b>
		${funcionario.rg}
	</p>
	<p>
		<b>Matricula:</b>
		${funcionario.matricula}
	</p>

	<a href="${pageContext.request.contextPath}/funcionarios/${funcionario.id}/edit">Edit</a>
	<a href="${pageContext.request.contextPath}/funcionarios">Back</a>
</body>