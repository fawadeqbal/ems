/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;

/**
 *
 * @author fawad
 */
public class ObjectReader {
    ResultSet read(Connection connection,Response response,String query){
        PreparedStatement stmnt=null;
        try {
            stmnt=connection.prepareStatement(query);
            return stmnt.executeQuery();
        } catch (SQLException ex) {
            response.addMessage(new Message("Error occured while reading data from database.",MessageType.Error));
            response.addMessage(new Message(ex.getLocalizedMessage(),MessageType.Exception));
            return null;
        }
        
    }
}
