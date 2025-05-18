package biblioteca;

import biblioteca.model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Archivio archivio = new Archivio();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Aggiungi | 2. Cerca ISBN | 3. Rimuovi | 4. Cerca per anno | 5. Cerca per autore | 6. Aggiorna | 7. Statistiche | x. Esci");
            String scelta = sc.nextLine();

            try {
                switch (scelta) {
                    case "1":
                        System.out.println("Libro o Rivista? (l/r)");
                        String tipo = sc.nextLine();
                        System.out.print("ISBN: "); String isbn = sc.nextLine();
                        System.out.print("Titolo: "); String titolo = sc.nextLine();
                        System.out.print("Anno: "); int anno = Integer.parseInt(sc.nextLine());
                        System.out.print("Pagine: "); int pagine = Integer.parseInt(sc.nextLine());

                        if (tipo.equals("l")) {
                            System.out.print("Autore: "); String autore = sc.nextLine();
                            System.out.print("Genere: "); String genere = sc.nextLine();
                            archivio.aggiungi(new Libro(isbn, titolo, anno, pagine, autore, genere));
                        } else {
                            System.out.print("Periodicità (SETTIMANALE/MENSILE/SEMESTRALE): ");
                            Periodicita p = Periodicita.valueOf(sc.nextLine().toUpperCase());
                            archivio.aggiungi(new Rivista(isbn, titolo, anno, pagine, p));
                        }
                        break;

                    case "2":
                        System.out.print("ISBN: ");
                        System.out.println(archivio.cercaPerIsbn(sc.nextLine()));
                        break;

                    case "3":
                        System.out.print("ISBN da rimuovere: ");
                        archivio.rimuovi(sc.nextLine());
                        break;

                    case "4":
                        System.out.print("Anno: ");
                        archivio.cercaPerAnno(Integer.parseInt(sc.nextLine())).forEach(System.out::println);
                        break;

                    case "5":
                        System.out.print("Autore: ");
                        archivio.cercaPerAutore(sc.nextLine()).forEach(System.out::println);
                        break;

                    case "6":
                        System.out.print("ISBN da aggiornare: ");
                        String isbnUp = sc.nextLine();
                        System.out.print("Nuovo titolo: ");
                        String tit = sc.nextLine();
                        archivio.aggiorna(isbnUp, new Libro(isbnUp, tit, 2020, 100, "N/D", "aggiornato"));
                        break;

                    case "7":
                        archivio.stampaStatistiche();
                        break;

                    case "x":
                        return;

                    default:
                        System.out.println("Scelta non valida.");
                }
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }
    }
}
