/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

/**
 *
 * @author Ucebna
 */
public class Panel extends JPanel {

    private Kostky kostky[];
    private Barva barvicky[][];

    public static final int POCET_X = 10;
    public static final int POCET_Y = 25;
    public static final int VELIKOST_CTVERECKU = 30;

    public Panel() {
        setBackground(Color.black);
        setFocusable(true);
        setPreferredSize(new Dimension(321, 813));

        kostky = new Kostky[10];
        barvicky = new Barva[POCET_X][POCET_Y];
    }

    public void paintComponent(Graphics g) {

        // Pozadí
        g.setColor(Color.black);
        g.fillRect(0, 0, 301, 751);

        // Čtverečky
        g.setColor(Color.white);
        for (int x = 0; x < POCET_X; x++) {
            for (int y = 0; y < POCET_Y; y++) {
                g.drawRect(x * VELIKOST_CTVERECKU + 1, y * VELIKOST_CTVERECKU + 1,
                        VELIKOST_CTVERECKU - 2, VELIKOST_CTVERECKU - 2);
            }
        }

        Kostky kostkyTest = new Kostky();
        kostkyTest.tvar = Tvar.ELKO_L;
        kostkyTest.x = 5;
        kostkyTest.y = 3;
        nakresliKostky(kostkyTest, g);
    }

    public void nakresliKostky(Kostky kostky, Graphics g) {
        g.setColor(Color.red);
        
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 2; x++) {
                if (kostky.tvar.vTabulce()[y][x] == true) {
                    g.fillRect((kostky.x + x) * VELIKOST_CTVERECKU + 1,
                            (kostky.y + y) * VELIKOST_CTVERECKU + 1,
                            VELIKOST_CTVERECKU - 2, VELIKOST_CTVERECKU - 2);
                }
            }
        }
    }
}