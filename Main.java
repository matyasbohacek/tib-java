/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.*;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author Ucebna
 */
class Main{
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new Tetris();
            frame.setVisible(true);
        });
    }
}