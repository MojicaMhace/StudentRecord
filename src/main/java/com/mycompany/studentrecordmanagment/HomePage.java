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
        Acc.setSize(800, 500);
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
        BgImg.setBounds(0, 0, 800, 500);
        ImageIcon Background = new ImageIcon("ems.png");
        Image picsize = Background.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH);
        ImageIcon drawpic = new ImageIcon(picsize);
        BgImg.setIcon(drawpic);
        depanel.add(BgImg);
        
        // welcome
        lblwelc = new JLabel("WELCOME!!!");
        lblwelc.setBounds(50, 100, 200, 30);
        lblwelc.setFont(new Font("Aptos", Font.BOLD, 15));
        BgImg.add(lblwelc);

        // Where do u want to go label
        lblDescription = new JLabel("Where would you like to go?");
        lblDescription.setBounds(50, 130, 200, 30);
        lblDescription.setFont(new Font("Aptos", Font.BOLD, 15));
        BgImg.add(lblDescription);

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(19, 7, 46));
        panel1.setBounds(390, 0, 400, 500);
        BgImg.add(panel1);

        lbllogo = new JLabel();
        lbllogo.setBounds(20, 20, 200, 200);
        ImageIcon logo = new ImageIcon("logs.png");
        Image logoImage = logo.getImage().getScaledInstance(210, 210, Image.SCALE_SMOOTH);
        lbllogo.setIcon(new ImageIcon(logoImage));
        panel1.add(lbllogo);

        lblpup = new JLabel();
        lblpup.setBounds(160, 80, 200, 200);
        ImageIcon pup = new ImageIcon("icons.png");
        Image logo2Image = pup.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        lblpup.setIcon(new ImageIcon(logo2Image));
        panel1.add(lblpup);

        lblIbits = new JLabel("IBITS");
        lblIbits.setBounds(85, 300, 300, 100);
        lblIbits.setForeground(Color.WHITE);
        lblIbits.setFont(new Font("Courier New", Font.BOLD, 40));
        panel1.add(lblIbits);

        btnreg = new JButton("REGISTRATION");
        btnreg.setBounds(100, 250, 200, 30);
        btnreg.setBackground(new Color(215, 60, 190));
        btnreg.setForeground(new Color(255, 255, 255));
        btnreg.addActionListener(this);
        BgImg.add(btnreg);

        btntable = new JButton("STUDENTS TABLE");
        btntable.setBounds(100, 300, 200, 30);
        btntable.setBackground(new Color(215, 60, 190));
        btntable.setForeground(new Color(255, 255, 255));
        btntable.addActionListener(this);
        BgImg.add(btntable);

        ExitBtn = new JButton("EXIT");
        ExitBtn.setBounds(130, 400, 100, 20);
        ExitBtn.addActionListener(this);
        BgImg.add(ExitBtn);

        Acc.setVisible(true);
    }

    public static void main(String[] args) {
        new HomePage();
    }

    @Override
    public void actionPerformed(ActionEvent open) {
        if (open.getSource() == btnreg) {
            Acc.dispose();
            new Register();
        }
    }
}
