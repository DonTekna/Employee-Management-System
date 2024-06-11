package employee.management.system;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Home extends JFrame implements ActionListener{
    
    JButton btnadd,btnview,btnupdate,btnremove;

    Home() {
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1020,630);
        add(image);
        
        JLabel lblheading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        lblheading.setBounds(620,20,400,40);
        lblheading.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(lblheading);
        
        btnadd =new JButton("Add Employee");
        btnadd.setBounds(650,80,150,40);
        btnadd.addActionListener(this);
        image.add(btnadd);
        
        btnview =new JButton("View Employee");
        btnview.setBounds(820,80,150,40);
        btnview.addActionListener(this);
        image.add(btnview);
        
        btnupdate =new JButton("Update Employee");
        btnupdate.setBounds(650,140,150,40);
        btnupdate.addActionListener(this);
        image.add(btnupdate);
        
        btnremove =new JButton("Remove Employee");
        btnremove.setBounds(820,140,150,40);
        btnremove.addActionListener(this);
        image.add(btnremove);
        
       
        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==btnadd)
        {
            setVisible(false);
            new AddEmployee();
        }
        else if(ae.getSource()==btnview)
        {
            setVisible(false);
            new ViewEmployee();   
        }
        else if(ae.getSource()==btnupdate)
        {
            setVisible(false);
            new ViewEmployee();
          
            
        }
        else
        {
            setVisible(false);
            new RemoveEmployee();
        
        }
        
        
    }
    
    public static void main(String[] args) {
        new Home();
    }
    
}
