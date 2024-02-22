/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import java.sql.*;
import model.dto.EmployeeDTO;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;
/**
 *
 * @author fawad
 */
public class ObjectAdder {
    public boolean addEmployee(Connection connection,Response response, EmployeeDTO employee) {
        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO Employee (name, age, department) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, employee.getName());
            statement.setInt(2, employee.getAge());
            statement.setString(3, employee.getDepartment());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            response.addMessage(new Message("Error occured while adding employee into database.",MessageType.Error));
            response.addMessage(new Message(e.getLocalizedMessage(),MessageType.Exception));
            return false;
        } 
    }
}
