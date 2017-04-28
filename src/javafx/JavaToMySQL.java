package javafx;

import java.sql.*;

/**
 *
 * @author Нина
 */
public class JavaToMySQL {
    //JDBC URL, user, password
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "root";
    private static final String password = "admin";
    
    //JDBC variable
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    public String data="";
    public String connect()
    {
        String query = "select idStudent,name,family,gender from student";
        
        try{
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String fam = rs.getString(3);
                String gend = rs.getString(4);
                data = data+ name+ " " +fam+" "+"\n";
        System.out.printf("id: %d, имя: %s, фамилия: %s,пол: %s \n", id, name, fam, gend);
       
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }finally{
        //close connection
            try{con.close();}catch(SQLException se) {}
            try{stmt.close();}catch(SQLException se) {}
            try{rs.close();}catch(SQLException se) {}
        } return(data);
    }
}
