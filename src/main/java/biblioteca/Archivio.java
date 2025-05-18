package biblioteca;
import biblioteca.exception.ElementoNonTrovatoException;
import biblioteca.model.*;

import java.util.*;
import java.util.stream.Collectors;
public class Archivio {
    private Map<String, ElementoCatalogo> catalogo = new HashMap<>();
    public void aggiungi(ElementoCatalogo e) {
        if (catalogo.containsKey(e.getIsbn())) throw new IllegalArgumentException("ISBN già presente!");
        catalogo.put(e.getIsbn(), e);
    }
    public ElementoCatalogo cercaPerIsbn (String isbn) {
        ElementoCatalogo e = catalogo.get(isbn);
        if ( e== null) throw new ElementoNonTrovatoException("Elemento non trovato con ISBN: "+ isbn);
        return e;
    }
    public void rimuovi(String isbn) {
        if (!catalogo.containsKey(isbn)) throw new ElementoNonTrovatoException("Impossibile rimuovere. ISBN non esiste.");
        catalogo.remove(isbn);
    }

    public List<ElementoCatalogo> cercaPerAnno(int anno) {
        return catalogo.values().stream()
                .filter(e -> e.getAnno() == anno)
                .collect(Collectors.toList());
    }

    public List<Libro> cercaPerAutore(String autore) {
        return catalogo.values().stream()
                .filter(e -> e instanceof Libro)
                .map(e -> (Libro)e)
                .filter(l -> l.getAutore().equalsIgnoreCase(autore))
                .collect(Collectors.toList());
    }

    public void aggiorna(String isbn, ElementoCatalogo nuovo) {
        if (!catalogo.containsKey(isbn)) throw new ElementoNonTrovatoException("Impossibile aggiornare. ISBN non esiste.");
        catalogo.put(isbn, nuovo);
    }

    public void stampaStatistiche() {
        long nLibri = catalogo.values().stream().filter(e -> e instanceof Libro).count();
        long nRiviste = catalogo.values().stream().filter(e -> e instanceof Rivista).count();

        ElementoCatalogo maxPagine = catalogo.values().stream()
                .max(Comparator.comparingInt(ElementoCatalogo::getPagine))
                .orElse(null);

        double media = catalogo.values().stream()
                .mapToInt(ElementoCatalogo::getPagine)
                .average().orElse(0);

        System.out.println("Totale libri: " + nLibri);
        System.out.println("Totale riviste: " + nRiviste);
        System.out.println("Elemento con più pagine: " + (maxPagine != null ? maxPagine.getTitolo() : "Nessuno"));
        System.out.println("Media pagine: " + media);
    }
}

