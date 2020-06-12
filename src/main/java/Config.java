public class Config {
    //a method for a getter for a URL
    public String getUrl() {
        //Update the database_name to adlister_db in URL
        return "jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";
    }
    //a method for a getter for user
    public String getUser() {
        return "root";
    }

    //a method for a getter for password
    public String getPassword() {
        return "codeup";
    }

    //UPDATE return user and password
    //add Config.java file to .gitignore file to protect credentials and password. Security Check!
}


