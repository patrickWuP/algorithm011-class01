class Solution_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] dic = new int[26];
        for (char c : s.toCharArray()) {
            dic[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            dic[c - 'a']--;
            if (dic[c - 'a'] < 0) return false;
        }
        return true;
    }
}