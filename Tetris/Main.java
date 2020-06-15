
import javax.swing.*;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;

class Main {
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
            JFrame frame = new Tetris();
            frame.setVisible(true);
        });
  }
}
