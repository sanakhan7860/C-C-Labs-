import java.util.ArrayList;

/**
 * COMP 2231 Assignment 3: Lists & Iterators
 * 
 * This ArrayListStack class is a data structure which adds and removes elements from the stack using LIFO (last in first out) 
 *
 * This implements the StackADT interface 
 * 
 * @author (Sana Khan-t00718201)
 * @version (Oct 3, 2022)
 */
public class ArrayListStack<T> implements StackADT<T> {
    // stack container
    private ArrayList<T> ArrStack;

    /**
     * This is a constructor which creates an empty stack.
     */
    public ArrayListStack() {
        ArrStack = new ArrayList<T>();
    }

    /**
     * Adds the given element to the top of the stack.
     * 
     * @param element element to be pushed onto the stack
     */
    public void push(T element) {
        ArrStack.add(0, element);
    }

    /**
     * Removes and returns the top element from this stack.
     * 
     * @return the element removed from the stack
     */
    public T pop() {
        // stores element in temporary variable to return
        T element = ArrStack.remove(0);

        return element;
    }

    /**
     * Returns the top element of the stack without removing it
     * Returns null if the stack is empty.
     * 
     * @return the element on top of the stack
     */
    public T peek() {
        if (isEmpty()){
            return null;
        }
        else{
            return ArrStack.get(0);
        }
    }

    /**
     * Returns true if this stack contains no elements.
     * 
     * @return true if the stack is empty
     */
    public boolean isEmpty() {
        return ArrStack.isEmpty();
    }

    /**
     * Returns the number of elements in this stack.
     * 
     * @return the integer representation of the size of the stack
     */
    public int size() {
        return ArrStack.size();
    }

    /**
     * Returns a string representation of this stack.
     * 
     * @return a string representation of the stack
     */
    public String toString() {
        //create a new string which will hold the elements of the stack 
        String result = "";

        // loops through the elements in the stack, adding each one to result
        for (T element : ArrStack){
            result += element + "\n";
        }

        return result;
    }
    
    //These are the test cases for the ArrayListStack class
    public static void main(String[] args) {
        
        // create a new stack
        System.out.println("Creating a new ArrayListStack...");
        ArrayListStack<String> ALstack = new ArrayListStack<String>();

        // push three items onto the stack
        System.out.println("Pushing three items onto the stack...");
        ALstack.push("Sept");
        ALstack.push("Oct");
        ALstack.push("Nov");

        // print the stack and test stack methods
        System.out.println("Printing the stack...");
        System.out.println(ALstack);
        System.out.println("The top element is: " + ALstack.peek());
        System.out.println("The stack contains: " + ALstack.size() + " elements");
        System.out.println("The stack is empty: " + ALstack.isEmpty());
        System.out.println();

        // push two more items onto the stack
        System.out.println("Pushing three more items onto the stack...");
        ALstack.push("Dec");
        ALstack.push("Jan");
        ALstack.push("Feb");

        // print the stack and test stack methods
        System.out.println("Printing the stack...");
        System.out.println(ALstack);
        System.out.println("The top element is: " + ALstack.peek());
        System.out.println("The stack contains: " + ALstack.size() + " elements");
        System.out.println("The stack is empty: " + ALstack.isEmpty());
        System.out.println();

        // pop top two items from the stack
        System.out.println("Popping the top two items from the stack...");
        ALstack.pop();
        ALstack.pop();

        // print the stack and test stack methods
        System.out.println("Printing the stack...");
        System.out.println(ALstack);
        System.out.println("The top element is: " + ALstack.peek());
        System.out.println("The stack contains: " + ALstack.size() + " elements");
        System.out.println("The stack is empty: " + ALstack.isEmpty());
        System.out.println();

        // pop remaining items from the stack
        System.out.println("Popping the remaining items from the stack...");
        ALstack.pop();
        ALstack.pop();
        ALstack.pop();
        ALstack.pop();

        // print the stack and test stack methods
        System.out.println("Printing the stack...");
        System.out.println(ALstack);
        System.out.println("The top element is: " + ALstack.peek());
        System.out.println("The stack contains: " + ALstack.size() + " elements");
        System.out.println("The stack is empty: " + ALstack.isEmpty());
        System.out.println();
        
    }
}
