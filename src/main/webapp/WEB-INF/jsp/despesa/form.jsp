<c:if test="${not empty errors}">
	<c:forEach items="${errors}" var="error">
		${error.category} - ${error.message}<br />
	</c:forEach>
</c:if>

<form action="${pageContext.request.contextPath}/despesas" method="post">
  
	<c:if test="${not empty despesa.id}">
		<input type="hidden" name="despesa.id" value="${despesa.id}"/>
		<input type="hidden" name="_method" value="put"/>
	</c:if>

	<div class="field">
		Valor:<br />
		<input type="text" name="despesa.valor" value="${despesa.valor}"/>
	</div>

<div class="actions">
	<button type="submit">send</button>
	</div>
</form>

<a href="${pageContext.request.contextPath}/despesas">Back</a>
