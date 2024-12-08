package ex1;
/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {

            // Validate the input using isNumber
            if (!isNumber(num))
                return -1; // Invalid number

            // Handle numbers without "b" as base 10
            if (!num.contains("b"))
                return Integer.parseInt(num); // Valid base 10 number

            // Split the input into the number and base parts
            String[] parts = num.split("b");
            String number = parts[0];
            String baseStr = parts[1];

            int base = baseToInt(baseStr);
            int result = 0;

            // Convert the number part to decimal
            for (char c : number.toCharArray()) {
                int digit = Character.digit(c, base);
                result = result * base + digit;
            }

            return result;
        }



        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * @param a a String representing a number
         * @return true iff the given String is in a number format
         */
    public static boolean isNumber(String a) {

            if (a == null || a.isEmpty())
                return false;

            // Handle numbers without "b" as base 10
            if (!a.contains("b")) {
                // Verify that all characters are digits (0-9)
                for (char c : a.toCharArray()) {
                    if (!Character.isDigit(c))
                        return false; // Not a valid base 10 number
                }
                return true; // All characters are digits, valid base 10 number
            }

            // Split the input into the number and base parts
            String[] parts = a.split("b");
            if (parts.length != 2 || parts[0].isEmpty())
                return false; // Invalid: missing number before "b"

            String number = parts[0];
            String baseStr = parts[1];

            // Validate the base
            if (!isNumberBaseValid(baseStr))
                return false;

            int base = baseToInt(baseStr);
            if (base < 2 || base > 16)
                return false;

            // Validate the number part
            for (char c : number.toCharArray()) {
                if (Character.digit(c, base) == -1)
                    return false; // Invalid digit for the given base
            }

            return true; // Valid number
        }


        /**
         * Calculate the number representation (in basis base)
         * of the given natural number (represented as an integer).
         * If num<0 or base is not in [2,16] the function should return "" (the empty String).
         * @param num the natural number (include 0).
         * @param base the basis [2,16]
         * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
         */
    public static String int2Number(int num, int base) {

            if (num < 0 || base < 2 || base > 16)
                return "";

            // Convert the number to the specified base
            String result = Integer.toString(num, base).toUpperCase();

            // If the base is 10, return the number without the base indicator
            if (base == 10)
                return result;

            // Append the base indicator for bases other than 10
            return result + "b" + baseToChar(base);

    }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        return number2Int(n1) == number2Int(n2);

    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */
    public static int maxIndex(String[] arr) {
        int maxValue = -1, maxIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            int value = number2Int(arr[i]);
            if (value > maxValue) {
                maxValue = value;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static boolean isNumberBaseValid(String baseStr) {
            if (baseStr.length() == 1) {
                char c = baseStr.charAt(0);
                return Character.isDigit(c) || (c >= 'A' && c <= 'G');
            }
            return false;
        }


        private static int baseToInt(String baseStr) {
                if (Character.isDigit(baseStr.charAt(0))) {
                    return Integer.parseInt(baseStr);
                } else {
                    return 10 + (baseStr.charAt(0) - 'A');
                }
            }

            private static char baseToChar(int base) {
        if (base <= 9) return (char) ('0' + base);
        return (char) ('A' + (base - 10));
    }
}