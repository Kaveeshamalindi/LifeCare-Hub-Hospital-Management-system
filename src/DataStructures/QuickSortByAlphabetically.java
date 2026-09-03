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
public class QuickSortByAlphabetically {
    private Patient[] arr;
    private int nElems;

    public QuickSortByAlphabetically(int size) {
        arr = new Patient[size];
        nElems = 0;
    }

    public void insert(Patient p) {
        arr[nElems++] = p;
    }

    public Patient[] getArray() {
        return arr;
    }

    public int size() {
        return nElems;
    }

    public void quickSort() {
        recQuickSort(0, nElems - 1);
    }

    private void recQuickSort(int left, int right) {
        if (left >= right) return;

        Patient pivot = arr[right];
        int partition = partitionIt(left, right, pivot);

        recQuickSort(left, partition - 1);
        recQuickSort(partition + 1, right);
    }

    private int partitionIt(int left, int right, Patient pivot) {

        int leftPtr = left - 1;
        int rightPtr = right;

        while (true) {

            while (arr[++leftPtr].getName()
                    .compareToIgnoreCase(pivot.getName()) < 0);

            while (rightPtr > 0 &&
                   arr[--rightPtr].getName()
                   .compareToIgnoreCase(pivot.getName()) > 0);

            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }

        swap(leftPtr, right);
        return leftPtr;
    }

    private void swap(int i, int j) {
        Patient temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
