package matrix;

public class Example {

    private static final int BAR_LENGTH = 20;

    private static void fill (Matrix m) {
        int value = 0;
        for (int i = 0; i < m.rows(); i = i+1)
            for (int j = 0; j < m.columns(); j = j+1)
                m.setValue(i,j,value++);
    }

    private static void printMatrix (String name, Matrix m) {
        System.out.println(name);
        printBar();
        System.out.println(m);
        printBar();
        System.out.println();
    }

    private static void printBar () {
        for (int i = 0; i < BAR_LENGTH; i = i+1)
            System.out.print("-");
        System.out.println();
    }

    public static void main (String[] argv) {
        Matrix a, b, c, x, y, z;
        int n, m, p;

        n = 2;
        m = 3;
        p = 4;

        a = new Matrix(n,p);
        b = new Matrix(p,m);
        fill(a);
        fill(b);
        c = a.product(b);
        printMatrix("A",a);
        printMatrix("B",b);
        printMatrix("C = A x B",c);

        x = new Matrix(p,n);
        y = new Matrix(m,p);
        fill(x);
        fill(y);
        z = x.product(y);
        printMatrix("X",x);
        printMatrix("Y",y);
        printMatrix("Z = X x Y",z);
    }
}
