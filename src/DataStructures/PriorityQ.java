/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;
import User.Patient;

/**
 *
 * @author USER
 */
public class PriorityQ {

    // array in sorted order, from max at 0 to min at size-1
    private int maxSize;
    private Patient[] queArray;
    private int nItems;
    
    // constructor
    public PriorityQ(int s) {
        maxSize = s;
        queArray = new Patient[maxSize];
        nItems = 0;
    }
    
    // insert item
    public void insert(Patient item) {
        int j;

        if (nItems == 0) {
            queArray[nItems++] = item;
        } else {
            for (j = nItems - 1; j >= 0; j--) {

                if (item.getPriority() > queArray[j].getPriority()) {
                    queArray[j + 1] = queArray[j];
                }
                else if (item.getPriority() == queArray[j].getPriority() && item.getArrivalOrder() < queArray[j].getArrivalOrder()) {
                    queArray[j + 1] = queArray[j];
                }
                else {
                    break;
                }
            }

            queArray[j + 1] = item;
            nItems++;
        }
    }  // end insert()
    
    public Patient remove() {
        Patient temp = queArray[0];

        // shift everything left
        for (int i = 1; i < nItems; i++) {
            queArray[i - 1] = queArray[i];
        }

        nItems--;
        return temp;
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }
      
} // end class PriorityQ
