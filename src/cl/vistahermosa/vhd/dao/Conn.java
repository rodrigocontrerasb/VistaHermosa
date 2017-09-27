/*
 * Data Access Object: Conn 
 * Descripcion: Clase de conexion al motor de datos
 * Objetivo: Conectar con la base de datos oracle
 * @author Jorge Galleguillos S. <jgs@gmail.com>
 * @version 2017-09-27
 * @since 2017-09-27
 */
package cl.vistahermosa.vhd.dao;

import cl.vistahermosa.vhd.utils.UtilesConfig;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {

    /* 
     * Funcion: conectarOracle   
     * Descripcion: Genera la conexion con el motor de datos Oracle
     * @return Connection conn
     * @throws FileNotFoundException, IOException, SQLException
     * @author Jorge Galleguillos S. <jgs@gmail.com>
     * @version 2017-09-27
     * @since 2017-09-27
     */
    static public Connection conectarOracle() throws FileNotFoundException, IOException, SQLException {
        // Parametros de Conexion extraidos desde archivo de configuarcion
        UtilesConfig utilesconfig = new UtilesConfig();
        String[] rutaini = utilesconfig.getRutaIni();
        String arch = rutaini[1] + "ini/" + rutaini[3];

        // Creacion del lector de archivo
        FileReader fr = new FileReader(arch);
        BufferedReader entArch = new BufferedReader(fr);
        String usuario = entArch.readLine();
        String passwd = entArch.readLine();
        String cadenaConnexion = entArch.readLine();
        entArch.close();

        // Conexion por medio del Driver Oracle 
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection conn = DriverManager.getConnection(cadenaConnexion, usuario, passwd);

        // Retorno de Conexion
        return conn;

    }

}
