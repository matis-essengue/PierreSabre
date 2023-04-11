package histoire;

import personnages.Commercant;
import personnages.Ronin;
import personnages.Samourai;
import personnages.Traitre;
import personnages.Yakuza;

public class HistoireTP5 {
    public static void main(String[] args) {
        Commercant marco = new Commercant("Marco", "thé", 20);
        Commercant chonin = new Commercant("Chonin", "thé", 40);
        Commercant kumi = new Commercant("Kumi", "thé", 10);
        Yakuza yaku = new Yakuza("Yaku Le Noir", "whisky", 30, "Warsong");
        Ronin roro = new Ronin("Roro", "shochu", 60);

        // marco.faireConnaissanceAveHumain(roro);
        // marco.faireConnaissanceAveHumain(yaku);
        // marco.faireConnaissanceAveHumain(chonin);
        // marco.faireConnaissanceAveHumain(kumi);
        // marco.listerConnaissances();
        // roro.listerConnaissances();
        // yaku.listerConnaissances();

        Samourai akimoto = new Samourai("Miyamoto", "Akimoto", "Saké", 80);

        // akimoto.faireConnaissanceAveHumain(marco);
        // akimoto.listerConnaissances();
        // akimoto.boire("thé");

        Traitre masako = new Traitre("Miyamoto", "Masako", "whisky", 100);

        masako.faireLeGentil();
        masako.ranconner(kumi);
        masako.ranconner(chonin);
        masako.ranconner(marco);
        akimoto.faireConnaissanceAveHumain(masako);
        masako.ranconner(kumi);
        masako.faireConnaissanceAveHumain(yaku);
        masako.faireLeGentil();
        masako.faireConnaissanceAveHumain(roro);
    }
}
