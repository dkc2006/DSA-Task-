class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sMapping = new int[256];
        int[] tMapping = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (sMapping[charS] != tMapping[charT]) {
                return false;
            }
            sMapping[charS] = i + 1;
            tMapping[charT] = i + 1;
        }
        return true;
    }
}
