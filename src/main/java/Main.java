import java.sql.*;

public class Main {
    public static void main(String[] args) {

        ContactDAO dao = new ContactDAO();
        dao.addContact(new Contact(9,"Bob","+790368856734","Bob@gmail.com"));


        try(Connection connection = DB.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from contacts order by id")){
            while(resultSet.next()){
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name")
                        + " " + resultSet.getString("phone") + " " + resultSet.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
