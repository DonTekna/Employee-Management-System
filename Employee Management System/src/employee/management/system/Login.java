package employee.management.system;

import java.sql.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{

    JTextField txtusername,txtpassword;
    public Login() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(40,20,100,30);
        add(lblUsername);
        
        txtusername = new JTextField();
        txtusername.setBounds(150,20,150,30);
        add(txtusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40,70,100,30);
        add(lblpassword);
        
        txtpassword = new JTextField();
        txtpassword.setBounds(150,70,150,30);
        add(txtpassword);
        
        JButton btnlogin  = new JButton("LOGIN");
        btnlogin.setBounds(150,140,150,30);
        btnlogin.setBackground(Color.BLACK);
        btnlogin.setForeground(Color.WHITE);
        btnlogin.addActionListener(this);
        add(btnlogin);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);
        
        
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
    
    }
    
      public void actionPerformed(ActionEvent ae){
          try{
              String username = txtusername.getText();
              String password = txtpassword.getText();
              
              Conn c =new Conn();
              String query= "select * from login where username ='"+username+"'and password= '"+password+"' ";
              
              ResultSet rs = c.s.executeQuery(query); 
              if (rs.next())
              {
                  setVisible(false);
                  new Home();
              }
              else
              {
                  JOptionPane.showMessageDialog(null, "Invalid username or password");
                  setVisible(false);
              }
          }catch(Exception e)
          {
              e.printStackTrace();
          
          }
          
          
      }
    
    
    
    public static void main(String[] args) 
    {
        new Login();
    }
}
