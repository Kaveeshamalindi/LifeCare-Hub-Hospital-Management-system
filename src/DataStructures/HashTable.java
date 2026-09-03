/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;

/**
 *
 * @author USER
 */
public class HashTable {
    
    private DataItem[] hashArray;    // array holds hash table
    private int arraySize;
    private DataItem nonItem;        // for deleted items
    
    // constructor
    public HashTable(int size){
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1, null);
    }
    
    public void displayTable(){
        System.out.print("Table: ");
        for(int j=0; j<arraySize; j++){
            if(hashArray[j] != null)
                System.out.print(hashArray[j].getKey() + " ");
            else
                System.out.print("** ");
        }
            System.out.println("");
            }
    
    public int hashFunc(int key){
        return key % arraySize;       // hash function
    }
    
    // insert a DataItem
    public void insert(DataItem item){
        // (assumes table not full)
        int key = item.getKey();      // extract key
        int hashVal = hashFunc(key);  // hash the key, until empty cell or -1,
        
        while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1){
            ++hashVal;                 // go to next cell
            hashVal %= arraySize;      // wraparound if necessary
        }
        hashArray[hashVal] = item;    // insert item
    }// end insert()

    // delete a DataItem
    public DataItem delete(int key){
        int hashVal = hashFunc(key);  // hash the key
        
        while(hashArray[hashVal] != null){
            // until empty cell, found the key ?
            if(hashArray[hashVal].getKey() == key){
                DataItem temp = hashArray[hashVal]; // save item
                hashArray[hashVal] = nonItem;       // delete item
                return temp;                        // return item
            }
            ++hashVal;                 // go to next cell
            hashVal %= arraySize;      // wraparound if necessary
        } return null; 
    }  // end delete()
    
    // find item with key
    public DataItem find(int key){
        int hashVal = hashFunc(key);  // hash the key
        while(hashArray[hashVal] != null){
            // until empty cell, found the key ?
            if(hashArray[hashVal].getKey() == key)
                return hashArray[hashVal];   // yes, return item
            ++hashVal;                 // go to next cell
            hashVal %= arraySize;      // wraparound if necessary
        } return null;                  // can’t find item
    }  
    
    public DataItem[] getAllItems() {
        return hashArray;
    }
    
}  // end class HashTable
