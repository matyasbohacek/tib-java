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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.util.Random;

/**
 *
 * @author Ucebna
 */
public class Panel extends JPanel implements ActionListener, KeyListener {

    private Kostky kostky[];
    private Timer timer;

    public static final int POCET_X = 10;
    public static final int POCET_Y = 25;
    public static final int VELIKOST_CTVERECKU = 30;

    public static boolean game = true;

    public Panel() {
        setBackground(Color.black);
        setFocusable(true);
        setPreferredSize(new Dimension(321, 813));

        kostky = new Kostky[10];

        Kostky k = new Kostky();
        k.x = new Random().nextInt(POCET_X - 1);
        k.y = 0;
        k.tvar = Tvar.nahodnyTvar();
        k.barva = Barva.nahodnaBarva();
        k.muzeSeHybat = true;
        kostky[0] = k;

        timer = new Timer(150, this);
        timer.start();

        addKeyListener(this);
    }

    public void paintComponent(Graphics g) {

        // Pozadí
        g.setColor(Color.black);
        g.fillRect(0, 0, 301, 751);

        if (game == true) {
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
        } else {
          g.setColor(Color.white);
          g.drawString("GAME OVER", 20, 50);
        }

    }

    public void nakresliKostky(Kostky kostky, Graphics g) {

        switch (kostky.barva) {
          case ZELENA:
            g.setColor(Color.green);
            break;

          case MODRA:
            g.setColor(Color.blue);
            break;

          case CERVENA:
            g.setColor(Color.red);
            break;

          case ZLUTA:
            g.setColor(Color.yellow);
            break;

          case FIALOVA:
            g.setColor(Color.magenta);
            break;

        }

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
            if (kostky[i] != null && kostky[i].muzeSeHybat == true) {
                kostky[i].y++;
            }

            // Ověřování zastavení
            if(kostky[i] != null && kostky[i].muzeSeHybat == true) {
              if (kostky[i].y + Tvar.vyska(kostky[i].tvar) >= 19) {
                kostky[i].muzeSeHybat = false;

                vytvorKostku(i + 1);
                repaint();
                return;
              }

              
              boolean[][] poleObsazenosti = new boolean[POCET_X][POCET_Y];

              for (Kostky k: kostky) {
                if (k != null && k.muzeSeHybat == false) {
                  for (int y = 0; y < 4; y++) {
                    for (int x = 0; x < 2; x++) {
                      poleObsazenosti[k.x + x][k.y + y] = k.tvar.vTabulce()[y][x];
                    }
                  }
                }
              }

              for (int y = 0; y < 4; y++) {
                for (int x = 0; x < 2; x++) {
                  if (kostky[i].tvar.vTabulce()[y][x]) {
                    if (poleObsazenosti[kostky[i].x + x][kostky[i].y + y + 1]) {
                      // Narazila by
                      kostky[i].muzeSeHybat = false;

                      // Ověření konce hry
                      for (int j = 0; j < POCET_X; j++) {
                        if(poleObsazenosti[j][0] == true) {
                          game = false;
                          return;
                        }
                      }

                      vytvorKostku(i + 1);
                      repaint();
                      return;
                    }
                  }
                }
              }

            }
        }
              

        // Znova vykreslit
        repaint();
    }

    public void vytvorKostku(int i) {
      Kostky k = new Kostky();
      k.x = new Random().nextInt(POCET_X - 1);
      k.y = 0;
      k.tvar = Tvar.nahodnyTvar();
      k.barva = Barva.nahodnaBarva();
      k.muzeSeHybat = true;
      kostky[i] = k;
    }

    @Override
    public void keyTyped(KeyEvent e) {
      
    }

    @Override
    public void keyPressed(KeyEvent e) {
      int iAktivni = 0;
      for (int i = 0; i < kostky.length; i++) {
        if (kostky[i] != null) {

        }

        if (kostky[i].muzeSeHybat == true) {
          iAktivni = i;
          break;
        }
      }

      if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        if (kostky[iAktivni].x > 0) {
          kostky[iAktivni].x -= 1;
        }
      } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        if (kostky[iAktivni].x + Tvar.sirka(kostky[iAktivni].tvar) < POCET_X) {
          kostky[iAktivni].x += 1;
        }
      }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
