package com.michel.qa;

public class Variables {
    public static void main(String[] args) {
        //Primitivos Guardan valor directo
        int casosEjecutados = 10;
        long ejecucionesHistoricas = 1_500_00L;
        double tasaExitoso = 87.5;
        boolean todosPasaron = false;
        char InicialTester = 'M';

        //VARIABLES REFERENCIA
        String nombreTester = "Michel";
        String plataforma = "SauceDemo";

        System.out.println("Tester: "+nombreTester);
        System.out.println("Plataforma: "+plataforma);
        System.out.println("Casos ejecutados: "+casosEjecutados);
        System.out.println("tasa de exito: "+tasaExitoso);
        System.out.println("Todos pasaron: "+todosPasaron);
        System.out.println("ejecuciones historicas: "+ejecucionesHistoricas);       
        System.out.println("Inicial del tester: "+InicialTester);




    }
}
