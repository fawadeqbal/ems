/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.DALManager;
import dal.ObjectAdder;
import dal.ObjectMapper;
import dal.ObjectReader;
import model.dto.Response;

/**
 *
 * @author fawad
 */
public class EMSFactory {
    public static Response getInstanceofResponse(){
        return new Response();
    }
    public static ObjectAdder getInstanceofObjectAdder(){
        return new ObjectAdder();
    }
    
    public static ObjectMapper getInstanceofObjectMapper(){
        return new ObjectMapper();
    }
    
    public static DALManager getInstanceofDALManager(){
        return new DALManager();
    }
    
    public static ObjectReader getInstanceofObjectReader(){
        return new ObjectReader();
    }
    public static EMSController getInstanceofEMSController(){
        return new EMSController();
    }
}
