package main;

import javax.swing.JFrame;

/**
 *  *
 *  * @author matyas.bohacek  
 */
public class Main {

     /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {

        JFrame f = new JFrame("Snake 1.0");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        Panel a = new Panel(20, 80);
        a.setB
        f.add(a);
        f.addKeyListener(a);
        new Thread() {
            @Override

            public void run() {

                while (true) {

                    a.krok();
                    f.repaint();
                    try {

                        Thread.sleep(20);

                    } catch (InterruptedException ex) {
                        //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);

                    }
                }
            }
        }.start();

        f.setVisible(true);
        // TODO code application logic here

    }

}

