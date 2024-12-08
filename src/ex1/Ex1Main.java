package ex1;
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
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
                break; // Exit if user enters "quit"
            }


            boolean isNum1Valid = Ex1.isNumber(num1);
            int value1 = Ex1.number2Int(num1);
            System.out.println("num1= " + num1 + " is number: " + isNum1Valid + " , value: " + value1);

            // Get number#2
            System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
            num2 = sc.next();
            if (num2.equals(quit)) {
               break; // Exit if user enters "quit"
            }


            boolean isNum2Valid = Ex1.isNumber(num2);
            int value2 = Ex1.number2Int(num2);
            System.out.println("num2= " + num2 + " is number: " + isNum2Valid + " , value: " + value2);

            // Get the base for output
            System.out.println("Enter a base for output: (a number [2,16])");
            int base = sc.nextInt();

            if (isNum1Valid && isNum2Valid) {
                // Perform calculations
                String sum = Ex1.int2Number(value1 + value2, base);
                String kefel = Ex1.int2Number(value1 * value2, base);

                System.out.println(num1 + " + " + num2 + " = " + sum);
                System.out.println(num1 + " * " + num2 + " = " + kefel);
                // Find the max number in the array
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