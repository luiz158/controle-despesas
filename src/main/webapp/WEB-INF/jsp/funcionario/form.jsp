<c:if test="${not empty errors}">
	<c:forEach items="${errors}" var="error">
		${error.category} - ${error.message}<br />
	</c:forEach>
</c:if>

<form action="${pageContext.request.contextPath}/funcionarios" method="post">
  
	<c:if test="${not empty funcionario.id}">
		<input type="hidden" name="funcionario.id" value="${funcionario.id}"/>
		<input type="hidden" name="_method" value="put"/>
	</c:if>

	<div class="field">
		Cpf:<br />
		<input type="text" name="funcionario.cpf" value="${funcionario.cpf}"/>
	</div>
	<div class="field">
		Nome:<br />
		<input type="text" name="funcionario.nome" value="${funcionario.nome}"/>
	</div>
	<div class="field">
		Rg:<br />
		<input type="text" name="funcionario.rg" value="${funcionario.rg}"/>
	</div>
	<div class="field">
		Matricula:<br />
		<input type="text" name="funcionario.matricula" value="${funcionario.matricula}"/>
	</div>

<div class="actions">
	<button type="submit">send</button>
	</div>
</form>

<a href="${pageContext.request.contextPath}/funcionarios">Back</a>
