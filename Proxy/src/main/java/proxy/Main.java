package proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Image> kuvalista = new ArrayList();
        ListIterator<Image> kuvaitr;
        Scanner lukija = new Scanner(System.in);
        boolean suunta = true;

        String imgName = "kuva ";
        for (int i = 0; i < 10; i++) {
            kuvalista.add(new ProxyImage(imgName + (i + 1)));
        }

        System.out.println("Kuvat: ");
        for (Image kuva : kuvalista) {
            kuva.showData();
        }
        System.out.println("");

        for (int i = 0; i < 2; i++) {
            kuvaitr = kuvalista.listIterator();

            while (kuvaitr.hasNext()) {
                System.out.println("edellinen valitse 1:, seuraava valitse 2");
                String vastaus = lukija.next();

                switch (vastaus) {
                    case "2":
                        if (suunta == false) {
                            kuvaitr.next();
                            kuvaitr.next().displayImage();
                            suunta = true;

                        } else {
                            kuvaitr.next().displayImage();
                        }
                        break;

                    case "1":
                        if (kuvaitr.hasPrevious() && suunta == true) {
                            kuvaitr.previous();
                            kuvaitr.previous().displayImage();
                            suunta = false;

                        } else if (kuvaitr.hasPrevious() && suunta == false) {
                            kuvaitr.previous().displayImage();
                        } else {
                            System.out.println("Ei enempää edellisiä kuvia.");
                        }
                        break;

                    default:
                        System.out.println("Valitse 2 tai 1!");
                        break;
                }
            }
        }
    }

}
