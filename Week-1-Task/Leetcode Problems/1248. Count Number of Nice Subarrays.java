class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            nums[i] %= 2;
        }
        int[] arr = new int[len + 1];

        int sum = 0;
        for (int i : nums) {
            sum += i;
            arr[sum]++;
        }
        int ans = 0;
        arr[0]++;
        for (int i = 0; i + k <= sum; i++) {
            ans += arr[i] * arr[i + k];
        }
        return ans;
    }
}