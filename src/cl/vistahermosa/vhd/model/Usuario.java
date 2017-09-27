/*
 * Modelo: Usuario
 * Descripcion: Representación en clase para tabla usuario
 * Objetivo: Controlar las llamadas de asignacion y retorno de valores para objetos del tipo
 * @author Jorge Galleguillos S. <jgs@gmail.com>
 * @version 2016-09-27
 * @since 2016-09-27
 */
package cl.vistahermosa.vhd.model;

public class Usuario {

    /*
     Atributos de Tabla Usuario
     */
    private int run;
    private String rundv;
    private String nombres;
    private String paterno;
    private String materno;
    private String password;

    /*
     Atributos Adiciones
     */
    private int salida_codigo;
    private String salida_mensaje;


    /*
     Getters
     */
    public int getRun() {
        return run;
    }

    public String getRundv() {
        return rundv;
    }

    public String getNombres() {
        return nombres;
    }

    public String getPaterno() {
        return paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public String getPassword() {
        return password;
    }

    public int getSalida_codigo() {
        return salida_codigo;
    }

    public String getSalida_mensaje() {
        return salida_mensaje;
    }

    /*
     Setters
     */
    public void setRun(int run) {
        this.run = run;
    }

    public void setRundv(String rundv) {
        this.rundv = rundv;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalida_codigo(int salida_codigo) {
        this.salida_codigo = salida_codigo;
    }

    public void setSalida_mensaje(String salida_mensaje) {
        this.salida_mensaje = salida_mensaje;
    }

}
