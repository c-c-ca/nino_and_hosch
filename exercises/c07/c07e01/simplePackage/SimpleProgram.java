package simplePackage;

/**
 * A simple program as suggested in the exercise.
 */
public class SimpleProgram {

    public static void main (String[] args) {
        System.out.write(65); // writes the byte 65 to the output stream
                              // which when interpreted as a character is
                              // is the encoding for the character 'A'

        System.out.println(); // writes a line terminating character
                              // to the output stream

        System.out.print(65); // writes the characters representing the digits
                              // in the decimal integer 65 to the output stream

        System.out.println(); // writes a line terminating character
                              // to the output stream
    }

}
