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

    public void provoquer(Yakuza adversaire) {
        int force = honneur * 2;
        int forceAdversaire = adversaire.getReputation();

        parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");

        if (force >= forceAdversaire) {
            parler("Je t’ai eu petit yakusa!");
            honneur += 1;
            int gain = adversaire.perdre();
            gagnerArgent(gain);
        } else {
            parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont pris un coup.");
            honneur -= 1;
            int argentPerdu = getArgent();
            perdreArgent(argentPerdu);
            adversaire.gagner(argentPerdu);
        }
    }
}
