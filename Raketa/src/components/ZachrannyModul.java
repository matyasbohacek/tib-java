/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.util.Random;

/**
 *
 * @author matyas.bohacek
 */
public class ZachrannyModul {

    public boolean aktivovano = false;

    public void aktivovatPadak() {
        if (new Random().nextInt(2) == 0) {
            System.out.println("Padák úspěšně aktivován. Přistání na Zemi úspěšně naplánováno. Vyčkejte.");

            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
            }

            System.out.println("Finální fáze přistávání.");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
            }

            if (new Random().nextInt(2) == 0) {
                System.out.println("Přistání proběhlo úspěšně. Gratulujeme! Mise splněna.");
            } else {
                System.out.println("Přistání proběhlo neúspěšně. Posádka bohužel nepřežila.");
            }

            System.exit(0);
        }
    }

}
