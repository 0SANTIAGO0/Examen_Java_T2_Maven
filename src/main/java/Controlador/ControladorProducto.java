package Controlador;

import java.io.IOException;

import javax.enterprise.inject.Default;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import Dao.ClassProducto;
import Modelos.TblProductocl3;

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
		
		TblProductocl3 producto = new TblProductocl3();
		ClassProducto crud = new ClassProducto();
		java.util.List<TblProductocl3> listadoproductos=crud.ListadoProducto();
		//invocamos el listado  de productos para la vista
		request.setAttribute("listadodeproductos",listadoproductos);
		//redireccionamos
		//request.getRequestDispatcher("/ListadoDeProductos.jsp").forward(request, response);
		
		//recuperamos la accion y codigo
		String accion=request.getParameter("accion");
		//aplicamos una condicion
		if(accion!=null) {
			switch(accion) {
					case "Modificar":
						int codigo=Integer.parseInt(request.getParameter("idproductocl3"));
						//asignar el codigo
						producto.setIdproductocl3(codigo);
						TblProductocl3 buscarcod=crud.BuscarProducto(producto);
						request.setAttribute("codigo", buscarcod.getIdproductocl3());
						request.setAttribute("descripcion", buscarcod.getDescripcl3());
						request.setAttribute("estado", buscarcod.getEstadocl3());
						request.setAttribute("nombre", buscarcod.getNombrecl3());
						request.setAttribute("precioCom", buscarcod.getPreciocompcl3());
						request.setAttribute("precioVen", buscarcod.getPrecioventacl3());
						//redireccionamos
						request.getRequestDispatcher("/ActualizarProducto.jsp").forward(request, response);
						break;
					case "Eliminar":
						int codigoEliminar=Integer.parseInt(request.getParameter("idproductocl3"));
						//asignar el codigo
						producto.setIdproductocl3(codigoEliminar);
						//invocamos al metodo eliminar
						crud.EliminarProducto(producto);
						//Refrescar el listado
						List<TblProductocl3>listado=crud.ListadoProducto();
						request.setAttribute("listadodeproductos",listado);
						//redireccionamos
						request.getRequestDispatcher("/ListadoDeProductos.jsp").forward(request, response);
						//salimos
						break;
			}//FIN DEL SWITCH
		}//FIN DEL IF
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String idpro=request.getParameter("codigo");
		String nombrepro=request.getParameter("nombre");
		String precioven=request.getParameter("precioVen");
		String preciocom=request.getParameter("precioCom");		
		String estad=request.getParameter("estado");
		String descrip=request.getParameter("descripcion");
				
		TblProductocl3 producto=new TblProductocl3();
		ClassProducto crud=new ClassProducto();
		
		java.util.List<TblProductocl3> listadoproductos = null;
		
		//asignamos valores
		producto.setNombrecl3(nombrepro);
		producto.setPrecioventacl3(Double.parseDouble(precioven));
		producto.setPreciocompcl3(Double.parseDouble(preciocom));
		producto.setEstadocl3(estad);
		producto.setDescripcl3(descrip);
		
		if(idpro!=null){
			int codigo=Integer.parseInt(idpro);
			//asigno el codigo a actualizar
			
			producto.setIdproductocl3(codigo);
			crud.ActualizarProducto(producto);
			listadoproductos = crud.ListadoProducto();
			
		}else{
			crud.RegistrarProducto(producto);
			listadoproductos = crud.ListadoProducto();
		}
		 
		//invocamos el metodo registrar...
		//actualizador listado de clientes
		
		//invocamos el listado  de productos para la vista
		request.setAttribute("listadodeproductos",listadoproductos);
		//redireccionamos
		request.getRequestDispatcher("/ListadoDeProductos.jsp").forward(request, response);
		
	}

}
