package br.com.ricardo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ricardo.dao.Dao;
import br.com.ricardo.model.Clientes;
import br.com.ricardo.utils.Utils;

/**
 * Servlet implementation class CadastroCliente
 */
public class CadastroClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroClientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String identificado			=	request.getParameter("id");
		String nome					= 	request.getParameter("nome");
		String idade 				= 	request.getParameter("idade");
		String data_nascimento 		= 	request.getParameter("data_nascimento");
		
		String data 				= 	Utils.FormataDataBanco(data_nascimento);
		
		Clientes cliente 			= 	new Clientes();
		Dao dao 					= 	new Dao();
		
		cliente.setNome(nome);
		cliente.setIdade(idade);
		cliente.setData_nascimento(data);
		
		if (identificado.trim().equals(""))		
			dao.inserir(cliente);	
		else {
			int id = Integer.parseInt(identificado);
			cliente.setId(id);
			
			dao.alterar(cliente);
		}
			
		PrintWriter out = response.getWriter();
		out.println("Registros Cadastrados com sucesso.");
	}
}