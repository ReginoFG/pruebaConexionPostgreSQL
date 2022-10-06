package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.conexionPostgresql;
import modelo.dtoAlumno;
import modelo.consultasPostgreSQL;
import util.variablesConexionPostgreSQL;

/** controladorPostgreSQL - Controlador que gestiona todos los métodos de PostgreSQL
 * @author garfe
 *
 */
public class controladorPostgreSQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//CONSTANTES
		final String HOST = variablesConexionPostgreSQL.getHost();
		final String PORT = variablesConexionPostgreSQL.getPort();
		final String DB = variablesConexionPostgreSQL.getDb();
		final String USER = variablesConexionPostgreSQL.getUser();
		final String PASS = variablesConexionPostgreSQL.getPass();
		ArrayList<dtoAlumno> listAlumnos = new ArrayList<>();

		
		/*Se crea una instancia de la clase en la que estamos para poder generar la conexión a PostgreSQL
		*utilizando el método generaConexion
		*/
		System.out.println("[INFORMACIÓN-controladorPortgreSQL-main] Lamada generaConexion");
		conexionPostgresql conexionPostgresql = new conexionPostgresql();
		Connection conexionGenerada = conexionPostgresql.generaConexion(HOST,PORT,DB,USER,PASS);
		
		if(conexionGenerada != null) {
			
			//Llamar al método que ejecuta la consulta
			System.out.println("[INFORMACIÓN-controladorPortgreSQL-main] Lamada selectAllAlumnos");
			listAlumnos = consultasPostgreSQL.selectAllAlumnos(conexionGenerada);
			int i = listAlumnos.size();
			System.out.println("[INFORMACIÓN-controladorPortgreSQL-main] Número alumnos: "+i);
			
		}		
	
	}

}
