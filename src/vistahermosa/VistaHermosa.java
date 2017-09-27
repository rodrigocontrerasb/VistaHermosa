/*
 * Main: Main 
 * Descripcion: Ejecucion inicial del sistema
 * Objetivo: Disparar la ejecucion inicial del sistema
 * @author Jorge Galleguillos S. <jgs@gmail.com>
 * @version 2017-09-27
 * @since 2017-09-27
 */
package vistahermosa;

import cl.vistahermosa.vhd.controller.UsuarioController;
import cl.vistahermosa.vhd.model.Usuario;
import java.util.List;

public class VistaHermosa {

    /* 
     * Funcion: main   
     * Descripcion: Inicia el sistema
     * @param String[] args
     * @return -
     * @author Jorge Galleguillos S. <jgs@gmail.com>
     * @version 2017-09-27
     * @since 2017-09-27
     */
    public static void main(String[] args) throws Exception {

        // Clases Utilizadas
        UsuarioController usuariocontroller = new UsuarioController();

        // Usuario a validar en BD
        Usuario usuario = new Usuario();
        usuario.setRun(1);
        usuario.setPassword("123");

        // Verificar Usuario
        usuario = usuariocontroller.loginUsuario(usuario);

        // Salida
        System.out.println("VISTA HERMOSA");
        System.out.println("SALIDA ID --> " + usuario.getSalida_mensaje());
        System.out.println("USUARIO NOMBRE --> " + usuario.getNombres() + " " + usuario.getPaterno());

        // Listar Usuarios
        List<Usuario> usuarios;
        usuarios = usuariocontroller.listarUsuarios();

        System.out.println("LISTADO DE USUARIOS");
        for (int x = 0; x < usuarios.size(); x++) {
            System.out.println("USUARIO --> " + usuarios.get(x).getNombres() + " " + usuarios.get(x).getPaterno());
        }

    }

}
