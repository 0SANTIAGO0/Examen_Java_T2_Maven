package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassUsuario;
import Modelos.TblUsuariocl2;

/**
 * Servlet implementation class ControladorUsuario
 */
public class ControladorUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String login = request.getParameter("usuario");
	     String clave = request.getParameter("password");

	     //instancias
	     TblUsuariocl2 usu = new TblUsuariocl2();
	     ClassUsuario crud = new ClassUsuario();
	     
	     usu = crud.validarUsuario(login, clave);

	        if (usu != null) {
	            
	            request.setAttribute("mensaje", "Credenciales correctas");
	            request.getRequestDispatcher("/Menu.jsp").forward(request, response);
	        } else {
	            
	            request.setAttribute("mensaje", "Credenciales incorrectas");
	            request.getRequestDispatcher("/Login.jsp").forward(request, response);
	        }
	}

}
