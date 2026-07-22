package com.michel.qa;

import java.util.Arrays;
import java.util.Scanner;

public class ValidadorLogin {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Bienvenido a SauceDemo, por favor siga las intrucciones para iniciar sesión.");
            int intentos = 0;
            String usuariosValidos[] = {"standard_user", "locked_out_user", "problem_user", "performance_glitch_user"};
            String usuariosBloqueados[] = {"locked_out_user"};
            String mensajeUsuario[] = {"usuario normal, flujo feliz", "Epic sadface: Sorry, this user has been locked out.", "bugs visuales a propósito", "lentitud intencional"};
            String contraseñaCorrecta = "secret_sauce";

            while (intentos < 3 ){
                
                System.out.print("Ingrese su usuario: ");
                String usuario = scanner.nextLine();

                System.out.print("Ingrese su contraseña: ");
                String contraseña = scanner.nextLine();

                if (usuario.isEmpty()) {
                    System.out.println("Epic sadface: Username is required");
                } else if (contraseña.isEmpty()) {
                    System.out.println("Epic sadface: Password is required");
                } else if (Arrays.asList(usuariosBloqueados).contains(usuario)) {
                    System.out.println("Epic sadface: Sorry, this user has been locked out.");
                } else if (!contraseña.equals(contraseñaCorrecta)) {
                    System.out.println("Epic sadface: Username and password do not match any user in this service");
                } else if (Arrays.asList(usuariosValidos).contains(usuario)) {
                    int index = Arrays.asList(usuariosValidos).indexOf(usuario);
                    System.out.println("Login exitoso. Descripción del usuario: " + mensajeUsuario[index]);
                    break;
                } else {
                    System.out.println("Usuario no reconocido, por favor contacte al administrador.");
                }

                intentos++;

            }

            if (intentos >= 3) {
                System.out.println("Demasiados intentos fallidos. Por favor, intente más tarde.");
            }
    scanner.close();
        }
}

