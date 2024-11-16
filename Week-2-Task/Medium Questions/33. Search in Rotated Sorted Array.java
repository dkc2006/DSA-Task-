class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}

// OR

// class Solution {
// public int search(int[] nums, int target) {
// int left = 0, right = nums.length - 1;

// while (left <= right) {
// int mid = left + (right - left) / 2;

// if (nums[mid] == target) {
// return mid;
// }
// if (nums[left] <= nums[mid]) { // Left half is sorted
// if (target >= nums[left] && target < nums[mid]) {
// right = mid - 1; // Target is in the left half
// } else {
// left = mid + 1; // Target is in the right half
// }
// } else { // Right half is sorted
// if (target > nums[mid] && target <= nums[right]) {
// left = mid + 1; // Target is in the right half
// } else {
// right = mid - 1; // Target is in the left half
// }
// }
// }

// return -1; // Target not found
// }
// }
