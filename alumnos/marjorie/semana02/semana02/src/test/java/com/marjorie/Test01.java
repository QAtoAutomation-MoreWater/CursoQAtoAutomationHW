package com.marjorie;

public class Test01 {
    public static void main(String[] args) {
    int Exitosos = 8;
    int total = 10;
    int usuariosSuace = 4;// Estandar, Problem User, Performance User, locked User
    int usariosRotos = 2;
    double tasaExito = (double) Exitosos / total * 100;
    double porcentajeUsuariosRotos = (double) usariosRotos / usuariosSuace * 100;
  System.out.println("Porcentaje Usuarios Rotos: " + porcentajeUsuariosRotos + "%");
System.out.println("Tasa de éxito: " + tasaExito + "%");
    }

}
/*package com.morewater.qa;

public class ValidadorLogin {

    public static void main(String[] args) {
        String usuario;
        String contraseña;

        //Logica para pedir a consola el usuario y contraseña


        // validacion de tipos de usuario y mensaje despues de ingresar

        standard_user // login exitoso
        locked_out_user // usuario bloqueado
        problem_user // entra pero no cargan imagenes
        performance_glitch_user // tarda entre 10 y 20 segundos en ingresar , pagina tiene lentitud


        if (usuario.equals("standard_user") && contraseña.equals("secret_sauce")) {
            System.out.println("Login exitoso");
        } else {
            System.out.println("Login fallido");
        }
    } */