<%@page import="clienteservidor2.implementacion.UsuariosJpaController" %>
<%@page import="clienteservidor2.modelo.Usuarios" %>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <%
       clienteservidor2.implementacion.UsuariosJpaController usuario = new clienteservidor2.implementacion.UsuariosJpaController(); 
        List<clienteservidor2.modelo.Usuarios> datos= new ArrayList();
    %>
    
        
    <body>
        <h1>Vista Usuarios</h1>
        <form name="FormUsuarios" method="POST" action="SERVUsuarios"> 
            DNI <input type="text" name="textDNI"><br>
            Apellido <input type="text" name="textApellido"><br>
            Nombre <input type="text" name="textNombre"><br>
            Usuario <input type="text" name="textUsuario"><br>
            Contraseña <input type="text" name="textContrasena"><br>
            Direccion <input type="text" name="textDireccion"><br>
            Correo <input type="text" name="textCorreo"><br>
            Telefono <input type="text" name="textTelefono"><br>
            <input type="submit" name="btnInsertar" value="Insertar">
            <input type="submit" name="btnModificar" value="Modificar">
            <input type="submit" name="btnEliminar" value="Eliminar">
        </form>
        <br>
        <br>
        <table border="1px">
            <tr>
                <td> DNI</td> 
                <td>APELLIDO </td>
                <td>NOMBRE </td>
                <td>CONTRASEÑA </td>
                <td>USUARIO </td>
                <td>CONTRASEÑA </td>
                <td>CORREO </td>
                <td> DIRECCION</td>
                <td>TELEFONO </td>
            </tr>
            
           // <%
           //    datos = usuario.findAll();
           //  for(Usuarios u: datos){
            //   %>
               <tr>
                  <!-- <td>  <% u.getDni(); %> </td>
                   <td> <% u.getApellido();  %>  </td>
                   <td> <% u.getNombre();  %>    </td>
                   <td> <% u.getContrasena();  %>    </td>
                   <td> <% u.getUsuario(); %>    </td>
                   <td> <% u.getCorreo();  %>    </td>
                   <td> <% u.getDireccion();  %>    </td>
                   <td> <% u.getTelefono();  %>   </td>-->

               </tr>
               
              // <%
              // }
               // %>
            
            
        </table>
        
    </body>
</html>
