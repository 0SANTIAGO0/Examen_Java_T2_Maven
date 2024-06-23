<%@page import="Modelos.TblProductocl2"%>
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
List<TblProductocl2> listadoProducto=(List<TblProductocl2>)request.getAttribute("listadodeproductos");
//aplicamos una condicion..
if(listadoProducto!=null){
	//aplicamos un bucle for..
	for(TblProductocl2 lis:listadoProducto){
		%>
		<tr>
		<td><%=lis.getIdproductocl2() %></td>
		<td><%=lis.getNombrecl2() %></td>
		<td><%=lis.getPrecioventacl2() %></td>
		<td><%=lis.getPreciocompcl2() %></td>
		<td><%=lis.getEstadocl2() %></td>
		<td><%=lis.getDescripcl2() %></td>
		
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