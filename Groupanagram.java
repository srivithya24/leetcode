import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to store sorted string as key and list of anagrams as value
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // 1. Convert string to character array and sort it
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            
            // 2. Use the sorted characters as a key
            String sortedKey = new String(chars);
            
            // 3. Add the original string to the corresponding group
            if (!map.containsKey(sortedKey)) {
                map.put(sortedKey, new ArrayList<>());
            }
            map.get(sortedKey).add(s);
        }
        
        // Return all the groups as a List of Lists
        return new ArrayList<>(map.values());
    }
}
