package ex1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v,11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v,2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v,v2);
        assertTrue(Ex1.equals(s10,s2));
    }

    @Test
    void isBasisNumberTest() {
       String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA","0","1DbG","AAbB","0b2"};
        for(int i=0;i<good.length;i=i+1) {
           boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
       String[] not_good = {"b2", "2b2", "1G3bG", "0bbA", "!@b2", "A", "1bb2", " BbG", "abB","1b"};
         for(int i=0;i<not_good.length;i=i+1) {
          boolean not_ok = Ex1.isNumber(not_good[i]);
           assertFalse(not_ok);
        }
    }
    @Test
    void int2NumberTest() {
        assertEquals("11b2", Ex1.int2Number(3, 2));
        assertEquals("11", Ex1.int2Number(11, 10));
        assertEquals("123", Ex1.int2Number(123, 10));
        assertEquals("", Ex1.int2Number(-1, 16));
        assertEquals("", Ex1.int2Number(123, 20));
        assertEquals("1AFbG", Ex1.int2Number(431, 16));
    }
    @Test
    void maxIndexTest() {
        String[] arr1 = {"1", "0","1","0"};
        assertEquals(0, Ex1.maxIndex(arr1));
        String[] arr2 = {"b2", "abc", "GbG", null, ""};
        assertEquals(-1, Ex1.maxIndex(arr2));
        String[] arr3 = {"1001b2","11b3","13","36"};
        assertEquals(3, Ex1.maxIndex(arr3));
        String[] arr4 = {"1DbG","AAbB","10010101b2","110110011000b2"};
        assertEquals(3, Ex1.maxIndex(arr4));

    }

    @Test
    void equalsTest() {
        assertTrue(Ex1.equals("0b2", "0"));
        assertFalse(Ex1.equals("123b10", null));
        assertFalse(Ex1.equals("invalid", "123b10"));
        assertTrue(Ex1.equals("10011b2", "19"));
        assertTrue(Ex1.equals("1", "1"));
        assertTrue(Ex1.equals("AAbB", "120"));
        assertFalse(Ex1.equals("AAbB  ", "120"));

    }
    @Test
    void isNumberBaseValidTest() {
        assertTrue(Ex1.isNumberBaseValid("A")); // Base 10
        assertTrue(Ex1.isNumberBaseValid("2")); // Base 2
        assertFalse(Ex1.isNumberBaseValid("H")); // Invalid base
        assertFalse(Ex1.isNumberBaseValid("20")); // Invalid base (length > 1)
    }

    @Test
    void baseToIntTest() {
        assertEquals(10, Ex1.baseToInt("A"));  // Base 10
        assertEquals(2, Ex1.baseToInt("2"));   // Base 2
        assertEquals(16, Ex1.baseToInt("G"));  // Base 16
    }

    @Test
    void baseToCharTest() {
        assertEquals('A', Ex1.baseToChar(10)); // Base 10
        assertEquals('G', Ex1.baseToChar(16)); // Base 16
        assertEquals('2', Ex1.baseToChar(2));  // Base 2
    }


}