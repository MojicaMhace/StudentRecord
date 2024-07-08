package com.mycompany.studentrecordmanagment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HomePage implements ActionListener {
    private JFrame Acc;
    private ImageIcon iconImage;
    private JPanel depanel, panel1;
    private JLabel BgImg, lbllogo, lblpup, lblIbits, lblIbits1, lblDescription, lblwelc;
    private JButton btntable, btnreg, ExitBtn;

    HomePage() {
        // frame
        Acc = new JFrame();
        Acc.setTitle("Login Page");
        Acc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Acc.setResizable(false);
        Acc.setSize(500, 400);
        // icon
        iconImage = new ImageIcon("icon.png");
        Acc.setIconImage(iconImage.getImage());
        Acc.getContentPane().setBackground(new Color(100, 50, 78));
        Acc.setLayout(new BorderLayout());

        depanel = new JPanel();
        depanel.setLayout(null);
        depanel.setBackground(new Color(220, 190, 200));
        depanel.setBounds(0, 0, 800, 500); // Adjust bounds to match JFrame
        Acc.add(depanel);

        // Background
        BgImg = new JLabel();
        BgImg.setBounds(0, 0, 500, 500);
        ImageIcon Background = new ImageIcon("ems.png");
        Image picsize = Background.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH);
        ImageIcon drawpic = new ImageIcon(picsize);
        BgImg.setIcon(drawpic);
        BgImg.setLayout(null);
        depanel.add(BgImg);
        
        // welcome
        lblwelc = new JLabel("WELCOME!!!");
        lblwelc.setBounds(20, 20, 250, 40);
        lblwelc.setFont(new Font("Aptos", Font.BOLD, 35));
        lblwelc.setForeground(new Color(255, 255, 255));
        BgImg.add(lblwelc);

        // Where do u want to go label
        lblDescription = new JLabel("Where would you like to go?");
        lblDescription.setBounds(50, 100, 200, 30);
        lblDescription.setFont(new Font("Aptos", Font.BOLD, 15));
        lblDescription.setForeground(new Color(255, 255, 255));
        BgImg.add(lblDescription);

//        panel1 = new JPanel();
//        panel1.setLayout(null);
//        panel1.setBackground(new Color(19, 7, 46));
//        panel1.setBounds(30, 120, 200, 200);
//        BgImg.add(panel1);

//        lbllogo = new JLabel();
//        lbllogo.setBounds(20, 20, 200, 200);
//        ImageIcon logo = new ImageIcon("logs.png");
//        Image logoImage = logo.getImage().getScaledInstance(210, 210, Image.SCALE_SMOOTH);
//        lbllogo.setIcon(new ImageIcon(logoImage));
//        panel1.add(lbllogo);
//
//        lblpup = new JLabel();
//        lblpup.setBounds(160, 80, 200, 200);
//        ImageIcon pup = new ImageIcon("icons.png");
//        Image logo2Image = pup.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
//        lblpup.setIcon(new ImageIcon(logo2Image));
//        panel1.add(lblpup);


        btnreg = new JButton("REGISTRATION");
        btnreg.setBounds(140, 170, 200, 30);
        btnreg.setBackground(new Color(215, 60, 190));
        btnreg.setForeground(new Color(255, 255, 255));
        btnreg.addActionListener(this);
        BgImg.add(btnreg);

        btntable = new JButton("STUDENTS TABLE");
        btntable.setBounds(140, 230, 200, 30);
        btntable.setBackground(new Color(215, 60, 190));
        btntable.setForeground(new Color(255, 255, 255));
        btntable.addActionListener(this);
        BgImg.add(btntable);

        ExitBtn = new JButton("EXIT");
        ExitBtn.setBounds(200, 300, 70, 20);
        ExitBtn.addActionListener(this);
        BgImg.add(ExitBtn);

        Acc.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent open) {
        if (open.getSource() == btnreg) {
            Acc.dispose();
            new Register();
            LoadingScreen screen = new LoadingScreen();
            screen.startLoading();
        }else if(open.getSource()== btntable){
            Acc.dispose();
            new Record();
            LoadingScreen screen = new LoadingScreen();
            screen.startLoading();
        }else if(open.getSource()== ExitBtn){
            Acc.dispose();
        }
    }
}
