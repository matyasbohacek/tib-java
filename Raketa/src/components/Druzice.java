/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.util.Random;
import main.Raketa;

/**
 *
 * @author matyas.bohacek
 */
public class Druzice {

    public boolean odpojeno = false;

    public void odpojit() {
        if (new Random().nextInt(2) == 0) {
            this.odpojeno = true;

            if (Raketa.vyska > 6000 && Raketa.vyska < 7000 && !Raketa.motor.zapnuto) {
                System.out.println("Družice úspěšně odpojena. Vraťe se na Zem!");
            } else {
                System.out.println("Při odpojování družice došlo k fatální chybě. Družice expolodovala, s tím i kus Vaší rakety. Mise neúspěšná.");
                System.exit(0);
            }

        }
    }

}
