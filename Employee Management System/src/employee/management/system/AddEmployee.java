package employee.management.system;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField txtname,txtfathername,txtsalary,txtaddress,txtphone,txtemail,txtdesignation,txtother;
    JDateChooser dcdob;
    JComboBox jceducation;
    JLabel lblempId,lblname,lblsalary,lblphone,lblemail,lblother,lbladdres,lblfathername,lblempIdnum,lbldob,lbleducation,lbldesignation;
    JButton btnadd, btnback;
    public AddEmployee() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN SERIF",Font.BOLD,25));
        add(heading);
        
        lblname=new JLabel("Name");
        lblname.setBounds(50,150,150,30);
        lblname.setFont(new Font("SAN SERIF",Font.PLAIN,20));
        add(lblname);
        
        txtname =new JTextField();
        txtname.setBounds(200,150,150,30);
        add(txtname);
        
        lblfathername=new JLabel("Father's Name");
        lblfathername.setBounds(400,150,150,30);
        lblfathername.setFont(new Font("SAN SERIF",Font.PLAIN,20));
        add(lblfathername);
        
        txtfathername =new JTextField();
        txtfathername.setBounds(600,150,150,30);
        add(txtfathername);
        
        lbldob=new JLabel("Date of Birth");
        lbldob.setBounds(50,200,150,30);
        lbldob.setFont(new Font("SAN SERIF",Font.PLAIN,20));
        add(lbldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);
        
        lblsalary=new JLabel("Salary");
        lblsalary.setBounds(400,200,150,30);
        lblsalary.setFont(new Font("SAN SERIF",Font.PLAIN,20));
        add(lblsalary);
        
        txtsalary =new JTextField();
        txtsalary.setBounds(600,200,150,30);
        add(txtsalary);
        
        lbladdres=new JLabel("Address");
        lbladdres.setBounds(50,250,150,30);
        lbladdres.setFont(new Font("SAN SERIF",Font.PLAIN,20));
        add(lbladdres);
        
        txtaddress =new JTextField();
        txtaddress.setBounds(200,250,150,30);
        add(txtaddress);
        
        lblphone=new JLabel("Phone");
        lblphone.setBounds(400,250,150,30);
        lblphone.setFont(new Font("SAN SERIF",Font.PLAIN,20));
        add(lblphone);
        
        txtphone =new JTextField();
        txtphone.setBounds(600,250,150,30);
        add(txtphone);
        
        lblemail=new JLabel("Email");
        lblemail.setBounds(50,300,150,30);
        lblemail.setFont(new Font("SAN SERIF",Font.PLAIN,20));
        add(lblemail);
        
        txtemail =new JTextField();
        txtemail.setBounds(200,300,150,30);
        add(txtemail);
        
        lbleducation = new JLabel("Higest Education");
        lbleducation.setBounds(400, 300, 150, 30);
        lbleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbleducation);
        
        String courses[] = {"BBA", "BCA", "BA", "BSC", "B.COM", "BTech", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        jceducation = new JComboBox(courses);
        jceducation.setBackground(Color.WHITE);
        jceducation.setBounds(600, 300, 150, 30);
        add(jceducation);
        
        lbldesignation = new JLabel("Designation");
        lbldesignation.setBounds(50, 350, 150, 30);
        lbldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbldesignation);
        
        txtdesignation = new JTextField();
        txtdesignation.setBounds(200, 350, 150, 30);
        add(txtdesignation);
        
        lblother = new JLabel("Other Number");
        lblother.setBounds(400, 350, 150, 30);
        lblother.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblother);
        
        txtother = new JTextField();
        txtother.setBounds(600, 350, 150, 30);
        add(txtother);
        
        lblempId = new JLabel("Employee id");
        lblempId.setBounds(50, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);
        
        
        lblempIdnum = new JLabel("" + number);
        lblempIdnum.setBounds(200, 400, 150, 30);
        lblempIdnum.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempIdnum);
        
        btnadd = new JButton("Add Details");
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
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
        
    }
     public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnadd) {
            String name = txtname.getText();
            String fathername = txtfathername.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = txtsalary.getText();
            String address = txtaddress.getText();
            String phone = txtphone.getText();
            String email = txtemail.getText();
            String education = (String) jceducation.getSelectedItem();
            String designation = txtdesignation.getText();
            String other = txtother.getText();
            String empId = lblempIdnum.getText();
            
            try {
                Conn conn = new Conn();
                String query = "insert into employee values('"+name+"', '"+fathername+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+other+"', '"+empId+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
                
            } 
            catch (Exception e)
            {
                e.printStackTrace();
            }
        } else 
        {
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args) {
        new AddEmployee();
    }
    
}
