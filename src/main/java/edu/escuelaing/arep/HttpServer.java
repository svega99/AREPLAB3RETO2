package edu.escuelaing.arep;

import org.apache.commons.io.FilenameUtils;

import edu.escuelaing.arep.Connection.impl.DBConnectionImpl;
import edu.escuelaing.arep.Model.estudiante;

import java.net.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class HttpServer {
	static ServerSocket serverSocket = null;
	
	static Socket clientSocket = null;
	
	static PrintWriter out;
	static BufferedReader in;
	static DBConnectionImpl con;
	
  public static void main(String[] args) throws IOException {
	  
	  
	   serverSocket = null;
	   try { 
	      serverSocket = new ServerSocket(getPort());
	   } catch (IOException e) {
	      System.err.println("Could not listen on port: 35000.");
	      System.exit(1);
	   }
	   
	   try {
			con = new DBConnectionImpl();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	   while(true) {
	   
	
		   
		   try {
		       System.out.println("Listo para recibir ...");
		       clientSocket = serverSocket.accept();
		   } catch (IOException e) {
		       System.err.println("Accept failed."+e.getMessage());
		       System.exit(1);
		   }
		   out = new PrintWriter(
		                         clientSocket.getOutputStream(), true);
		   in = new BufferedReader(
		                         new InputStreamReader(clientSocket.getInputStream()));
		   String inputLine, outputLine;
		   
		    
		   
		   
		   StringBuilder stringBuilder = new StringBuilder();
		   
		   Pattern pattern = Pattern.compile("GET /([^\\s]+)");
	       Matcher matcher = null;
		   
	       while ((inputLine = in.readLine()) != null) {
	    	      System.out.println("Recibí: " + inputLine);
	    	      if (!in.ready()) {break; }
	    	   }
	       out.println("HTTP/1.1 200 \r\nContent-Type: text/html\r\n\r\n");
	     
			
	    	   outputLine = 
	    	          "<!DOCTYPE html>" + 
	    	          "<html>" + 
	    	          "<head>" + 
	    	          "<meta charset=\"UTF-8\">" + 
	    	          "<title>Base de Datos</title>\n" + 
	    	          "</head>" + 
	    	          "<body>" + 
	    	          "<h1>Tabla Estudiante</h1>" + 
	    	          "<table border=\"1\">"+
	    	          "<tr>"+
	    	          "<td>Id</td>"+
	    	          "<td>Nombres</td>"+
	    	          "<td>Apellidos</td>"+
	    	          "<td>Semestre</td>"+
	    	          "<td>Carrera</td>"+
	    	          "</tr>";
	    	     
	    	          ArrayList<estudiante> lista = con.getEstudiantes();
	    	          for (int i=0;i<lista.size();i++)
	    	          {
	    	             outputLine=outputLine +"<tr>"+
	    	            		 				"<td>"+lista.get(i).getCarnet()+"</td>"+
	    	            		 				"<td>"+lista.get(i).getNombres()+"</td>"+
							    	            "<td>"+lista.get(i).getApellidos()+"</td>"+
							    	            "<td>"+lista.get(i).getSemestre()+"</td>"+
							    	            "<td>"+lista.get(i).getCarrera()+"</td>"+
							    	            "</tr>";
	    	          }
	    	          
	    	          outputLine=outputLine +"</table>"+
	    	          "</body>" + 
	    	          "</html>"; 
	    	    out.println(outputLine);
	    	    System.err.println(outputLine);
	    	    out.close(); 
	    	    in.close(); 
	    	    clientSocket.close(); 
	    	    //serverSocket.close(); 
	   }
  }
  
  
  
  static int getPort() {
      if (System.getenv("PORT") != null) {
          return Integer.parseInt(System.getenv("PORT"));
      }        
         
      return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)    }
  }
  
  
  
  
}