/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;
import java.util.ArrayList;
import model.dto.EmployeeDTO;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;

/**
 *
 * @author fawad
 */
public class ObjectMapper {

    public ArrayList<EmployeeDTO> mapEmployees(ResultSet rs,Response response) {
        ArrayList<EmployeeDTO> employeeList = new ArrayList<>();
        try {
            while (rs.next()) {
                EmployeeDTO employee = new EmployeeDTO();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setAge(rs.getInt("age"));
                employee.setDepartment(rs.getString("department"));
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            response.addMessage(new Message("Error occured while mapping data from database.", MessageType.Error));
            response.addMessage(new Message(e.getLocalizedMessage(), MessageType.Exception));
        }
        return employeeList;
    }
}
