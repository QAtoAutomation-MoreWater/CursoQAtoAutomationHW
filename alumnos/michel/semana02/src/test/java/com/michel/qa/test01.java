package com.michel.qa;

public class test01 {
    public static void main(String[] args) {
        int exitosos = 8;
        int total = 10;

        double tasa = (double) exitosos / total * 100;
        System.out.println("Tasa de éxito: " + tasa + "%");
/* 
standar_user
locked_out_user
problem_user
performance_glitch_user
*/

int usuariosConocidos = 4;
int usuariosRotos = 2;

double pUsuariosRotos = (double) usuariosRotos / usuariosConocidos * 100;
System.out.println("Porcentaje de usuarios rotos: " + pUsuariosRotos + "%");




    }
}
//METER 3 NUEVAS VARIAABLES, 1 POR CADA USUARIO DE SAUCE DEMO QUE CONOSCAS
//Y UNA LINEA QUE CALCULE EL PORCENTAJE DE CUANTOS USUARIOS DE ESTOS SON ROTOS,