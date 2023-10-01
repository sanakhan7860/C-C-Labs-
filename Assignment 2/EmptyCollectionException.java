/**
 * EmptyCollectionException.Java
 * COMP 2231 Assignment 2: Stacks and Queues 
 * This is the Exception Class
 * 
 * Represents the situation in which a collection is empty. 
 *
 * @author Java Foundations
 */
public class EmptyCollectionException extends RuntimeException
{
    /**
     * Sets up this exception with an appropriate message.
     * @param collection the name of the collection
     */
    public EmptyCollectionException(String collection)
    {
        super("The " + collection + " is empty.");
    }
}
