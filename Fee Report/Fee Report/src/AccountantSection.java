import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class AccountantSection extends JFrame implements ActionListener{


    JButton add,view,due,Logout,back;


    AccountantSection(){

        getContentPane().setBackground(Color.WHITE);
        JLabel heading = new JLabel("Accountant Login ");
        setLayout(null);
        heading.setFont(new Font("Roboto",Font.BOLD,20));
        heading.setForeground(Color.BLACK);
        heading.setBounds(100,0,200,50);
        add(heading);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/remove.jpg"));
        Image img = i1.getImage().getScaledInstance(420,320,Image.SCALE_DEFAULT);
        ImageIcon i2= new ImageIcon(img);
        JLabel image = new JLabel(i2);
        image.setBounds(0,0,420,320);
        add(image);


        add = new JButton("Add Students");
        add.setBounds(85,50,200,30);
        add.setBackground(Color.DARK_GRAY);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        view = new JButton("View Students");
        view.setBounds(85,90,200,30);
        view.setBackground(Color.DARK_GRAY);
        view.setForeground(Color.white);
        view.addActionListener(this);
        add(view);



        due = new JButton("Due Fees");
        due.setBounds(85,130,200,30);
        due.setBackground(Color.DARK_GRAY);
        due.setForeground(Color.white);
        due.addActionListener(this);
        add(due);

        Logout = new JButton("Logout");
        Logout.setBounds(85,170,200,30);
        Logout.setBackground(Color.DARK_GRAY);
        Logout.setForeground(Color.white);
        Logout.addActionListener(this);
        add(Logout);

        back = new JButton("Back");
        back.setBounds(85,210,200,30);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);



        setUndecorated(true);
        setLocation(450,230);
        setSize(380,280);
        setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==add){
            new AddStudent();
                setVisible(false);
        } else if (e.getSource()==view) {
            setVisible(false);
            new ViewStudent();
        } else if (e.getSource()==due) {
            setVisible(false);
            new DueFees();
        } else if (e.getSource()==Logout) {
            System.exit(0);
        }else {
            new AccountantLogin();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AccountantSection();
    }
}
