package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 290. Word Pattern
 *
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Integer, String> patternMap = new HashMap<>();
        Map<Integer, String> strMAp = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            patternMap.put(i, pattern.substring(i, i + 1));
        }
        List<String> strList = Arrays.asList(str.split(" "));

        if (patternMap.size() != strList.size()) return false;
        String patValue;
        String strValue;
        int j = 0;
        for (Map.Entry<Integer, String> entry : patternMap.entrySet()) {
            j++;
            patValue = entry.getValue();
            strValue = strList.get(entry.getKey());
            for (int i = j; i < strList.size(); i++) {
                if (strValue.equals(strList.get(i))) {
                    if (!patternMap.get(i).equals(patValue)) {
                        return false;
                    }
                } else if (patternMap.get(j-1).equals(patternMap.get(i))) {
                        return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        WordPattern pattern = new WordPattern();
        String pat = "abba";
        String str = "dog cat cat fish";
        pattern.wordPattern(pat, str);
    }
}
