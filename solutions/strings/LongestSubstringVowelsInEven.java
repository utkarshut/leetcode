package solutions.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringVowelsInEven {


    // need to check aeiou 00000
    // if we see a then toggle 1st bit same for e i o u
    // we store prefix bitmask and index in map
    // if we see same bitmask again we can calculate length from previous index to
    // current index
    // calculation of bitmask is done using xor operation e.g. 00000 ^ 00001 = 00001
    // 00001 ^ 00001 = 00000
    public int  LongestSubstringVowelsInEvenCount(String s) {
        int res = 0;
        int bitmask = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                bitmask ^= (1 << 0);
            } else if (s.charAt(i) == 'e') {
                bitmask ^= (1 << 1);
            } else if (s.charAt(i) == 'i') {
                bitmask ^= (1 << 2);
            } else if (s.charAt(i) == 'o') {
                bitmask ^= (1 << 3);
            } else if (s.charAt(i) == 'u') {
                bitmask ^= (1 << 4);
            }
            if (bitmask == 0) {
                res = i + 1;
            } else if (map.containsKey(bitmask)) {
                res = Math.max(res, i - map.get(bitmask));
            } else {
                map.put(bitmask, i);
            }
        }
        System.out.println(res);
        return res;
    }
    public static void main(String[] args) {
        LongestSubstringVowelsInEven solution = new LongestSubstringVowelsInEven();
        String s = "eleetminicoworoep";
        solution.LongestSubstringVowelsInEvenCount(s);
        System.out.println("Longest substring with vowels in even count: " + solution.LongestSubstringVowelsInEvenCount(s));
    }
}
