import java.util.*;

class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();
        int initialZeros = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') initialZeros++;
        }

        if (initialZeros == 0) return 0;

        // Sets to keep track of unvisited counts by parity
        TreeSet<Integer> evenUnvisited = new TreeSet<>();
        TreeSet<Integer> oddUnvisited = new TreeSet<>();

        for (int i = 0; i <= n; i++) {
            if (i == initialZeros) continue;
            if (i % 2 == 0) evenUnvisited.add(i);
            else oddUnvisited.add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(initialZeros);
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[initialZeros] = 0;

        while (!queue.isEmpty()) {
            int z = queue.poll();
            
            // Calculate the range [low, high] for next zero count
            // x is the number of zeros we flip (0 <= x <= k)
            // x <= z (can't flip more zeros than we have)
            // k - x <= n - z (can't flip more ones than we have)
            int minX = Math.max(0, k - (n - z));
            int maxX = Math.min(k, z);

            int low = z + k - 2 * maxX;
            int high = z + k - 2 * minX;

            // Determine which set to search based on parity of the range
            TreeSet<Integer> targetSet = (low % 2 == 0) ? evenUnvisited : oddUnvisited;

            // Find all unvisited states in [low, high]
            Integer nextZ = targetSet.ceiling(low);
            while (nextZ != null && nextZ <= high) {
                dist[nextZ] = dist[z] + 1;
                if (nextZ == 0) return dist[nextZ];
                
                queue.add(nextZ);
                // Remove from set so we never visit this count again
                targetSet.remove(nextZ);
                
                // Get the next available unvisited state in the range
                nextZ = targetSet.ceiling(low);
            }
        }

        return -1;
    }
}
