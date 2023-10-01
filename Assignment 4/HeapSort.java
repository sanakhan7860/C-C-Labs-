import java.util.Arrays;

/**
 * Assignment 5: Part 1
 * 
 * HeapSort sorts a given array of Comparable objects using a heap. The method
 * heapSort is the original heapSort method from the Java Foundations textbook.
 * The method efficientHeapSort is the more efficient implementation for this assignment 
 * 
 * @author (Sana Khan - t00718201)
 */
public class HeapSort<T> {
    /**
     * Sorts the specified array using a HeapSort which is written by Java Foundations 
     *
     * @param data the data to be added to the heapsort
     */
    public void heapSort(T[] data) {
        ArrayHeap<T> heap = new ArrayHeap<T>();

        // copy the array into a heap
        for (int i = 0; i < data.length; i++){
            heap.addElement(data[i]);
        }

        // place the sorted elements back into the array by removing the minimum number for each iteration
        int count = 0;
        while (!(heap.isEmpty())) {
            data[count] = heap.removeMin();
            count++;
        }
    }

    /**
     * Recursively builds a maxheap out of an array of data.
     * 
     * @param data the data to be heapified
     * @param size the size of the heap
     * @param i    the node of the subtree to heapify
     */
    private void heapify(T[] data, int size, int i) {
        // assume parent node is largest to start
        int max = i;

        // left child index
        int left = 2 * i + 1;

        // right child index
        int right = 2 * i + 2;

        // swap max index if left child > parent
        if (left < size && ((Comparable) data[left]).compareTo(data[max]) > 0){
            max = left;
        }

        // swap max index if right child > max index
        if (right < size && ((Comparable) data[right]).compareTo(data[max]) > 0){
            max = right;
        }

        // if parent index is not max, swap parent element and max element
        if (max != i) {
            T temp = data[i];
            data[i] = data[max];
            data[max] = temp;

            // recursively heapify subtrees
            heapify(data, size, max);
        }
    }
    
    /**
     * Sorts the specificed array using a more efficient Heap Sort. First, builds a
     * maxheap in place using the data in the array. Then, sorts the array by moving
     * the max element (root) to the end of the array, one by one, until all
     * elements have been processed.
     * 
     * @param data the data to be sorted
     */
    public void efficientHeapSort(T[] data) {
        // size of heap (# of nodes)
        int size = data.length;

        // first non-leaf node
        int start = (size - 1) / 2;

        // build maxheap inplace
        for (int i = start; i >= 0; i--){
            heapify(data, size, i);
        }

        // remove maxheap elements one by one, starting at root and
        // moving to the end of the array, until array is sorted.
        for (int i = size - 1; i >= 0; i--) {
            // move current root (current max element) to end of array
            T temp = data[0];
            data[0] = data[i];
            data[i] = temp;

            // recursively heapify remaining elements
            heapify(data, i, 0);
        }
    }
    
        public static void main(String[] args) {
        // test cases
        Integer[] array0 = { 30, 15, 35, 8, 12, 0, 49 };
        Integer[] array1 = { 100/4, 4/7, 15/35, 1000/46, 15/3 };
        Double[] array2 = { -5000.678, 615.43, 222.222, -3.141596, -0.554789, 2000.0 };
        String[] array3 = { "X", "U", "Q", "B", "M", "I", "F" };
        String[] array4 = { "B", "E", "H", "L", "N", "S", "Y" };
        String[] array5 = { "cat", "dog", "fish", "parrot", "coyote" };
        String[] array6 = { "+", ">", "@", "&", "?" };
        String[] array7 = { "t+1", "6 + 2", "x - 5", "(6/3)-y" };
        
        // used to perform heapsort
        HeapSort heapsorter = new HeapSort();

        // test case 0: Integer Array
        System.out.println("---------------Test Case 0: Integer Array 0---------------");

        // print array before heap sort
        System.out.println("Array before heapsort: " + Arrays.toString(array0));

        // run the new efficient method of heapsort and reprint array
        System.out.println("Running heapsort...");
        heapsorter.efficientHeapSort(array0);
        System.out.println("Array after heapsort: " + Arrays.toString(array0));

        // run the new efficient method of heapsort on sorted array and reprint array
        System.out.println("Running heapsort again on sorted array...");
        heapsorter.efficientHeapSort(array0);
        System.out.println("Sorted array after heapsort: " + Arrays.toString(array0));
        System.out.println();
        
        
        // test case 1: Fraction Array
        System.out.println("---------------Test Case 1: Fraction Array 1---------------");

        // print array before heap sort
        System.out.println("Array before heapsort: " + Arrays.toString(array1));

        // run the new efficient method of heapsort and reprint array
        System.out.println("Running heapsort...");
        heapsorter.efficientHeapSort(array1);
        System.out.println("Array after heapsort: " + Arrays.toString(array1));

        // run the new efficient method of heapsort on sorted array and reprint array
        System.out.println("Running heapsort again on sorted array...");
        heapsorter.efficientHeapSort(array1);
        System.out.println("Sorted array after heapsort: " + Arrays.toString(array1));
        System.out.println();
        
        
        // test case 2 decimal/double value array 
        System.out.println("---------------Test Case 2: Decimal Array 2---------------");

        // print array before heap sort
        System.out.println("Array before heapsort: " + Arrays.toString(array2));

        // run the new efficient method of heapsort and reprint array
        System.out.println("Running heapsort...");
        heapsorter.efficientHeapSort(array2);
        System.out.println("Array after heapsort: " + Arrays.toString(array2));

        // run the new efficient method of heapsort on sorted array and reprint array
        System.out.println("Running heapsort again on sorted array...");
        heapsorter.efficientHeapSort(array2);
        System.out.println("Sorted array after heapsort: " + Arrays.toString(array2));
        System.out.println();
        

        // test case 3: String Array
        System.out.println("---------------Test Case 3: String Array---------------");

        // print array before heap sort
        System.out.println("Array before heapsort: " + Arrays.toString(array3));

        // run the new efficient method of heapsort and reprint array
        System.out.println("Running heapsort...");
        heapsorter.efficientHeapSort(array3);
        System.out.println("Array after heapsort: " + Arrays.toString(array3));

        // run the new efficient method of heapsort on sorted array and reprint array
        System.out.println("Running heapsort again on sorted array...");
        heapsorter.efficientHeapSort(array3);
        System.out.println("Sorted array after heapsort: " + Arrays.toString(array3));
        System.out.println();
        
        
        // test case 4: Ordered String Array
        System.out.println("---------------Test Case 4: Ordered String Array---------------");
        
        // print array before heap sort
        System.out.println("Array before heapsort: " + Arrays.toString(array4));

        // run the new efficient method of heapsort and reprint array
        System.out.println("Running heapsort...");
        heapsorter.efficientHeapSort(array4);
        System.out.println("Array after heapsort: " + Arrays.toString(array4));

        // run the new efficient method of heapsort on sorted array and reprint array
        System.out.println("Running heapsort again on sorted array...");
        heapsorter.efficientHeapSort(array4);
        System.out.println("Sorted array after heapsort: " + Arrays.toString(array4));
        System.out.println();
        
        // test case 5: String arrray with words 
        System.out.println("---------------Test Case 5: Word String Array---------------");
        
        // print array before heap sort
        System.out.println("Array before heapsort: " + Arrays.toString(array5));

        // run the new efficient method of heapsort and reprint array
        System.out.println("Running heapsort...");
        heapsorter.efficientHeapSort(array5);
        System.out.println("Array after heapsort: " + Arrays.toString(array5));

        // run the new efficient method of heapsort on sorted array and reprint array
        System.out.println("Running heapsort again on sorted array...");
        heapsorter.efficientHeapSort(array5);
        System.out.println("Sorted array after heapsort: " + Arrays.toString(array5));
        System.out.println();
        
        
        // test case 6: String Symbol array
        System.out.println("---------------Test Case 6: String Symbol Array---------------");
        
        // print array before heap sort
        System.out.println("Array before heapsort: " + Arrays.toString(array6));

        // run the new efficient method of heapsort and reprint array
        System.out.println("Running heapsort...");
        heapsorter.efficientHeapSort(array6);
        System.out.println("Array after heapsort: " + Arrays.toString(array6));

        // run the new efficient method of heapsort on sorted array and reprint array
        System.out.println("Running heapsort again on sorted array...");
        heapsorter.efficientHeapSort(array6);
        System.out.println("Sorted array after heapsort: " + Arrays.toString(array6));
        System.out.println();
        
        // test case 7: String Equation array
        System.out.println("---------------Test Case 7: String Equation Array---------------");
        
        // print array before heap sort
        System.out.println("Array before heapsort: " + Arrays.toString(array7));

        // run the new efficient method of heapsort and reprint array
        System.out.println("Running heapsort...");
        heapsorter.efficientHeapSort(array7);
        System.out.println("Array after heapsort: " + Arrays.toString(array7));

        // run the new efficient method of heapsort on sorted array and reprint array
        System.out.println("Running heapsort again on sorted array...");
        heapsorter.efficientHeapSort(array7);
        System.out.println("Sorted array after heapsort: " + Arrays.toString(array7));
        System.out.println();


    }
}