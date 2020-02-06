package edu.escuelaing.arep.Model;
/**
 * Clase estudiante
 * 
 * @author santiago.vega-r
 *
 */
public class estudiante {
	
	private int carnet;
	private String nombres;
	private String apellidos;
	private int semestre;
	private String carrera;
	
	/**
	 *  Devuelve el carnet
	 * @return carnet
	 */
	public int getCarnet() {
		return carnet;
	}
	
	/**
	 * Asigna carnet a la variable dada
	 * @param carnet
	 */
	public void setCarnet(int carnet) {
		this.carnet = carnet;
	}
	/**
	 *  Devuelve el nombre
	 * @return nombre
	 */
	public String getNombres() {
		return nombres;
	}
	
	/**
	 * Asigna nombres a la variable dada
	 * @param nombres
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	/**
	 *  Devuelve los apellidos
	 * @return apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}
	
	/**
	 * Asigna apellidos a la variable dada
	 * @param apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	/**
	 *  Devuelve el numero de semestre
	 * @return semestre
	 */
	public int getSemestre() {
		return semestre;
	}
	
	/**
	 * Asigna semestre a la variable dada
	 * @param semestre
	 */
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	
	/**
	 *  Devuelve la carrera 
	 * @return carrera
	 */
	public String getCarrera() {
		return carrera;
	}
	
	/**
	 * Asigna carrera a la variable dada
	 * @param carrera
	 */
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	} 
}
