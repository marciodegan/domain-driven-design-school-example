package br.com.cleanarch.school.academic.domain;

/*
    Essa classe representa um ouvinte Genérico, e só sabe processar um evento e para isso, verifica se tem que processar, chama o método reage.
 */
public abstract class Ouvinte {

    public void processa(Evento evento) {
        if (this.deveProcessar(evento)) {
            this.reageAo(evento);
        }
    }

    protected abstract void reageAo(Evento evento);
    protected abstract boolean deveProcessar(Evento evento);
}
