package com.raul.qa;

import java.util.Scanner;

public class ValidadorLogin {

    //Método que valida usuario. Regresa un String con el resultado de la validación.
    public static String validarUsuario(String usuario) {
        if (usuario == null || usuario.isEmpty()) {
            return "Epic Sadface: Username is required.";
        }

        if (usuario.equals("locked_out_user")) {
            return "Epic Sadface: Sorry, this user has been locked out.";
        }

        //Arreglo de cadenas de texto con los nombres de usuarios permitidos.
        String[] usuariosAdmitidos = {
            "standard_user", "problem_user", "performance_glitch_user",
            "error_user", "visual_user", "locked_out_user"
        };

        //Recorre cada elemento del arreglo  de usuarios y compara con el que le pasamos si es que coincide con alguno.
        for (String usuarioValido : usuariosAdmitidos) {
            if (usuario.equals(usuarioValido)) {
                return "OK"; // si el usuario pasado al método coincide con uno del arreglo, devuelve "OK".
            }
        }
        return "Epic Sadface: Usuario no reconocido."; //si no coincide con ninguno de los usuarios del arreglo, devuelve "usuario no reconocido".
    }

    //Método que valida el password. Regresa un String con el resultado de la validación.
    public static String validarPassword(String password) {
        if (password == null || password.isEmpty()) {
            return "Epic Sadface: Password is required.";
        }

        //Si el password no es igual a "secret_sauce", devuelve un mensaje de error.
        if (!password.equals("secret_sauce")) {
            return "Epic Sadface: Username and password do not match any user in this service.";
        }

        return "OK"; // si el password es igual a "secret_sauce", devuelve "OK".
    }

    //Método que devuelve una descripción del usuario según su nombre.
    //Utilzo switch moderno.
    public static String descripcionUsuario(String usuario) {
        return switch (usuario) {
            case "standard_user" -> "Usuario normal, flujo feliz.";
            case "problem_user" -> "Bugs visuales a propósito.";
            case "performance_glitch_user" -> "Lentitud intencional.";
            case "error_user" -> "Ventanas con errores.";
            case "visual_user" -> "Componentes desalineados.";
            default -> "Usuario no reconocido.";
        };
    }

    //Función principal.
    public static void main(String[] args) {


        Scanner lector = new Scanner(System.in);//Crea un objeto Scanner para leer la entrada del usuario desde la consola.
        boolean continuar = true;

        while(continuar){

            System.out.println("Ingresa usuario: ");
            String usuario = lector.nextLine();

            System.out.println("Ingresa password: ");
            String password = lector.nextLine();

            System.out.println("\n=== Login Saucedemo ===");
            System.out.println("Usuario: " + usuario);
            System.out.println("Password: " + password);

            String resultadoUsuario = validarUsuario(usuario);//
            String resultadoPassword = validarPassword(password);

            if (resultadoUsuario.equals("OK") && resultadoPassword.equals("OK")) {
                System.out.println("Login exitoso para: " + usuario);
                System.out.println("Perfil: " + descripcionUsuario(usuario));
            } else {
                if (!resultadoUsuario.equals("OK")) {
                System.out.println(resultadoUsuario);
                }
            if (!resultadoPassword.equals("OK")) {
                System.out.println(resultadoPassword);
            }
        
        }
    

        //Pregunta al usuario si desea intentar nuevamente. Usando un operador ternario para asignar el valor a la variable continuar.
            System.out.println("\n¿Deseas intentar nuevamente? (s/S para continuar): ");
            String respuesta = lector.nextLine();
            continuar = respuesta.equalsIgnoreCase("s") ? true : false;


        }

    }
}
