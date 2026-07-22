package com.marjorie;

public class Variables {
public static void main (String[] args) {
    // Primitivos guardan valores directo
    int casosejecutados = 10;
    long ejecucioneshistoricas = 10_000_000L;
    double tasaExito = 87.5;
    boolean todosPasaron = false;
    char inicialTester = 'M';
    
    //variables de referencia
    String nombreTester = "Marjorie";
    String plataforma = "SauceDemo";

    // Imprimir valores de las variables
    System.out.println("Tester: " + nombreTester);
    System.out.println("Plataforma: " + plataforma);
    System.out.println("Casos ejecutados: " + casosejecutados);
    System.out.println("Tasa de éxito: " + tasaExito);
    System.out.println("Todos pasaron: " + todosPasaron);
    System.out.println("Ejecuciones históricas: " + ejecucioneshistoricas);
    
    
}
}