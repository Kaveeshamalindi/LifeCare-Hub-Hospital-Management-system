/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 *
 * @author icbt1
 */
public class Link {
    
    public String patientId;
    public String name;
    public int age;
    public String illness;
    public String severity;
    public String checkInTime;  
    public int arrivalOrder;

    public Link next;
    public Link previous;

    public Link(String patientId, String name, int age, String illness, String severity, String checkInTime) {

        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.illness = illness;
        this.severity = severity;
        this.checkInTime = checkInTime;

        this.arrivalOrder = 0;
        this.next = null;
        this.previous = null;
    }
    
}

