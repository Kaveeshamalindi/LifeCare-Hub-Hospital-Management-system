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
public class DoublyLinkedList {
    
    private Link first; // ref to first item
    private Link last; // ref to last item

    // constructor
    public DoublyLinkedList() {
        first = null; // no items on list yet
        last = null;
    }
    
    // true if no links
    public boolean isEmpty(){
        return first==null;
    }
    
    // insert at front of list
    public void insertFirst(String patientId, String name, int age, String illness, String severity, String checkInTime) {

        Link newLink = new Link(patientId, name, age, illness, severity, checkInTime);

        if (isEmpty())
            last = newLink;
        else
            first.previous = newLink;

        newLink.next = first;
        first = newLink;
    }
    
    // insert at end of list
    public void insertLast(String patientId, String name, int age, String illness, String severity, String checkInTime) {

        Link newLink = new Link(patientId, name, age, illness, severity, checkInTime);

        if (isEmpty())
            first = newLink;
        else {
            last.next = newLink;
            newLink.previous = last;
        }

        last = newLink;
    }
    
    // insert dd just after key
    public boolean insertAfter(String keyId, String patientId, String name, int age, String illness, String severity, String checkInTime) {

        Link current = first;

        while (!current.patientId.equals(keyId)) {
            current = current.next;
            if (current == null)
                return false;
        }

        Link newLink = new Link(patientId, name, age, illness, severity, checkInTime);

        if (current == last) {
            newLink.next = null;
            last = newLink;
        } else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }

        newLink.previous = current;
        current.next = newLink;

        return true;
    }
    
    // delete patient by using PatientId
    public Link deleteKey(String keyId) {

        Link current = first;

        while (!current.patientId.equals(keyId)) {
            current = current.next;
            if (current == null)
                return null;
        }

        if (current == first)
            first = current.next;
        else
            current.previous.next = current.next;

        if (current == last)
            last = current.previous;
        else
            current.next.previous = current.previous;

        return current;
    }
    
    public boolean DuplicatePatientID(String patientID) {

        Link current = first;

        while(current != null) {

            if(current.patientId.equals(patientID)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }
    
    public Link getFirst() {
        return first;
    }
        
}
