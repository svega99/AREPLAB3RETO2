package edu.escuelaing.arep.Connection.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.escuelaing.arep.Connection.DBConnection;
import edu.escuelaing.arep.Model.estudiante;

public class DBConnectionImpl implements DBConnection{

	
	private static String user = "ldxscymoompeab";
    private static String passw = "813a08acb3e71767a7186c311a6056a3982ab2a6213255e56c7149663034c06a";
    private static String url = "jdbc:postgresql://ec2-34-235-108-68.compute-1.amazonaws.com:5432/d38ekv52akfpdl";
    private static Connection connection;
	
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
	
	
	public static ArrayList<estudiante> getEstudiantes()
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
	         connection.close();
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return listaContactos;
	   }

}
