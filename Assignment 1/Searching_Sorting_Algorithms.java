//Assignment 1 
//Sana Khan 
//T00718201
import java.util.Arrays;
import java.util.Random;//used for createArray method

/**
 * Sorting demonstrates sorting and searching on an array 
 * of objects.
 *
 * @author Java Foundations
 * @version 4.0 
 */

public class Sorting {
	
	
	public static int swaps; //keeps track of the number of swaps occured during the sorting of the algori
	public static int comparisons;
	public static long startTime;
	public static long endTime;//in nanoseconds
	public static Random random=new Random();

	
	/**
	 * Sorts the given array of integers using the shell sort algorithm
	 * 
	 * @param data the array to be sorted
	 */
	public static <T extends Comparable<T>> 
	void shellSort(T[] data)
	{
		startTime=System.nanoTime(); //start execution time 
		
		//reset the swap and comparison variables before sorting 
		swaps=0;
		comparisons=0;
		
		//find the position of the gap
		int gap = data.length/2;
		
		//this variable indicates whether a swap has occured or not
		boolean swapflag;
		
		//the following loop sorts using shell sort as long as a gap size is calculated within the array  
		
		while (gap > 0){
			swapflag=true; //initialize to true before executing the 
			while (swapflag) {
				swapflag=false; //initialized as false since a swap has not occured yet 
				for (int s=0; s< data.length - gap ;s++) {//ensures loop is within data bounds
					if (data[s].compareTo(data[s+gap])==1) {//performs a swap if data[s+gap]>data[s]
						swap(data, s,s+gap);
						swapflag=true; //a swap has occured
						swaps++; //increase swap count 
					}
					//adds up the comparisons made in the array while sorting until it has been fully sorted 
					comparisons+=Math.abs(data[s].compareTo(data[s+gap])); 
				}
			}
			gap=gap/2; //continue to decrease the gaps 
		}
		
		endTime=(System.nanoTime()-startTime);//calculate execution time of sorting 
	}
	
	
	
	/**
	 * Sorts the given array of integers using bubble sort
	 * algorithm.
	 *
	 * @param data the array to be sorted
	 */
	public static <T extends Comparable<T>>
	void bubbleSort(T[] data)
	{
		startTime=System.nanoTime(); //start execution time 

		//reset the swap and comparison variables before sorting
		swaps=0;
		comparisons=0;
		
		int pos;
		int check;
		
		for (pos =  data.length - 1; pos >= 0; pos--)//iterates position in the array with every new pass
		{
			//this loop iterates through the number of passes made while sorting 
			for (check = 0; check <= pos - 1; check++)//ensures loop is within data bounds
			{
				if (data[check].compareTo(data[check + 1]) > 0) {//performs a swap if data[check+1]>data[check]
					swap(data, check, check + 1); //swap the data at specified indexes 
					swaps++; //increase swap count 
				}
				//adds up the comparisons made in the array until it has been sorted 
				comparisons+=Math.abs(data[check].compareTo(data[check+1]));
			}
		}
		
		endTime=(System.nanoTime()-startTime); //calculate execution time for sorting 
	}
	
	
	/**
	 * Sorts the given array of integers using the bubble sort 2 
	 * algorithm. This is similar to the bubble sort algorithm, but quits the algorithm
	 * when the data is sorted (rather than completing the sorting algorithm to 
	 * the end).
	 *
	 * @param data the array to be sorted
	 */
	public static <T extends Comparable<T>> 
	void bubbleSort2(T[] data)
	{		
		startTime=System.nanoTime(); //start execution time 
		
		//reset the swap and comparison variables before sorting 
		swaps=0;
		comparisons=0;
		
		int pos=data.length - 1; //gives the position of the 
		int check;
		boolean swapFlag=true;
		
		while (swapFlag)
		{
			swapFlag=false; //reset flag for each new pass
			
			//this loop marks a pass through the array 
			for (check = 0; check <= pos - 1; check++){//ensures that the loop is within data bounds
				if (data[check].compareTo(data[check + 1]) > 0) {//performs a swap if data[check+1]>data[check]
					swap(data, check, check + 1);
					swapFlag=true; //a swap has occured
					swaps++; //increase swap count 
				}
				//adds up the comparisons made in the array until it has been sorted 
				comparisons+=Math.abs(data[check].compareTo(data[check+1]));
			}
			pos--; //iterate position of array for next pass
		}		
		
		endTime=(System.nanoTime()-startTime); //calculate execution time for sorting 
	}
	
	
	
	/**
	 * Prints the array data to the terminal to be seen by the user 
	 *
	 * @param data the array to be printed
	 */
	public static <T extends Comparable<T>> 
	void printArray(T[] data)
	{
		System.out.print("{  ");
		for (int x=0;x<data.length;x++){//prints all values in the data array
			System.out.print(data[x]+"  ");
			}
		System.out.print("}\n");
	}
	
	/**
	 * Swaps two elements in an array and is used by various sorting algorithms.
	 * 
	 * @param data   the array in which the elements are swapped
	 * @param index1 the index of the first element to be swapped
	 * @param index2 the index of the second element to be swapped
	 */
	private static <T extends Comparable<T>> 
	void swap(T[] data, int index1, int index2)
	{
		T temporary = data[index1]; //create a temporary variable to store one of the values to be swapped 
		data[index1] = data[index2]; //assign second element to data[index1]
		data[index2] = temporary; //assign first element to data[index2] stored in the temporary variable 
	}
	
	/**
	 * Creates a random or sorted array and is used in the driver method to test sorting algorithms
	 * 
	 * @param length   the desired length of the array
	 * @param random.nextInt used to generate arrays composed of random integers 
	 * @param sorted the boolean used to generate a random or sorted array
	 */
	private static <T extends Comparable<T>> 
	Integer[] makeArray(int length,boolean sorted)
	{
		Integer[] array= new Integer[length];
		
		for (int x=0;x<=length-1;x++){ //creates a random array of length "length" using integers up to bound 100 
			array[x]=random.nextInt(100); //produces an array with random numbers ranging from 0-99
}
		
		if (sorted) {//performs a simple shell sort of the randomized array
			shellSort(array);
}
		
		return array;
	}
	
	
	public static void main(String[] args) {

		Integer[] original = {9,6,8,12,3,1,7}; //example array
		
		Integer[] data10 = makeArray(10,false);
		Integer[] data20 = makeArray(20,false);
		Integer[] data100 = makeArray(100,false);
		Integer[] data1000 = makeArray(1000,false);
		Integer[] sorted10 = makeArray(10,true);
		Integer[] sorted100 = makeArray(100,true);
		Integer[] sorted1000 = makeArray(1000,true);

		//TEST CASES
		
		System.out.println("\\     SORTING ORIGINAL     \\");
		shellSort(Arrays.copyOf(original, original.length));
		System.out.println("SHELLSORT\n"+"Swaps: "+swaps+"\nComparisons: "+comparisons+"\nExecution Time: "+endTime+"\n");

		bubbleSort(Arrays.copyOf(original, original.length));
		System.out.println("BUBBLESORT\n"+"Swaps: "+swaps+"\nComparisons: "+comparisons+"\nExecution Time: "+endTime+"\n");

		bubbleSort2(Arrays.copyOf(original, original.length));
		System.out.println("BUBBLESORT2\n"+"Swaps: "+swaps+"\nComparisons: "+comparisons+"\nExecution Time: "+endTime+"\n");

		
		System.out.println("\\     SORTING DATA10     \\");
		shellSort(Arrays.copyOf(data10, 10));
		System.out.println("SHELLSORT\n"+"Swaps: "+swaps+"\nComparisons: "+comparisons+"\nExecution Time: "+endTime+"\n");

		bubbleSort(Arrays.copyOf(data10, 10));
		System.out.println("BUBBLESORT\n"+"Swaps: "+swaps+"\nComparisons: "+comparisons+"\nExecution Time: "+endTime+"\n");

		bubbleSort2(Arrays.copyOf(data10, 10));
		System.out.println("BUBBLESORT2\n"+"Swaps: "+swaps+"\nComparisons: "+comparisons+"\nExecution Time: "+endTime+"\n");

		
		System.out.println("\\     SORTING DATA20     \\");
		shellSort(Arrays.copyOf(data20, 20));
		System.out.println("SHELLSORT\n"+"Swaps: "+swaps+"\nComparisons: "+comparisons+"\nExecution Time: "+endTime+"\n");

		bubbleSort(Arrays.copyOf(data20, 20));
		System.out.println("BUBBLESORT\n"+"Swaps: "+swaps+"\nComparisons: "+comparisons+"\nExecution Time: "+endTime+"\n");

		bubbleSort2(Arrays.copyOf(data20, 20));
		System.out.println("BUBBLESORT2\n"+"Swaps: "+swaps+"\nComparisons: "+comparisons+"\nExecution Time: "+endTime+"\n");

		
		System.out.println("\\     SORTING DATA100     \\");
		shellSort(Arrays.copyOf(data100, 100));
		System.out.println("SHELLSORT\n"+"Swaps: "+swaps+"\nComparisons: "+comparisons+"\nExecution Time: "+endTime+"\n");

		bubbleSort(Arrays.copyOf(data100, 100));
		System.out.println("BUBBLESORT\n"+"Swaps: "+swaps+"\nComparisons: "+comparisons+"\nExecution Time: "+endTime+"\n");

		bubbleSort2(Arrays.copyOf(data100, 100));
		System.out.println("BUBBLESORT2\n"+"Swaps: "+swaps+"\nComparisons: "+comparisons+"\nExecution Time: "+endTime+"\n");
		
		
		System.out.println("\\     SORTING DATA1000     \\");
		shellSort(Arrays.copyOf(data1000, 1000));
		System.out.println("SHELLSORT\n"+"Swaps: "+swaps+"\nComparisons: "+comparisons+"\nExecution Time: "+endTime+"\n");

		bubbleSort(Arrays.copyOf(data1000, 1000));
		System.out.println("BUBBLESORT\n"+"Swaps: "+swaps+"\nComparisons: "+comparisons+"\nExecution Time: "+endTime+"\n");

		bubbleSort2(Arrays.copyOf(data1000, 1000));
		System.out.println("BUBBLESORT2\n"+"Swaps: "+swaps+"\nComparisons: "+comparisons+"\nExecution Time: "+endTime+"\n");

		
		System.out.println("\\     SORTING SORTED10     \\");
		shellSort(Arrays.copyOf(sorted10, 10));
		System.out.println("SHELLSORT\n"+"Swaps: "+swaps+"\nComparisons: "+comparisons+"\nExecution Time: "+endTime+"\n");

		bubbleSort(Arrays.copyOf(sorted10, 10));
		System.out.println("BUBBLESORT\n"+"Swaps: "+swaps+"\nComparisons: "+comparisons+"\nExecution Time: "+endTime+"\n");

		bubbleSort2(Arrays.copyOf(sorted10, 10));
		System.out.println("BUBBLESORT2\n"+"Swaps: "+swaps+"\nComparisons: "+comparisons+"\nExecution Time: "+endTime+"\n");

		
		System.out.println("\\     SORTING SORTED100     \\");
		shellSort(Arrays.copyOf(sorted100, 100));
		System.out.println("SHELLSORT\n"+"Swaps: "+swaps+"\nComparisons: "+comparisons+"\nExecution Time: "+endTime+"\n");

		bubbleSort(Arrays.copyOf(sorted100, 100));
		System.out.println("BUBBLESORT\n"+"Swaps: "+swaps+"\nComparisons: "+comparisons+"\nExecution Time: "+endTime+"\n");

		bubbleSort2(Arrays.copyOf(sorted100, 100));
		System.out.println("BUBBLESORT2\n"+"Swaps: "+swaps+"\nComparisons: "+comparisons+"\nExecution Time: "+endTime+"\n");
		
		
		System.out.println("\\     SORTING SORTED1000     \\");
		shellSort(Arrays.copyOf(sorted1000, 1000));
		System.out.println("SHELLSORT\n"+"Swaps: "+swaps+"\nComparisons: "+comparisons+"\nExecution Time: "+endTime+"\n");

		bubbleSort(Arrays.copyOf(sorted1000, 1000));
		System.out.println("BUBBLESORT\n"+"Swaps: "+swaps+"\nComparisons: "+comparisons+"\nExecution Time: "+endTime+"\n");

		bubbleSort2(Arrays.copyOf(sorted1000, 1000));
		System.out.println("BUBBLESORT2\n"+"Swaps: "+swaps+"\nComparisons: "+comparisons+"\nExecution Time: "+endTime+"\n");
		
	
		
}

	}
