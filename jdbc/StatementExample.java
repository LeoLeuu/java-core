package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementExample {
    static Statement statement;
    static ConnectDatabase connectDatabase;
    public static void main(String[] args) {
        try {
            statement = connectDatabase.toConnection().createStatement();
            String sql = "create table student(ID int primary key, " +
                    "name varchar(200), age integer default 20)";
//            statement.execute("insert into student (ID,name ,age) values (1,'Le Xuan Vinh',21)");
//            statement.execute("insert into student (ID,name ,age) values (2,'Le Xuan Hoang',31)");
//            statement.execute("insert into student (ID,name ,age) values (3,'Ngo Van Linh',51)");
            ResultSet set = statement.executeQuery("select * from student");
            while (set.next()){
                int id = set.getInt("id");
                String s = set.getString("name");
                int age = set.getInt("age");

                System.out.println(id + " " + s + " "+ age);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
