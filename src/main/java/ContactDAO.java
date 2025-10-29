import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactDAO {
    public void addContact(Contact contact) {
        String sql = "insert into contacts(name,phone,email) values(?,?,?)";
        try(Connection connection = DB.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1,contact.getName());
            stmt.setString(2,contact.getPhone());
            stmt.setString(3,contact.getEmail());
            stmt.executeUpdate();
            System.out.println("Contact added" + "\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateContact(int id, String newPhone, String newEmail) {
        String sql = "UPDATE contacts SET phone = ?, email = ? WHERE id = ?";

        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newPhone);
            stmt.setString(2, newEmail);
            stmt.setInt(3, id);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Contact with ID " + id + " updated.");
            } else {
                System.out.println("⚠️ No contact found with ID " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteContact(int id) {
        String sql = "DELETE FROM contacts WHERE id = ?";
        try(Connection connection = DB.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Contact with ID " + id + " deleted.");
            }else {
                System.out.println("No contact found with ID " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
