/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Random;

/**
 *
 * @author Ucebna
 */
public class Panel extends JPanel implements ActionListener {

    private Kostky kostky[];
    private Timer timer;


    public static final int POCET_X = 10;
    public static final int POCET_Y = 25;
    public static final int VELIKOST_CTVERECKU = 30;

    public Panel() {
        setBackground(Color.black);
        setFocusable(true);
        setPreferredSize(new Dimension(321, 813));

        kostky = new Kostky[10];

        Kostky k = new Kostky();
        k.x = new Random().nextInt(POCET_X - 1);
        k.y = 2;
        k.tvar = Tvar.NahodnyTvar();
        k.barva = Barva.NahodnaBarva();
        kostky[0] = k;

        timer = new Timer(150, this);
        timer.start();
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

        for (Kostky kostka : kostky) {
            if (kostka != null) {
                nakresliKostky(kostka, g);
            }
        }

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

    @Override
    public void actionPerformed(ActionEvent e) {
        // Přepočítat kostky
        for (int i = 0; i < kostky.length; i++) {
            if (kostky[i] != null) {
                kostky[i].y++;
            }
        }

        // Znova vykreslit
        repaint();
    }
}
