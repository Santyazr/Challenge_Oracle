package com.aluracursos.screenmatch.modelos;


import com.aluracursos.screenmatch.calculos.Clasificacion;

public class Pelicula extends Titulo implements Clasificacion {
    private String director;

    public Pelicula(TituloOmdb miTituloOmdb) {
        super(miTituloOmdb);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getClasificacion(){
        return (int) (calculaMedia() /2);
    }
}
