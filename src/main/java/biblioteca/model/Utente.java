package biblioteca.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Utente {

    @Id
    private int numeroTessera;

    private String nome;
    private String cognome;
    private LocalDate dataNascita;

    public Utente() {}

    public Utente(String nome, String cognome, LocalDate dataNascita, int numeroTessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.numeroTessera = numeroTessera;
    }

    public int getNumeroTessera() {
        return numeroTessera;
    }

    public String getNomeCompleto() {
        return nome + " " + cognome;
    }

    @Override
    public String toString() {
        return getNomeCompleto() + numeroTessera;
    }
}
