package biblioteca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="elemento_catalogo")
public abstract class ElementoCatalogo {
    @Id
    protected String isbn;

    protected String titolo;

    protected int anno;

    protected int pagine;
public ElementoCatalogo(){}

    public ElementoCatalogo(String isbn, String titolo, int anno, int pagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.anno = anno;
        this.pagine = pagine;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnno() {
        return anno;
    }

    public int getPagine() {
        return pagine;
    }

    @Override
    public String toString() {
        return "ElementoCatalogo{" +
                "isbn='" + isbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", anno=" + anno +
                ", pagine=" + pagine +
                '}';
    }
}
