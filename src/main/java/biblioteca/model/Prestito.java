package biblioteca.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Prestito {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Utente utente;

    @ManyToOne
    private ElementoCatalogo elemento;

    private LocalDate dataInizio;
    private LocalDate dataPrevistaRestituzione;
    private LocalDate dataRestituzioneEffettiva;

    public Prestito() {}

    public Prestito(Utente utente, ElementoCatalogo elemento, LocalDate dataInizio) {
        this.utente = utente;
        this.elemento = elemento;
        this.dataInizio = dataInizio;
        this.dataPrevistaRestituzione = dataInizio.plusDays(30);
    }

    public void restituisci(LocalDate data) {
        this.dataRestituzioneEffettiva = data;
    }

    public boolean isInPrestito() {
        return dataRestituzioneEffettiva == null;
    }

    @Override
    public String toString() {
        return "Prestito a " + utente.getNomeCompleto() +
                " di '" + elemento.getTitolo() + "' | Inizio: " + dataInizio +
                " | Prevista: " + dataPrevistaRestituzione +
                " | Restituita: " + (dataRestituzioneEffettiva != null ? dataRestituzioneEffettiva : "Non ancora");
    }
}
