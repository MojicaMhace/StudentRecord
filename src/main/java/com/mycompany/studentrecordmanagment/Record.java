package com.mycompany.studentrecordmanagment;

import java.awt.*;
import static java.awt.Color.black;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;

public class Record implements ActionListener {
    private JFrame Acc;
    private ImageIcon iconImage;
    private JPanel depanel, pnlheader;
    private JLabel BgImg, lbltext, lbltable;
    private JButton ExitBtn, btnUpdate, btnDelete;
    private JTable tblRecords;
    private JScrollPane spScroll;
    private DefaultTableModel ColumnHeaders;
    private JTableHeader TableHeader;

    Record() {
        // Frame
        Acc = new JFrame();
        Acc.setTitle("Record Page");
        Acc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Acc.setLayout(null);
        Acc.setSize(1200, 680);

        // Icon
        iconImage = new ImageIcon("icon.png");
        Acc.setIconImage(iconImage.getImage());
        Acc.getContentPane().setBackground(new Color(100, 50, 78));
        Acc.setLayout(new BorderLayout());

        depanel = new JPanel();
        depanel.setLayout(null);
        depanel.setBounds(0, 0, 1200, 680);
        Acc.add(depanel);

        // Background
        BgImg = new JLabel();
        BgImg.setBounds(0, 0, 1200, 700);
        ImageIcon Background = new ImageIcon("Bg4.png");
        Image picsize = Background.getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
        ImageIcon drawpic = new ImageIcon(picsize);
        BgImg.setIcon(drawpic);
        BgImg.setLayout(null); 
        depanel.add(BgImg);
        
        pnlheader = new JPanel();
        pnlheader.setBounds(0, 0, 1200, 80);
        pnlheader.setBackground(new Color(45, 31, 62));
        BgImg.add(pnlheader);

        lbltable = new JLabel();
        lbltable.setBounds(70, 130, 1070, 440); 
        ImageIcon Bg = new ImageIcon("Bg5.png");
        Image edbg = Bg.getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
        ImageIcon finalbg = new ImageIcon(edbg);
        lbltable.setIcon(finalbg);
        lbltable.setLayout(null);
        BgImg.add(lbltable);
        
        lbltext = new JLabel("Students Information", SwingConstants.CENTER);
        lbltext.setBounds(0,20,250,30);
        lbltext.setFont(new Font("Impact", Font.PLAIN, 50));
        lbltext.setForeground(new Color(255, 255, 255));
        pnlheader.add(lbltext);
        // Table
        ColumnHeaders = new DefaultTableModel(new Object[] {"Student_ID", "Student_LastName", "Student_FirstName", "Student_MiddleName", "Course",
        "Student_Year", "Address", "Contact_Number", "Birthday", "Position", "Organization"}, 0);
        tblRecords = new JTable(ColumnHeaders);
        tblRecords.setOpaque(false);

        TableHeader = tblRecords.getTableHeader();
        tblRecords.getTableHeader().setBackground(new Color(204, 204, 255));
        tblRecords.getTableHeader().setForeground(new Color(0, 0, 0));
        tblRecords.getTableHeader().setFont(new Font("Aptos", Font.PLAIN, 12));

        spScroll = new JScrollPane(tblRecords);
        spScroll.setBounds(20, 20, 1030, 400);
        spScroll.setBorder(new LineBorder(Color.BLACK, 1));
        lbltable.add(spScroll);

  
        //update button
        btnUpdate = new JButton("ADD");
        btnUpdate.setBounds(100, 600, 100, 30);
        btnUpdate.setBackground(new Color(215, 60, 190));
        btnUpdate.setForeground(new Color(255, 255, 255));
        btnUpdate.addActionListener(this);
        BgImg.add(btnUpdate);
        
        //deletebutton
        btnDelete = new JButton("DELETE");
        btnDelete.setBounds(220, 600, 100, 30);
        btnDelete.setBackground(new Color(215, 60, 190));
        btnDelete.setForeground(new Color(255, 255, 255));
        btnDelete.addActionListener(this);
        BgImg.add(btnDelete);
        // Exit button
        ExitBtn = new JButton("EXIT");
        ExitBtn.setBounds(1010, 600, 100, 30);
        ExitBtn.setBackground(new Color(215, 60, 190));
        ExitBtn.setForeground(new Color(255, 255, 255));
        ExitBtn.addActionListener(this);
        BgImg.add(ExitBtn);

        Acc.setVisible(true);
        ViewTable();
    }

    private void ViewTable() {
        try {
            String url = "jdbc:mysql://localhost:3306/db_cite";
            String user = "mhace";
            String password = "1234";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            String selectQuery = "SELECT * FROM tbl_cite";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(selectQuery);

            DefaultTableModel model = (DefaultTableModel) tblRecords.getModel();

            while (rs.next()) {
                String studentId = rs.getString("Student_ID");
                String lastName = rs.getString("Student_LastName");
                String firstName = rs.getString("Student_FirstName");
                String middleName = rs.getString("Student_MiddleName");
                String course = rs.getString("Course");
                String year = rs.getString("Student_Year");
                String address = rs.getString("Address");
                String contactNumber = rs.getString("Contact_Number");
                String birthday = rs.getString("Birthday");
                String position = rs.getString("Position");
                String organization = rs.getString("Organization");
                String[] tbData = {studentId, lastName, firstName, middleName, course, year, address, contactNumber, birthday, position, organization};
                model.addRow(tbData);
            }

            rs.close();
            st.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void deleteFromDatabase(String studentId) {
    try {
        String url = "jdbc:mysql://localhost:3306/db_cite";
        String user = "mhace";
        String password = "1234";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, password);

        String deleteQuery = "DELETE FROM tbl_cite WHERE Student_ID = ?";
        PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
        pstmt.setString(1, studentId);
        
        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null,"Row deleted successfully!!!");
        } else {
            JOptionPane.showMessageDialog(null,"Failed to delete!!!");
        }

        pstmt.close();
        conn.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

    @Override
    public void actionPerformed(ActionEvent open) {
        if (open.getSource() == ExitBtn) {
            new LoginPage();
            Acc.dispose();
        }else if(open.getSource() == btnUpdate){
            new Register();
            Acc.dispose();
        }else if(open.getSource()== btnDelete){
            DefaultTableModel model = (DefaultTableModel) tblRecords.getModel();
            int row = tblRecords.getSelectedRow();
            if (row != -1) {
            String studentId = model.getValueAt(row, 0).toString();
            model.removeRow(row);
            deleteFromDatabase(studentId);
            } 
        }
    }

}
