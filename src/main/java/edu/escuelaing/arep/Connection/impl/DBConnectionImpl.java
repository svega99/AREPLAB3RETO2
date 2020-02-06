package edu.escuelaing.arep.Connection.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.escuelaing.arep.Connection.DBConnection;
import edu.escuelaing.arep.Model.estudiante;
/**
 * Implementacion de la clase DBConnection que conecta a una base de datos especifica
 * 
 * @author santiago.vega-r
 *
 */
public class DBConnectionImpl implements DBConnection{

	
	private  String user = "krjcafarpdqaqk";
    private  String passw = "181334f00fdee6a334d4093c731df9855486e18430ae3bf3f83dd11e0365a85d";
    private  String url = "jdbc:postgresql://ec2-3-213-192-58.compute-1.amazonaws.com:5432/d3fh8fvthfbg5h?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
    private  Connection connection;
    
    public DBConnectionImpl() throws SQLException {
    	conectar();
    }
    
	/**
	 * Clase que conecta a la base de datos
	 */
	public void conectar() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
	        connection = DriverManager.getConnection(url, user, passw);
	     } catch (SQLException ex) {
	        throw new SQLException(ex);
	     } catch (ClassNotFoundException ex) {
	        throw new ClassCastException(ex.getMessage());
	     }
		
	}
	
	/**
	 * Devuelve una lista de todos los estudiantes que se encuentran en la base de datos
	 * 
	 * @return Lista de estudiantes
	 */
	public ArrayList<estudiante> getEstudiantes()
	   {
			ArrayList<estudiante> listaContactos=new ArrayList<estudiante>();
	      try
	      {
	
	         Statement st = connection.createStatement();
	         ResultSet rs = st.executeQuery("select * from estudiantes" );
	         while (rs.next())
	         {
	        	 estudiante est = new estudiante();
	        	 est.setCarnet(rs.getInt("carnet"));
	        	 est.setNombres(rs.getString("nombres"));
	        	 est.setApellidos(rs.getString("apellidos"));
	        	 est.setSemestre(rs.getInt("semestre"));
	        	 est.setCarrera(rs.getString("carrera"));
	            listaContactos.add(est);
	         }
	         rs.close();
	         st.close();
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return listaContactos;
	   }

}
