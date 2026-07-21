package com.raul.qa;

import java.util.Scanner;

public class ValidadorLoginPrueba {


    public static boolean esUsuarioValido(String usuario) {

        if(usuario==null || usuario.length()==0)
        {
            System.out.println("Epic Sadface: Username is required.");
            return false;

        }

         if(usuario.equals("locked_out_user"))
        {
            System.out.println("Epic Sadface: Sorry, this user has been locked out.");
            return false;

        }

        String[] usuariosAdmitidos = {"standard_user", "problem_user", "performance_glithch_user", "error_user", "visual_user", "locked_out_user"};
        for (String usuarioValido : usuariosAdmitidos) {
            if (usuario.equals(usuarioValido)) {
                return true;
            }
        }
        return false;
    }


    public static boolean esPasswordValido(String password) {
       
        if(password==null || password.length()==0)
        {
            System.out.println("Epic Sadface: Password is required.");
            return false;

        }

        if(!password.equals("secret_sauce"))
        {
            System.out.println("Epic Sadface: Username and password do not match any user in this service.");
            return false;

        }
       
        
        if(password!=null && password.length()>0 && password.equals("secret_sauce"))
        {
            return true;
        }
    

        return false;
    }


    public static String descripcionUsuario(String usuario) {
        return switch (usuario) {
            case "standard_user" -> "Usuario normal, flujo felíz.";
            case "problem_user" -> "Bugs visuales a propósito.";
            case "performance_glitch_user" -> "Lentitud intencional.";
            case "error_user" -> "Ventanas con errores.";
            case "visual_user" -> "Componentes desaliedos";
            default -> "Usuario no reconocido";
        };
    }


    public static void main(String[] args) {

        String[] usuariosPermitidos = {"standard_user", "problem_user", "performance_glitch_user", "error_user", "visual_user", "locked_out_user"};
        
       Scanner lector = new Scanner(System.in);
        System.out.println("Ingresa usuario: ");
        String usuario = lector.nextLine();
//        System.out.println("Usuario capturado: " + usuario);

 //       System.out.println("Es usuario válido?: " + esUsuarioValido(usuario));


        Scanner lectorPassword = new Scanner(System.in);
        System.out.println("Ingresa password: ");
        String password = lectorPassword.nextLine();
//        System.out.println("Password capturado: " + password);

  //      System.out.println("Es password válido?: " + esPasswordValido(password));


  
    System.out.println("");
    System.out.println("=== Login Saucedemo ===");
    System.out.println("Usuario: " + usuario);
    System.out.println("Password: " + password);

    if (esUsuarioValido(usuario) && esPasswordValido(password)) {
        System.out.println("Login exitoso para: " + usuario);
        System.out.println("Perfil: " + descripcionUsuario(usuario));
    }

    else{
        System.out.println("Login fallido.");
    }

/*
 for (String u : usuariosPermitidos) {
            System.out.println("Usuario: " + u + " → " + descripcionUsuario(u));
        }
*/
       

    }
}
