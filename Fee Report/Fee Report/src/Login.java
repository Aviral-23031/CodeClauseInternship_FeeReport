
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    JButton AdminLogin, AccountantLogin,back;

    public static void main(String[] args) {
         new Login();
    }

    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Login");
        heading.setFont(new Font("Arial",Font.BOLD,25));
        heading.setBounds(260,0,100,50);
        add(heading);

        JLabel admin = new JLabel("Admin: ");
        admin.setFont(new Font("Arial", Font.BOLD,16));
        admin.setBounds(50,50,200,70);
        add(admin);


        JLabel account = new JLabel("Account: ");
        account.setFont(new Font("Arial", Font.BOLD,16));
        account.setBounds(50,110,200,70);
        add(account);

        AdminLogin = new JButton("Login");
        AdminLogin.setBounds(150,70,150,30);
        AdminLogin.addActionListener(this);
        add(AdminLogin);


        AccountantLogin = new JButton("Login");
        AccountantLogin.setBounds(150,130,150,30);
        AccountantLogin.addActionListener(this);
        add(AccountantLogin);


        ImageIcon icon= new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image img = icon.getImage().getScaledInstance(180,180,Image.SCALE_DEFAULT);
        ImageIcon icon1 = new ImageIcon(img);
        JLabel image = new JLabel(icon1);
        image.setBounds(350,20,200,200);
        add(image);


        back=new JButton("Back");
        back.setBounds(245,220,100,30);
        back.addActionListener(this);
        add(back);


        setUndecorated(true);
        setSize(570,280);
        setVisible(true);
        setLocation(450,200);
    }

    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==AdminLogin){
                setVisible(false);
                new AdminLogin();
            } else if (e.getSource()==AccountantLogin) {
                setVisible(false);
                new AccountantLogin();
            }else{
                setVisible(false);
                new Splash();
            }
    }
}
