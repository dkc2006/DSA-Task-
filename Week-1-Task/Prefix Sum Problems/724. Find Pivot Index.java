class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int left_sum = 0;
        int right_sum = sum;

        for (int i = 0; i < n; i++) {
            right_sum -= nums[i];
            if (right_sum == left_sum) {
                return i;
            }
            left_sum += nums[i];
        }
        return -1;
    }
}