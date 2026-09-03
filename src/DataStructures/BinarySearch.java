/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;
import User.Patient;

/**
 *
 * @author icbt1
 */
public class BinarySearch {

    public static Patient search(Patient[] arr, int searchId) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (arr[mid].getPatientId() == searchId) {
                return arr[mid];
            } else if (arr[mid].getPatientId() < searchId) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return null;
    }
}