package org.example;
import  java.util.*;
import java.sql.*;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc=new Scanner(System.in);
        String url="jdbc:mysql://localhost:3306/bmsit";
        int n=sc.nextInt();
        sc.nextLine();
        String query="insert into hostel values(?,?)";
        try {
            Connection con=DriverManager.getConnection(url,"root","");
            PreparedStatement st = null;
            while(n>0) {
                String name=sc.nextLine();
                int room_no=sc.nextInt();
                sc.nextLine();
              st = con.prepareStatement(query);
                st.setString(1,name);
                st.setInt(2,room_no);
                int count = st.executeUpdate();
               n=n-1;
            }
            ResultSet rs=st.executeQuery("select  * from hostel");
            while(rs.next()){
                System.out.println(rs.getString(1)+" "+rs.getInt(2));
            }
            st.close();
            rs.close();

        }
        catch (SQLException e){
            System.out.println(e);
        }


    }
}
