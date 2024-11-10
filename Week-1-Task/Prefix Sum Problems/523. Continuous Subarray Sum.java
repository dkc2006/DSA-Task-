import java.util.HashMap;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Initialize with sum 0 at index -1
        int sum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            // Handle division by zero (k == 0) separately
            int remainder = (k != 0) ? sum % k : sum;

            if (map.containsKey(remainder)) {
                int index = map.get(remainder);
                // Check if the subarray length is at least 2
                if (i - index >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}
