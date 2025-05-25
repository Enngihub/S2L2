package biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


@Entity
public class Rivista  extends ElementoCatalogo{
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;
public Rivista(){}

    public Rivista(String isbn, String titolo, int anno, int pagine, Periodicita periodicita) {
        super(isbn, titolo, anno, pagine);
        this.periodicita = periodicita;
    }
    public Periodicita getPeriodicita(){ return periodicita;}
    @Override
    public String toString() {
    return super.toString()+periodicita;
    }
}
