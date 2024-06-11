package employee.management.system;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class mainclass extends JFrame implements ActionListener{

    public mainclass() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
         
         JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
         heading.setBounds(80, 30, 1200, 60);
         heading.setFont(new Font("serif",Font.PLAIN,60));
         heading.setForeground(Color.red);
         add(heading);
         
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
         Image i2 = i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
         ImageIcon i3= new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(50,100,1050,500);
         add(image);
         
         JButton btnclick  = new JButton("CLICK  HERE TO CONTINUE");
         btnclick.setBounds(400,400,300,70);
         btnclick.setBackground(Color.BLACK);
         btnclick.setForeground(Color.WHITE);
         btnclick.addActionListener(this);
         image.add(btnclick);
                 
        setSize(1170,650);
        setLocation(200,50);
        setVisible(true);
        
        while(true)
        {
         heading.setVisible(false);
        try
        {
            Thread.sleep(500);
            
        }catch(Exception e)
        {
        
        }
     
         heading.setVisible(true);
         try
             {  
             Thread.sleep(500);
         }catch(Exception e)
         {
             
        }

    }
    }  
    
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    
    }
            
    
    public static void main(String[] args) {
        new mainclass();
    }
}
