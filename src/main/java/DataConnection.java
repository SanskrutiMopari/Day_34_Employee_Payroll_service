import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Employee_Payroll";
        String userName = "root";
        String passWord = "Amravati@123";
        try {
            Connection con = DriverManager.getConnection(url, userName, passWord);
            System.out.println("Connection Create Successfully" + con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
