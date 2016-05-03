package br.com.ricardo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ricardo.dao.Dao;
import br.com.ricardo.model.Clientes;
import br.com.ricardo.utils.Utils;

/**
 * Servlet implementation class EditarClientes
 */
@WebServlet("/EditarClientes")
public class EditarClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarClientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		Dao dao = new Dao();
		Clientes cliente = new Clientes();				
		
		cliente.setId(id);		
		Clientes client = dao.selecionarCliente(cliente);
		
		String data = Utils.FormataDataApp(client.getData_nascimento());		
		client.setData_nascimento(data);				
		
		request.setAttribute("clientes", client);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("index.jsp");
		dispacher.forward(request, response);
		
		
	}
	
}
