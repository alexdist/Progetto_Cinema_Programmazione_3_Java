package Cinema.user_services;



import Cinema.memento.Acquisto;
import Cinema.user_interfaces.AcquistoBiglietto;
import Cinema.payment_strategy.GestorePagamenti;
import Cinema.payment_strategy.IPagamentoStrategy;
import Cinema.ticket.Biglietto;

import Cinema.singleton.*;

import java.time.LocalDateTime;
import Cinema.memento.*;

public class ServizioAcquistoBiglietto implements AcquistoBiglietto {

    private GestorePagamenti gestorePagamenti;

    // Rimuovi il riferimento diretto a GestoreRicavi dal costruttore
    public ServizioAcquistoBiglietto(GestorePagamenti gestorePagamenti) {
        this.gestorePagamenti = gestorePagamenti;
    }

    @Override
    public void acquistaBiglietto(Biglietto biglietto, IPagamentoStrategy metodoPagamento) {
        // Configura e effettua il pagamento
        gestorePagamenti.setMetodoPagamento(metodoPagamento);
        gestorePagamenti.effettuaPagamento(biglietto.getCosto());

        // Ottiene GestoreRicavi dal Singleton Cinema e registra la vendita del biglietto
        Cinema.getInstance().getGestoreRicavi().registraVenditaBiglietto(biglietto);

        // Salva lo stato dell'acquisto utilizzando il pattern Memento
        // Accesso a Caretaker tramite il singleton Cinema (se implementato in questo modo)
        Caretaker caretaker = Cinema.getInstance().getCaretaker(); // Assumendo che esista questo metodo
        caretaker.addMemento(new Acquisto(biglietto, LocalDateTime.now()));

        System.out.println("Biglietto acquistato con successo per lo spettacolo: "
                + biglietto.getSpettacolo().getFilm().getTitolo() + " al costo di: " + biglietto.getCosto());
    }
}

