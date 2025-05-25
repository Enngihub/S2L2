package biblioteca.model;

import jakarta.persistence.Entity;


@Entity
public class Libro extends ElementoCatalogo{

    private String autore;
    private String genere;

    public Libro() {}

    public Libro(String isbn, String titolo, int anno, int pagine, String autore, String genere) {
        super(isbn, titolo, anno, pagine);
        this.autore = autore;
        this.genere = genere;
    }
    public String getAutore() {return autore;}
    public String getGenere() {return genere;}
    @Override
    public String toString() {
        return super.toString() + autore + genere;
    }
}
