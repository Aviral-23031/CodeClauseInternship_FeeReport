import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class ViewAccount extends JFrame{


        String x[]={"Name", "Password","Email","Contact","Address"};

        String[][] y=new String[20][5];
        int i=0,j=0;
        JTable table;
        Font f,f1;
        ViewAccount(){
            super("View Data");
            f = new Font("Roboto",Font.PLAIN,15);
            try{

                ConnectionClass con= new ConnectionClass();
                String query="select * from AddAccount";
                ResultSet rs= con.statement.executeQuery(query);
                while(rs.next()){
                    y[i][j++]=rs.getString("Name");
                    y[i][j++]=rs.getString("Password");
                    y[i][j++]=rs.getString("Email");
                    y[i][j++]=rs.getString("Contact");
                    y[i][j++]=rs.getString("Address");
                    i++;
                    j=0;
                }

                table=new JTable(y,x);
                table.setFont(f);

                JScrollPane jsp=new JScrollPane(table);
                add(jsp);


            }catch (Exception e){
                e.printStackTrace();
            }



            setSize(800,400);
            setVisible(true);
            setLocation(1,1);
        }


    public static void main(String[] args) {
        new ViewAccount();
    }
}
