package arrayExercises;

public class Example {

    public static void main (String[] argv) {
        int[] arr = new int[]{1,3,7,9,4};
        System.out.println("forward: " + arrayToString(arr));
        reverse(arr);
        System.out.println("reverse: " + arrayToString(arr));
    }

    /**
     * Reverses the values in the specified array.
     */
    public static void reverse (int[] arr) {
        int i, j, temp;

        i = 0;
        j = arr.length - 1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i = i+1;
            j = j-1;
        }
    }

    public static String arrayToString (int[] arr) {
        String s = "{";
        if (arr.length > 0)
            s = s + arr[0];
        for (int i = 1; i < arr.length; i = i+1)
            s = s + ", " + arr[i];
        return s + "}";
    }
}
