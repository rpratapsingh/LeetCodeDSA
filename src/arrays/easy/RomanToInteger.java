// https://leetcode.com/problems/roman-to-integer/

package arrays.easy;

public class RomanToInteger {
    static int value(char r) {
        if (r == 'I') return 1;
        if (r == 'V') return 5;
        if (r == 'X') return 10;
        if (r == 'L') return 50;
        if (r == 'C') return 100;
        if (r == 'D') return 500;
        if (r == 'M') return 1000;
        return -1;
    }

    public static int romanToInt(String s) {
        char[] charArray = s.toCharArray();
        int integer = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (i + 1 < charArray.length) {
                if (value(charArray[i + 1]) > value(charArray[i])) {
                    integer += (value(charArray[i + 1]) - value(charArray[i]));
                    i++;
                } else {
                    integer += value(charArray[i]);
                }
            } else {
                integer += value(charArray[i]);
            }
        }
        return integer;
    }

    public static void main(String args[]) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }


}
