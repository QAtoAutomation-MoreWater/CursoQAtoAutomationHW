package com.morewater.qa;

import java.io.Console;
import java.util.Scanner;



/**
 * ValidadorLogin — Version presentacion (Java 11, textos en espanol).
 * Simula el login de SauceDemo (https://www.saucedemo.com) por consola.
 *
 * Extras: password oculto (cuando hay terminal real), animacion de
 * validacion, contador de intentos visible y menu post-login.
 *
 * NOTA DIDACTICA: los mensajes reales de SauceDemo estan en ingles
 * ("Epic sadface: ..."). Aqui se muestran en espanol para la demo,
    * pero cada constante conserva el original en comentario — cuando
 * lleguemos a Selenium, las assertions verificaran el texto INGLES.
            */
public class ValidadorLogin {
//
    // ==========================================================
    // CONSTANTES DE NEGOCIO
    // ==========================================================
    private static final String PASSWORD_CORRECTO = "secret_sauce";
    private static final int MAX_INTENTOS = 3;

    // Original: "Epic sadface: Username is required"
    private static final String ERROR_USUARIO_VACIO = ":(  El usuario es obligatorio";
    // Original: "Epic sadface: Password is required"
    private static final String ERROR_PASSWORD_VACIO = ":(  La contrasena es obligatoria";
    // Original: "Epic sadface: Sorry, this user has been locked out."
    private static final String ERROR_BLOQUEADO = ":(  Lo sentimos, este usuario ha sido bloqueado.";
    // Original: "Epic sadface: Username and password do not match..."
    private static final String ERROR_CREDENCIALES = ":(  El usuario y la contrasena no coinciden con ningun usuario del servicio";

    // ==========================================================
    // COLORES ANSI — cambia COLORES_ACTIVOS a false si tu
    // terminal imprime simbolos raros.
    // ==========================================================
    private static final boolean COLORES_ACTIVOS = true;-
    private static final String RESET = COLORES_ACTIVOS ? "\u001B[0m" : "";
    private static final String NEGRITA = COLORES_ACTIVOS ? "\u001B[1m" : "";
    private static final String ROJO = COLORES_ACTIVOS ? "\u001B[31m" : "";
    private static final String VERDE = COLORES_ACTIVOS ? "\u001B[32m" : "";
    private static final String CYAN = COLORES_ACTIVOS ? "\u001B[36m" : "";
    private static final String AMARILLO = COLORES_ACTIVOS ? "\u001B[33m" : "";
    private static final String GRIS = COLORES_ACTIVOS ? "\u001B[90m" : "";

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        imprimirBanner();

        int intentosFallidos = 0;
        boolean sesionIniciada = false;
        String usuarioActivo = "";

        while (!sesionIniciada && intentosFallidos < MAX_INTENTOS) {

            imprimirEncabezadoIntento(intentosFallidos + 1);

            System.out.print(CYAN + "   Usuario    > " + RESET);
            String usuario = lector.nextLine().trim();

            String password = leerPassword(lector);

            animacionValidando();

            String resultado = validarLogin(usuario, password);

            if (resultado.isEmpty()) {
                sesionIniciada = true;
                usuarioActivo = usuario;
            } else {
                intentosFallidos++;
                int restantes = MAX_INTENTOS - intentosFallidos;
                imprimirError(resultado);

                String aviso = (restantes > 0)
                        ? "Te quedan " + restantes + " intento(s)"
                        : "Cuenta bloqueada por seguridad. Intenta mas tarde.";
                System.out.println(AMARILLO + "   [!] " + aviso + RESET);
            }
        }

        if (sesionIniciada) {
            imprimirBienvenida(usuarioActivo);
            mostrarMenu(lector, usuarioActivo);
        } else {
            imprimirDespedidaBloqueado();
        }

        lector.close();
    }

    // ==========================================================
    // LECTURA DE PASSWORD — oculto si hay terminal real.
    // System.console() regresa null dentro de consolas de IDE;
    // el fallback evita que el programa truene.
    // ==========================================================
    private static String leerPassword(Scanner lector) {
        Console consola = System.console();
        if (consola != null) {
            // Terminal real: ocultamiento nativo (no se ve NADA al teclear)
            char[] oculto = consola.readPassword(CYAN + "   Contrasena > " + RESET);
            return new String(oculto).trim();
        }
        // Plan B (consola de IDE): modo "conceal" ANSI — el texto se
        // teclea invisible en terminales que soportan el codigo [8m.
        // Si tu consola lo ignora, el password se vera: es limitacion
        // del entorno, no del codigo.
        System.out.print(CYAN + "   Contrasena > " + RESET + "\u001B[8m");
        String password = lector.nextLine().trim();
        System.out.print("\u001B[28m" + RESET); // desactivar conceal
        return password;
    }

    // ==========================================================
    // VALIDACION — early return. El ORDEN es logica de negocio:
    // locked_out_user se rechaza AUNQUE su password sea correcto.
    // ==========================================================
    public static String validarLogin(String usuario, String password) {
        if (usuario.isEmpty())
            return ERROR_USUARIO_VACIO;
        if (password.isEmpty())
            return ERROR_PASSWORD_VACIO;
        if (usuario.equals("locked_out_user"))
            return ERROR_BLOQUEADO;
        if (!password.equals(PASSWORD_CORRECTO))
            return ERROR_CREDENCIALES;
        return "";
    }

    // ==========================================================
    // PERFIL — switch clasico (compatible Java 11).
    // ==========================================================
    public static String describirUsuario(String usuario) {
        switch (usuario) {
            case "standard_user":
                return "Usuario normal — flujo feliz";
            case "problem_user":
                return "Bugs visuales a proposito — imagenes rotas, botones raros";
            case "performance_glitch_user":
                return "Lentitud intencional — entrena tus esperas";
            default:
                return "Usuario no registrado en el catalogo (typo en datos de prueba?)";
        }
    }

    // ==========================================================
    // MENU POST-LOGIN
    // ==========================================================
    private static void mostrarMenu(Scanner lector, String usuario) {
        boolean salir = false;

        while (!salir) {
            System.out.println(CYAN + "   +----------------------------------+" + RESET);
            System.out.println(CYAN + "   |          MENU PRINCIPAL          |" + RESET);
            System.out.println(CYAN + "   +----------------------------------+" + RESET);
            System.out.println(CYAN + "   |  1. Ver mi perfil                |" + RESET);
            System.out.println(CYAN + "   |  2. Cerrar sesion                |" + RESET);
            System.out.println(CYAN + "   +----------------------------------+" + RESET);
            System.out.print("   Elige una opcion > ");
            String opcion = lector.nextLine().trim();

            switch (opcion) {
                case "1":
                    System.out.println();
                    System.out.println("   +----------------------------------------------------------+");
                    System.out.println("   |  PERFIL DEL USUARIO                                      |");
                    System.out.println("   +----------------------------------------------------------+");
                    System.out.println("     Cuenta : " + VERDE + usuario + RESET);
                    System.out.println("     Tipo   : " + VERDE + describirUsuario(usuario) + RESET);
                    System.out.println();
                    break;
                case "2":
                    salir = true;
                    System.out.println();
                    System.out.println(VERDE + "   Sesion cerrada. Hasta la proxima, " + usuario + "!" + RESET);
                    System.out.println(GRIS + "   ..........................................." + RESET);
                    break;
                default:
                    System.out.println(ROJO + "   [X] Opcion no valida. Escribe 1 o 2." + RESET);
                    System.out.println();
                    break;
            }
        }
    }

    // ==========================================================
    // PRESENTACION / DECORACION
    // ==========================================================
    private static void imprimirBanner() {
        System.out.println();
        System.out.println(CYAN + NEGRITA);
        System.out.println("   __  __  ___  ____  _____ _    _  _  _____ _____ ____  ");
        System.out.println("  |  \\/  |/ _ \\|  _ \\| ____| |  | || ||_   _| ____|  _ \\ ");
        System.out.println("  | |\\/| | | | | |_) |  _| | |/\\| |/\\ | | | |  _| | |_) |");
        System.out.println("  | |  | | |_| |  _ <| |___|   /\\   /_| |_| |___|  _ < ");
        System.out.println("  |_|  |_|\\___/|_| \\_\\_____|__/  \\__|_____|_____|_| \\_\\");
        System.out.println(RESET);
        System.out.println(GRIS + "  ------------------------------------------------------" + RESET);
        System.out.println(NEGRITA + "        MOREWATER QA EVOLUTION  ·  Login SauceDemo" + RESET);
        System.out.println(GRIS + "        De QA Manual a QA Automation — Semana 2" + RESET);
        System.out.println(GRIS + "  ------------------------------------------------------" + RESET);
        System.out.println();
        System.out.println(AMARILLO + "   Tip: usuarios de prueba -> standard_user, locked_out_user," + RESET);
        System.out.println(AMARILLO + "        problem_user, performance_glitch_user" + RESET);
        System.out.println();
    }

    private static void imprimirEncabezadoIntento(int numeroIntento) {
        System.out.println(GRIS + "   ===========================================" + RESET);
        System.out.println(GRIS + "    INICIO DE SESION" + RESET
                + GRIS + "   [ Intento " + numeroIntento + " de " + MAX_INTENTOS + " ]" + RESET);
        System.out.println(GRIS + "   ===========================================" + RESET);
    }

    // Pequena animacion de puntos: "Validando credenciales..."
    private static void animacionValidando() {
        System.out.print(GRIS + "   Validando credenciales" + RESET);
        for (int i = 0; i < 3; i++) {
            pausa(280);
            System.out.print(GRIS + "." + RESET);
        }
        System.out.println();
        pausa(150);
    }

    private static void pausa(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // buena practica: restaurar la senal
        }
    }

    private static void imprimirError(String mensaje) {
        System.out.println();
        System.out.println(ROJO + "   " + mensaje + RESET);
    }

    private static void imprimirBienvenida(String usuario) {
        System.out.println();
        System.out.println(VERDE + "   +==========================================+" + RESET);
        System.out.println(VERDE + "   |          [OK]  LOGIN EXITOSO             |" + RESET);
        System.out.println(VERDE + "   +==========================================+" + RESET);
        System.out.println();
        System.out.println("   Bienvenido/a, " + VERDE + NEGRITA + usuario + RESET + "!");
        System.out.println(GRIS + "   Sesion iniciada correctamente en SauceDemo." + RESET);
        System.out.println();
    }

    private static void imprimirDespedidaBloqueado() {
        System.out.println();
        System.out.println(ROJO + "   +==========================================+" + RESET);
        System.out.println(ROJO + "   |   [X]  CUENTA BLOQUEADA - 3 INTENTOS     |" + RESET);
        System.out.println(ROJO + "   +==========================================+" + RESET);
        System.out.println(GRIS + "   Contacta al administrador o intenta mas tarde." + RESET);
        System.out.println();
    }
}