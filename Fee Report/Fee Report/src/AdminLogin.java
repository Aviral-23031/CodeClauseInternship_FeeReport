import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.sql.ResultSet;

public class AdminLogin extends JFrame implements ActionListener{

    JButton Login, close;
    JTextField tf;
    JPasswordField pf;
    AdminLogin(){

        getContentPane().setBackground(Color.lightGray);

        JLabel heading = new JLabel("Admin Login ");
        setLayout(null);
        heading.setFont(new Font("Arial",Font.BOLD,20));
        heading.setBounds(160,0,200,50);
        add(heading);


        JLabel username = new JLabel("Username: ");
        setLayout(null);
        username.setFont(new Font("Roboto",Font.BOLD,16));
        username.setBounds(50,50,100,50);
        add(username);


        JLabel password = new JLabel("Password: ");
        setLayout(null);
        password.setFont(new Font("Roboto",Font.BOLD,16));
        password.setBounds(50,100,100,50);
        add(password);


        tf = new JTextField();
        tf.setBounds(200,67,150,20);
        add(tf);


        pf = new JPasswordField();
        pf.setBounds(200,117,150,20);
        add(pf);


        Login = new JButton("Login");
        Login.setBounds(200,167, 150,30);
        Login.setBackground(Color.DARK_GRAY);
        Login.setForeground(Color.white);
        Login.addActionListener(this);
        add(Login);


        close = new JButton("Close");
        close.setBounds(200,217, 150,30);
        close.setBackground(Color.DARK_GRAY);
        close.addActionListener(this);
        close.setForeground(Color.white);
        add(close);

        setUndecorated(true);
        setSize(450,280);
        setVisible(true);
        setLocation(450,200);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==Login){
            try
            {
                String username=tf.getText();
                String password=pf.getText();
                String query="select*from admin where username= '"+username+"' and password= '"+password+"'";
                ConnectionClass con= new ConnectionClass();

                ResultSet res = con.statement.executeQuery(query);
                if(res.next()){
                    new AdminSection();
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Either the name or password is wrong!");
                    setVisible(false);
                }

            }catch (Exception ee){
                ee.printStackTrace();
            }
        }
        else if (e.getSource()==close)
        {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new AdminLogin();
    }
}
