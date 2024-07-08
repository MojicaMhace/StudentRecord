/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentrecordmanagment;

import java.awt.BorderLayout;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.*;


/**
 *
 * @author mhace
 */
public class HomePage {
    private JFrame Acc;
    private ImageIcon iconImage;
    private JPanel depanel, panel1;
    private JLabel BgImg, lbllogo;
    
    HomePage(){
        // frame
        Acc = new JFrame();
        Acc.setTitle("Login Page");
        Acc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Acc.setResizable(false);
        Acc.setSize(800, 500);
        // icon
        iconImage = new ImageIcon("icon.png");
        Acc.setIconImage(iconImage.getImage());
        Acc.getContentPane().setBackground(new Color(100, 50, 78));
        Acc.setLayout(new BorderLayout());

        depanel = new JPanel();
        depanel.setLayout(null);
        depanel.setBackground(new Color(220, 190, 200));
        depanel.setBounds(0, 0, 1200, 680);
        Acc.add(depanel);

        // Background
        BgImg = new JLabel();
        BgImg.setBounds(0, 0, 800, 500);
        ImageIcon Background = new ImageIcon("ems.png");
        Image picsize = Background.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH);
        ImageIcon drawpic = new ImageIcon(picsize);
        BgImg.setIcon(drawpic);
        depanel.add(BgImg);
        
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(19, 7, 46));
        panel1.setBounds(390, 0, 400, 500);
        BgImg.add(panel1);
        
        lbllogo = new JLabel();
        lbllogo.setBounds(0, 0, 800, 500);
        ImageIcon bg = new ImageIcon("ems.png");
        Image pz = bg.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH);
        ImageIcon lg = new ImageIcon(pz);
        lbllogo.setIcon(lg);
        depanel.add(lbllogo);
        
        Acc.setVisible(true);
    }
    
    public static void main(String[] args) {
        new HomePage();
    }
}
