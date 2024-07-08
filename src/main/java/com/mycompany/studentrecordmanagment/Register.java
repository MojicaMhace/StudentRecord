/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentrecordmanagment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;

/**
 *
 * @author mhace
 */
public class Register implements ActionListener{
    private JFrame Acc;
    private ImageIcon iconImage;
    private JPanel depanel,pnlStudId;
    private JLabel BgImg,Registrationlbl, lblRegis, lblStuNum, lblLastName, lblFirstName, lblMiddleName,
            lblCourse, lblStudYear, lblAddress,lblContact, lblBday, lblPosition, lblOrg;
;
    private JTextField tfStudNunm, tfLastName, tfFirstName, tfMiddleName,
            tfCourse, tfStudYear, tfAddress, tfContact, tfBday, tfPosition, tfOrg;
    private JButton btnSubmit, btnReset, ExitBtn;
    Register(){
        //frame
        Acc = new JFrame();
        Acc.setTitle("Login Page");
        Acc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Acc.setResizable(false);
        Acc.setSize(1200, 580);
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
        Registrationlbl = new JLabel("REGISTRATION FORM");
        Registrationlbl.setBounds(325,20,700,70);
        Font font = new Font("Aptos", Font.BOLD, 50);
        Registrationlbl.setFont(font);
        Registrationlbl.setForeground(new Color(255, 255, 255));
        depanel.add(Registrationlbl);
        
        lblRegis =new JLabel("Fill out the form carefully for registration....");
        lblRegis.setBounds(400,60,500,70);
        lblRegis.setForeground(new Color(255, 255, 255));
        Font font1 = new Font("Courier New", Font.BOLD, 15);
        lblRegis.setFont(font1);
        depanel.add(lblRegis);
        
        //label and textfieldds
        lblStuNum = new JLabel ("Student Number:");
        lblStuNum.setBounds (140, 150, 150, 30);
        Font font2 = new Font("Aptos", Font.BOLD, 12);
        lblStuNum.setFont(font2);
        lblStuNum.setForeground(new Color(255, 255, 255));
        depanel.add(lblStuNum);
        tfStudNunm = new JTextField();
        tfStudNunm.setBounds(140, 180, 200, 30);
        tfStudNunm.setHorizontalAlignment(JTextField.CENTER);
        depanel.add(tfStudNunm);
       
        lblLastName = new JLabel ("Last Name:");
        lblLastName.setBounds (370, 150, 100, 30);
        lblLastName.setFont(font2);
        lblLastName.setForeground(new Color(255, 255, 255));
        depanel.add(lblLastName);        
        tfLastName = new JTextField();
        tfLastName.setBounds(370, 180, 200, 30);
        tfLastName.setHorizontalAlignment(JTextField.CENTER);
        depanel.add(tfLastName);
       
        lblFirstName = new JLabel ("First Name:");
        lblFirstName.setBounds (602, 150, 100, 30);
        lblFirstName.setFont(font2);
        lblFirstName.setForeground(new Color(255, 255, 255));
        depanel.add(lblFirstName);
        tfFirstName = new JTextField();
        tfFirstName.setBounds(602, 180, 200, 30);
        tfFirstName.setHorizontalAlignment(JTextField.CENTER);
        depanel.add(tfFirstName);
               
        lblMiddleName = new JLabel ("Middle Name:");
        lblMiddleName.setBounds (834, 150, 150, 30);
        lblMiddleName.setFont(font2);
        lblMiddleName.setForeground(new Color(255, 255, 255));
        depanel.add(lblMiddleName);
        tfMiddleName = new JTextField();
        tfMiddleName.setBounds(834, 180, 200, 30);
        tfMiddleName.setHorizontalAlignment(JTextField.CENTER);
        depanel.add(tfMiddleName);
        
        lblCourse = new JLabel ("Course:");
        lblCourse.setBounds (140, 230, 100, 30);
        lblCourse.setFont(font2);
        lblCourse.setForeground(new Color(255, 255, 255));
        depanel.add(lblCourse);
        tfCourse = new JTextField();
        tfCourse.setBounds(140, 260, 200, 30);
        tfCourse.setHorizontalAlignment(JTextField.CENTER);
        depanel.add(tfCourse);
        
        lblStudYear = new JLabel ("Year:");
        lblStudYear.setBounds (370, 230, 100, 30);
        lblStudYear.setFont(font2);
        lblStudYear.setForeground(new Color(255, 255, 255));
        depanel.add(lblStudYear);
        tfStudYear = new JTextField();
        tfStudYear.setBounds(370, 260, 200, 30);
        tfStudYear.setHorizontalAlignment(JTextField.CENTER);
        depanel.add(tfStudYear);
        
        lblAddress = new JLabel ("Address:");
        lblAddress.setBounds (602, 230, 100, 30);
        lblAddress.setFont(font2);
        lblAddress.setForeground(new Color(255, 255, 255));
        depanel.add(lblAddress);
        tfAddress = new JTextField();
        tfAddress.setBounds(602, 260, 200, 30);
        tfAddress.setHorizontalAlignment(JTextField.CENTER);
        depanel.add(tfAddress);
        
        lblContact = new JLabel ("Contact Number:");
        lblContact.setBounds (834, 230, 100, 30);
        lblContact.setFont(font2);
        lblContact.setForeground(new Color(255, 255, 255));
        depanel.add(lblContact);
        tfContact = new JTextField();
        tfContact.setBounds(834, 260, 200, 30);
        tfContact.setHorizontalAlignment(JTextField.CENTER);
        depanel.add(tfContact);
        
        lblBday = new JLabel ("Birthday:(01-04-2004)");
        lblBday.setBounds (140, 310, 200, 30);
        lblBday.setFont(font2);
        lblBday.setForeground(new Color(255, 255, 255));
        depanel.add(lblBday);
        tfBday = new JTextField();
        tfBday.setBounds(140, 340, 200, 30);
        tfBday.setHorizontalAlignment(JTextField.CENTER);
        depanel.add(tfBday);
        
        lblPosition = new JLabel ("Position:");
        lblPosition.setBounds (370, 310, 100, 30);
        lblPosition.setFont(font2);
        lblPosition.setForeground(new Color(255, 255, 255));
        depanel.add(lblPosition);
        tfPosition = new JTextField();
        tfPosition.setBounds(370, 340, 200, 30);
        tfPosition.setHorizontalAlignment(JTextField.CENTER);
        depanel.add(tfPosition);
        
        lblOrg = new JLabel ("Organization:");
        lblOrg.setBounds (602, 310, 100, 30);
        lblOrg.setFont(font2);
        lblOrg.setForeground(new Color(255, 255, 255));
        depanel.add(lblOrg);
        tfOrg = new JTextField();
        tfOrg.setBounds(602, 340, 200, 30);
        tfOrg.setHorizontalAlignment(JTextField.CENTER);
        depanel.add(tfOrg);
        //buttn
        btnSubmit = new JButton("SUBMIT");
        btnSubmit.setBounds(140, 450, 200, 30);
        btnSubmit.setBackground(new Color(215, 60, 190));
        btnSubmit.setForeground(new Color(255, 255, 255));
        btnSubmit.addActionListener(this);
        depanel.add(btnSubmit);
        
        btnReset = new JButton("RESET");
        btnReset.setBounds(370, 450, 200, 30);
        btnReset.setBackground(new Color(215, 60, 190));
        btnReset.setForeground(new Color(255, 255, 255));
        btnReset.addActionListener(this);
        depanel.add(btnReset);
        
        ExitBtn = new JButton("EXIT");
        ExitBtn.setBounds(834, 450, 200, 30);
        ExitBtn.setBackground(new Color(215, 60, 190));
        ExitBtn.setForeground(new Color(255, 255, 255));
        ExitBtn.addActionListener(this);
        depanel.add(ExitBtn);
        
        BgImg = new JLabel();
        BgImg.setBounds(0, 0, 1200, 700);
        ImageIcon Background = new ImageIcon("Bg4.png");
        Image picsize = Background.getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
        ImageIcon drawpic = new ImageIcon(picsize);
        BgImg.setIcon(drawpic);
        depanel.add(BgImg);
        
        Acc.setVisible(true);
   }

    @Override
    public void actionPerformed(ActionEvent open) {
    if (open.getSource() == ExitBtn) {
        new HomePage();
        Acc.dispose();
    } else if (open.getSource() == btnSubmit) {
        try {
            String url = "jdbc:mysql://localhost:3306/db_cite";
            String user = "mhace";
            String password = "1234";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "INSERT INTO `tbl_cite`(`Student_ID`, `Student_LastName`, `Student_FirstName`, `Student_MiddleName`, `Course`, `Student_Year`, `Address`, `Contact_Number`, `Birthday`, `Position`, `Organization`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pr = conn.prepareStatement(query);

            pr.setString(1, tfStudNunm.getText());    
            pr.setString(2, tfLastName.getText());   
            pr.setString(3, tfFirstName.getText());      
            pr.setString(4, tfMiddleName.getText());  
            pr.setString(5, tfCourse.getText());     
            pr.setString(6, tfStudYear.getText());      
            pr.setString(7, tfAddress.getText());     
            pr.setString(8, tfContact.getText());      
            pr.setString(9, tfBday.getText());         
            pr.setString(10, tfPosition.getText());   
            pr.setString(11, tfOrg.getText());       

            pr.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registered Successfully");

            conn.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Registration Failed. Please check your input.");
        }
    } else if (open.getSource() == btnReset) {
        tfStudNunm.setText("");
        tfLastName.setText("");
        tfFirstName.setText("");
        tfMiddleName.setText("");
        tfCourse.setText("");
        tfStudYear.setText("");
        tfAddress.setText("");
        tfContact.setText("");
        tfBday.setText("");
        tfPosition.setText("");
        tfOrg.setText("");
    }
}
    
    
}
