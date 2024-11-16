class Solution {
    public int splitArray(int[] nums, int k) {
        // Step 1: Calculate the range for binary search
        int low = 0, high = 0;
        for (int num : nums) {
            low = Math.max(low, num); // The minimum possible max sum is the largest element
            high += num; // The maximum possible max sum is the total sum of the array
        }

        // Step 2: Binary search on the result
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canSplit(nums, mid, k)) {
                high = mid; // If we can split, try for a smaller max sum
            } else {
                low = mid + 1; // Otherwise, we need a larger max sum
            }
        }

        return low; // The smallest valid max sum is found here
    }

    // Helper function to check if we can split the array with max sum <= maxSum
    private boolean canSplit(int[] nums, int maxSum, int k) {
        int currentSum = 0;
        int count = 1; // At least one subarray
        for (int num : nums) {
            if (currentSum + num > maxSum) {
                count++; // We need a new subarray
                currentSum = num; // Start a new subarray with the current number
                if (count > k) {
                    return false; // Too many subarrays, not possible
                }
            } else {
                currentSum += num; // Continue adding to the current subarray
            }
        }
        return true; // If we can split into <= k subarrays
    }
}
