/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import DataStructures.DataItem;
import DataStructures.HashTable;
import User.Patient;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class CheckOutFileDB implements ICheckOut{

    private static final String FILE_NAME = "PatientRegistration.txt";
    private static final String FILE_NAME_Temp = "PatientRegistrationTemp.txt";
    
    private HashTable deletedTable = new HashTable(50); // size can be changed

    public CheckOutFileDB() {
    }
    
    @Override
    public boolean checkOutPatient(int pID) {
        Path myFile5 = Paths.get(FILE_NAME);
        Path temFile5 = Paths.get(FILE_NAME_Temp);  
        boolean deleted = false;

        try (BufferedReader br = Files.newBufferedReader(myFile5, StandardCharsets.UTF_8);
             BufferedWriter bw = Files.newBufferedWriter(temFile5, StandardCharsets.UTF_8,
                     StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] s = line.split(",");

                if (Integer.valueOf(s[0]) != pID) {
                    bw.write(line);
                    bw.newLine();
                } else {
                    deleted = true;

                    // ✅ Create Patient object
                    Patient p = new Patient(
                            Integer.parseInt(s[0]),
                            s[1],
                            Integer.parseInt(s[2]),
                            s[3],
                            s[4],
                            s[5]
                    );

                    // ✅ Store in HashTable
                    DataItem item = new DataItem(p.getPatientId(), p);
                    deletedTable.insert(item);

                    // ✅ Save to deleted file
                    saveDeletedPatient(p);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        try {
            Files.delete(myFile5);
            Files.move(temFile5, myFile5, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return deleted;
    }

    @Override
    public ArrayList<Patient> getMedicalHistory() {
        ArrayList<Patient> pList=new ArrayList<>();
        Path myFile5=Paths.get(FILE_NAME);
        try(BufferedReader br=Files.newBufferedReader(myFile5,StandardCharsets.UTF_8);){
             String line;
           while((line=br.readLine())!=null){
              String[] s=line.split(",");
              int patientId=Integer.valueOf(s[0]);
              String name=s[1];
              int age=Integer.valueOf(s[2]);
              String illness=s[3];
              String severity=s[4];
              String checkInTime=s[5];
              
              Patient p=new Patient(patientId, name, age, illness, severity, checkInTime);
              pList.add(p);              
           }
          return pList;
       }catch(Exception e){
           return pList;
       }
    }  
    
    
    private void saveDeletedPatient(Patient p) {
        String deletedFile = "DeletedPatients.txt";

        try (BufferedWriter bw = Files.newBufferedWriter(
                Paths.get(deletedFile),
                StandardCharsets.UTF_8,
                StandardOpenOption.APPEND,
                StandardOpenOption.CREATE)) {

            bw.write(p.toCSV());
            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public HashTable loadDeletedPatientsToHashTable() {
        HashTable table = new HashTable(50);
        Path path = Paths.get("DeletedPatients.txt");

        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;

            while ((line = br.readLine()) != null) {
                Patient p = Patient.fromCSV(line);

                DataItem item = new DataItem(p.getPatientId(), p);
                table.insert(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return table;
    }
    
    
}
