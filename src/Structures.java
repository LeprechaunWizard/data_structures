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

    // helper functions
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
        System.out.println(textArray.getValueAtIndex(5));
        System.out.println(textArray.doesArrayContainValue(40));
        textArray.insertValue(70);

        textArray.printArray();

    }
}
