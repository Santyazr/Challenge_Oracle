package com.aluracursos.screenmatch.modelos;

public class Serie extends Titulo{
    int temporadas;
    int epPorTemporadas;
    int minPorEpisodio;

    public Serie(TituloOmdb miTituloOmdb) {
        super(miTituloOmdb);
    }

    public int getTemporadas() {
        return temporadas;
    }

    public int getEpPorTemporadas() {
        return epPorTemporadas;
    }

    public int getMinPorEpisodio() {
        return minPorEpisodio;
    }


    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public void setEpPorTemporadas(int epPorTemporadas) {
        this.epPorTemporadas = epPorTemporadas;
    }

    public void setMinPorEpisodio(int minPorEpisodio) {
        this.minPorEpisodio = minPorEpisodio;
    }

    @Override
    public int getDuracionEnMinutos() {
        return temporadas * epPorTemporadas*minPorEpisodio;
    }

}
