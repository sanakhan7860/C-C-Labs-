import java.util.LinkedList;

/**
 * COMP 2231 Assignment 3: Lists & Iterators
 * 
 * This LinkedListStack class is a data structure which adds and removes elements from the stack using LIFO (last in first out)
 * 
 * This implements the StackADT interface 
 *
 * @author (Sana Khan-t00718201)
 * @version (Sep 29, 2022)
 */

public class LinkedListStack<T> implements StackADT<T> {
   
    // stack container
    private LinkedList<T> LLstack;

    /**
     * This is a constructor which creates an empty stack.
     */
    public LinkedListStack() {
        LLstack = new LinkedList<T>();
    }

    /**
     * Adds the given element to the top of this stack.
     * 
     * @param element element to be pushed onto the stack
     */
    public void push(T element) {
        LLstack.push(element);
    }

    /**
     * Removes and returns the top element from the stack.
     * 
     * @return the element removed from the stack
     */
    public T pop() {
        // stores element in temporary variable to return
        T element = LLstack.pop();

        return element;
    }

    /**
     * Returns the top element of the stack without removing it
     * Returns null if the stack is empty 
     * 
     * @return the current element on the top of the stack
     */
    public T peek() {
        return LLstack.peek();
    }

    /**
     * Returns true if this stack contains no elements and returns false if there are elements 
     * 
     * @return true if the stack is empty
     */
    public boolean isEmpty() {
        return LLstack.isEmpty();
    }

    /**
     * Returns the number of elements in the stack.
     * 
     * @return the integer representation of the size of the stack
     */
    public int size() {
        return LLstack.size();
    }

    /**
     * Returns a string representation of the stack.
     * 
     * @return a string representation of the stack
     */
    public String toString() {
        //create a new string which will hold the elements of the stack 
        String result = "";

        // loops through the elements in the stack, adding each one to the result
        for (T element : LLstack){
            result += element + "\n";
        }
        return result;
    }
    
    //These are the test cases for the LinkedListStack class 
    public static void main(String[] args) {
        
        // create a new stack
        System.out.println("Creating a new LinkedListStack...");
        LinkedListStack<String> LLstack = new LinkedListStack<String>();

        // push three items onto the stack
        System.out.println("Pushing three items onto the stack...");
        LLstack.push("Sept");
        LLstack.push("Oct");
        LLstack.push("Nov");

        // print the stack and test stack methods
        System.out.println("Printing the stack...");
        System.out.println(LLstack);
        System.out.println("The top element is: " + LLstack.peek());
        System.out.println("The stack contains: " + LLstack.size() + " elements");
        System.out.println("The stack is empty: " + LLstack.isEmpty());
        System.out.println();

        // push two more items onto the stack
        System.out.println("Pushing three more items onto the stack...");
        LLstack.push("Dec");
        LLstack.push("Jan");
        LLstack.push("Feb");

        // print the stack and test stack methods
        System.out.println("Printing the stack...");
        System.out.println(LLstack);
        System.out.println("The top element is: " + LLstack.peek());
        System.out.println("The stack contains: " + LLstack.size() + " elements");
        System.out.println("The stack is empty: " + LLstack.isEmpty());
        System.out.println();

        // pop top two items from the stack
        System.out.println("Popping the top two items from the stack...");
        LLstack.pop();
        LLstack.pop();

        // print the stack and test stack methods
        System.out.println("Printing the stack...");
        System.out.println(LLstack);
        System.out.println("The top element is: " + LLstack.peek());
        System.out.println("The stack contains: " + LLstack.size() + " elements");
        System.out.println("The stack is empty: " + LLstack.isEmpty());
        System.out.println();

        // pop remaining items from the stack
        System.out.println("Popping the remaining items from the stack...");
        LLstack.pop();
        LLstack.pop();
        LLstack.pop();
        LLstack.pop();

        // print the stack and test stack methods
        System.out.println("Printing the stack...");
        System.out.println(LLstack);
        System.out.println("The top element is: " + LLstack.peek());
        System.out.println("The stack contains: " + LLstack.size() + " elements");
        System.out.println("The stack is empty: " + LLstack.isEmpty());
        System.out.println();
       
        
    
      
   }
}
