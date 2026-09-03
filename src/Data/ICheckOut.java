/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Data;
import User.Patient;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public interface ICheckOut {
    public abstract boolean checkOutPatient(int pID);
    public abstract ArrayList<Patient> getMedicalHistory();
}
