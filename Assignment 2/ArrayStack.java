import java.util.Arrays;

/**
 * ArrayStack.Java
 * COMP 2231 Assignment 2: Stacks and Queues
 * 
 * Array based implementation of a stack which also implements the StackADT interface 
 * This implementation has been updated so that the top of
 * the stack is the actual top element, rather than the next available position in the stack.
 * 
 * @author (Sana Khan-t00718201)
 * @version (Sep 15, 2022)
 */

public class ArrayStack<T> implements StackADT<T> 
{
    // default stack capacity is set to 100
    private final static int DEFAULT_CAPACITY = 100;

    private int top; // keeps track of the top element location
    private T[] stack; // array used as the data structure for the stack

    /**
     * This constructor creates an empty stack using the default capacity.
     */
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * This constructor creates an empty stack of the user specified quantity.
     * 
     * @param initialCapacity the initial size of the stack specified by the user 
     */
    public ArrayStack(int initialCapacity) {
        // initialize top to -1 since there are no items on the stack yet
        top = -1;

        // create an empty stack
        stack = (T[]) (new Object[initialCapacity]);
    }

    /**
     * Adds the specified element to the top of the stack 
     * It also expands the capacity of the array by twice its actual size if needed 
     * 
     * @param element an element to be pushed onto the stack
     */
    public void push(T element) {
        // expands stack capacity if stack is full
        if (size() == stack.length){
            expandCapacity();
        }

        // increments top counter and pushes element onto stack
        top++;
        stack[top] = element;
    }

    /**
     * Creates a new array to store the contents of the stack with twice the capacity of the old one.
     */
    private void expandCapacity() {
        // creates a copy of the stack with double the capcity
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    /**
     * Removes the element at the top of the stack and returns the value that has been removed.
     * 
     * @return element removed from top of stack
     * @throws EmptyCollectionException if stack is empty
     */
    public T pop() throws EmptyCollectionException {
        // throws an exception if the stack is empty
        if (isEmpty()){
            throw new EmptyCollectionException("stack");
        }
        
        // stores the top element value of the stack in a temporary variable and updates the top to null
        T result = stack[top];
        stack[top] = null;

        // decrements top counter since the number of elements in the stack has decreased 
        top--;

        //return the value that has been removed 
        return result;
    }

    /**
     * Returns a reference to the element at the top of the stack. 
     * This element is only looked at and not removed from the stack.
     * 
     * @return element on top of stack
     * @throws EmptyCollectionException if stack is empty
     */
    public T peek() throws EmptyCollectionException {
        // throws an exception if the stack is empty
        if (isEmpty()){
            throw new EmptyCollectionException("stack");
        }

        return stack[top];
    }

    /**
     * Returns true if this stack is empty and false otherwise. 
     * The stack is considered empty if the top reference variable is equal to -1.
     * 
     * @return true if this stack is empty
     */
    public boolean isEmpty() {
        if(top != -1){
            return false; 
        }
        else{
            return true; 
        }
    }

    /**
     * Returns the number of elements in the stack.
     * If the stack is empty a value of 0 is returned 
     * 
     * @return the number of elements in the stack
     */
    public int size() {
        if (isEmpty()){
            return 0; // stack is empty
        }
        else{
            return (top + 1); // add 1 to top due to zero based array indexing
        }
    }

    /**
     * Returns a string representation of the stack. 
     * If the stack is empty a return statement is displayed stating the fact 
     * 
     * @return a string representation of the stack
     */
    public String toString() {
        //create an empty string to store the stack in
        String result = "";

        if (isEmpty())
            result += "Stack is empty, no elements to print\n"; 
        else {
            //loops through the stack, adding each element to the result string 
            for (int i = 0; i <= top; i++){
                result += stack[i] + "\n";
            }
        }

        return result;
    }
    
    public static void main(String[] args) {
        // create stack to hold Integer values
        ArrayStack<Integer> integerStack = new ArrayStack<Integer>();

        // create stack to hold String values
        ArrayStack<String> stringStack = new ArrayStack<String>();

        // first test exhibit: Integer stack
        System.out.println("-----------------Test case 1: Integer Stack-----------------");
        System.out.println("Pushing some Integers onto the stack...");
        System.out.println();

        // push 5 Integers onto the Integer stack
        integerStack.push(-45);
        integerStack.push(-9);
        integerStack.push(0);
        integerStack.push(31);
        integerStack.push(2500);

        // print the Integer stack
        System.out.println("Printing the stack...");
        System.out.println(integerStack);

        // test out updated methods and print the results
        System.out.println("Testing stack methods and printing results...");
        System.out.println("The stack currently contains: " + integerStack.size() + " elements.");
        System.out.println("The top of the stack contains: " + integerStack.peek());
        System.out.println("The stack is empty: " + integerStack.isEmpty());
        System.out.println();

        // pop 2 elements from the Integer stack
        System.out.println("Popping a few elements from the stack...");
        System.out.println();
        integerStack.pop();
        integerStack.pop();

        // reprint the Integer stack
        System.out.println("Reprinting the stack...");
        System.out.println(integerStack);

        // test out updated methods and print the results
        System.out.println("The stack currently contains: " + integerStack.size() + " elements.");
        System.out.println("The top of the stack contains: " + integerStack.peek());
        System.out.println("The stack is empty: " + integerStack.isEmpty());
        System.out.println();

        // pop all remaining elements from the integer Stack
        System.out.println("Popping the remaining elements from the stack...");
        System.out.println();
        integerStack.pop();
        integerStack.pop();
        integerStack.pop();

        // reprint the Integer stack
        System.out.println("Reprinting the stack...");
        System.out.println(integerStack);

        // test out updated methods and print the results
        System.out.println("The stack currently contains: " + integerStack.size() + " elements.");
        System.out.println("The stack is empty: " + integerStack.isEmpty());
        System.out.println();

        // second test exhibit: String stack
        System.out.println("-----------------Test case 2: String Stack-----------------");

        System.out.println("Pushing some Strings onto the stack...");
        System.out.println();

        // push 6 Strings onto the String stack
        stringStack.push("Sept");
        stringStack.push("Oct");
        stringStack.push("Nov");
        stringStack.push("Dec");
        stringStack.push("Jan");
        stringStack.push("Feb");

        // print the String stack
        System.out.println("Printing the stack...");
        System.out.println(stringStack);

        // test out updated methods and print the results
        System.out.println("Testing some stack methods and printing the results...");
        System.out.println("The stack currently contains: " + stringStack.size() + " elements.");
        System.out.println("The top of the stack contains: " + stringStack.peek());
        System.out.println("The stack is empty: " + stringStack.isEmpty());
        System.out.println();

        // pop 3 elements from the String stack
        System.out.println("Popping some elements from the stack...");
        System.out.println();
        stringStack.pop();
        stringStack.pop();
        stringStack.pop();

        // print the String stack
        System.out.println("Reprinting the stack...");
        System.out.println(stringStack);

        // test out updated methods and print the results
        System.out.println("The stack currently contains: " + stringStack.size() + " elements.");
        System.out.println("The top of the stack contains: " + stringStack.peek());
        System.out.println("The stack is empty: " + stringStack.isEmpty());
        System.out.println();

        // pop all remaining elements from the String Stack
        System.out.println("Popping the remaining elements from the stack...");
        System.out.println();
        stringStack.pop();
        stringStack.pop();
        stringStack.pop();

        // print the String stack
        System.out.println("Reprinting the stack...");
        System.out.println(stringStack);

        // test out updated methods and print the results
        System.out.println("The stack currently contains: " + stringStack.size() + " elements.");
        System.out.println("The stack is empty: " + stringStack.isEmpty());
        System.out.println();
    }
}
