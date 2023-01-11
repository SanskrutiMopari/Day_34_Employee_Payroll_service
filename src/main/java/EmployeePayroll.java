import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayroll {

    List<Employee> list;

    public Connection dataConnection() {
        String url = "jdbc:mysql://localhost:3306/Employee_Payroll";
        String userName = "root";
        String passWord = "Amravati@123";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, userName, passWord);
            System.out.println("Connection Create Successfully" + con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void retrieveData() {
        list = new ArrayList<>();
        String sql = "select * from Employee_Table";
        try {
            Connection connection = dataConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                double salary = resultSet.getDouble("Salary");
                LocalDate startDate = resultSet.getDate("StartDate").toLocalDate();
                list.add(new Employee(id, name, salary, startDate));
            }
            list.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
