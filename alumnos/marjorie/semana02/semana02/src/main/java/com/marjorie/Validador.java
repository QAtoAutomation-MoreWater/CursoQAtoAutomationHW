package com.marjorie;
import java.util.Scanner;

public class Validador {
    
    public static void main (String[] args) {
        String contrasena;
        String usuario;
        Scanner lector = new Scanner(System.in);

        System.out.println("Ingrese su usuario: ");
        usuario =lector.nextLine();
        System.out.println("Ingrese su contraseña: ");
        contrasena = lector.nextLine();
        System.out.println("=== Sauce Demo ===");
        if (usuario.isEmpty() || contrasena.isEmpty()) {
            if (usuario.isEmpty()){
                System.out.println("Epic sadface: Username is required");
            } else if (contrasena.isEmpty()) {
                System.out.println("Epic sadface: Password is required");
            }
        } else {
            contrasena = iniciarSesion(usuario, contrasena);
        }
        System.out.println("Usuario: " + usuario);
        System.out.println("Contraseña: " + contrasena);

    }
public static String iniciarSesion(String usuario, String password) {
    String inicioSesion = usuario + ":" + password;
    int contador = 1;
    Scanner lector = new Scanner(System.in);

if (!password.equals("secret_sauce")){
    System.out.println("Username and password do not match any user in this service");
    switch (usuario) {
            case "standard_user" -> {
              while(contador < 3){
                System.out.println("Contraseña incorrecta");
                     System.out.println("Ingresa Contraseña correcta: ");
                      password=lector.nextLine();
                if (password.equals("secret_sauce")){
                    System.out.println("=== Sauce Demo ===");
                    System.out.println("Todo correcto -> Login Exitoso");
                    System.out.println("Usuario Normal, Happy Path");
                    Menu(usuario);
                    break;
                } else {
                    contador++;
                    if (contador == 3){
                        System.out.println("Cuenta bloqueada");
                    }
                }
            }
            }
            case "problem_user" -> {
              while(contador < 3){
                System.out.println("Contraseña incorrecta");
                     System.out.println("Ingresa Contraseña correcta: ");
                      password=lector.nextLine();
                if (password.equals("secret_sauce")){
                    System.out.println("=== Sauce Demo ===");
                    System.out.println("Todo correcto -> Login Exitoso");
                    System.out.println("Bugs visibles a proposito");
                    Menu(usuario);
                    break;
                } else {
                    contador++;
                    if (contador == 3){
                        System.out.println("Cuenta bloqueada");
                    }
                }
            }
            }
            case "performance_glitch_user" -> {
                 while(contador < 3){
                System.out.println("Contraseña incorrecta");
                     System.out.println("Ingresa Contraseña correcta: ");
                  password=lector.nextLine();
                if (password.equals("secret_sauce")){
                    System.out.println("=== Sauce Demo ===");
                    System.out.println("Todo correcto -> Login Exitoso");
                    System.out.println("Lentitud intencional");
                     Menu(usuario);
                    break;
                } else {
                    contador++;
                    if (contador == 3){
                        System.out.println("Cuenta bloqueada");
                    }
                }
            }
            }
            case "locked_out_user"->{
                while(contador < 3){
                System.out.println("Contraseña incorrecta");
                     System.out.println("Ingresa Contraseña correcta: ");
                  password=lector.nextLine();
                if (password.equals("secret_sauce")){
                    System.out.println("=== Sauce Demo ===");
                    System.out.println("Todo correcto -> Login Exitoso");
                    System.out.println("Epic sadface: Sorry, this user has been locked out.");
                    Menu(usuario);
                    break;
                } else {
                    contador++;
                    if (contador == 3){
                        System.out.println("Cuenta bloqueada");
                    }
                }
            }
            }
        }
}else {
      switch (inicioSesion) {
            case "standard_user:secret_sauce" -> {
                System.out.println("Todo correcto -> Login Exitoso");
                System.out.println("Usuario Normal, Happy Path");
                Menu(usuario);
            }
            case "problem_user:secret_sauce" -> {
                System.out.println("Todo correcto -> Login Exitoso");
                System.out.println("Bugs visibles a proposito");
                Menu(usuario);
            }
            case "performance_glitch_user:secret_sauce" -> {
                System.out.println("Todo correcto -> Login Exitoso");
                System.out.println("Lentitud intencional");
                Menu(usuario);
            }
            case "locked_out_user:secret_sauce"->{
                System.out.println("Epic sadface: Sorry, this user has been locked out.");
            }
            default -> {
                System.out.println("Usuario o contraseña incorrectos");
            }
        }
}
return password;
}

public static void Menu(String usuario) {
    Scanner lector = new Scanner(System.in);
    int opcion=0;

      do{
        System.out.println("=== Menu ===");
        System.out.println("1. Ver Perfil");
        System.out.println("2. Salir");
      if (!lector.hasNextInt()) {
            System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            lector.next(); // Limpiar el buffer de entrada
            continue; // Volver al inicio del bucle
        }
        else {
        opcion = lector.nextInt();
        switch (opcion) {
            case 1 -> {
                System.out.println("Perfil de " + usuario);
            }
            case 2 -> {
                System.out.println("Saliendo del programa...");
                opcion = 2; 
            }
            default->{
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                break;
            }
        }
        }  
    }while (opcion != 2);

    }
}
