class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Find the row with the maximum element in the middle column
            int maxRow = 0;
            for (int i = 1; i < m; i++) {
                if (mat[i][mid] > mat[maxRow][mid]) {
                    maxRow = i;
                }
            }

            // Check if the middle element is a peak
            if ((mid == 0 || mat[maxRow][mid] > mat[maxRow][mid - 1]) &&
                    (mid == n - 1 || mat[maxRow][mid] > mat[maxRow][mid + 1])) {
                return new int[] { maxRow, mid };
            }

            // If the element to the left is greater, search the left half
            if (mid > 0 && mat[maxRow][mid - 1] > mat[maxRow][mid]) {
                right = mid - 1;
            } else { // Otherwise, search the right half
                left = mid + 1;
            }
        }

        return new int[] { -1, -1 }; // This should never be reached if there's a peak
    }
}
