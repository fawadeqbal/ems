package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.dto.EmployeeDTO;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;

/**
 * Class responsible for removing objects from the database.
 */
public class ObjectRemover {
    public void removeEmployee(Connection connection, Response response, EmployeeDTO employee) {
        PreparedStatement statement = null;
        try {
            // Prepare the DELETE query
            String query = "DELETE FROM Employee WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, employee.getId());

            // Execute the query
            int rowsAffected = statement.executeUpdate();

            // Check if any rows were affected
            if (rowsAffected > 0) {
                response.addMessage(new Message("Employee removed successfully.", MessageType.Information));
            } else {
                response.addMessage(new Message("Employee with ID " + employee.getId() + " not found.", MessageType.Warning));
            }
        } catch (SQLException e) {
            response.addMessage(new Message("Error occurred while removing employee from the database.", MessageType.Error));
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
