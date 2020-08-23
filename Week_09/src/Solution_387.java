class Solution_387 {
    public int firstUniqChar(String s) {
        int[] dp = new int[26];
        char[] data = s.toCharArray();
        for (char c : data) {
            dp[c - 'a']++;
        }

        for (int i = 0; i < data.length; i++) {
            if (dp[data[i] - 'a'] == 1) return i;
        }
        return -1;
    }
}