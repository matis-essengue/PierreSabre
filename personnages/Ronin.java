package personnages;

public class Ronin extends Humain {
    private int honneur = 1;

    public Ronin(String nom, String boissonFavorite, int argent) {
        super(nom, boissonFavorite, argent);
    }

    public void donner(Commercant beneficiare) {
        int don = getArgent() / 10;
        parler(beneficiare.getNom() + " prend ces " + don + " sous.");
        perdreArgent(don);
        beneficiare.recevoir(don);
    }
}
