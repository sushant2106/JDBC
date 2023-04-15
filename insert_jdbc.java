import java.sql.*;


public class Main {
    public static void main(String[] args)throws Exception {


            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
            Statement st=con.createStatement();
            String query="insert into ece values('lakshay',182,'c')";
            int count=st.executeUpdate(query);

            System.out.println(count);

            st.close();

            con.close();

    }
}
