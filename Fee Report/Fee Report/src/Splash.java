import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Splash extends JFrame implements ActionListener {

    JButton exit,Login;
    Splash(){

            getContentPane().setBackground(Color.WHITE);

           JLabel heading = new JLabel("Fee Report Management System");
           setLayout(null);
           heading.setBounds(200, 10, 1200, 60);
           heading.setFont(new Font("Arial", Font.BOLD,50));
           heading.setForeground(Color.CYAN);
           add(heading);


           ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
           Image img= i.getImage().getScaledInstance(1170,700,Image.SCALE_DEFAULT);
           ImageIcon icon= new ImageIcon(img);
           JLabel image= new JLabel(icon);
           image.setBounds(0,0,1170,650);
           add(image);


           Login = new JButton("Go to Login");
           Login.setBounds(430, 450, 300, 50);
           Login.setForeground(Color.white);
           Login.setBackground(Color.DARK_GRAY);
           Login.setFont(new Font("Roboto",Font.BOLD,15));
           Login.addActionListener(this);
           add(Login);



           exit = new JButton("Close");
           exit.setBounds(430, 520, 300, 50);
           exit.setForeground(Color.white);
           exit.setBackground(Color.DARK_GRAY);
           exit.setFont(new Font("Roboto",Font.BOLD,15));
           exit.addActionListener(this);
           add(exit);


        setUndecorated(true);
        setSize(1170, 650);
        setVisible(true);
        setLocation(100, 50);
    }






    public void actionPerformed(ActionEvent e){
           if (e.getSource()==Login){
               setVisible(false);
               new Login();
           }
           else {
               System.exit(0);
           }
    }


    public static void main(String[] args) {
        new Splash();
    }
}
