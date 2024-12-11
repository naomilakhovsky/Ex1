
// ID:213370919
package ex1;
/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,...G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”, ”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {

    /**
     * Converts a valid base-represented number string to its decimal integer equivalent.
     * Internally, this function splits the input string into two parts: the number and the base.
     * It calculates the decimal value by iterating through each character of the number, converting
     * it to a digit in the specified base, and updating the result using positional arithmetic.
     * @param num a String representing a number in bases [2,16].
     * @return the decimal representation of the number, or -1 if invalid.
     */

    public static int number2Int(String num) {

            if (!isNumber(num))       // If the string is not a valid number according to `isNumber`, return -1.

                return -1;

            if (!num.contains("b"))  //if the input does not contain the base specifier "b". parse it directly if not.
                return Integer.parseInt(num);

            String[] parts = num.split("b");
            String number = parts[0];
            String baseStr = parts[1];

            int base = baseToInt(baseStr); // Convert the base string (e.g., "2", "A") to its integer equivalent.

        int result = 0;

        // For each character, convert it to a digit in the given base, and update the result.
            for (char c : number.toCharArray()) {
                int digit = Character.digit(c, base);
                result = result * base + digit;
            }

            return result;
        }

    /**
     * Validates whether a given string is a correctly formatted base-represented number.
     * This function checks if the string has the correct format (contains "b" and valid base suffix),
     * and ensures that all characters in the number portion are valid digits for the specified base.
     * @param a a String to validate.
     * @return true if the string is in valid number format, false otherwise.
     */
    public static boolean isNumber(String a) {

            if (a == null || a.isEmpty())
                return false;

            if (a.startsWith(" ") || a.endsWith(" "))
                return false;

            if (!a.contains("b")) {       // If no "b" is present, ensure all characters are digits.

                for (char c : a.toCharArray()) {
                    if (!Character.isDigit(c))    // Return false if any character is not a digit.
                        return false;
                }
                return true;
            }

            String[] parts = a.split("b");

            if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty())
                return false;

            String number = parts[0];
            String baseStr = parts[1];

        if (!number.equals(number.toUpperCase()) || !baseStr.equals(baseStr.toUpperCase()))    //Ensure the input strings are uppercase.

            return false;

            if (!isNumberBaseValid(baseStr))     // Ensure it represents a valid base using the helper function `isNumberBaseValid`.

                return false;

            int base = baseToInt(baseStr);
            if (base < 2 || base > 16)
                return false;

            for (char c : number.toCharArray()) {
                if (Character.digit(c, base) == -1)
                    return false;
            }

            return true;
        }


    /**
     * Converts a decimal integer to its String representation in a specified base.
     * This function uses Java's built-in `Integer.toString` for conversion, then appends the base
     * suffix (e.g., "b2", "bA") for non-decimal bases. It handles invalid inputs by returning an empty string.
     * @param num the integer to convert.
     * @param base the target base [2,16].
     * @return a String representation of the number in the target base, or "" if invalid.
     */
    public static String int2Number(int num, int base) {

            if (num < 0 || base < 2 || base > 16)
                return "";

            String result = Integer.toString(num, base).toUpperCase();

            if (base == 10)
                return result;

            return result + "b" + baseToChar(base);

    }

    /**
     * Compares two base-represented number strings to check if they are equal in value.
     * This function converts both strings to their decimal equivalents using `number2Int`
     * and compares the resulting values. Invalid inputs return false.
     * @param n1 the first number as a String.
     * @param n2 the second number as a String.
     * @return true if the numbers are equal, false otherwise.
     */

    public static boolean equals(String n1, String n2) {

            if (!isNumber(n1) || !isNumber(n2)) {
                return false;
            }

            return number2Int(n1) == number2Int(n2);

    }

    /**
     * Finds the index of the largest number (by value) in an array of number strings.
     * Internally, it iterates over the array, converting each valid number string
     * to its decimal value and keeping track of the maximum value and its index.
     * Invalid numbers are ignored.
     * @param arr an array of number strings.
     * @return the index of the largest number in the array, or -1 if all are invalid.
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

    /**
     * This static function checks if the given string represents a valid number base.
     * A valid base is represented by either:
     * - A single digit ('0' to '9')
     * - A single uppercase letter ('A' to 'G'), where letters correspond to bases 10 to 16.
     * Assumes the input string is not null.
     * @param baseStr a string representing the base
     * @return true if the string is a valid base, false otherwise
     */

    public static boolean isNumberBaseValid(String baseStr) {
            if (baseStr.length() == 1) {
                char c = baseStr.charAt(0);
                return Character.isDigit(c) || (c >= 'A' && c <= 'G');
            }
            return false;
        }

    /**
     * This static function converts a valid base string to its integer value.
     * The base string must represent:
     * A single digit ('0' to '9') which is converted to its numeric value.
     * A single uppercase letter ('A' to 'G'), where 'A' corresponds to 10, 'B' to 11, and so on.
     * Note: Assumes the input string is valid and contains one character.
     * @param baseStr a string representing the base
     * @return the integer value of the base (e.g., "A" -> 10, "5" -> 5)
     */

        public static int baseToInt(String baseStr) {
                if (Character.isDigit(baseStr.charAt(0))) {
                    return Integer.parseInt(baseStr);
                } else {
                    return 10 + (baseStr.charAt(0) - 'A');
                }
            }

    /**
     * This static function converts an integer base value to its character representation.
     * For bases 0 to 9, the result is the corresponding digit ('0' to '9').
     * For bases 10 to 16, the result is the corresponding uppercase letter ('A' to 'G').
     * Note: Assumes the input integer is within the valid base range (0 to 16).
     * @param base an integer representing the base
     * @return the character representation of the base ( 10 -> 'A', 5 -> '5')
     */
            public static char baseToChar(int base) {
        if (base <= 9) return (char) ('0' + base);
        return (char) ('A' + (base - 10));
    }
}