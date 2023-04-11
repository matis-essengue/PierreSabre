package personnages;

public class Humain {
    private String nom;
    private String boissonFavorite;
    private int argent;
    private int nbConnaissance;
    private Humain[] connaissances;
    private static int nbConnaissanceMax = 30;

    public Humain(String nom, String boissonFavorite, int argent) {
        this.nom = nom;
        this.boissonFavorite = boissonFavorite;
        this.argent = argent;
        this.nbConnaissance = 0;
        this.connaissances = new Humain[nbConnaissanceMax];
    }

    public String getNom() {
        return nom;
    }

    public int getArgent() {
        return argent;
    }

    public void direBonjour() {
        parler("Bonjour ! je m'appelle " + nom + " et j'aime boire du " + boissonFavorite + ".");
    }

    public void boire() {
        parler("Mmmm un bon verre de " + boissonFavorite + " ! GLOUPS !");
    }

    public void acheter(String bien, int prix) {
        if (argent >= prix) {
            parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir un(e) " + bien + " à " + prix
                    + " sous.");
            argent -= prix;
        } else {
            parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux mmême pas m'offrir un(e) " + bien + " à "
                    + prix + " sous.");
        }
    }

    public void gagnerArgent(int gain) {
        argent += gain;
    }

    public void perdreArgent(int perte) {
        argent -= perte;
    }

    protected void parler(String texte) {
        System.out.println("(" + nom + ")" + " : " + texte);
    }

    public void faireConnaissanceAveHumain(Humain autreHumain) {
        direBonjour();
        autreHumain.repondre(this);
        memoriser(autreHumain);
    }

    private void memoriser(Humain humain) {
        if (nbConnaissance < nbConnaissanceMax) {
            connaissances[nbConnaissance] = humain;
            nbConnaissance++;
        } else {
            for (int i = 0; i < nbConnaissance - 1; i++) {
                connaissances[i] = connaissances[i + 1];
            }
            connaissances[nbConnaissance - 1] = humain;
        }
    }

    protected void repondre(Humain humain) {
        direBonjour();
        memoriser(humain);
    }

    public void listerConnaissances() {
        System.out.print("Je connais beaucoup de monde dont : ");
        for (int i = 0; i < nbConnaissance; i++) {
            System.out.print(connaissances[i].getNom() + ", ");
        }
        System.out.println();
    }
}
