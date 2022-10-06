/**
 * 
 */
package modelo;

/** dtoAlumno - DTO de la entidad alumnos de la BBDD de PostgreSQL
 * @author garfe
 *
 */
public class dtoAlumno {
	
	//Constructor completo
	public dtoAlumno(int id, String nom, String ape, String ema) {
		
		id_alumno = id;
		nombre = nom;
		apellidos = ape;
		email = ema;
		
	}
	
	//Atributos	
	int id_alumno;
	String nombre;
	String apellidos;
	String email;
	
	
	//Getters Setters
	public int getId_alumno() {
		return id_alumno;
	}
	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
