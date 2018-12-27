package main.java;

import java.util.HashMap;
import java.util.Map;

/**
 * 409
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes
 * that can be built with those letters.
 *
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<String, Integer> map = new HashMap<>();
        int palindromeLength = 0;
        boolean addFlag = true;

        int value;
        for (int i = 0; i < s.length(); i++) {
            String subStr = s.substring(i, i +1);
            if (map.containsKey(subStr)) {
                value = map.get(subStr);
                map.put(subStr, value + 1);
            } else {
                map.put(subStr, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int odevity = entry.getValue() % 2;
            if (addFlag && odevity == 1) {
                palindromeLength += 1;
                addFlag = false;
            }
            if (odevity == 0) {
                palindromeLength += entry.getValue();
            } else {
                palindromeLength += (entry.getValue() - 1);
            }
        }
        return palindromeLength;
    }

    public static void main(String[] args) {
        LongestPalindrome palindrome = new LongestPalindrome();
        int a = palindrome.longestPalindrome("abccccdd");
        System.out.println(a);
    }
}
