import java.time.LocalDate;

public class AbonnementPremium extends Abonnement {
    // Attribut spécifique à la version Premium
    private int creditsCoach;

    public AbonnementPremium(String reference, LocalDate dateDebut, int dureeMois, double prixMensuel, int creditsCoach) {
        // On envoie les infos de base à la classe mère
        super(reference, dateDebut, dureeMois, prixMensuel);
        this.creditsCoach = creditsCoach;
    }

    @Override
    public boolean permetAccesSauna() {
        return true; // Accès autorisé pour les Premium
    }

    @Override
    public int creditCoachInclus() {
        // On retourne la valeur de l'attribut spécifique
        return this.creditsCoach;
    }

    @Override
    public String toString() {
        return super.toString() + " [Type: PREMIUM, Crédits Coach: " + creditsCoach + "]";
    }
}