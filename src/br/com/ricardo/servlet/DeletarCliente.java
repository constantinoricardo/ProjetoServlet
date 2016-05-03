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

/**
 * Servlet implementation class DeletarCliente
 */
@WebServlet("/DeletarCliente")
public class DeletarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Clientes cliente = new Clientes();
		Dao dao = new Dao();
		
		cliente.setId(id);
		
		dao.deletar(cliente);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("lista.jsp");
		dispacher.forward(request, response);
	}

	

}
