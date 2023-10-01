/**
 * DropoutStack.Java
 * COMP 2231 Assignment 2: Stacks and Queues 
 * 
 * Implementation of a drop-out stack. This is similar to a normal stack however the only difference is that
 * the stack size is limited to "n" elements.  When the "n + 1" element is pushed onto the
 * top of the drop-out stack, the bottom element is lost (removed).  
 * The user can specify the size or number of elements "n" that the drop-out stack can hold.
 * 
 *
 * @author (Sana Khan-t00718201)
 * @version (Sep 18, 2022)
 */

public class DropoutStack<T> implements StackADT<T>
{
    private int count;              // keeps track of the number of nodes on the stack
    private int maxSize;            // holds the max number of elements "n" for the stack
    private LinearNode<T> top;      // points to the top node of the stack

    /**
     * This constructor creates an empty dropout-stack, allowing the user to choose a desired capacity 
     * @param maxSize the max number of elements the drop-out stack can hold
     */
    public DropoutStack(int max)
    {
        //initialize all the variables 
        maxSize = max;
        count = 0;
        top = null;
    }

    /**
     * Adds the specified element to the top of this stack. If the drop-out
     * stack is at capcity, the bottom element is "dropped" (lost/removed).
     * @param element element to be pushed onto the stack
     */
    public void push(T element)
    {   
        // checks if the current number of elements on the stack is equal to the max number of elements allowed in the stack 
        if (count == maxSize)
        {
            // temporary node which holds the top value of the stack 
            LinearNode current = top;
            
            // loop through the stack until the second last element
            for (int i = 1; i < maxSize - 1; i++){
                current = current.getNext();
            }
            
            // set last (bottom) element of the stack to null
            current.setNext(null);
            
            // decrement count as an element is dropped
            count--;
        }
        
        // pushes the passed element to the top of the stack 
        LinearNode<T> temp = new LinearNode<T>(element); //temporary node stores the element value to be added to the stack 
        temp.setNext(top); 
        top = temp; //this element is set as the top of the stack 
        count++; //increment counter as the number of elements in the stack increases 
    }

    /**
     * Removes the element at the top of this stack and returns the value that has been removed 
     * 
     * @return element from top of stack
     * @throws EmptyCollectionException if the stack is empty
     */
    public T pop() throws EmptyCollectionException
    {
        // throws exception for an empty stack
        if (isEmpty()){
            throw new EmptyCollectionException("stack");
        }
        
        // pops and returns the top element 
        T result = top.getElement();
        top = top.getNext();
        
        //decrements counter since the number of elements in the stack has decreased 
        count--;
        
        return result;
    }
    
    /**
     * Returns a reference to the element at the top of the stack.
     * The element is not removed from the stack.
     * @return element on top of stack
     * @throws EmptyCollectionException if the stack is empty
     */
    public T peek() throws EmptyCollectionException
    {
        // throws exception if empty, otherwise returns the top element in the stack
        if (isEmpty()){
            throw new EmptyCollectionException("stack");
        }

        return top.getElement();
    }

    /**
     * Returns true if this stack is empty and false otherwise. A
     * The stack is considered empty if the number of elements in the stack is zero.
     * @return true if stack is empty
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
     * Returns true if the number of elements in the dropout stack
     * is equal to the max elements it can hold.  E.g. for a dropout
     * stack that can hold 5 elements, returns true if the stack 
     * contains 5 elements.
     * @return true if dropout stack contains max number of elements
     */
    public boolean isFull()
    {
        if(count == maxSize){
            return true;
        }
        else{
            return false;
        }
    }    
    
    /**
     * Returns the number of elements in this stack.
     * @return number of elements in the stack
     */
    public int size()
    {
        return count;
    }

    /**
     * Returns the max number of elements in this dropout stack.
     * @return max number of elements in the stack
     */
    public int getMaxSize()
    {
        return maxSize;
    }
    
    /**
     * Allows the user to choose the max number of elements for a dropout stack.
     */
    public void setMaxSize(int max)
    {
        maxSize = max;
    }
    
    /**
     * Returns a string representation of this dropout stack.
     * @return string representation of the dropout stack
     */
    public String toString()
    {
        //create an empty string which will hold the contents of the stack 
        String result = "";
        
        //the top value of the stack is stored in the temporary variable current 
        LinearNode current = top;
        
        // loops through the drop-out stack, adding the String of each node to result
        while (current != null)
        {
            result = result + current.getElement() + "\n";
            current = current.getNext(); //move to the next node 
        }

        return result;
    }
    
    public static void main (String [] args)
    {   
        // create a drop-out stack that can hold five String objects
        System.out.println("Creating a drop-out stack that can hold 5 names...");
        DropoutStack<String> names = new DropoutStack<String>(5);
        
        // create a drop-out stack which can hold 4 integer objects 
        DropoutStack<Integer> numbers = new DropoutStack<Integer>(4);
        
        //______________________________________TESTING WITH STRING OBJECTS________________________________________________
        System.out.println("_________________TESTING WIITH STRING OBJECTS___________________"); 
        
        // add five Strings to drop-out stack
        System.out.println("Pushing five names onto the stack...");
        System.out.println();
        names.push("Sana");
        names.push("Rory");
        names.push("Lorelai");
        names.push("Luke");
        names.push("Sookie");
        
        // print the contents of the drop-out stack
        System.out.println("Testing the toString, peek, and size methods...");
        System.out.println("Contents of the stack: ");
        System.out.println(names);
        
        // print the output of the peek() and size() methods
        System.out.println("Top element: " + names.peek());
        System.out.println("Number of elements: " + names.size());
        System.out.println("Is the stack full? " + names.isFull());
        System.out.println();
               
        // push a new String to the drop-out stack
        System.out.println("Adding a new name to the drop-out stack...");
        names.push("Morey");
               
        // reprint the contents and results of the peek() and size() methods
        System.out.println("Testing the toString, peek, and size methods...");
        System.out.println("Contents of the stack: ");
        System.out.println(names);
        System.out.println("Top element: " + names.peek());
        System.out.println("Number of elements: " + names.size());
        System.out.println("Is the stack full? " + names.isFull());
        System.out.println();
        
        // push a new String to the drop-out stack
        System.out.println("Adding a new name to the drop-out stack...");
        names.push("Richard");
        
        // reprint the contents and results of the peek() and size() methods        
        System.out.println("Testing the toString, peek, and size methods...");
        System.out.println("Contents of the stack: ");
        System.out.println(names);
        System.out.println("Top element: " + names.peek());
        System.out.println("Number of elements: " + names.size());
        System.out.println("Is the stack full? " + names.isFull());
        System.out.println();
        
        // pop the top two elements of the drop-out stack
        System.out.println("Popping the top two elements from the drop-out stack...");
        System.out.println();
        names.pop();
        names.pop();
        
        // reprint the contents and results of the peek() and size() methods
        System.out.println("Testing the toString, peek, and size methods...");
        System.out.println("Contents of the stack: ");
        System.out.println(names);
        System.out.println("Top element: " + names.peek());
        System.out.println("Number of elements: " + names.size());
        System.out.println("Is the stack full? " + names.isFull());
        System.out.println();
        
        // update max size of the drop-out stack to be seven String objects
        System.out.println("Updating the max size of the drop-out stack to 6 names");
        names.setMaxSize(6);
        
        // push seven new Strings onto the drop-out stack
        System.out.println("Pushing 7 new names to the drop-out stack of max size 6");
        System.out.println();
        names.push("Ross");
        names.push("Monica");
        names.push("Joey");
        names.push("Phoebe");
        names.push("Rachel");
        names.push("Chandler");
        names.push("Billy");
        
        // reprint the contents and results of the peek() and size() methods 
        System.out.println("Testing the toString, peek, and size methods...");
        System.out.println("Contents of the stack: ");
        System.out.println(names);
        System.out.println("Top element: " + names.peek());
        System.out.println("Number of elements: " + names.size());
        System.out.println("Is the stack full? " + names.isFull());
        System.out.println();
        
        //______________________________________TESTING WITH INTEGER OBJECTS________________________________________________
        System.out.println("_________________TESTING WIITH INTEGER OBJECTS___________________"); 
        
        // push the integer values onto the stack 
        numbers.push(-5);
        numbers.push(0);
        numbers.push(3);
        numbers.push(100);
        
        System.out.println("Printing the integer stack...");
        System.out.println("The contents of the stack are:\n" + numbers);
        System.out.println("Top element: " + numbers.peek());
        System.out.println("Number of elements: " + numbers.size());
        System.out.println("Is the stack full? " + numbers.isFull());
        System.out.println();
        
        // popping elements off the stack 
        System.out.println("Popping elements off the stack...");
        numbers.pop();
        numbers.pop();
        
        System.out.println("Printing the integer stack...");
        System.out.println("The contents of the stack are:\n" + numbers);
        System.out.println("Top element: " + numbers.peek());
        System.out.println("Number of elements: " + numbers.size());
        System.out.println("Is the stack full? " + numbers.isFull());
        System.out.println();
        
        // updating the max size of the stack 
        System.out.println("Updating the max size of the drop-out stack to 6 numbers");
        numbers.setMaxSize(6);
        
        System.out.println("Pushing 7 new integer values onto the stack of max size 6");
        // pushing elements onto the stack greater than the max size given 
        numbers.push(34);
        numbers.push(15);
        numbers.push(4500);
        numbers.push(2);
        numbers.push(54);
        numbers.push(6);
        numbers.push(10);        
        // display deque information 
        System.out.println("Printing the integer stack...");
        System.out.println("The contents of the stack are:\n" + numbers);
        System.out.println("Top element: " + numbers.peek());
        System.out.println("Number of elements: " + numbers.size());
        System.out.println("Is the stack full? " + numbers.isFull());
        System.out.println();
     
    }
}
