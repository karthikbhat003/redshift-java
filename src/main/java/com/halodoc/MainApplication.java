package com.halodoc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import com.halodoc.domain.User;

public class MainApplication {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        User user=new User();
        user.setName("karthik");
        user.setId(1);

        Properties properties=new Properties();

        Class.forName("com.amazon.redshift.jdbc42.Driver");
        final String url="jdbc:redshift://redshift-cluster-1.ckdfxjy2diz9.us-east-2.redshift.amazonaws.com:5439/redshift_trial";
        final String userName="awsuser";
        final String passWord="Halodoc123";
        properties.setProperty("user", userName);
        properties.setProperty("password", passWord);

        Connection con= DriverManager.getConnection(url,properties);


        String query="select * from user1";
        Statement st=con.createStatement();

        ResultSet rs=st.executeQuery(query);

        rs.next();
    }
}
