public class Solution {
    public int minFlips(String s) {
        int n = s.length();
        // Concatenate s with itself to simulate all cyclic shifts
        String doubled = s + s;
        
        // Target patterns: '0101...' and '1010...'
        char[] target1 = new char[2 * n];
        char[] target2 = new char[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            target1[i] = (i % 2 == 0) ? '0' : '1';
            target2[i] = (i % 2 == 0) ? '1' : '0';
        }

        int minFlips = Integer.MAX_VALUE;
        int diff1 = 0, diff2 = 0;
        int left = 0;

        for (int right = 0; right < 2 * n; right++) {
            // Add cost for new character entering the window
            if (doubled.charAt(right) != target1[right]) diff1++;
            if (doubled.charAt(right) != target2[right]) diff2++;

            // If window size exceeds n, remove the character leaving the window
            if (right - left + 1 > n) {
                if (doubled.charAt(left) != target1[left]) diff1--;
                if (doubled.charAt(left) != target2[left]) diff2--;
                left++;
            }

            // Once window is exactly size n, track the minimum flips
            if (right - left + 1 == n) {
                minFlips = Math.min(minFlips, Math.min(diff1, diff2));
            }
        }
        return minFlips;
    }
}
