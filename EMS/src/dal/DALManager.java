/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.db.SQLConnection;
import java.util.ArrayList;
import java.sql.*;
import model.EMSFactory;
import model.dto.EmployeeDTO;
import model.dto.Response;

/**
 *
 * @author fawad
 */
public class DALManager {

    private SQLConnection sql;
    private ObjectMapper objMapper;
    private ObjectReader objReader;
    private ObjectAdder objAdder;
    private ObjectRemover objRemover;
    private ObjectModifier objModifier;
    

    public DALManager() {
        sql = new SQLConnection("ems", "root", "Admin123$");
        objMapper = EMSFactory.getInstanceofObjectMapper();
        objReader = EMSFactory.getInstanceofObjectReader();
        objAdder = EMSFactory.getInstanceofObjectAdder();
        objRemover= EMSFactory.getInstanceofObjectRemover();
        objModifier= EMSFactory.getInstanceofObjectModifier();
    }

    public ArrayList<EmployeeDTO> getEmployees(Response response) {
        Connection connection = sql.getConnection(response);
        if (response.isSuccessfull()) {
            String query = "SELECT * FROM employee";
            ResultSet resultSet = objReader.read(connection,response,query);
            return objMapper.mapEmployees(resultSet,response);
        }
        return null;
    }
    public void addEmployee(EmployeeDTO employee,Response response) {
        Connection connection = sql.getConnection(response);
        if (response.isSuccessfull()) {
           objAdder.addEmployee(connection, response, employee);
        }
    }
    public void deleteEmployee(EmployeeDTO employee, Response response) {
        Connection connection = sql.getConnection(response);
        if (response.isSuccessfull()) {
            objRemover.removeEmployee(connection, response, employee);
        }
    }

    public void updateEmployee(EmployeeDTO employee, Response response) {
        Connection connection = sql.getConnection(response);
        if (response.isSuccessfull()) {
            objModifier.updateEmployee(connection, response, employee);
        }
    }
}
