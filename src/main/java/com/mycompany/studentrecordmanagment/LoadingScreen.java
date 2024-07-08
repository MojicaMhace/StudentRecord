package com.mycompany.studentrecordmanagment;

import java.awt.*;
import javax.swing.*;

public class LoadingScreen {
    private JFrame Acc;
    private ImageIcon iconImage;
    private JPanel depanel, BgImg1;
    private JLabel BgImg, lblload;
    private JTextArea tatext;
    private JProgressBar PBload;

    LoadingScreen(){
        // Frame
        Acc = new JFrame();
        Acc.setTitle("Login Page");
        Acc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Acc.setResizable(false);
        Acc.setSize(1200, 680);
        // Icon
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
        

        // For text
//        tatext = new JTextArea("Always do your best. What you plant now,\nyou will harvest later.");
//        tatext.setBounds(500, 200, 600, 40); 
//        tatext.setForeground(new Color(255, 255, 255));
//        tatext.setBackground(new Color(0, 0, 0, 0));
//        tatext.setLineWrap(true);
//        tatext.setWrapStyleWord(true);
//        BgImg.add(tatext);

        // lblload
        lblload = new JLabel("Loading....");
        lblload.setBounds(560, 380, 600, 30);
        lblload.setForeground(new Color(255, 255, 255));
        BgImg.add(lblload);
//
        // Loading Screen
        PBload = new JProgressBar();
        PBload.setBounds(300, 410, 600, 30);
        PBload.setStringPainted(true);
        depanel.add(PBload);

        depanel.add(BgImg);
        
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
        }).start();
    
    }
}
