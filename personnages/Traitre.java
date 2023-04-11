package personnages;

import java.util.Random;

public class Traitre extends Samourai {
    private int niveauTraitrise;

    public Traitre(String seigneur, String nom, String boissonFavorite, int argent) {
        super(seigneur, nom, boissonFavorite, argent);
    }

    @Override
    public void direBonjour() {
        super.direBonjour();
        parler("Mais je suis un traître et mon niveau de traîtrise est : " + niveauTraitrise + ". Chut !");
    }

    public void ranconner(Commercant commercant) {
        if (niveauTraitrise < 3) {
            int argentCommercant = commercant.getArgent();
            int argentRanconner = argentCommercant * 2 / 10;
            commercant.perdreArgent(argentRanconner);
            gagnerArgent(argentRanconner);
            niveauTraitrise += 1;

            parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne moi " + argentRanconner
                    + " sous ou gare à toi!");
            commercant.parler("Tout de suite grand " + getNom() + ".");
        } else {
            parler("Mince je ne peux plus rançonner personne sinon un samourai risque de me démasquer !");
        }
    }

    public void faireLeGentil() {
        if (nbConnaissance < 1) {
            parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif.");
        } else {
            Random random = new Random();
            Humain ami = connaissances[random.nextInt(nbConnaissance)];
            int don = getArgent() * 1 / 20;
            String nomAmi = ami.getNom();
            parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + nomAmi + ".");
            parler("Bonjour l'ami !" + "Je voudrais vous aider en vous donnant " + don + " sous.");
            ami.gagnerArgent(don);
            perdreArgent(don);
            ami.parler("Merci " + getNom() + ". Vous êtes quelqu'un de bien.");
            niveauTraitrise -= 1;
        }
    }
}
