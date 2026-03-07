public class Solution {
    public int minOperations(String s) {
        int count0 = 0; // Mismatches for pattern starting with '0' (0101...)
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            // Check if current character matches the '0101...' pattern
            // Even index should be '0', odd index should be '1'
            if (i % 2 == 0) {
                if (s.charAt(i) == '1') count0++;
            } else {
                if (s.charAt(i) == '0') count0++;
            }
        }
        
        // The other pattern (1010...) will have (n - count0) mismatches
        return Math.min(count0, n - count0);
    }
}
