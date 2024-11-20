import java.util.*;

class Solution {
    public String frequencySort(String s) {
        // Count frequencies of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Sort characters by frequency
        List<Character> chars = new ArrayList<>(freqMap.keySet());
        chars.sort((a, b) -> freqMap.get(b) - freqMap.get(a)); // Descending order

        // Build the result string
        StringBuilder result = new StringBuilder();
        for (char ch : chars) {
            int count = freqMap.get(ch);
            result.append(String.valueOf(ch).repeat(count));
        }

        return result.toString();
    }
}
