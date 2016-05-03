<%@page import="br.com.ricardo.utils.Utils"%>
<%@page import="br.com.ricardo.model.Clientes"%>
<%@page import="br.com.ricardo.dao.Dao"%>
<%@page import="java.util.List" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
	<tr>
		<th>ID</th>
		<th>Nome</th>
		<th>Idade</th>
		<th>Data Nascimento</th>
		<th>Editar</th>
		<th>Excluir</th>
	</tr>
	
	<% 
		Dao dao = new Dao();	
		List<Clientes> clientes = dao.selecionarTodos();					
		for (Clientes cliente : clientes) {
	%>
	<tr>
		<td><%= cliente.getId() %></td>
		<td><%= cliente.getNome() %></td>
		<td><%= cliente.getIdade() %></td>
		<td><%= Utils.FormataDataApp(cliente.getData_nascimento()) %></td>
		<td><a href="/ProjetoServlet/EditarClientes?id=<%=cliente.getId() %>" />Editar</a>
		<td><a href="/ProjetoServlet/DeletarCliente?id=<%=cliente.getId() %>"">Excluir</a>
	</tr>
	<% } %>
</table>

</body>
</html>