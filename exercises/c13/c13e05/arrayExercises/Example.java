package arrayExercises;

public class Example {

    public static void main (String[] argv) {
        int[] x = new int[]{9,2,3};
        int[] y = new int[]{5,7,7};
        int[] z = addarr(x,y);
        displayCalculation(x,y,z);
    }

    private static void displayCalculation (
        int[] x, int[] y, int[] z) {
            System.out.println("  " + arrayToString(x));
            System.out.println("+ " + arrayToString(y));
            System.out.print("  ");
            for (int i = 0; i < z.length*3; i = i+1)
                System.out.print("-");
            System.out.println();
            System.out.println("  " + arrayToString(z));
        }

    public static int[] addarr (int[] x, int[] y) {
        int length, sum, carry, xDigit, yDigit;
        int[] z;

        length = (x.length > y.length) ? x.length : y.length;
        z = new int[length];
        sum = 0;
        carry = 0;
        for (int i = 0; i < length; i = i+1) {
            xDigit = (i < x.length) ? x[i] : 0;
            yDigit = (i < y.length) ? y[i] : 0;
            sum = xDigit + yDigit + carry;
            z[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry > 0)
            z = addcarry(z,carry);
        return z;
    }

    private static int[] addcarry (int[] arr, int carry) {
        int[] newarr = new int[arr.length+1];
        for (int i = 0; i < arr.length; i = i+1)
            newarr[i] = arr[i];
        newarr[arr.length] = carry;
        return newarr;
    }

    private static String arrayToString (int[] arr) {
        String s = "{";
        if (arr.length > 0)
            s = s + arr[0];
        for (int i = 1; i < arr.length; i = i+1)
            s = s + ", " + arr[i];
        return s + "}";
    }
}
