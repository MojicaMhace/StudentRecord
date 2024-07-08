/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentrecordmanagment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author mhace
 */
public class LoadingScreen {
    private JFrame Acc;
    private ImageIcon iconImage;
    private JPanel depanel;
    private JLabel BgImg, lblload;
    private JTextArea tatext;
    private JProgressBar PBload;
    LoadingScreen(){
         //frame
        Acc = new JFrame();
        Acc.setTitle("Login Page");
        Acc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Acc.setResizable(false);
        Acc.setSize(1200, 680);
        //icon
        iconImage = new ImageIcon("icon.png");
        Acc.setIconImage(iconImage.getImage());
        Acc.getContentPane().setBackground(new Color(100,50,78));
        Acc.setLayout(new BorderLayout());
        
        depanel = new JPanel();
        depanel.setLayout(null);
        depanel.setBackground(new Color(220, 190, 200));
        depanel.setBounds(0, 0, 1200, 680);
        Acc.add(depanel);
        
        // Background
        BgImg = new JLabel();
        BgImg.setBounds(0, 0, 1200, 700);
        ImageIcon Background = new ImageIcon("Bg4.png");
        Image picsize = Background.getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
        ImageIcon drawpic = new ImageIcon(picsize);
        BgImg.setIcon(drawpic);
        depanel.add(BgImg);
        
        //for text
        tatext = new JTextArea("Always do your best. What you plant now,\nyou will harvest later.");
        tatext.setBounds(200, 200, 600, 60); 
        tatext.setFont(new Font("Aptos", Font.BOLD, 20));
        tatext.setForeground(new Color(255, 255, 255));
        tatext.setBackground(new Color(0, 0, 0, 0));
        tatext.setLineWrap(true);
        tatext.setWrapStyleWord(true);
        BgImg.add(tatext);
        
        //lblload
        lblload = new JLabel("Loading....");
        lblload.setBounds(400,350,600,30);
        lblload.setFont(new Font("Aptos", Font.BOLD, 20));
        lblload.setForeground(new Color(255, 255, 255));
        BgImg.add(lblload);
        
        //Loading Screen
        PBload = new JProgressBar();
        PBload.setBounds(300, 400, 600, 30);
        PBload.setStringPainted(true);
        depanel.add(PBload);
    
        
        Acc.setVisible(true);
    }

    public void startLoading() {
        PBload.setVisible(true);
        new Thread(() -> {
            int i = 0;
            while (i <= 100) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex){
                }
                PBload.setValue(i);
                i++;
            }
            
            Acc.dispose();
            
            SwingUtilities.invokeLater(() -> {
                Record record = new Record();
            }); }).start();
    }
}

