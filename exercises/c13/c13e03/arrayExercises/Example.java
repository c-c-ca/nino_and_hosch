package arrayExercises;

public class Example {

    public static void main (String[] argv) {
        int[] arr = new int[]{1,3,7,9,4};
        System.out.println("forward: " + arrayToString(arr));
        rightrot(arr);
        System.out.println("reverse: " + arrayToString(arr));
    }

    /**
     * Shifts the values in the specified array up by one,
     * moving the last value into the 0th position.
     */
    public static void rightrot (int[] arr) {
        int last = arr[arr.length-1];
        for (int i = arr.length-1; i > 0; i = i-1)
            arr[i] = arr[i-1];
        arr[0] = last;
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
