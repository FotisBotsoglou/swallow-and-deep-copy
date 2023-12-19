import java.util.Arrays;

public class CopyArrays {
    /**
     *
     * A demonstration App that explains the difference between copy by reference(swallow copy)
     * and copy the entire array and not just the reference(deep copy).
     */

    public static int[][] swallowCopy(int[][] initialArray){
        // this method of the Class Arrays returns a swallow copy ot the
        // initial array(copy the reference at the stack who points at the actual array at the heap).
        // With that way changes that are made in each one of the two arrays are also made to the other
        // array.
        return Arrays.copyOf(initialArray,initialArray.length);
    }

    public static int[][] deepCopy(int[][] initialArray){
        // Creation of a new array with the same dimensions of the initial array.
        int[][] deepCopyArray = new int[initialArray.length][];

        // Copy the elements of the initial array to the new array tha it was created.
        for (int i = 0; i < initialArray.length; i++){
            deepCopyArray[i] = Arrays.copyOf(initialArray[i],initialArray[i].length);
        }
        return deepCopyArray;

        // with this method we have two different references at the stack that point to
        // two different places at the heap memory . Changes in either of the arrays do not
        // affect the other array.
    }
    public static void main(String[] args) {
        //Initialize the first array that we want to copy.
        int[][] initialArray =
                {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                };

        // swallow copy
        int[][] swallowCopy = swallowCopy(initialArray);
        System.out.println("Initial and swallow copy arrays:");
        System.out.println("\t"+Arrays.deepToString(initialArray));
        System.out.println("\t"+Arrays.deepToString(swallowCopy));
        System.out.println("-".repeat(20));

        // modify an element to the second array in order to check
        // if the changes are also applied in the initial array.
        swallowCopy[1][1] = 100;
        System.out.println("Changes in either of the arrays affects the other array too:");
        System.out.println("\t"+Arrays.deepToString(initialArray));
        System.out.println("\t"+Arrays.deepToString(swallowCopy));
        System.out.println("-".repeat(20));
        // we modify the arrays in order to be at the initial form;
        initialArray[1][1] = 5;

        // deep copy
        int[][] deepCopy = deepCopy(initialArray);
        System.out.println("Initial and deep copy arrays:");
        System.out.println("\t"+Arrays.deepToString(initialArray));
        System.out.println("\t"+Arrays.deepToString(deepCopy));
        System.out.println("-".repeat(20));

        // we modify the deep copy array in order to check that
        // the changes do not affect the initial array.
        deepCopy[0][0] = 200;

        System.out.println("Changes at the deep copy array do not affect the initial array:");
        System.out.println("\t"+Arrays.deepToString(initialArray));
        System.out.println("\t"+Arrays.deepToString(deepCopy));
        System.out.println("-".repeat(20));

    }
}

