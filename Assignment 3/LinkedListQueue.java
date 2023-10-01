import java.util.LinkedList;

/**
 * COMP 2231 Assignment 3: Lists & Iterators
 * 
 * This LinkedListQueue class is a data structure which adds and removes elements from the queue using FIFO (first in last out)
 * 
 * This implements the QueueADT interface 
 *
 * @author (Sana Khan-t00718201)
 * @version (Oct 9, 2022)
 */
public class LinkedListQueue<T> implements QueueADT<T>
{
    //queue container
    private LinkedList<T> LLqueue;

    /**
     * This is a constructor which creates an empty queue.
     */
    public LinkedListQueue() {
        LLqueue = new LinkedList<T>();
    }

    /**
     * Adds one element to the end of this queue.
     * 
     * @param element the element to be added to the end of the queue
     */
    public void enqueue(T element) {
        LLqueue.add(element);
    }

    /**
     * Removes and returns the element at the front of this queue.
     * 
     * @return the element at the front of the queue
     */
    public T dequeue() {
        // stores element in temporary variable to be able to return the value 
        T element = LLqueue.remove();

        return element;
    }
    
    /**
    * Returns without removing the element at the front of this queue. Returns null
     * if empty.
     * 
     * @return the first element in the queue
     */
    public T first() {
        // uses peekFirst method from LinkedList as this performs the desired operation
        return LLqueue.peekFirst();
    }

    /**
     * Returns true if this queue contains no elements.
     * 
     * @return true if this queue is empty
     */
    public boolean isEmpty() {
        return LLqueue.isEmpty();
    }

    /**
     * Returns the number of elements in this queue.
     * 
     * @return the integer representation of the size of the queue
     */
    public int size() {
        return LLqueue.size();
    }

    /**
     * Returns a string representation of this queue.
     * 
     * @return the string representation of the queue
     */
    public String toString() {
        // create a new string which will hold the elements of the queue
        String result = "";

        // loops through the elements in the queue, adding each one to result
        for (T element : LLqueue){
            result += element + "\n";
        }

        return result;
    }
    
    //These are the test cases for the LinkedListQueue class
    public static void main(String[] args) {
        // create a new queue
        System.out.println("Creating a new LinkedListQueue...");
        LinkedListQueue<String> LLqueue = new LinkedListQueue<String>();

        // enqueue three items onto the queue
        System.out.println("Enqueue three items onto the queue...");
        LLqueue.enqueue("Sept");
        LLqueue.enqueue("Oct");
        LLqueue.enqueue("Nov");

        // print the queue and test queue methods
        System.out.println("Printing the queue...");
        System.out.println(LLqueue);
        System.out.println("The first element is: " + LLqueue.first());
        System.out.println("The queue contains: " + LLqueue.size() + " elements");
        System.out.println("The queue is empty: " + LLqueue.isEmpty());
        System.out.println();

        // enqueue two more items onto the queue
        System.out.println("Enqueue three more items onto the queue...");
        LLqueue.enqueue("Dec");
        LLqueue.enqueue("Jan");
        LLqueue.enqueue("Feb");

        // print the queue and test queue methods
        System.out.println("Printing the queue...");
        System.out.println(LLqueue);
        System.out.println("The first element is: " + LLqueue.first());
        System.out.println("The queue contains: " + LLqueue.size() + " elements");
        System.out.println("The queue is empty: " + LLqueue.isEmpty());
        System.out.println();

        // Dequeue first two items from the queue
        System.out.println("Dequeue the first two items from the queue...");
        LLqueue.dequeue();
        LLqueue.dequeue();

        // print the queue and test queue methods
        System.out.println("Printing the queue...");
        System.out.println(LLqueue);
        System.out.println("The first element is: " + LLqueue.first());
        System.out.println("The queue contains: " + LLqueue.size() + " elements");
        System.out.println("The queue is empty: " + LLqueue.isEmpty());
        System.out.println();

        // Dequeue remaining items from the queue
        System.out.println("Dequeue the remaining items from the queue...");
        LLqueue.dequeue();
        LLqueue.dequeue();
        LLqueue.dequeue();
        LLqueue.dequeue();

        // print the queue and test queue methods
        System.out.println("Printing the queue...");
        System.out.println(LLqueue);
        System.out.println("The first element is: " + LLqueue.first());
        System.out.println("The queue contains: " + LLqueue.size() + " elements");
        System.out.println("The queue is empty: " + LLqueue.isEmpty());
        System.out.println();
        
        
    }
}

