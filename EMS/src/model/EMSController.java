/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.DALManager;
import java.util.ArrayList;
import model.dto.EmployeeDTO;
import model.dto.Response;

/**
 *
 * @author fawad
 */
public class EMSController {

    private final DALManager objDALManager;

    public EMSController() {
        objDALManager = EMSFactory.getInstanceofDALManager();
    }

    public ArrayList<EmployeeDTO> getEmployees(Response response) {
        return objDALManager.getEmployees(response);
    }

    public Response addEmployee(EmployeeDTO employee) {
        Response response = EMSFactory.getInstanceofResponse();
        objDALManager.addEmployee(employee, response);
        return response;
    }
    public Response deleteEmployee(EmployeeDTO employee) {
        Response response = EMSFactory.getInstanceofResponse();
        objDALManager.deleteEmployee(employee, response);
        return response;
    }
    public Response updateEmployee(EmployeeDTO employee) {
        Response response = EMSFactory.getInstanceofResponse();
        objDALManager.updateEmployee(employee, response);
        return response;
    }
}
