package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import javax.swing.JPanel;

/**
 *  *
 *  * @author matyas.bohacek  
 */
public class Panel extends JPanel implements KeyListener {

    int x = 20;
    int y = 80;
    int q = 0;
    Queue<Integer> qx = new LinkedList();
    Queue<Integer> qy = new LinkedList();
    int sirka = 0;
    int vyska = 0;

    boolean[][] s = new boolean[1370][1370];
    boolean noSweets = true;

    int timeSweets = 0;

    boolean up = false;
    boolean down = false;
    boolean right = true;
    boolean left = false;
    boolean life = true;


    int rA = (int )(Math.random() * 50 + 1);
    int rB = (int )(Math.random() * 50 + 1);
    int delkaHada = 3;

    public Panel(int x, int y) {

        this.x = x;
        this.y = y;
        qx.add(x);
        qy.add(y);

    }

    public void krok() {

        if (s[x][y] == true) {

            life = false;

        }

        q++;

        if (q == 15) {

            if (life == true) {

                s[x][y] = true;
                if (up == true) {
                    y -= 20;
                }

                if (down == true) {
                    y += 20;
                }

                if (right == true) {
                    x += 20;
                }

                if (left == true) {
                    x -= 20;
                }

            }

            q = 0;

            qx.add(x);
            qy.add(y);

            if (delkaHada < qx.size()) {
                s[qx.poll()][qy.poll()] = false;
            }

        }
        timeSweets++;
        if (timeSweets == 82) {
            timeSweets = 0;
        }
    }

    @Override

    public void paintComponent(Graphics g) {

        g.setColor(Color.GRAY);

        int p = 0;
        int o = 0;
        for (p = 0; p < 1370; p++) {

            for (o = 0; o < 1370; o++) {

                if (s[o][p] == true) {

                    g.fillRect(o, p, 20, 20);

                }

            }

            if (x > this.getWidth() || y > this.getHeight()) {
                life = false;
                g.setFont(g.getFont().deriveFont(50.0f));
                g.setColor(Color.red);
                g.drawString("KONEC HRY!", 250, 230);
                break;
            }

        }

        if (noSweets == true || timeSweets > 80) {
            g.setColor(Color.yellow);
            g.fillRect(rA * 20, rB* 2 , 20, 20);
        }

        if (rA <= qx.peek() <= rA + 20 && p <= rB && rB <= (p + 20)) {
            delkaHada++;
            noSweets = false;
            noSweets = true;
            timeSweets = 0;
        }
        System.out.println(rA );
        g.setFont(g.getFont().deriveFont(50.0f));
        g.setColor(Color.green);
        g.drawString("Snake", 15, 45);

        g.setFont(g.getFont().deriveFont(9.0f));
        g.setColor(Color.black);
        g.drawString("MW GAMES STUDIO", 20, 60);

    }

    @Override

    public void keyTyped(KeyEvent e) {

    }

    @Override

    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case (KeyEvent.VK_W):

                up = true;
                down = false;
                left = false;
                right = false;
                break;

            case (KeyEvent.VK_S):

                up = false;
                down = true;
                left = false;
                right = false;
                break;

            case (KeyEvent.VK_A):

                up = false;
                down = false;
                left = true;
                right = false;
                break;

            case (KeyEvent.VK_D):

                up = false;
                down = false;
                left = false;
                right = true;
                break;

            case (KeyEvent.VK_SPACE):

                life = true;

        }

    }

    @Override

    public void keyReleased(KeyEvent e) {

    }

}
