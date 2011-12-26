<head>
	<title>Despesa [show]</title>
</head>
<body>
	<p>
		<b>Valor:</b>
		${despesa.valor}
	</p>

	<a href="${pageContext.request.contextPath}/despesas/${despesa.id}/edit">Edit</a>
	<a href="${pageContext.request.contextPath}/despesas">Back</a>
</body>