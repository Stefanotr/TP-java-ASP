import java.util.ArrayList;
import java.util.List;

enum StatusReservation {
    CONFIRMEE, ANNULEE
}

public class Reservation {
    private Seance seance;
    private List<Prestation> prestations;
    private StatusReservation status;

    public Reservation(Seance seance) {
        this.seance = seance;
        this.prestations = new ArrayList<>();
        this.status = StatusReservation.CONFIRMEE;
    }

    public void ajouterPrestation(Prestation p) {
        if (this.status == StatusReservation.CONFIRMEE) {
            this.prestations.add(p);
        } else {
            System.out.println("Impossible d'ajouter une prestation à une réservation annulée.");
        }
    }

    public double coutPrestation() {
        double total = 0;
        for (Prestation p : prestations) {
            total += p.getPrix();
        }
        return total;
    }

    public void annuler() {
        this.status = StatusReservation.ANNULEE;
    }

    public Seance getSeance() {
        return seance;
    }

    public StatusReservation getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Réservation [" + seance.getNom() + "] - Statut: " + status + ", Prestations: " + prestations.size() + ", Total: " + coutPrestation() + "€";
    }
}