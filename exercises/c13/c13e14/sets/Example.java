package sets;

public class Example {

    private static final int SET_A_SIZE = 20;

    private static final int SET_B_SIZE = 30;

    private static final int[] SET_A_MEMBERS =
        {0,3,5,14,11,7};
    private static final int[] SET_B_MEMBERS =
        {14,28,1,11,5,30};

    private static void fill (
        IntSet set, int[] elements) {
        for (int i = 0; i < elements.length; i = i+1)
            set.add(elements[i]);
    }

    public static void main (String[] argv) {
        IntSet a, b, c;

        a = new IntSet(SET_A_SIZE);
        fill(a,SET_A_MEMBERS);

        b = new IntSet(SET_B_SIZE);
        fill(b,SET_B_MEMBERS);

        c = a.intersection(b);

        System.out.println("A: " + a);
        System.out.println("B: " + b);
        System.out.println("C: " + c);
    }
}
