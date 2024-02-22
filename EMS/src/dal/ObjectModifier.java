/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

/**
 *
 * @author fawad
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.dto.EmployeeDTO;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;

/**
 * Class responsible for updating objects in the database.
 */
public class ObjectModifier {

    /**
     * Updates information of an employee in the database.
     * @param connection The database connection.
     * @param response The response object to populate with the result or error message.
     * @param employee The EmployeeDTO object representing the employee to update.
     */
    public void updateEmployee(Connection connection, Response response, EmployeeDTO employee) {
        PreparedStatement statement = null;
        try {
            // Prepare the UPDATE query
            String query = "UPDATE Employee SET name = ?, age = ?, department = ? WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, employee.getName());
            statement.setInt(2, employee.getAge());
            statement.setString(3, employee.getDepartment());
            statement.setInt(4, employee.getId());

            // Execute the query
            int rowsAffected = statement.executeUpdate();

            // Check if any rows were affected
            if (rowsAffected > 0) {
                response.addMessage(new Message("Employee updated successfully.", MessageType.Information));
            } else {
                response.addMessage(new Message("Employee with ID " + employee.getId() + " not found.", MessageType.Warning));
            }
        } catch (SQLException e) {
            response.addMessage(new Message("Error occurred while updating employee in the database.", MessageType.Error));
            response.addMessage(new Message(e.getLocalizedMessage(), MessageType.Exception));
        } finally {
            // Close the PreparedStatement
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    response.addMessage(new Message("Error occurred while closing statement.", MessageType.Exception));
                }
            }
        }
    }
}
