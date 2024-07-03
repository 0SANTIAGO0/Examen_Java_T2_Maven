<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Producto</title>
</head>
<body bgcolor="#c5dec9">

<h1 align="center">Actualizar Productos</h1>
<form action="ControladorProducto" method="post">
<% 
	String codigo=request.getAttribute("codigo").toString();
	String descrip=(request.getAttribute("descripcion")!=null)?request.getAttribute("descripcion").toString():"";
	String esta=(request.getAttribute("estado")!=null)?request.getAttribute("estado").toString():"";
	String nom=(request.getAttribute("nombre")!=null)?request.getAttribute("nombre").toString():"";
	String preCom=(request.getAttribute("precioCom")!=null)?request.getAttribute("precioCom").toString():"";
	String preVe=(request.getAttribute("precioVen")!=null)?request.getAttribute("precioVen").toString():"";
%>
<table border="2" align="center">
<tr>
<td>Codigo</td>
<td><input type="text" name="codigo" value="<%=codigo%>"></td>
</tr>
<td>Nombre</td>
<td><input type="text" name="nombre" value="<%=nom%>"></td>
</tr>
<tr>
<td>Precio</td>
<td><input type="text" name="precioCom" value="<%=preCom%>"></td>
</tr>
<tr>
<td>PrecioVen</td>
<td><input type="text" name="precioVen" value="<%=preVe%>"></td>
</tr>
<tr>
<tr>
<td>Estado</td>
<td><input type="text" name="estado" value="<%=esta%>" ></td>
</tr>
<tr>
<td>Descrip</td>
<td><input type="text" name="descripcion" value="<%=descrip%>"></td>
</tr>

<tr>
<td colspan="2"  align="center" >
<input type="submit" value="Actualizar Producto">
</td>
</tr>
</table>
</form>

</body>
</html>