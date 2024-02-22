/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.DALManager;
import dal.ObjectAdder;
import dal.ObjectMapper;
import dal.ObjectModifier;
import dal.ObjectReader;
import dal.ObjectRemover;
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
    public static ObjectRemover getInstanceofObjectRemover(){
        return new ObjectRemover();
    }
    public static ObjectModifier getInstanceofObjectModifier(){
        return new ObjectModifier();
    }
    public static EMSController getInstanceofEMSController(){
        return new EMSController();
    }
}
