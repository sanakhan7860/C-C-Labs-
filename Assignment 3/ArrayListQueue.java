import java.util.ArrayList;

/**
 * COMP 2231 Assignment 3: Lists & Iterators
 * 
 * The ArrayListQueue class is a data structure which adds and removes elements from the queue using FIFO (first in last out).
 * 
 * This implements the QueueADT interface 
 *
 * @author (Sana Khan-t00718201)
 * @version (Oct 6, 2022)
 */
public class ArrayListQueue <T> implements QueueADT<T>
{
    //queue container
    private ArrayList<T> queue;

    /**
     * This is a constructor which creates an empty queue.
     */
    public ArrayListQueue() {
        queue = new ArrayList<T>();
    }

    /**
     * Adds one element to the end of this queue.
     * 
     * @param element the element to be added to the end of the queue
     */
    public void enqueue(T element) {
        queue.add(element);
    }

    /**
     * Removes and returns the element at the front of the queue.
     * 
     * @return the element at the front of the queue
     */
    public T dequeue() {
        // stores element in temporary variable to be able to return the value 
        T element = queue.remove(0);

        return element;
    }

    /**
     * Returns the top element of the stack without removing it
     * Returns null if empty.
     * 
     * @return the first element in the queue
     */
    public T first() {
        if (isEmpty()){
            return null;
        }
        else{
            return queue.get(0);
        }
    }

    /**
     * Returns true if this queue contains no elements.
     * 
     * @return true if this queue is empty
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Returns the number of elements in this queue.
     * 
     * @return the integer representation of the size of the queue
     */
    public int size() {
        return queue.size();
    }

    /**
     * Returns a string representation of this queue.
     * 
     * @return the string representation of the queue
     */
    public String toString() {
        //create a new string which will hold the elements of the queue
        String result = "";

        // loops through elements in the queue, adding each one to result
        for (T element : queue){
            result += element + "\n";
        }
        
        return result;
    }
    
    //These are the test cases for the ArrayListQueue class
    public static void main(String[] args) {
         // create a new queue
        System.out.println("Creating a new ArrayListQueue...");
        ArrayListQueue<String> ALqueue = new ArrayListQueue<String>();

        // enqueue three items onto the queue
        System.out.println("Enqueue three items onto the queue...");
        ALqueue.enqueue("Sept");
        ALqueue.enqueue("Oct");
        ALqueue.enqueue("Nov");

        // print the queue and test queue methods
        System.out.println("Printing the queue...");
        System.out.println(ALqueue);
        System.out.println("The first element is: " + ALqueue.first());
        System.out.println("The queue contains: " + ALqueue.size() + " elements");
        System.out.println("The queue is empty: " + ALqueue.isEmpty());
        System.out.println();

        // enqueue two more items onto the queue
        System.out.println("Enqueue three more items onto the queue...");
        ALqueue.enqueue("Dec");
        ALqueue.enqueue("Jan");
        ALqueue.enqueue("Feb");

        // print the queue and test queue methods
        System.out.println("Printing the queue...");
        System.out.println(ALqueue);
        System.out.println("The first element is: " + ALqueue.first());
        System.out.println("The queue contains: " + ALqueue.size() + " elements");
        System.out.println("The queue is empty: " + ALqueue.isEmpty());
        System.out.println();

        // Dequeue first two items from the queue
        System.out.println("Dequeue the first two items from the queue...");
        ALqueue.dequeue();
        ALqueue.dequeue();

        // print the queue and test queue methods
        System.out.println("Printing the queue...");
        System.out.println(ALqueue);
        System.out.println("The first element is: " + ALqueue.first());
        System.out.println("The queue contains: " + ALqueue.size() + " elements");
        System.out.println("The queue is empty: " + ALqueue.isEmpty());
        System.out.println();

        // Dequeue remaining items from the queue
        System.out.println("Dequeue the remaining items from the queue...");
        ALqueue.dequeue();
        ALqueue.dequeue();
        ALqueue.dequeue();
        ALqueue.dequeue();

        // print the queue and test queue methods
        System.out.println("Printing the queue...");
        System.out.println(ALqueue);
        System.out.println("The first element is: " + ALqueue.first());
        System.out.println("The queue contains: " + ALqueue.size() + " elements");
        System.out.println("The queue is empty: " + ALqueue.isEmpty());
        System.out.println();
        
        
    }
}
