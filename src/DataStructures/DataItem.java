/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;

import User.Patient;

public class DataItem {
    
    private int key;
    private Patient patient;

    public DataItem(int key, Patient patient){
        this.key = key;
        this.patient = patient;
    }

    public int getKey(){
        return key;
    }

    public Patient getPatient(){
        return patient;
    }
} // end class DataItem
