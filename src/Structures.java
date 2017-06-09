/**
 * Created by dieterverhufen on 2017-05-20.
 */
public class Structures {
    private int MAX_SIZE = 50;
    private int[] theArray = new int[MAX_SIZE];
    private int arraySize = 10;
    private int maxValue = 51;
    private int minValue = 10;

    // Display functions
    public int[] getTheArray() { return theArray; }

    public String[] generateDisplayArray() {
        String[] displayArray = new String[arraySize];

        for(int i = 0; i < arraySize; i++) {
            displayArray[i] = String.format("Index:  %d  | Value:  %d  ",
                    i, theArray[i]);
        }
        return displayArray;
    }


    // BASIC ARRAY FUNCTIONS
    public void generateRandomArray() {
        // Generates random array
        // Values may be equal to min but less than max
        for(int i = 0; i < arraySize; i++) {
            theArray[i] = (int)(Math.random() * (maxValue - minValue)) + minValue;
        }
    }

    public int getValueAtIndex(int index) {
        // Returns value at given index
        if (index < arraySize)
            return theArray[index];
        return 0;
    }

    public boolean doesArrayContainValue( int value) {
        // checks theArray contains the specified value

        for(int i = 0; i < arraySize; i++) {
            if (value == theArray[i]) {
                return true;
            }
        }
        return false;
    }

    public void deleteIndex(int index) {
        // Deletes the specified index
        if(index < arraySize) {
            for(int i = index; i < (arraySize - 1); i++) {
                theArray[i] = theArray[i + 1];
            }
            arraySize--;
        }
    }

    public void insertValue(int value) {
        // Adds the specified value to the end of array
        if(arraySize < MAX_SIZE) {
            theArray[arraySize++] = value;
        }
    }

    // SEARCH FUNCTIONS
    public String linearSearch(int value) {
        // searches for indexes with value and returns string
        String indexWithValue = "";
        boolean valuePresent = false;

        for(int i = 0; i < arraySize; i++) {
            if(theArray[i] == value) {
                valuePresent = true;
                indexWithValue += i + " ";
            }
        }
        if(!valuePresent) {
            indexWithValue = "None";
        }

        return indexWithValue;
    }

    public String binarySearch(int value) {
        // search by continually cutting the array in half
        // array must be sorted
        int lowIndex = 0;
        int highIndex = arraySize - 1;
        int middleIndex = -1;

        while (lowIndex <= highIndex) {
            middleIndex = (lowIndex + highIndex) / 2;

            if (theArray[middleIndex] > value)
                highIndex = middleIndex - 1;
            else if (theArray[middleIndex] < value)
                lowIndex = middleIndex + 1;
            else
                lowIndex = highIndex + 1;

        }
        return "The value " + value + " is located at index" + middleIndex;
    }

    // SORT FUNCTIONS
    public void bubbleSortAscending() {
        // bubble sort in ascending order
        for(int j = arraySize; j > 1; j--){
            for(int i = 0; i < arraySize - 1; i++) {
                if (theArray[i] > theArray[i+1]) {
                    swap(i, i+1);
                }
            }
        }
    }

    public void bubbleSortDescending() {
        // bubble sort in decending order
        for (int j = arraySize; j > 1; j--){
            for(int i = 0; i < arraySize - 1; i++) {
                if (theArray[i] < theArray[i+1]) {
                    swap(i, i+1);
                }
            }
        }
    }

    public void selectionSort() {
        for(int x = 0; x < arraySize; x++) {
            int min = x;

            for(int y = x; y < arraySize; y++) {
                if (theArray[min] > theArray[y]) {
                    min = y;
                }
            }

            swap(x, min);
        }

    }


    // Helper Functions
    private void swap(int indexOne, int indexTwo) {
        int temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;
    }

    private void printArray() {
        // Helper function to visualize the array
        for(int i = 0; i < arraySize; i++) {
            System.out.print("| " + i + " : ");
            System.out.println(theArray[i] + " |");
        }
    }

    public static void main(String[]args) {
        Structures textArray = new Structures();
        textArray.generateRandomArray();
        textArray.printArray();
        System.out.println();
        textArray.bubbleSortAscending();
        textArray.printArray();
        System.out.println();
        textArray.bubbleSortDescending();
        textArray.printArray();


    }
}
