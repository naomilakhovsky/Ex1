
// ID:213370919
package ex1;
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
/**
 * ID:213370919
 * Ex1Main Class
 * This class provides a simple interactive program for testing the functionality of the Ex1 class.
 * Users can input numbers in various bases (2-16), validate them, perform arithmetic operations
 * (addition and multiplication), and find the largest number among the inputs and results.
 * The program runs in a loop until the user enters "quit". It also allows converting between
 * string-based number formats and decimal values.
 */

public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");

            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (num1.equals("quit")) {
                break;
            }


            boolean isNum1Valid = Ex1.isNumber(num1);
            int value1 = Ex1.number2Int(num1);
            System.out.println("num1= " + num1 + " is number: " + isNum1Valid + " , value: " + value1);

            System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
            num2 = sc.next();
            if (num2.equals(quit)) {
               break;
            }


            boolean isNum2Valid = Ex1.isNumber(num2);
            int value2 = Ex1.number2Int(num2);
            System.out.println("num2= " + num2 + " is number: " + isNum2Valid + " , value: " + value2);

            System.out.println("Enter a base for output: (a number [2,16])");
            int base = sc.nextInt();

            if (isNum1Valid && isNum2Valid) {
                String sum = Ex1.int2Number(value1 + value2, base);
                String kefel = Ex1.int2Number(value1 * value2, base);

                System.out.println(num1 + " + " + num2 + " = " + sum);
                System.out.println(num1 + " * " + num2 + " = " + kefel);
                String[] arr = {num1, num2, sum, kefel};
                int maxIndex = Ex1.maxIndex(arr);
                System.out.println("Max number over " + java.util.Arrays.toString(arr) + " is: " + arr[maxIndex]);
            } else {
                System.out.println("One or both of the inputs are not valid numbers.");
            }
        }

        System.out.println("quitting now...");
    }
}