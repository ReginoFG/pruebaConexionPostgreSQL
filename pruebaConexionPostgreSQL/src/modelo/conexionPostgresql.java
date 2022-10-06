package modelo;

import util.variablesConexionPostgreSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** conexionPostgreSQL - Clase que realiza la conexión a PostgreSQL de forma parametrizada; basándose en la información 
 * procedente del controlador.
 * @author garfe
 * 29/09/2022
 */
public class conexionPostgresql {
	
	//MÉTODOS
	/** generaConexion - Método que genera a partir de parámetros la conexión a PostgreSQL
	 * @param host
	 * @param port
	 * @param db
	 * @param user
	 * @param pass
	 * @return Conexión a postgreSQL, null si no es válida, y la correspondiente si sí lo es.
	 */
	public Connection generaConexion(final String host, final String port, final String db, final String user, final String pass) {

		System.out.println("[INFORMACIÓN-conexionPostgresql-generaConexion] Entra en generaConexion");
		
        /*(Definición local) Definimos connection a null y url a vacío para 
         * asegurarnos de que ambas variables están limpias.
         */
        Connection conexion = null;
        String url = "";            
        url = "jdbc:postgresql://" + host + ":" + port + "/" + db;
		
        try {
        	
        	/*Class.forName obtiene una instancia de la clase de java especificada.
			*En este caso registra la clase como driver JDBC
			*/
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException cnfe) {
                System.out.println("[ERROR-conexionPostgresql-generaConexion] Error en registro driver PostgreSQL: " + cnfe);
            }
      
            //Conexión a la base de datos en PostgreSQL y validación de esta
            conexion = DriverManager.getConnection(url, user, pass);           
            boolean esValida = conexion.isValid(50000);
            if(esValida == false) {
            	conexion = null;
            }
            System.out.println(esValida ? "[INFORMACIÓN-conexionPostgresql-generaConexion] Conexión a PostgreSQL válida" : "[ERROR-conexionPostgresql-generaConexion] Conexión a PostgreSQL no válida");
            return conexion;
            
        } catch (java.sql.SQLException jsqle) {
        	
            System.out.println("[ERROR-conexionPostgresql-generaConexion] Error en conexión a PostgreSQL (" + url + "): " + jsqle);
            return conexion;
            
        }
    }

}

