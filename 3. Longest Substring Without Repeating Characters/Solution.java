import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int result = 0; 
        int j = 0;

        Map<Character, Integer> mapper = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);
            if (mapper.containsKey(currentChar)) {
                j = Math.max(j, mapper.get(currentChar) + 1);
            }
            result = Math.max(result, i - j + 1);
            mapper.put(currentChar, i);
        }
        return result;
    }
}
