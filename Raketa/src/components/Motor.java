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
public class Motor {

    public boolean zapnuto = false;

    public boolean hori = false;

    public void zapnoutMotor() {
        if (Raketa.palivo == 0) {
            return;
        }

        if (new Random().nextInt(2) == 0) {
            this.zapnuto = true;
        }
    }

    public void vypnoutMotor() {
        this.zapnuto = false;
    }

    public void pridatRychlost(int pridani) {
        if (pridani > 100) {
            System.out.println("Příliš rychlé přidání. Spadli jste. " + pridani);
            System.exit(0);
        }

        Raketa.rychlost += pridani;
    }

    public void ubratRychlost(int odebrani) {
        if (odebrani > 100) {
            System.out.println("Příliš rychlé přidání. Spadli jste. " + odebrani);
            System.exit(0);
        }

        Raketa.rychlost -= odebrani;
    }

    public void prepocitatHodnoty() {
        Raketa.vyska += (int) (0.5 * Raketa.rychlost);
        Raketa.palivo -= (double) Raketa.rychlost / (double) 15;
    }

}
