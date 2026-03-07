class Solution {
    public boolean checkOnesSegment(String s) {
        // If "01" is not in the string, there's only one segment of 1s (at the start).
        return !s.contains("01");
    }
}
