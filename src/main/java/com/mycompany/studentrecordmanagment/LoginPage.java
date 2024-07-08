package com.mycompany.studentrecordmanagment;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class LoginPage implements ActionListener {
    private JFrame Acc;
    private ImageIcon iconImage;
    private JPanel depanel, panel1, panel2, PnlStudnum, PnlPass;
    private JLabel BgImg, lblIBITS, lblStudRec, lblSignin, lblProceed, lblStudnum, lblPass;
    private JTextField Studnumtf;
    private JPasswordField tfPass;
    private JButton btnReg, btnSign;
    private JCheckBox chShow;
    
    // Variables for login attempt tracking and freezing
    private int loginAttempts = 0;
    private Timer freezeTimer;
    private boolean isFrozen = false;

    public LoginPage() {
        // frame
        Acc = new JFrame();
        Acc.setTitle("Login Page");
        Acc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Acc.setResizable(false);
        Acc.setSize(1200, 680);
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

        // text ibits
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/FontsFree-Net-Lastica.ttf")).deriveFont(Font.BOLD, 26f);
            Font bfont = font.deriveFont(Font.BOLD, 14f);

            lblIBITS = new JLabel("INSTITUTE OF BACHELORS IN INFORMATION");
            lblIBITS.setBounds(210, 20, 900, 70);
            lblIBITS.setFont(font);
            lblIBITS.setForeground(new Color(255, 255, 255));
            depanel.add(lblIBITS);

            lblIBITS = new JLabel("TECHNOLOGY STUDIES - PUPBC");
            lblIBITS.setBounds(310, 60, 900, 70);
            lblIBITS.setFont(font);
            lblIBITS.setForeground(new Color(255, 255, 255));
            depanel.add(lblIBITS);

            lblStudRec = new JLabel("IBITS - STUDENT RECORD");
            lblStudRec.setBounds(460, 100, 900, 70);
            lblStudRec.setFont(bfont);
            lblStudRec.setForeground(new Color(255, 255, 255));
            depanel.add(lblStudRec);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        // Background
        BgImg = new JLabel();
        BgImg.setBounds(0, 0, 1200, 700);
        ImageIcon Background = new ImageIcon("Bg4.png");
        Image picsize = Background.getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
        ImageIcon drawpic = new ImageIcon(picsize);
        BgImg.setIcon(drawpic);
        depanel.add(BgImg);

        // panel for signing in
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(45, 31, 62));
        panel1.setBounds(245, 200, 700, 400);
        BgImg.add(panel1);
        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(new Color(226, 219, 232));
        panel2.setBounds(30, 30, 640, 340);
        panel1.add(panel2);

        // lbl signin
        try {
            Font font3 = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/nt-fabulous-alternative-only-personal-use.otf")).deriveFont(Font.BOLD, 26f);
            Font font4 = font3.deriveFont(Font.BOLD, 13f);
            lblSignin = new JLabel("Sign In");
            lblSignin.setFont(font3);
            lblSignin.setBounds(210, 20, 100, 50);
            lblSignin.setForeground(new Color(0, 74, 173));
            panel2.add(lblSignin);

            lblProceed = new JLabel("to start your session.");
            lblProceed.setFont(font4);
            lblProceed.setBounds(300, 22, 200, 50);
            lblProceed.setForeground(new Color(25, 25, 25));
            panel2.add(lblProceed);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        // lbl and panelstudnum
        lblStudnum = new JLabel("Student Number:");
        lblStudnum.setBounds(0, 135, 250, 30);
        lblStudnum.setForeground(new Color(255, 255, 255));
        PnlStudnum = new JPanel();
        PnlStudnum.setBounds(115, 105, 160, 30);
        PnlStudnum.setBackground(new Color(44, 30, 74));
        PnlStudnum.add(lblStudnum);
        panel2.add(PnlStudnum);

        // Textfields
        Studnumtf = new JTextField();
        Studnumtf.setBounds(300, 105, 250, 30);
        Studnumtf.setForeground(new Color(44, 30, 74));
        panel2.add(Studnumtf);

        // lbl and panel pass
        lblPass = new JLabel("Password:");
        lblPass.setBounds(0, 180, 250, 30);
        lblPass.setForeground(new Color(255, 255, 255));
        PnlPass = new JPanel();
        PnlPass.setBounds(115, 160, 160, 30);
        PnlPass.setBackground(new Color(44, 30, 74));
        PnlPass.add(lblPass);
        panel2.add(PnlPass);

        // Textfields
        tfPass = new JPasswordField();
        tfPass.setBounds(300, 160, 250, 30);
        tfPass.setForeground(new Color(44, 30, 74));
        panel2.add(tfPass);

        //checkbox
        chShow = new JCheckBox("Show Password");
        chShow.setBounds(300, 200, 250, 30);
        chShow.setBackground(new Color(226, 219, 232));
        chShow.addActionListener(this);
        panel2.add(chShow);

        // buttons
        btnReg = new JButton("REGISTER");
        btnReg.setBounds(150, 250, 150, 30);
        btnReg.setBackground(new Color(215, 60, 190));
        btnReg.setForeground(new Color(255, 255, 255));
        btnReg.addActionListener(this);
        panel2.add(btnReg);

        btnSign = new JButton("SIGN IN");
        btnSign.setBounds(350, 250, 150, 30);
        btnSign.setBackground(new Color(215, 60, 190));
        btnSign.setForeground(new Color(255, 255, 255));
        btnSign.addActionListener(this);
        panel2.add(btnSign);

        Acc.setVisible(true);

       //stop na teh the freezer (5)
        freezeTimer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginAttempts = 0;
                isFrozen = false;
                freezeTimer.stop(); 
                JOptionPane.showMessageDialog(Acc, "You can try logging in again.");
                btnSign.setEnabled(true); 
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent open) {
        if (open.getSource() == chShow) {
            if (chShow.isSelected()) {
                tfPass.setEchoChar((char) 0);
            } else {
                tfPass.setEchoChar('*'); 
            }
        } else if (open.getSource() == btnSign) {
            if (isFrozen) {
                JOptionPane.showMessageDialog(Acc, "Please wait before trying again.");
                return;
            }

            String userName = Studnumtf.getText();
            String password = new String(tfPass.getPassword());
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_cite", "mhace", "1234");
                PreparedStatement st = connection.prepareStatement("Select studentnum, password from tbl_login where studentnum=? and password=?");
                st.setString(1, userName);
                st.setString(2, password);
                ResultSet rs = st.executeQuery();
                 if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Sign In Successfully");
                Acc.dispose();
                new LoadingScreen();
                } else {
                    loginAttempts++;
                    if (loginAttempts >= 5) {
                        JOptionPane.showMessageDialog(Acc, "Access Denied\nMaximum attempts reached. Please wait 5 seconds before trying again.");
                        isFrozen = true;
                        freezeTimer.start();
                        btnSign.setEnabled(false); 
                    } else {
                        JOptionPane.showMessageDialog(Acc, "Wrong Username & Password.\nAttempt: " + loginAttempts + "/5");
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if (open.getSource() == btnReg) {
            Acc.dispose();
            new Register();
            Load ld = new Load();
            ld.startLoading();
        }
    }

}
