import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        try {
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
            Statement stmt= con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from emp_info");
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
