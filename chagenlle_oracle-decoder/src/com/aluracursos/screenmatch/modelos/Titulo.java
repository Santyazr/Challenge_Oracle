package com.aluracursos.screenmatch.modelos;

import com.google.gson.annotations.SerializedName;

public class Titulo {
    @SerializedName("Title")
    String nombre;
    @SerializedName("Year")
    int fechaDeLanzamiento;
    int duracionEnMinutos;
    boolean incluidoEnElPlan;
    private double sumaDeLasEvaluaciones;
    private int totalDeLasEvaluaciones;

    public Titulo(TituloOmdb miTituloOmdb) {
        this.nombre = miTituloOmdb.title();
        this.fechaDeLanzamiento = Integer.valueOf(miTituloOmdb.year());
        this.duracionEnMinutos = Integer.valueOf(miTituloOmdb.runtime().substring(0,3).replace(" ",""));
    }

    public boolean isIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    public int getTotalDeLasEvaluaciones() {
        return totalDeLasEvaluaciones;
    }

    double getSumaDeLasEvaluaciones() {
        return sumaDeLasEvaluaciones;
    }

    public void muestraFichaTecnica() {
        System.out.println("El nombre de la pelicula/serie es: " + nombre);
        System.out.println("Y fue lanzada en: " + fechaDeLanzamiento);
        System.out.println("Duracion en minutos " + getDuracionEnMinutos());
    }

    public void evalua(double nota) {
        sumaDeLasEvaluaciones += nota;
        totalDeLasEvaluaciones++;

    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ",fechaDeLanzamiento=" + fechaDeLanzamiento+
                ", duracionEnMinutos" + duracionEnMinutos;
    }

    public double calculaMedia() {
        return sumaDeLasEvaluaciones / totalDeLasEvaluaciones;



    }



}
