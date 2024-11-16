class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int start = -1;
        int end = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                if (start == -1) {
                    start = i;
                }
                end = i;
            }
        }

        return new int[] { start, end };
    }
}
