class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;

        // 1. Skip any trailing spaces at the end
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // 2. Count characters until we hit another space or the start
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}
