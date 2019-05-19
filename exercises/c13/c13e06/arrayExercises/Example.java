package arrayExercises;

public class Example {

    public static void main (String[] argv) {
        int[] x = new int[]{4,1,3,6};
        int[] y = new int[]{1,4,5};
        int[] z = multarr(x,y);
        displayMultiplication(x,y,z);
    }

    private static void displayMultiplication (
        int[] x, int[] y, int[] z) {
            System.out.println("  " + arrayToString(x));
            System.out.println("x " + arrayToString(y));
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

    public static int[] multarr (int[] x, int[] y) {
        int carry, p;
        int[] product, z;

        z = new int[0];
        for (int i = 0; i < x.length; i = i+1) {
            product = new int[i + y.length];
            carry = 0;
            for (int j = 0; j < y.length; j = j+1) {
                p = x[i] * y[j] + carry;
                product[j+i] = p % 10;
                carry = p / 10;
            }
            if (carry > 0)
                product = addcarry(product,carry);
            z = addarr(z,product);
        }
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
