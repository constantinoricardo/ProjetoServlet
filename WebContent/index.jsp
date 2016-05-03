<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c: var="cliente" items="${clientes}">						
		<form method="post" action="CadastroClientes">
			<input type="hidden" name="id" id="id" value="${clientes.getId()}" />
			Nome: <input type="text" name="nome" id="nome" size="50" value="${clientes.getNome()}" /><br />
			Idade: <input type="text" name="idade" id="idade" size="20" value="${clientes.getIdade()}" /><br />
			Data de Nascimento: <input type="text" name="data_nascimento" id="data_nascimento"
			value="${clientes.getData_nascimento()}"
			 size="12" 
			
			/><br />
			<button id="cadastrar" type="submit">Cadastrar</button>
		</form>
		
		
	
	</c:>
</body>
</html>