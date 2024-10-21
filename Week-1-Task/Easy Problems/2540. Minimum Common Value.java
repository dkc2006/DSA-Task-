class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int n = nums1.length;
        int m = nums2.length;

        // Loop while both pointers are within the bounds of the arrays
        while (i < n && j < m) {
            if (nums1[i] == nums2[j]) {
                return nums1[i]; // Common element found
            }
            if (nums1[i] < nums2[j]) {
                i++; // Increment i if nums1's element is smaller
            } else {
                j++; // Increment j if nums2's element is smaller
            }
        }
        return -1; // Return -1 if no common element is found
    }
}
