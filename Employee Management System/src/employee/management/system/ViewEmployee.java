
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewEmployee extends JFrame implements ActionListener{

    JTable table;
    Choice cemployeeId;
    JButton btnsearch, btnprint, btnupdate, btnback;
    
    ViewEmployee() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblsearch = new JLabel("Search by Employee Id");
        lblsearch.setBounds(20, 20, 150, 20);
        add(lblsearch);
        
        cemployeeId = new Choice();
        cemployeeId.setBounds(180, 20, 150, 20);
        add(cemployeeId);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()) {
                cemployeeId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        btnsearch = new JButton("Search");
        btnsearch.setBounds(20, 70, 80, 20);
        btnsearch.addActionListener(this);
        add(btnsearch);
        
        btnprint = new JButton("Print");
        btnprint.setBounds(120, 70, 80, 20);
        btnprint.addActionListener(this);
        add(btnprint);
        
        btnupdate = new JButton("Update");
        btnupdate.setBounds(220, 70, 80, 20);
        btnupdate.addActionListener(this);
        add(btnupdate);
        
        btnback = new JButton("Back");
        btnback.setBounds(320, 70, 80, 20);
        btnback.addActionListener(this);
        add(btnback);
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnsearch) {
            String query = "select * from employee where empId = '"+cemployeeId.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            
        } else if (ae.getSource() == btnprint) {
            try 
            {
                table.print();
            } catch (Exception e) {
                
                e.printStackTrace();
           
            }
        } else if (ae.getSource() == btnupdate) 
        {
          
            setVisible(false);
            new UpdateEmployee(cemployeeId.getSelectedItem());
        } 
        else 
        {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}
