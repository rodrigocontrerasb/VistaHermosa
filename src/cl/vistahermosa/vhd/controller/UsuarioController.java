/*
 * Controller: Usuario 
 * Descripcion: Funciones generales asociadas a objetos del tipo usuario
 * Objetivo: Entregar el conjunto de acciones para los objetos del tipo, gatilladas desde la vista
 * @author Jorge Galleguillos S. <jgs@gmail.com>
 * @version 2017-09-27
 * @since 2017-09-27
 */
package cl.vistahermosa.vhd.controller;

import cl.vistahermosa.vhd.dao.UsuarioDao;
import cl.vistahermosa.vhd.model.Usuario;
import java.util.List;

public class UsuarioController {

    /* 
     * Funcion: loginUsuario   
     * Descripcion: Verifica la existencia de un usuario en sistema
     * @param Usuario usuario
     * @return Usuario usuario
     * @throws Exception
     * @author Jorge Galleguillos S. <jgs@gmail.com>
     * @version 2017-09-27
     * @since 2017-09-27
     */
    public Usuario loginUsuario(Usuario usuario) throws Exception {
        UsuarioDao usuariodao = new UsuarioDao();
        return usuariodao.loginUsuario(usuario);
    }

    /* 
     * Funcion: listarUsuarios   
     * Descripcion: lista todos los usuarios
     * @param --
     * @return List<Usuario>
     * @throws Exception
     * @author Jorge Galleguillos S. <jgs@gmail.com>
     * @version 2017-09-27
     * @since 2017-09-27
     */
    public List<Usuario> listarUsuarios() throws Exception {
        UsuarioDao usuariodao = new UsuarioDao();
        return usuariodao.listarUsuarios();
    }

}
