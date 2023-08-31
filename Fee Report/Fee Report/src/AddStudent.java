
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;

public class AddStudent extends JFrame implements ActionListener{


    JButton AddAccount, back;
    JLabel heading,name,Email,course,fee,paid,due,address,contact;
    JTextField nf,ef,cf,ff,pf,df,af,conf;

    AddStudent(){

        heading=new JLabel("Add Student");
        setLayout(null);
        heading.setBounds(130,10,200,30);
        heading.setFont(new Font("Algerian",Font.PLAIN,25));
        add(heading);

        name=new JLabel("Name: ");

        name.setBounds(50,60,200,30);
        name.setFont(new Font("Roboto",Font.PLAIN,20));
        add(name);


        nf = new JTextField();
        nf.setBounds(180,67,150,20);
        add(nf);


        Email=new JLabel("Email: ");

        Email.setBounds(50,100,200,30);
        Email.setFont(new Font("Roboto",Font.PLAIN,20));
        add(Email);

        ef = new JTextField();
        ef.setBounds(180,107,150,20);
        add(ef);

        course=new JLabel("Course: ");

        course.setBounds(50,140,200,30);
        course.setFont(new Font("Roboto",Font.PLAIN,20));
        add(course);


        cf = new JTextField();
        cf.setBounds(180,147,150,20);
        add(cf);

        fee=new JLabel("Fee: ");

        fee.setBounds(50,180,200,30);
        fee.setFont(new Font("Roboto",Font.PLAIN,20));
        add(fee);

        ff = new JTextField();
        ff.setBounds(180,187,150,20);
        add(ff);


        paid=new JLabel("Paid: ");

        paid.setBounds(50,220,200,30);
        paid.setFont(new Font("Roboto",Font.PLAIN,20));
        add(paid);

        pf = new JTextField();
        pf.setBounds(180,227,150,20);
        add(pf);


        due=new JLabel("Due: ");

        due.setBounds(50,260,200,30);
        due.setFont(new Font("Roboto",Font.PLAIN,20));
        add(due);

        df = new JTextField();
        df.setBounds(180,267,150,20);
        add(df);

        address=new JLabel("Address");

        address.setBounds(50,300,200,30);
        address.setFont(new Font("Roboto",Font.PLAIN,20));
        add(address);

        af = new JTextField();
        af.setBounds(180,307,150,20);
        add(af);


        contact=new JLabel("Contact: ");

        contact.setBounds(50,340,200,30);
        contact.setFont(new Font("Roboto",Font.PLAIN,20));
        add(contact);


        conf = new JTextField();
        conf.setBounds(180,347,150,20);
        add(conf);



        AddAccount = new JButton("Add Account");
        AddAccount.setBounds(50,450,130,30);
        AddAccount.setBackground(Color.DARK_GRAY);
        AddAccount.setForeground(Color.WHITE);
        AddAccount.addActionListener(this);
        add(AddAccount);

        back = new JButton("Back");
        back.setBounds(210,450,130,30);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/print.jpg"));
        Image img = i1.getImage().getScaledInstance(400,510,Image.SCALE_DEFAULT);
        ImageIcon i2= new ImageIcon(img);
        JLabel image = new JLabel(i2);
        image.setBounds(0,0,400,510);
        add(image);

        setSize(400,510);
        setUndecorated(true);
        setLocation(150,10);
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==AddAccount){
                try{

                    String name=nf.getText();
                    String email=ef.getText();
                    String course=cf.getText();
                    float fee= Float.parseFloat(ff.getText());
                    float paid= Float.parseFloat(pf.getText());
                    float due= Float.parseFloat(df.getText());
                    String address=af.getText();
                    String contact=conf.getText();

                    ConnectionClass conn=new ConnectionClass();
                    String query="insert into addstudents values('"+name+"','"+email+"','"+course+"','"+fee+"','"+paid
                            +"','"+due+"','"+address+"','"+contact+"')";
                    int check=conn.statement.executeUpdate(query);
                    if(check==1){
                        JOptionPane.showMessageDialog(null,"Successfully added :)");

                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Failed!!");
                    }

                }catch (Exception ee){
                    ee.printStackTrace();
                }
            }
            else {
                new AccountantSection();
                setVisible(false);
            }
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
