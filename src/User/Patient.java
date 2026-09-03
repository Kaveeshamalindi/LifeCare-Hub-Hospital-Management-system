/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;
import java.time.LocalDateTime;

/**
 *
 * @author icbt1
 */
public class Patient {
    
    int patientId;
    String name;
    int age;
    String illness;
    String severity;
    String checkInTime;  
    int arrivalOrder;

    public Patient() {
    }

    public Patient(int patientId, String name, int age, String illness, String severity, String checkInTime) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.illness = illness;
        this.severity = severity;
        this.checkInTime = checkInTime;
    }

    public Patient(int patientId, String name, int age, String illness, String severity, String checkInTime, int arrivalOrder) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.illness = illness;
        this.severity = severity;
        this.checkInTime = checkInTime;
        this.arrivalOrder = arrivalOrder;
    }
    
    

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public int getArrivalOrder() {
        return arrivalOrder;
    }

    public void setArrivalOrder(int arrivalOrder) {
        this.arrivalOrder = arrivalOrder;
    }
    
    // Convert Patient to CSV string
    public String toCSV() {
        return patientId + "," + name + "," + age + "," + illness + "," + severity + "," + checkInTime;
    }
    
    // Convert CSV string to Patient
    public static Patient fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        return new Patient(
            Integer.parseInt(parts[0]),
            parts[1],
            Integer.parseInt(parts[2]),
            parts[3],
            parts[4],
            parts[5]
        );
    }
    
    public int getPriority() {
        switch (severity.toLowerCase()) {
            case "critical": return 3;
            case "serious": return 2;
            case "normal": return 1;
            default: return 0;
        }
    }
}
