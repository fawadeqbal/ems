/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dto;

import java.util.ArrayList;

/**
 *
 * @author fawad
 */
public class Response {
    private ArrayList<Message> messagesList;

    public Response() {
        messagesList=new ArrayList<>();
    }
    private boolean hasError() {
        for(Message m : messagesList)
        {
            if(m.getType() == MessageType.Error || m.getType() == MessageType.Exception)
                return true;
        }
        return false;
}

    public String getErrorMessages() {
        StringBuilder sb = new StringBuilder();    
        for(Message m : messagesList)
        {
           if(sb.length() > 0) 
               sb.append(",\n");
            if(m.getType() == MessageType.Error || m.getType() == MessageType.Exception)
                sb.append(m.getMessage());
        }
        return sb.toString();
    }
    
    public String getInfoMessages() {
        StringBuilder sb = new StringBuilder();    
        for(Message m : messagesList)
        {
           if(sb.length() > 0) 
               sb.append(",\n");
            if(m.getType() == MessageType.Information)
                sb.append(m.getMessage());
        }
        return sb.toString();
    }
    public void addMessage(Message message){
        this.messagesList.add(message);
    }

    public boolean isSuccessfull() {
        return !hasError();
    }
}
