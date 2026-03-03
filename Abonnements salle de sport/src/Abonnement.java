import java.time.LocalDate;

public abstract class Abonnement {
    protected String reference;
    protected LocalDate dateDebut;
    protected int dureeMois;
    protected double prixMensuel;

    public Abonnement(String reference, LocalDate dateDebut, int dureeMois, double prixMensuel) {
    this.reference = reference;
    this.dateDebut = dateDebut;
    this.dureeMois = dureeMois;
    this.prixMensuel = prixMensuel;
    }

    public LocalDate dateFin() {
        return dateDebut.plusMonths(dureeMois);
    }

    public double coutTotal() {
    return prixMensuel * dureeMois;
    }

    public abstract boolean permetAccesSauna();
    public abstract int creditCoachInclus();

    @Override
    public String toString() {
        return "Abonnement Ref: " + reference + " | Début: " + dateDebut + " | Fin: " + dateFin() + " | Coût mensuel: " + prixMensuel + "€";
    }
}