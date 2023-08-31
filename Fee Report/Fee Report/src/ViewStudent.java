
import net.proteanit.sql.DbUtils;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.sql.ResultSet;


public class ViewStudent extends JFrame implements ActionListener {

    JButton back,search,print;
    Choice cempid;
    JTable table;
    ViewStudent()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        JLabel searchlbl=new JLabel("Select id:");
        searchlbl.setBounds(20,20,100,20);
        searchlbl.setFont(new Font("Arial",Font.BOLD,15));
        add(searchlbl);

        cempid=new Choice();
        cempid.setBounds(150,20,150,20);
        add(cempid);

        search =new JButton("Search");
        search.setBounds(20,60,80,20);
        search.setBackground(Color.DARK_GRAY);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);

        print=new JButton("Print");
        print.setBackground(Color.DARK_GRAY);
        print.setForeground(Color.WHITE);
        print.setBounds(120,60,80,20);
        print.addActionListener(this);
        add(print);


        back=new JButton("Back");
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(220,60,80,20);
        back.addActionListener(this);
        add(back);

        table =new JTable();

        try
        {
            ConnectionClass c=new ConnectionClass();
            ResultSet rs=c.statement.executeQuery("Select * from addstudents");
            while (rs.next())
            {
                cempid.add(rs.getString("rollno"));
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            ConnectionClass c=new ConnectionClass();
            ResultSet rs=c.statement.executeQuery("Select * from addstudents");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            while (rs.next())
            {
                cempid.add(rs.getString("rollno"));
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }

        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);

        setSize(900,700);
        setVisible(true);

        setLocation(250,30);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==search)
        {
            String query="select * from addstudents where rollno='"+cempid.getSelectedItem()+"'";
            try{
                ConnectionClass c=new ConnectionClass();
                ResultSet rs=c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception aee)
            {
                System.out.println(aee);
            }

        } else if (e.getSource()==print) {

            try
            {
                table.print();
            }catch (Exception aeee)
            {
                System.out.println(aeee);
            }
        }
        else {
            try{
                setVisible(false);
                new AccountantSection();
            }catch (Exception ae)
            {
                System.out.println(ae);
            }
        }
    }

    public static void main(String[] args) {
        new ViewStudent();
    }
}
