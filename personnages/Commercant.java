package personnages;

public class Commercant extends Humain {
    public Commercant(String nom, String boissonFavorite, int argent) {
        super(nom, boissonFavorite, argent);
    }

    public int seFaireExtorquer() {
        int argent = getArgent();
        perdreArgent(argent);
        parler("J’ai tout perdu! Le monde est trop injuste...");
        return argent;
    }

    public void recevoir(int argent) {
        parler(argent + " sous ! Je te remercie généreux donateur!");
        gagnerArgent(argent);
    }
}
