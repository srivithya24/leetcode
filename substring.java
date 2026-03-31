import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;
        
        // Frequency map of all words we need to find
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        // Check every possible starting offset up to wordLen
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            Map<String, Integer> currentCounts = new HashMap<>();
            int wordsFound = 0;

            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordFreq.containsKey(word)) {
                    currentCounts.put(word, currentCounts.getOrDefault(word, 0) + 1);
                    wordsFound++;

                    // If we have more of a word than needed, shrink the window from the left
                    while (currentCounts.get(word) > wordFreq.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentCounts.put(leftWord, currentCounts.get(leftWord) - 1);
                        wordsFound--;
                        left += wordLen;
                    }

                    // Found a valid permutation
                    if (wordsFound == wordCount) {
                        result.add(left);
                    }
                } else {
                    // Not a valid word, reset the window
                    currentCounts.clear();
                    wordsFound = 0;
                    left = right;
                }
            }
        }
        return result;
    }
}
