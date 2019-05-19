package arrayExercises;

public class Example {

    public static void main (String[] argv) {
        int[] arr = new int[]{1,-2,3,-4,-5};
        System.out.println(countNegatives(arr));
    }

    /**
     * The number of negative values int the specified array.
     */
    public static int countNegatives (int[] arr) {
        int count;  // number of negative values with index
                    // less than i
        int i;      // the index of the next value to check

        count = 0;
        i = 0;
        while (i < arr.length) {
            if (arr[i] < 0)
                count = count + 1;
            i = i+1;
        }
        return count;
    }
}
