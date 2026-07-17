package com.morewater.qa;

public class ValidadorLogin {

    public static void main(String[] args) {
        String usuario = "raul";
        String contraseña = "secret_sauce";


        if (usuario.equals("standard_user") && contraseña.equals("secret_sauce")) {
            System.out.println("Login exitoso");
        } else {
            System.out.println("Login fallido");
        }
    }


    
}
