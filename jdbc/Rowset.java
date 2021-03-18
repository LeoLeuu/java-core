package jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class Rowset {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");

        JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
        rowSet.setUrl("jdbc:mysql://localhost/mydatabase");
        rowSet.setUsername("root");
        rowSet.setPassword("123456a@");

        rowSet.setCommand("select * from student");
        rowSet.execute();
        while (rowSet.next()){
            System.out.println(rowSet.getString(2));
        }
    }
}
