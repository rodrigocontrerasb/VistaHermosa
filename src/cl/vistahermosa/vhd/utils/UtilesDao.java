/*
 * Utiles: UtilesDao 
 * Descripcion: Funciones utiles de carater general
 * Objetivo: Mantener todas las funciones generales dentro de un mismo objeto del tipo utiles
 * @author Jorge Galleguimmos S. <jgs@gmail.com>
 * @version 2017-09-27
 * @since 2017-09-27
 */
package cl.vistahermosa.vhd.utils;

import java.io.*;
import java.sql.SQLException;

public class UtilesDao {

    /* 
     * Funcion: obtenerUsuarioTabla   
     * Descripcion: Entrega el nombre de la tabla para referencia en consultas
     * @param String tabla
     * @return String usuarioTabla
     * @throws FileNotFoundException
     * @throws IOException
     * @author Jorge Galleguillos S. <jgs@gmail.com>
     * @version 2015-06-19
     * @since 2015-06-19
     */
    public String obtenerUsuarioTabla(String tabla) throws FileNotFoundException, IOException, SQLException {
        String usuarioTabla = null;
        String linea = null;

        // Configuracion de ruta archivo
        UtilesConfig utilesconfig = new UtilesConfig();
        String[] rutaini = utilesconfig.getRutaIni();
        String arch = rutaini[1] + "ini/" + rutaini[4];

        // Creacion del lector de archivo
        FileReader fr = new FileReader(arch);
        BufferedReader entArch = new BufferedReader(fr);
        linea = entArch.readLine();
        while (linea != null) {

            // Separa la linea en 2 strings cuando encuentra ":"
            String separa[] = linea.split(":");

            // Nombre tabla virtual es igual al parametro tabla
            if (separa[0].toUpperCase().equals(tabla.toUpperCase())) {

                // Asignamos elusuario.tablareal
                usuarioTabla = separa[1];
                break;
            }
            linea = entArch.readLine();
        }
        entArch.close();
        return usuarioTabla;
    }

}
