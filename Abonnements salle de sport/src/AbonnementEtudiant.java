import java.time.LocalDate;

public class AbonnementEtudiant extends Abonnement {
    private double reductionPourcent;

    public AbonnementEtudiant(String reference, LocalDate dateDebut, int dureeMois, double prixMensuel, double reductionPourcent) {
        super(reference, dateDebut, dureeMois, prixMensuel);
        this.reductionPourcent = reductionPourcent;
    }

    @Override
    public double coutTotal() {
        double prixNormal = super.coutTotal();
        return prixNormal * (1 - (reductionPourcent / 100));
    }

    @Override
    public boolean permetAccesSauna() {
        return false; // Les étudiants sont sur un budget, pas de sauna !
    }

    @Override
    public int creditCoachInclus() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " [Type: ETUDIANT, Réduction: " + reductionPourcent + "%]";
    }
}