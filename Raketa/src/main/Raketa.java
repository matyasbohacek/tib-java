/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import components.Druzice;
import components.Motor;
import components.ZachrannyModul;

/**
 *
 * @author matyas.bohacek
 */
public class Raketa {

    // INFORMACE
    public static int vyska = 1; // Výška je v kilometrech

    public static int rychlost = 0; // Rychlost je v kilometrech/hodinu

    public static float casLetu = 0; // Čas letu je v sekundách

    public static double palivo = 0; // Palivo je v litrech

    // MODULY
    public static Motor motor = new Motor();

    public static ZachrannyModul zachrannyModul = new ZachrannyModul();

    public static Druzice druzice = new Druzice();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        palivo = 1000;

        while (!motor.zapnuto) {
            motor.zapnoutMotor();
        }

        zkontrolovatStart();

        Thread letRakety = new Thread() {
            public void run() {
                while (true) {

                    // PROSTOR PRO PSANÍ KÓDU
                    if (casLetu < 10) {
                        motor.pridatRychlost(34);
                    }

                    if (vyska > 5000) {
                        if (rychlost > 100) {
                            motor.ubratRychlost(100);
                        } else {
                            motor.ubratRychlost(rychlost);
                        }
                    }

                    if (rychlost == 0) {
                        motor.vypnoutMotor();
                        druzice.odpojit();
                    }

                    if (druzice.odpojeno) {
                        zachrannyModul.aktivovatPadak();
                    }

                    // KONEC PROSTORU
                    motor.prepocitatHodnoty();
                    zkontrolovatUdaje();
                    vypsatInformace();

                    try {
                        // Program rakety se načítá každou půl minutu
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                    }

                    // Zvýšení času
                    Raketa.casLetu += 0.5;
                }
            }
        };

        letRakety.start();
    }

    private static void vypsatInformace() {
        System.out.println("VÝŠKA");
        System.out.println(vyska);

        System.out.println("RYCHLOST");
        System.out.println(rychlost);

        System.out.println("PALIVO");
        System.out.println(palivo);

        System.out.println("---" + casLetu + "---");
    }

    private static void zkontrolovatStart() {
        if (palivo == 0) {
            System.out.println("Není možno vzlétnout, nemáte palivo. " + palivo);
            System.exit(0);
        }

        if (!motor.zapnuto) {
            System.out.println("Není možno vzlétnout, motor není zapnutý.");
            System.exit(0);
        }
    }

    private static void zkontrolovatUdaje() {
        if (Raketa.casLetu < 10) {
            if (Raketa.rychlost > 700) {
                System.out.println("Špatná rychlost. Právě jste spadli. " + Raketa.rychlost);
                System.exit(0);
            }
        } else {

            if (Raketa.rychlost > 1000) {
                System.out.println("Špatná rychlost. Právě jste spadli. " + Raketa.rychlost);
                System.exit(0);
            }
        }

        if (Raketa.rychlost < 0) {
            System.out.println("Záporná rychlost není možna. Právě jste spadli.");
            System.exit(0);
        }

        if (Raketa.palivo < 0 && Raketa.rychlost > 0) {
            System.out.println("Nedostatek paliva. Právě jste spadli. " + Raketa.palivo);
            System.exit(0);
        }

        if (Raketa.palivo > 3000) {
            System.out.println("Nedostatek paliva. Právě jste spadli. " + Raketa.palivo);
            System.exit(0);
        }

        if (vyska > 7000) {
            System.out.println("Příliš vysoko. Mise nesplěna.");
            System.exit(0);
        }
    }

}
