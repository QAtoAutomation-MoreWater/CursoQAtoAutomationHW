package com.michel.qa;
import java.util.Arrays;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        
        /*Se creara un login de usuario y contraseña, 
        Se validaran las siguientes reglas de negocio.
        Al ejecutar el programa:
	    Pide por consola el usuario (escrito con teclado).
	    Pide por consola la contraseña.
	    Valida con estas reglas, EN ESTE ORDEN:
        Usuario vacío → Epic sadface: Username is required
	    Password vacío → Epic sadface: Password is required
	    Usuario locked_out_user → Epic sadface: Sorry, this user has been locked out.
	    Password distinto de secret_sauce → Epic sadface: Username and password do not match any user in this service
	    Todo correcto → login exitoso.
        Si el login es exitoso, imprime una descripción del usuario según cuál de los 4 entró:
        standard_user → usuario normal, flujo feliz
        problem_user → bugs visuales a propósito	    
        performance_glitch_user → lentitud intencional
    	Cualquier otro usuario con password correcto → decide tú qué debe pasar (y justifícalo en un comentario).
        */
        //Scanner scanner = new Scanner(System.in);


        System.out.println("Bienvenido a SauceDemo, por favor siga las intrucciones para iniciar sesión.");
        int intentos = 0;
        String usuariosValidos[] = {"standard_user", "locked_out_user", "problem_user", "performance_glitch_user"};
        String usuariosBloqueados[] = {"locked_out_user"};
        String MensajeUsuario[] = {"usuario normal, flujo feliz", "Epic sadface: Sorry, this user has been locked out.", "bugs visuales a propósito", "lentitud intencional"};

        try (Scanner scanner = new Scanner(System.in)) {
            while (intentos < 3) {
                
                System.out.print("Ingrese su usuario: ");
                String usuario = scanner.nextLine();

                System.out.print("Ingrese su contraseña: ");
                String contrasena = scanner.nextLine();

                if (usuario.isEmpty()) {
                    System.out.println("Epic sadface: Username is required");
                } else if (contrasena.isEmpty()) {
                    System.out.println("Epic sadface: Password is required");
                } else if (Arrays.asList(usuariosBloqueados).contains(usuario)) {
                    System.out.println("Epic sadface: Sorry, this user has been locked out.");
                } else if (!contrasena.equals("secret_sauce")) {
                    System.out.println("Epic sadface: Username and password do not match any user in this service");
                } else if (Arrays.asList(usuariosValidos).contains(usuario)) {
                    int index = Arrays.asList(usuariosValidos).indexOf(usuario);
                    System.out.println("Login exitoso. Descripción del usuario: " + MensajeUsuario[index]);
                    break;
                } else {
                    System.out.println("Usuario no reconocido, por favor contacte al administrador.");
                }

                intentos++;
            }
        }
    }
}

       