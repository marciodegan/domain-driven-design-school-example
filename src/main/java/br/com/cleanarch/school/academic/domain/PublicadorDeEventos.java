package br.com.cleanarch.school.academic.domain;

import java.util.ArrayList;
import java.util.List;

/*
O objetivo do publicador de eventos é guardar cada um dos ouvintes e quando o método for publicado para um determinado evento,
ele dispara o método processa para cada um desses ouvintes.
* */
public class PublicadorDeEventos {

    private List<Ouvinte> ouvintes = new ArrayList<>();

    public void adicionar(Ouvinte ouvinte) {
        this.ouvintes.add(ouvinte);
    }

    public void publicar(Evento evento) {
        this.ouvintes.forEach(o -> o.processa(evento));
    }
}
