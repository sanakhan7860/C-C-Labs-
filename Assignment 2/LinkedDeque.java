/**
 * LinkedDeque.Java
 * COMP 2231 Assignment 2: Stacks and Queues 
 *
 * Implementation of a deque which implments the DequeADT interface.  
 * This is similar to a normal queue however, we can add, remove, and view elements from the front and end of the deque
 *
 * @author (Sana Khan-t00718201)
 * @version (Sep 24,2022)
 */

public class LinkedDeque<T> implements DequeADT<T>
{
    private int count;                      // keeps a tally of the number of nodes on the deque
    private LinearNode<T> head, tail;       // points to the head and tail nodes of the deque

    /**
     * Constructor: Creates an empty deque
     */
    public LinkedDeque()
    {
        // initialize number of elements to zero, and head/tail elements to null
        count = 0;
        head = null;
        tail = null;
    }

    /**
     * Adds one element to the front of this deque
     * @param   element the element to be added to the front of the deque
     */
    public void enqueueFirst (T element)
    {
        //create a new node 
        LinearNode<T> node = new LinearNode<T>(element);

        // if deque is empty, assign new node as tail node
        if (isEmpty()){
            tail = node;
        }
        else
        {
            node.setNext(head); //link new node to the current head node 
            head.setPrevious(node); //link current head node to new node 
        }

        // assign new node to the head node and increment count
        head = node;
        count++;
    }

    /**
     * Adds one element to the rear of this deque
     * @param   element the element to be added to the rear of the deque
     */
    public void enqueueLast (T element)
    {
        //create a new node 
        LinearNode<T> node = new LinearNode<T>(element);

        // if deque is empty, assign new node as head node
        if (isEmpty()){
            head = node;
        }
        else
        {
            node.setPrevious(tail); //link new node to the current tail node 
            tail.setNext(node); //link current tail node to new node 
        }

        // assign new node to the tail node and increment count to increase the number of elements in the queue 
        tail = node;
        count++;
    }

    /**
     * Removes and returns the element at the front of the deque
     * @return  the element at the front of the deque
     * @throws  EmptyCollectionException if the deque is empty
     */
    public T dequeueFirst() throws EmptyCollectionException
    {
        // throw exception if deque is empty
        if (isEmpty()){
            throw new EmptyCollectionException("deque");
        }

        // store element from current head node in temporary variable for that element to be returned 
        T result = head.getElement();

        // reassign head node to the next node to update the head value to the next element, therefore removing the old value
        // decrement count to reduce the number of elements in the queue
        head = head.getNext();
        count--;

        // if deque is now empty update tail reference to null
        if (isEmpty()){
            tail = null;
        }
        else{
            // otherwise set the old head to null
            head.setPrevious(null);
        }

        return result;
    }

    /**
     * Removes and returns the element at the rear of the deque
     * @return  the element at the rear of the deque
     * @throws  EmptyCollectionException if the deque is empty
     */
    public T dequeueLast() throws EmptyCollectionException
    {
        // throw exception if deque is empty
        if (isEmpty()){
            throw new EmptyCollectionException("deque");
        }

        // store element from current tail node in temporary variable for that element to be returned 
        T result = tail.getElement();

        // reassign tail node to previous node which removes the previous tail and decrements the count to reduce the number of 
        //elements in the queue
        tail = tail.getPrevious();
        count--;

        // if deque is now empty update head reference to null
        if (isEmpty()){
            head = null;
        }
        else{
            // otherwise set the old tail to null
            tail.setNext(null);
        }

        return result;
    }

    /**
     * Returns the element at the front of the deque without removing it
     * @return  the element at the front of the deque
     * @throws  EmptyCollectionException if the deque is empty
     */
    public T getFirst() throws EmptyCollectionException
    {
        // throw exception if deque is empty
        if (isEmpty()){
            throw new EmptyCollectionException("deque");
        }

        return head.getElement();
    }

    /**
     * Returns the element at the end of the deque without removing it
     * @return  the element at the end of the deque
     * @throws  EmptyCollectionException if the deque is empty
     */
    public T getLast() throws EmptyCollectionException
    {
        // throw exception if deque is empty
        if (isEmpty()){
            throw new EmptyCollectionException("deque");
        }

        return tail.getElement();
    }

    /**
     * Determines if the deque is empty (i.e. contains no elements)
     * @return  true if the deque is empty, false otherwise
     */
    public boolean isEmpty()
    {
        if(count != 0){
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * Determines the size of the deque (i.e. number of elements it contains)
     * @return  the size of the deque
     */
    public int size()
    {
        return count;
    }

    /**
     * Returns a string representation of the deque
     * @return  a string representation of the deque
     */
    public String toString()
    {
        //create an empty string which will hold the contents of the deque
        String result = "";
        //create a temp node variable which will store the head (or first value) in the deque
        LinearNode<T> current = head;

        // traverses deque adding String of each node to result
        while (current != null)
        {
            result = result + current.getElement() + "\n";
            current = current.getNext(); //move to the next node 
        }

        return result;
    }
    
    public static void main (String [] args)
    {
        // create deque for test
        System.out.println("Creating a string deque...\n");
        LinkedDeque<String> deque = new LinkedDeque<String>();
        LinkedDeque<Integer> number = new LinkedDeque<Integer>();
        
        System.out.println("---------------Test 1: Adding String Elements to the Deque---------------");
        
        // adding elements to the deque
        System.out.println("Adding elements to the empty deque...");
        deque.enqueueFirst("Fall");
        deque.enqueueFirst("Pumpkins"); 
        deque.enqueueFirst("Sweaters");
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(deque);
        System.out.println("The front element is: " + deque.getFirst());
        System.out.println("The last element is: " + deque.getLast());
        System.out.println("The deque contains: " + deque.size() + " elements");
        System.out.println("The deque is empty: " + deque.isEmpty() + "\n");    
        
        System.out.println("Adding an element to the front of the deque...");
        deque.enqueueFirst("Pies");
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(deque);
        System.out.println("The front element is: " + deque.getFirst());
        System.out.println("The last element is: " + deque.getLast());
        System.out.println("The deque contains: " + deque.size() + " elements");
        System.out.println("The deque is empty: " + deque.isEmpty() + "\n");  
        
        System.out.println("Adding an element to the front of the deque...");
        deque.enqueueFirst("Rainy");
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(deque);
        System.out.println("The front element is: " + deque.getFirst());
        System.out.println("The last element is: " + deque.getLast());
        System.out.println("The deque contains: " + deque.size() + " elements");
        System.out.println("The deque is empty: " + deque.isEmpty() + "\n"); 
    
        
        System.out.println("Adding an element to the end of the deque...");
        deque.enqueueLast("Orange");
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(deque);
        System.out.println("The front element is: " + deque.getFirst());
        System.out.println("The last element is: " + deque.getLast());
        System.out.println("The deque contains: " + deque.size() + " elements");
        System.out.println("The deque is empty: " + deque.isEmpty() + "\n");
        

        System.out.println("Adding an element to the end of the deque...");
        deque.enqueueLast("Halloween");
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(deque);
        System.out.println("The front element is: " + deque.getFirst());
        System.out.println("The last element is: " + deque.getLast());
        System.out.println("The deque contains: " + deque.size() + " elements");
        System.out.println("The deque is empty: " + deque.isEmpty() + "\n");
        
        
        System.out.println("---------------Test 2: Removing String Elements from the Deque---------------");
        
        System.out.println("Printing the deque...");
        System.out.println(deque);
        
        // remove an element from the end of the deque
        System.out.println("Removing an element from the end of the deque...");
        deque.dequeueLast(); 
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(deque);
        System.out.println("The front element is: " + deque.getFirst());
        System.out.println("The last element is: " + deque.getLast());
        System.out.println("The deque contains: " + deque.size() + " elements");
        System.out.println("The deque is empty: " + deque.isEmpty() + "\n");
        
        // remove an element from the end of the deque
        System.out.println("Removing an element from the end of the deque...");
        deque.dequeueLast(); 
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(deque);
        System.out.println("The front element is: " + deque.getFirst());
        System.out.println("The last element is: " + deque.getLast());
        System.out.println("The deque contains: " + deque.size() + " elements");
        System.out.println("The deque is empty: " + deque.isEmpty() + "\n");
        
        
        // removing an element from the front of the deque
        System.out.println("Removing an element from the front of the deque...");
        deque.dequeueFirst();  
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(deque);
        System.out.println("The front element is: " + deque.getFirst());
        System.out.println("The last element is: " + deque.getLast());
        System.out.println("The deque contains: " + deque.size() + " elements");
        System.out.println("The deque is empty: " + deque.isEmpty() + "\n");
        
        // removing an element from the front of the deque
        System.out.println("Removing a few elements from the front of the deque...");
        deque.dequeueFirst(); 
        deque.dequeueFirst();
        deque.dequeueFirst();
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(deque);
        System.out.println("The front element is: " + deque.getFirst());
        System.out.println("The last element is: " + deque.getLast());
        System.out.println("The deque contains: " + deque.size() + " elements");
        System.out.println("The deque is empty: " + deque.isEmpty() + "\n");
        
        //removing the last element of the dequeue to test the isEmpty function 
        //here we can call dequeueLast or dequeueFirst since there is only one element in the dequeue, it doesn't change the result
        System.out.println("Removing the last element of the deque...");
        deque.dequeueLast();
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(deque);
        System.out.println("The deque contains: " + deque.size() + " elements");
        System.out.println("The deque is empty: " + deque.isEmpty() + "\n");
        
        
        System.out.println("---------------Test 3: Adding Integer Elements to the Deque---------------");
        System.out.println("Creating an integer deque...\n");
        
        // adding elements to the deque
        System.out.println("Adding elements to the empty deque...");
        number.enqueueFirst(10);
        number.enqueueFirst(15); 
        number.enqueueFirst(20);
        number.enqueueFirst(55);
        number.enqueueFirst(60);
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(number);
        System.out.println("The front element is: " + number.getFirst());
        System.out.println("The last element is: " + number.getLast());
        System.out.println("The deque contains: " + number.size() + " elements");
        System.out.println("The deque is empty: " + number.isEmpty() + "\n");
        
        System.out.println("Adding an element to the front of the deque");
        number.enqueueFirst(65);
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(number);
        System.out.println("The front element is: " + number.getFirst());
        System.out.println("The last element is: " + number.getLast());
        System.out.println("The deque contains: " + number.size() + " elements");
        System.out.println("The deque is empty: " + number.isEmpty() + "\n");
        
        // adding elements to the end of the deque
        System.out.println("Adding an element to the end of the deque...");
        number.enqueueLast(30);
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(number);
        System.out.println("The front element is: " + number.getFirst());
        System.out.println("The last element is: " + number.getLast());
        System.out.println("The deque contains: " + number.size() + " elements");
        System.out.println("The deque is empty: " + number.isEmpty() + "\n");
        
        System.out.println("---------------Test Part 4: Removing Integer Elements from the Deque---------------");
        
        System.out.println("Printing the deque...");
        System.out.println(number);
        
        // removing an element from the end of the deque
        System.out.println("Removing an element from the end of the deque...");
        number.dequeueLast(); 
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(number);
        System.out.println("The front element is: " + number.getFirst());
        System.out.println("The last element is: " + number.getLast());
        System.out.println("The deque contains: " + number.size() + " elements");
        System.out.println("The deque is empty: " + number.isEmpty() + "\n");
        
        // removing an element from the front of the deque
        System.out.println("Removing an element from the front of the deque...");
        number.dequeueFirst(); 
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(number);
        System.out.println("The front element is: " + number.getFirst());
        System.out.println("The last element is: " + number.getLast());
        System.out.println("The deque contains: " + number.size() + " elements");
        System.out.println("The deque is empty: " + number.isEmpty() + "\n");
        
        // removing a few elements from the front of the deque
        System.out.println("Removing an element from the front of the deque...");
        number.dequeueFirst();
        number.dequeueFirst(); 
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(number);
        System.out.println("The front element is: " + number.getFirst());
        System.out.println("The last element is: " + number.getLast());
        System.out.println("The deque contains: " + number.size() + " elements");
        System.out.println("The deque is empty: " + number.isEmpty() + "\n");
        
        // removing a few elements from the end of the deque
        System.out.println("Removing an element from the end of the deque...");
        number.dequeueLast(); 
        number.dequeueLast();
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(number);
        System.out.println("The front element is: " + number.getFirst());
        System.out.println("The last element is: " + number.getLast());
        System.out.println("The deque contains: " + number.size() + " elements");
        System.out.println("The deque is empty: " + number.isEmpty() + "\n");
        
        // removing the last element of the dequeue to test the isEmpty function 
        // here we can call dequeueLast or dequeueFirst since there is only one element in the dequeue, it doesn't change the result
        System.out.println("Removing the last element of the deque...");
        number.dequeueLast();
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(number);
        System.out.println("The deque contains: " + number.size() + " elements");
        System.out.println("The deque is empty: " + number.isEmpty() + "\n");
        
        
    }
}
