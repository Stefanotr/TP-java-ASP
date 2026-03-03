import java.time.LocalDate;

public class AbonnementBasic extends Abonnement {

    public AbonnementBasic(String reference, LocalDate dateDebut, int dureeMois, double prixMensuel) {
        super(reference, dateDebut, dureeMois, prixMensuel);
    }

    @Override
    public boolean permetAccesSauna() {
        return false;
    }

    @Override
    public int creditCoachInclus() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " [Type: BASIC]";
    }
}