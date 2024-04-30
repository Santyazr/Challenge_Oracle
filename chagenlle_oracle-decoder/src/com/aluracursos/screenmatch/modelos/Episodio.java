package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.calculos.Clasificacion;

public class Episodio implements Clasificacion {

    private int numreroEp;
    private String nombreEp;
    private Serie serie;
    private int totalVisualisaciones;

    public int getNumreroEp() {
        return numreroEp;
    }

    public String getNombreEp() {
        return nombreEp;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setNumreroEp(int numreroEp) {
        this.numreroEp = numreroEp;
    }

    public void setNombreEp(String nombreEp) {
        this.nombreEp = nombreEp;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public void setTotalVisualisaciones(int totalVisualisaciones) {
        this.totalVisualisaciones = totalVisualisaciones;
    }


    @Override
    public int getClasificacion() {
        if (totalVisualisaciones > 100) {
            return 4;
        }else {
            return 2;
        }

    }
}
