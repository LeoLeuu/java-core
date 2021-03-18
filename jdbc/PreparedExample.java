package jdbc;



import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedExample {
    static ConnectDatabase connectDatabase;
    public static void main(String[] args) {
        try {
            PreparedStatement preparedStatement =  connectDatabase.toConnection().prepareStatement("update student set name = ? where ID = ?");
            preparedStatement.setString(1,"vinh");
            preparedStatement.setInt(2,2);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
