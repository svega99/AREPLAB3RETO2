<!-- Los import -->
<%@ page language="java" %>
<%@ page import = "edu.escuelaing.arep.Connection.impl.DBConnectionImpl"%> 
<%@ page import = "import java.util.ArrayList;"%> 
<html>
<body>
<h1>Consulta a base de datos</h1>
<table border="1">
<tr>
<td>id</td>
<td>nombre</td>
<td>apellido</td>
<td>telefono</td>
</tr>
<%
ArrayList<estudiante> lista = DBConnectionImpl.getEstudiantes();
for (int i=0;i<lista.size();i++)
{
   out.println("<tr>");
   out.println("<td>"+lista.get(i).getId()+"</td>");
   out.println("<td>"+lista.get(i).getNombres()+"</td>");
   out.println("<td>"+lista.get(i).getApellidos()+"</td>");
   out.println("<td>"+lista.get(i).getSemestre()+"</td>");
   out.println("</tr>");
}
%>
</table>
</body>
</html>