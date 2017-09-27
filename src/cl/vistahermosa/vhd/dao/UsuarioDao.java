/*
 * Data Access Object: Usuario 
 * Descripcion: Acceso a datos para tabla usuario
 * Objetivo: Controlar las llamadas de ingreso y retorno de datos desde el motor Oracle
 * @author Jorge Galleguillos S. <sgs@gmail.com>
 * @version 2017-09-27
 * @since 2017-09-27
 */
package cl.vistahermosa.vhd.dao;

import cl.vistahermosa.vhd.model.Usuario;
import cl.vistahermosa.vhd.utils.UtilesDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.driver.OracleResultSet;
import oracle.jdbc.driver.OracleStatement;

public class UsuarioDao {

    /* 
     * Funcion: loginUsuario   
     * Descripcion: Verifica la existencia de un usuario en sistema
     * @param Usuario usuario
     * @return Usuario usuario
     * @throws Exception
     * @author Jorge galleguillos S. <jgs@gmail.com>
     * @version 2017-09-27
     * @since 2017-09-27
     */
    public Usuario loginUsuario(Usuario usuario) throws Exception {

        // Seteo de Parametros Iniciales
        usuario.setSalida_codigo(0);
        usuario.setSalida_mensaje("Usuario Inexistente");

        // Obtener Alias de tablas de BD
        UtilesDao util = new UtilesDao();
        String t_funcionario = util.obtenerUsuarioTabla("t_funcionario");

        // Construccion Consulta SQL
        String strsql = "select * from " + t_funcionario + " where run= " + usuario.getRun() + " and password = '" + usuario.getPassword() + "'";

        // Variables Generales de Conexion y Salida
        Connection conn = null;

        // Control de Ejecucion de Proceso SQL
        try {

            // Conexion a BD
            conn = Conn.conectarOracle();
            OracleResultSet rs = null;
            OracleStatement stmt = (OracleStatement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            // Execucion Consulta SQL
            try {
                rs = (OracleResultSet) stmt.executeQuery(strsql);
            } catch (Exception ex) {

            }

            // Recorrido
            if (rs.next()) {
                toUsuario(usuario, rs);
                usuario.setSalida_codigo(1);
                usuario.setSalida_mensaje("Usuario Existente");
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {
            conn.rollback();
        }

        // Cierra la conexion en caso de estar abierta
        if (conn != null) {
            conn.close();
        }

        // Retorno
        return usuario;

    }

    /* 
     * Funcion: listarUsuarios   
     * Descripcion: Entrega el listado de todos los usuarios
     * @param Usuario param
     * @return List<Usuario>
     * @throws Exception
     * @author Jorge Galleguillos S. <jgs@gmail.com>
     * @version 2016-07-06
     * @since 2016-07-06
     */
    public List<Usuario> listarUsuarios() throws Exception {

        // Obtener Alias de tablas de BD
        UtilesDao util = new UtilesDao();
        String t_funcionario = util.obtenerUsuarioTabla("t_funcionario");

        // Construccion Consulta SQL
        String strsql = "SELECT * from " + t_funcionario;

        // Variables Generales de Conexion y Salida
        Connection conn = null;
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        // Control de Ejecucion de Proceso SQL
        try {

            // Conexion a BD
            conn = Conn.conectarOracle();
            oracle.jdbc.OracleResultSet rs = null;
            oracle.jdbc.OracleStatement stmt = (oracle.jdbc.OracleStatement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            rs = (oracle.jdbc.OracleResultSet) stmt.executeQuery(strsql);

            // Recorido y Generacion de objeto de salida
            while (rs.next()) {
                Usuario l_usuario = new Usuario();
                toUsuario(l_usuario, rs);
                usuarios.add(l_usuario);
            }

            // Close
            rs.close();
            stmt.close();

        } catch (Exception e) {
            conn.rollback();
        }

        // Cierra la conexion en caso de estar abierta
        if (conn != null) {
            conn.close();
        }

        // Retorno
        return usuarios;
    }

    /* 
     * Funcion: toUsuario   
     * Descripcion: Envia el resultset de base de datos hacia abstraccion de objeto del tipo
     * @param UsuarioPerfil p_usuario, ResultSet rs
     * @param ResultSet rs
     * @return void
     * @throws Exception
     * @author Jorge Galleguillos S. <jgs@gmail.com>
     * @version 2017-09-27
     * @since 2017-09-27
     */
    public void toUsuario(Usuario p_usuario, ResultSet rs) throws SQLException {

        // Seteo de atributos hacia el objeto Acceso
        try {
            p_usuario.setRun(rs.getInt("run"));
        } catch (Exception e) {
        }

        try {
            p_usuario.setRundv(rs.getString("rundv"));
        } catch (Exception e) {
        }

        try {
            p_usuario.setNombres(rs.getString("nombres"));
        } catch (Exception e) {
        }

        try {
            p_usuario.setPaterno(rs.getString("paterno"));
        } catch (Exception e) {
        }

        try {
            p_usuario.setMaterno(rs.getString("materno"));
        } catch (Exception e) {
        }

    }
}
