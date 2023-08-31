import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class AddAccount extends JFrame implements ActionListener{

    JTextField tfname, tfemail, tfcontact, tfaddress;
    JPasswordField pf;
    JButton back,addAccount;
    AddAccount(){



        getContentPane().setBackground(Color.lightGray);

        JLabel heading = new JLabel("Add Accountant");
        setLayout(null);
        heading.setFont(new Font("Arial",Font.BOLD,20));
        heading.setBounds(160,0,200,50);
        add(heading);


        JLabel username = new JLabel("Name: ");
        setLayout(null);
        username.setFont(new Font("Roboto",Font.BOLD,16));
        username.setBounds(50,50,100,50);
        add(username);


        tfname = new JTextField();
        tfname.setBounds(200,67,150,20);
        add(tfname);

        JLabel password = new JLabel("Password: ");
        setLayout(null);
        password.setFont(new Font("Roboto",Font.BOLD,16));
        password.setBounds(50,80,100,50);
        add(password);

        pf = new JPasswordField();
        pf.setBounds(200,97,150,20);
        add(pf);

        JLabel email = new JLabel("Email: ");
        setLayout(null);
        email.setFont(new Font("Roboto",Font.BOLD,16));
        email.setBounds(50,110,100,50);
        add(email);

        tfemail= new JTextField();
        tfemail.setBounds(200,127,150,20);
        add(tfemail);


        JLabel contact = new JLabel("Contact: ");
        setLayout(null);
        contact.setFont(new Font("Roboto",Font.BOLD,16));
        contact.setBounds(50,140,100,50);
        add(contact);

        tfcontact= new JTextField();
        tfcontact.setBounds(200,157,150,20);
        add(tfcontact);


        JLabel address = new JLabel("Address: ");
        setLayout(null);
        address.setFont(new Font("Roboto",Font.BOLD,16));
        address.setBounds(50,170,100,50);
        add(address);

        tfaddress= new JTextField();
        tfaddress.setBounds(200,187,150,20);
        add(tfaddress);






        addAccount = new JButton("Add Accountant");
        addAccount.setBounds(200,217, 150,30);
        addAccount.setBackground(Color.DARK_GRAY);
        addAccount.setForeground(Color.white);
        addAccount.addActionListener(this);
        add(addAccount);


        back = new JButton("back");
        back.setBounds(200,267, 150,30);
        back.setBackground(Color.DARK_GRAY);
        back.addActionListener(this);
        back.setForeground(Color.white);
        add(back);

        setUndecorated(true);
        setSize(450,320);
        setVisible(true);
        setLocation(450,200);
    }


    public void actionPerformed(ActionEvent e){
        if(e.getSource()==addAccount){

            String name = tfname.getText();
            String pass= pf.getText();
            String email = tfemail.getText();
            String contact = tfcontact.getText();
            String address = tfaddress.getText();


            try{
                    ConnectionClass conn = new ConnectionClass();
                String query = "insert into AddAccount values('"+name+"','"+pass+"','"+email+"','"+contact+"','"+address+"')";
                int a= conn.statement.executeUpdate(query);
                if(a==1){
                    JOptionPane.showMessageDialog(null,"Details Successfully added.");

                }
                else{
                    JOptionPane.showMessageDialog(null,"Error!!");
                    setVisible(true);
                }
            }
            catch (Exception ee){
                ee.printStackTrace();
            }
        }
        else{
            new AdminSection();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddAccount();
    }
}
