/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;
import User.Patient;
import java.io.*;
import java.util.*;

/**
 *
 * @author USER
 */
public class FindPatientFileDB {
    public static Patient[] loadPatients(String fileName) {
    List<Patient> list = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;

        while ((line = br.readLine()) != null) {
            list.add(Patient.fromCSV(line));
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

    return list.toArray(new Patient[0]);
}
}
