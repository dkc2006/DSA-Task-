import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0, ans = 0;
        for (int i : g) {
            while (j < s.length && s[j] < i) {
                j++;
            }
            if (j == s.length)
                return ans;
            else {
                j++;
                ans++;
            }
        }
        return ans;

    }
}