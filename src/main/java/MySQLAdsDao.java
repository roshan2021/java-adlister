import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

//add implements Ads interface
public class MySQLAdsDao implements Ads{
    private Connection connection = null;
    public MySQLAdsDao(Config config){
        try{
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ads");
            while(rs.next()){
                // translating the rs into a java obj
                ads.add(new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                ));

                //Tomcat Output below for testing purposes
//                System.out.println("rs.getLong(\"id\") = " + rs.getLong("id"));
//                System.out.println("rs.getString(\"title\") = " + rs.getString("title"));
//                System.out.println("rs.getString(\"description\") = " + rs.getString("description"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ads;
    }



    @Override
    public Long insert(Ad ad) {
        String query = String.format("insert into ads (user_id, title, description) values (%s, '%s', '%s')", ad.getUserId(), ad.getTitle(), ad.getDescription());
        System.out.println("query = " + query);

        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            return rs.getLong("1");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
