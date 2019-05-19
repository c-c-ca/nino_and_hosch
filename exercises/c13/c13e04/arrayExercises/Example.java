package arrayExercises;

public class Example {

    public static void main (String[] argv) {
        int[] v1 = new int[]{1,2,3};
        int[] v2 = new int[]{4,5,6};
        System.out.println("inner product of " + arrayToString(v1) +
            " and " + arrayToString(v2) + ": " + innerProduct(v1,v2));
    }

    /**
     * Computes the inner product of two arrays with the
     * same length.
     */
    public static int innerProduct (int[] v1, int[] v2) {
        int innerProduct = 0;
        for (int i = 0; i < v1.length; i = i+1)
            innerProduct += v1[i] * v2[i];
        return innerProduct;
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
