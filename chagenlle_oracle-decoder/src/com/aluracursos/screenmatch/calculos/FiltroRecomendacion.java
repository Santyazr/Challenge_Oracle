package com.aluracursos.screenmatch.calculos;

public class FiltroRecomendacion {
    public void filtra(Clasificacion clasificacion){
        if (clasificacion.getClasificacion() >= 4) {
            System.out.println("Muy bien evaluado");
        }else if (clasificacion.getClasificacion() >= 2){
            System.out.println("Masomeno");
        }else{
            System.out.println("Todavia esta verde");
        }
    }
}