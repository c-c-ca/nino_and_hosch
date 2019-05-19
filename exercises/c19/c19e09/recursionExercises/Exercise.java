package recursionExercises;

public class Exercise {

    private static int findNineDigitNumber (int number, int digit) {
        if (digit < 10) {
            boolean found = false;
            int i = 1;
            while (!found) {
                int numberToTry;
                numberToTry = number * 10 + i;
                if (numberToTry%digit == 0) {
                    number =
                        findNineDigitNumber(numberToTry,digit+1);
                    found = true;
                }
                i = i+1;
            }
        }
        return number;
    }

    public static int findNineDigitNumber () {
        return findNineDigitNumber(0,1);
    }
}
