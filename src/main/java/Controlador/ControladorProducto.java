package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.persistence.internal.oxm.schema.model.List;

import Dao.ClassProducto;
import Modelos.TblProductocl2;

/**
 * Servlet implementation class ControladorProducto
 */
public class ControladorProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		TblProductocl2 producto = new TblProductocl2();
		ClassProducto crud = new ClassProducto();
		java.util.List<TblProductocl2> listadoproductos=crud.ListadoProducto();
		//invocamos el listado  de productos para la vista
		request.setAttribute("listadodeproductos",listadoproductos);
		//redireccionamos
		request.getRequestDispatcher("/ListadoDeProductos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String idpro=request.getParameter("idproducto");
		String nombrepro=request.getParameter("nombre");
		String precioven=request.getParameter("precioVen");
		String preciocom=request.getParameter("precioCom");		
		String estad=request.getParameter("estado");
		String descrip=request.getParameter("descripcion");
				
		TblProductocl2 producto=new TblProductocl2();
		ClassProducto crud=new ClassProducto();
		//asignamos valores
		producto.setNombrecl2(nombrepro);
		producto.setPrecioventacl2(Double.parseDouble(precioven));
		producto.setPreciocompcl2(Double.parseDouble(preciocom));
		producto.setEstadocl2(estad);
		producto.setDescripcl2(descrip);
		 
		//invocamos el metodo registrar...
		crud.RegistrarProducto(producto);
		//actualizador listado de clientes
		java.util.List<TblProductocl2> listadoproductos = crud.ListadoProducto();
		//invocamos el listado  de productos para la vista
		request.setAttribute("listadodeproductos",listadoproductos);
		//redireccionamos
		request.getRequestDispatcher("/ListadoDeProductos.jsp").forward(request, response);
		
	}

}
