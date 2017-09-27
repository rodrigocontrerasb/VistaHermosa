/*
 * Utiles: UtilesConfig 
 * Descripcion: Funciones utiles para la configuracion general del sistema
 * Objetivo: Mantener todas las funciones generales dentro de un mismo objeto del tipo utiles
 * @author Jorge Galleguillos S. <jgs@gmail.com>
 * @version 2017-09-27
 * @since 2017-09-27
 */
package cl.vistahermosa.vhd.utils;

public class UtilesConfig {

    /* 
     * Funcion: getRutaIni   
     * Descripcion: Setea las rutas del servidor activo
     * @param -
     * @return String rutaIni
     * @author Jorge Galleguillos S. <jgs@gmail.com>
     * @version 2017-09-27
     * @since 2017-09-27
     */
    public String[] getRutaIni() {

        // Nombre Proyecto
        String nombreProyecto = "VistaHermosa";
        String pathProyecto = "C:/Users/Rodrigo/Documents/NetBeansProjects/";

        // Variables Generales
        String[] rutaIni = new String[5];

        rutaIni[0] = pathProyecto + nombreProyecto + "/build/";
        rutaIni[1] = pathProyecto + nombreProyecto + "/build/classes/cl/vistahermosa/vhd/";
        rutaIni[2] = "/" + nombreProyecto + "/";
        rutaIni[3] = "parametros_conexion.ini";
        rutaIni[4] = "usuariosTablas.ini";

        // Salida
        return rutaIni;
    }

}
