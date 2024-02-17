package Cinema.cinema_Infrastructure;

import java.util.ArrayList;
import java.util.List;
import Cinema.cinema_Infrastructure.PostoASedere;

public class Sala {

    // Variabili d'istanza private per il numero della sala e per la lista dei posti a sedere.
    private int numeroSala;
    private List<PostoASedere> posti; // Lista di PostoASedere, che rappresenta i posti nella sala.

    // Costruttore che accetta solo il numero della sala.

    public Sala(int numeroSala){
        this.numeroSala = numeroSala;
    }

    // Costruttore che accetta il numero della sala e il numero di posti.
    // Inizializza la lista dei posti con una capacità definita e riempie la lista con posti liberi.
    public Sala(int numeroSala, int numeroPosti){
        this.numeroSala = numeroSala;
        this.posti = new ArrayList<>(numeroPosti); // Inizializza la lista con la capacità specificata.
        for(int i = 0; i < numeroPosti; i++){
            // Aggiunge posti alla lista, numerati da 1 a numeroPosti e inizialmente liberi.
            posti.add(new PostoASedere(i+1, true));
        }
    }

    // Metodo getter per ottenere il numero della sala.
    public int getNumeroSala() {
        return numeroSala;
    }

    // Metodo setter per impostare il numero della sala.
    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    // Metodo getter che ritorna il numero totale dei posti nella sala.
    public int getPosti() {
        return posti.size();
    }

    // Metodo setter per impostare la lista dei posti a sedere nella sala.
    public void setPosti(List<PostoASedere> posti) {
        this.posti = posti;
    }

    // Metodo per occupare un posto specifico nella sala.
    // Ritorna true se il posto è stato occupato con successo, false se il posto è già occupato.
    public boolean occupaPosto(int numeroPosto) {
        for (PostoASedere posto : posti) {
            // Cerca il posto specificato e verifica se è libero.
            if (posto.getNumero() == numeroPosto && posto.isLibero()) {
                posto.setLibero(false); // Occupa il posto.
                System.out.println("Prenotazione effettuata con successo!");
                return true; // Conferma l'avvenuta occupazione.
            }
        }
        System.out.println("Posto già occupato!"); // Il posto è già stato occupato.
        return false; // Non è stato possibile occupare il posto.
    }
}
