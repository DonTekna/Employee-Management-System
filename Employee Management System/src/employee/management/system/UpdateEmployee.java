package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    JTextField txteducation, txtfathername, txtaddress, txtphone,  txtemail, txtsalary, txtdesignation;
    JLabel LblempId,Lblother;
    JButton btnadd, btnback;
    String empId;
    
    UpdateEmployee(String empId) {
        this.empId = empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblheading = new JLabel("Update Employee Detail");
        lblheading.setBounds(320, 30, 500, 50);
        lblheading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(lblheading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 150, 30);
        lblname.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblname);
        
        JLabel Lblname = new JLabel();
        Lblname.setBounds(200, 150, 150, 30);
        add(Lblname);
        
        JLabel lblfathername = new JLabel("Father's Name");
        lblfathername.setBounds(400, 150, 150, 30);
        lblfathername.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblfathername);
        
        txtfathername = new JTextField();
        txtfathername.setBounds(600, 150, 150, 30);
        add(txtfathername);
        
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(50, 200, 150, 30);
        lbldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbldob);
        
        JLabel Lbldob = new JLabel();
        Lbldob.setBounds(200, 200, 150, 30);
        add(Lbldob);
        
        JLabel lblsalary = new JLabel("Salary");
        lblsalary.setBounds(400, 200, 150, 30);
        lblsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblsalary);
        
        txtsalary = new JTextField();
        txtsalary.setBounds(600, 200, 150, 30);
        add(txtsalary);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 150, 30);
        lbladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbladdress);
        
        txtaddress = new JTextField();
        txtaddress.setBounds(200, 250, 150, 30);
        add(txtaddress);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 150, 30);
        lblphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblphone);
        
        txtphone = new JTextField();
        txtphone.setBounds(600, 250, 150, 30);
        add(txtphone);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50, 300, 150, 30);
        lblemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblemail);
        
        txtemail = new JTextField();
        txtemail.setBounds(200, 300, 150, 30);
        add(txtemail);
        
        JLabel lbleducation = new JLabel("Higest Education");
        lbleducation.setBounds(400, 300, 150, 30);
        lbleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbleducation);
        
        txteducation = new JTextField();
        txteducation.setBounds(600, 300, 150, 30);
        add(txteducation);
        
        JLabel lbldesignation = new JLabel("Designation");
        lbldesignation.setBounds(50, 350, 150, 30);
        lbldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbldesignation);
        
        txtdesignation = new JTextField();
        txtdesignation.setBounds(200, 350, 150, 30);
        add(txtdesignation);
        
        JLabel lblother = new JLabel("Other Number");
        lblother.setBounds(400, 350, 150, 30);
        lblother.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblother);
        
        Lblother = new JLabel();
        Lblother.setBounds(600, 350, 150, 30);
        add(Lblother);
        
        JLabel lblempId = new JLabel("Employee id");
        lblempId.setBounds(50, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);
        
        LblempId = new JLabel();
        LblempId.setBounds(200, 400, 150, 30);
        LblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(LblempId);
        
        try {
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                txtfathername.setText(rs.getString("fname"));
                Lbldob.setText(rs.getString("dob"));
                txtaddress.setText(rs.getString("address"));
                txtsalary.setText(rs.getString("salary"));
                txtphone.setText(rs.getString("phone"));
                txtemail.setText(rs.getString("email"));
                txteducation.setText(rs.getString("education"));
                Lblother.setText(rs.getString("other"));
                LblempId.setText(rs.getString("empId"));
                txtdesignation.setText(rs.getString("designation"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        btnadd = new JButton("Update Details");
        btnadd.setBounds(250, 550, 150, 40);
        btnadd.addActionListener(this);
        btnadd.setBackground(Color.BLACK);
        btnadd.setForeground(Color.WHITE);
        add(btnadd);
        
        btnback = new JButton("Back");
        btnback.setBounds(450, 550, 150, 40);
        btnback.addActionListener(this);
        btnback.setBackground(Color.BLACK);
        btnback.setForeground(Color.WHITE);
        add(btnback);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnadd) 
        {
            String fathername = txtfathername.getText();
            String salary = txtsalary.getText();
            String address = txtaddress.getText();
            String phone = txtphone.getText();
            String email = txtemail.getText();
            String education = txteducation.getText();
            String designation = txtdesignation.getText();
            
            try {
                Conn conn = new Conn();
                String query = "update employee set fathername = '"+fathername+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email =  '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId = '"+empId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Home();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        } 
        
        else 
        {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}