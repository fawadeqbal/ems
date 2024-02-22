
package dal.db;

/**
 *
 * @author fawad
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;


public class SQLConnection implements IConnection {
    private String dbName;
    private String username;
    private String password;

    public SQLConnection(String dbName, String username, String password) {
        this.dbName = dbName;
        this.username = username;
        this.password = password;
    }

    @Override
    public Connection getConnection(Response response) {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, username, password);
        } catch (SQLException ex) {
            response.addMessage(new Message("Database connection error.",MessageType.Error));
            response.addMessage(new Message(ex.getLocalizedMessage(),MessageType.Exception));
        }
        return null;
    }
      // Example of closing the connection
    public void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            
        }
    }
}


