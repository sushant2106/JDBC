import java.sql.*;


public class Main {
    public static void main(String[] args)throws Exception {
        String name="ram";
        int usn=182;
        String c="c";

        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
            String query="insert into ece values(?,?,?)";
            PreparedStatement st=con.prepareStatement(query);
            st.setString(1,name);
            st.setInt(2,usn);
            st.setString(3,c);
            int count=st.executeUpdate();
            System.out.println(count);
            ResultSet rs=st.executeQuery("select * from ece");
            while(rs.next()){
                System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getString(3));
            }
            st.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
