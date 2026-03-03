import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Adherent {
    private int id;
    private String nom;
    private Abonnement abonnement;
    private List<Reservation> reservations;

    public Adherent(int id, String nom, Abonnement abonnement) {
        this.id = id;
        this.nom = nom;
        this.abonnement = abonnement;
        this.reservations = new ArrayList<>();
    }

    public void reserver(Seance s) {
        Reservation nouvelleResa = new Reservation(s);
        this.reservations.add(nouvelleResa);
    }

    public double depensesTotales() {
        double total = 0;
        for (Reservation r : reservations) {
            if (r.getStatus() == StatusReservation.CONFIRMEE) {
                // CORRECTION : on utilise coutPrestation() (sans 's')
                total += r.coutPrestation();
            }
        }
        return total;
    }

    public List<Reservation> reservationsFutures() {
        List<Reservation> futures = new ArrayList<>();
        LocalDateTime maintenant = LocalDateTime.now();

        for (Reservation r : reservations) {
            if (r.getSeance().getDateHeure().isAfter(maintenant)) {
                futures.add(r);
            }
        }
        return futures;
    }

    // Getters nécessaires pour la SalleDeSport
    public int getId() { return id; }
    public String getNom() { return nom; }
    public Abonnement getAbonnement() { return abonnement; }

    @Override
    public String toString() {
        return "Adhérent #" + id + " : " + nom + " (" + abonnement.getClass().getSimpleName() + ")";
    }
}