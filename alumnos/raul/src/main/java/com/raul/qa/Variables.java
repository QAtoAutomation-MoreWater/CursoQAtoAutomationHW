package com.raul.qa;

public class Variables {
    public static void main(String[] args) {

        //Primitivos Guardan valor directo

        int casosEjecutados = 10;
        long ejecucionesHistoricas = 1_500_00L;
        double tasaExito = 87.5;
        boolean todosPasaron = false;
        char inicialTester = 'M';
        
        //VARIABLES REFERENCIA..siempre apuntan a una dirección de una memoria
        String nombreTester = "Mazahua";
        String nombreTester2 = "Mazahua";
        String plataforma = "SauceDemo";

        boolean mismosNombres = nombreTester.equals(nombreTester2);
        boolean mismosNombres2 = nombreTester == nombreTester2;



        System.out.println("Tester: " + nombreTester);
        System.out.println("Plataforma: " + plataforma);
        System.out.println("Casos Ejecutados: " + casosEjecutados);
        System.out.println("Tasa de éxito: " + tasaExito + "%");
        System.out.println("Todos pasaron: " + todosPasaron);
        System.out.println("Ejecuciones Históricas: " + ejecucionesHistoricas);

String nombreUsuario1 = "admin_user";
String nombreUsuario2 = "blocked_user";
String nombreUsuario3 = "problem_user";
int usuariosRojos = 2;
int totalUsuarios = 3;

double porcRojos = (double) usuariosRojos / totalUsuarios * 100;
        System.out.println("% usuarios Rojos: " + porcRojos +"%");

         //3 nuevas variables, una por cada usuario
        // una mas por cada usuario si es rojo
        //calcular % de los rojos
    }

    
}
