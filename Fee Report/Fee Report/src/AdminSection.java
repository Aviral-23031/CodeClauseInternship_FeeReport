import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;


public class AdminSection extends JFrame implements ActionListener{

    JButton Logout, AddAccount, ViewAccount;


    AdminSection(){

        getContentPane().setBackground(Color.white);
        JLabel heading = new JLabel("Admin Section");
        setLayout(null);
        heading.setBounds(150,5,150,50);

        heading.setFont(new Font("Ubuntu",Font.BOLD,20));
        add(heading);


        AddAccount = new JButton("Add Accountant");
        AddAccount.setBounds(30,70,150,30);
        AddAccount.setForeground(Color.WHITE);
        AddAccount.setBackground(Color.DARK_GRAY);
        AddAccount.addActionListener(this);
        add(AddAccount);


        ViewAccount = new JButton("View Accountant");
        ViewAccount.setBounds(30,120,150,30);
        ViewAccount.setBackground(Color.DARK_GRAY);
        ViewAccount.setForeground(Color.white);
        ViewAccount.addActionListener(this);
        add(ViewAccount);

        Logout = new JButton("Logout");
        Logout.setBounds(30,170,150,30);
        Logout.setBackground(Color.DARK_GRAY);
        Logout.setForeground(Color.white);
        Logout.addActionListener(this);
        add(Logout);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/lgn.jpg"));
        Image img = i1.getImage().getScaledInstance(180,200,Image.SCALE_DEFAULT);
        ImageIcon i2= new ImageIcon(img);
        JLabel image = new JLabel(i2);
        image.setBounds(250,65,150,150);
        add(image);

        setUndecorated(true);
        setSize(450,250);
        setVisible(true);
        setLocation(450,200);
    }


    public void actionPerformed(ActionEvent e){
            if(e.getSource()==Logout){
                setVisible(false);
                new AdminLogin();
            }
            else if(e.getSource()==AddAccount){
                    new AddAccount();
                    setVisible(false);
            }else{
                setVisible(false);
                new ViewAccount();
            }
    }

    public static void main(String[] args) {
        new AdminSection();
    }
}
