/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        // Step 1: Find the peak of the mountain
        int left = 0, right = n - 1;
        int peak = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);

            if (mid > 0 && mid < n - 1) {
                int prev = mountainArr.get(mid - 1);
                int next = mountainArr.get(mid + 1);
                if (midVal > prev && midVal > next) {
                    peak = mid;
                    break;
                } else if (midVal > prev) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (mid == 0 || mid == n - 1) {
                peak = mid;
                break;
            }
        }

        // Step 2: Perform binary search on the left part (increasing order)
        int res = binarySearch(mountainArr, 0, peak, target, true);
        if (res != -1)
            return res;

        // Step 3: Perform binary search on the right part (decreasing order)
        return binarySearch(mountainArr, peak + 1, n - 1, target, false);
    }

    private int binarySearch(MountainArray mountainArr, int left, int right, int target, boolean increasing) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);

            if (midVal == target) {
                return mid;
            }

            if (increasing) {
                if (midVal < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (midVal > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
