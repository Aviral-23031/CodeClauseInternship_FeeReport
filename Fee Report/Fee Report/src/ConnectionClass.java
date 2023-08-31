import java.sql.*;
public class ConnectionClass {

        public Connection con;
        public Statement statement;

        ConnectionClass(){

                try{
                       //register the Driver class
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        //create connection object
                        con= DriverManager.getConnection("jdbc:mysql://localhost:3306/feereport","root","mysql@1312");

                        //create statement
                        statement=con.createStatement();
                        if(con.isClosed()){
                                System.out.println("not connected");
                        }
                        else {
                                System.out.println("connected");
                        }
                }
                catch (Exception e){
                        e.printStackTrace();
                }

        }

        public static void main(String[] args) {
                new ConnectionClass();
        }

}
