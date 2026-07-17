package com.morewater.qa;

public class Variables {
    public static void main(String[] args) {
        //Primitivos Guardan valor directo
        int casosEjecutados = 10;
        long ejecucionesHistoricas = 1_500_000_000_000L;
        double tasaExito = 87.5;
        boolean todosPasaron = false;
        char InicialTester = 'M';
        char InicialTester2 = 'M';

        boolean mismasIniciales = InicialTester == InicialTester2;

        //VARIABLES REFERENCIA
        String nombreTester = "Mazahua";
        String nombreTester2 = "Mazahua";

        boolean mismosNombres = nombreTester.equals(nombreTester2);
        boolean mismosNombres2 = nombreTester == nombreTester2;

        String plataforma = "SauceDemo";

        System.out.println("Tester: " + nombreTester);
        System.out.println("Plataforma: " + plataforma);
        System.out.println("Casos ejecutados: " + casosEjecutados);
        System.out.println("Tasa de éxito: " + tasaExito + "%");
        System.out.println("Todos pasaron: " + todosPasaron);
        System.out.println("Ejecuciones históricas: " + ejecucionesHistoricas);



        int exitosos = 8;
        int total = 10;

        double tasa = (double) exitosos / total * 100;
        System.out.println("Tasa de éxito: " + tasa + "%");

    }
    
}
