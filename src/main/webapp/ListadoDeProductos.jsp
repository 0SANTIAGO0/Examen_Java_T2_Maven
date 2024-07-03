<%@page import="Modelos.TblProductocl3"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<%@page import="java.util.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Productos</title>
</head>
<body bgcolor="#c5dec9">
<h1  align="center">Listado de Productos Registrados en BD</h1>

<table border="2" align="center">

<tr>
<td>Codigo</td>
<td>Nombre</td>
<td>PrecioVenta</td>
<td>PrecioCompra</td>
<td>Estado</td>
<td>Descripcion</td>
</tr>

<%
List<TblProductocl3> listadoProducto=(List<TblProductocl3>)request.getAttribute("listadodeproductos");
//aplicamos una condicion..
if(listadoProducto!=null){
	//aplicamos un bucle for..
	for(TblProductocl3 lis:listadoProducto){
		%>
		<tr>
		<td><%=lis.getIdproductocl3() %></td>
		<td><%=lis.getNombrecl3() %></td>
		<td><%=lis.getPrecioventacl3() %></td>
		<td><%=lis.getPreciocompcl3() %></td>
		<td><%=lis.getEstadocl3() %></td>
		<td><%=lis.getDescripcl3() %></td>
		<td><a href="ControladorProducto?accion=Eliminar&idproductocl3=<%=lis.getIdproductocl3()%>">Eliminar</a></td>
		<td><a href="ControladorProducto?accion=Modificar&idproductocl3=<%=lis.getIdproductocl3()%>">Actualizar</a></td>
		
		</tr>
		
		
	<%	
	}   //fin del bucle for...
	%>
	<%
}  //fin de la condicion ...

%>

</table>

</body>
</html>