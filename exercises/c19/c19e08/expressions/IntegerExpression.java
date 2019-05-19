package expressions;

public class IntegerExpression {

    // Named constants:

    public enum UnaryOperator {plus, minus}
    public enum BinaryOperator {plus, minus, multiply, divide}

    // Private components

    private int value;

    // Constructors:

    public IntegerExpression (int i) {
        this.value = i;
    }

    public IntegerExpression (UnaryOperator operator,
        IntegerExpression operand) {
        int sign = (operator == UnaryOperator.minus) ? -1 : 1;
        this.value = sign * operand.evaluate();
    }

    public IntegerExpression (BinaryOperator operator,
        IntegerExpression operand1, IntegerExpression operand2) {
        int m, n;

        m = operand1.evaluate();
        n = operand2.evaluate();
        if (operator == BinaryOperator.plus)
            this.value = m + n;
        else if (operator == BinaryOperator.minus)
            this.value = m - n;
        else if (operator == BinaryOperator.multiply)
            this.value = m * n;
        else
            this.value = m / n;
    }

    // Queries:

    public int evaluate () {
        return value;
    }

    public static void main (String[] argv) {
        IntegerExpression e = new IntegerExpression(1);
        e = new IntegerExpression(UnaryOperator.minus,e);
        e = new IntegerExpression(BinaryOperator.plus, e,
                new IntegerExpression(5));
        System.out.println(e.evaluate());
    }
}
