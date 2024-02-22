/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.db;
import java.sql.Connection;
import model.dto.Response;
/**
 *
 * @author fawad
 */
public interface IConnection {
    public Connection getConnection(Response response);
}
