# Ex1 - Number Formatting Converter and Calculator

## Overview
This project provides a solution for converting and performing calculations on numbers in various bases (from binary to hexadecimal). It supports converting numbers between different bases, performing arithmetic operations, validating the input format, and comparing numbers. The implementation handles numbers as strings to ensure compatibility with different bases.

## Features
- **Base Conversion**: Convert numbers from any base between 2 (binary) and 16 (hexadecimal) to decimal and vice versa.
- **Validation**: Ensure inputs are properly formatted and represent valid numbers in their respective bases.
- **Arithmetic Operations**: Perform addition and multiplication of numbers in any base.
- **Maximum Value Detection**: Find the largest number from an array of base-represented numbers.

## Input Format
The numbers should be represented as strings in the following format:
Where:
- `<number>` is the value written in the specified base.
- `<base>` is a single digit (`2`-`9`) or a single letter (`A`-`G`) representing bases 10 
to 16.

Examples of valid numbers:
- `101b2` (binary representation of 5)
- `1AbG` (base 16 representation of 26)

Invalid examples:
- `b2` (missing number)
- `A bG` (contains spaces)

---

## Functions
1. **`number2Int(String num)`**:
   - Converts a base-represented number string to its decimal integer equivalent.
   - 
2. **`isNumber(String a)`**:
   - Validates whether a string is a correctly formatted base-represented number.
   - Returns `true` if valid, `false` otherwise.

3. **`int2Number(int num, int base)`**:
   - Converts a decimal integer to its string representation in a specified base.
   - 
4. **`equals(String n1, String n2)`**:
   - Compares two base-represented numbers for equality, converting both to decimal first.

5. **`maxIndex(String[] arr)`**:
   - Finds the index of the largest number (by value) in an array of base-represented 
     numbers.

6. **`isNumberBaseValid(String baseStr)`**:
   - Checks if the given string represents a valid base (e.g., `2`-`9` or `A`-`G`).

7. **`baseToInt(String baseStr)`**:
   - Converts a valid base string to its integer equivalent.

8. **`baseToChar(int base)`**:
   - Converts an integer base value to its string representation (e.g., `10 -> A`).

**Example**:
Enter a string as number#1 (or "quit" to end the program): 
1DbG
num1= 1DbG is number: true , value: 29
Enter a string as number#2 (or "quit" to end the program): 
AAbB
num2= AAbB is number: true , value: 120
Enter a base for output: (a number [2,16] 
2
1DbG + AAbB = 10010101b2
1DbG * AAbB = 110110011000b2
Max number over [1DbG,AAbB,10010101b2,110110011000b2] is: 110110011000b2


