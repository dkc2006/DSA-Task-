class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int ans = 0;

        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) { // peak of the mountain
                int j = i;
                int count = 1; // Start with 1 to count the peak element itself

                // Count the left side of the mountain
                while (j > 0 && arr[j] > arr[j - 1]) {
                    j--;
                    count++;
                }

                // Count the right side of the mountain
                while (i < n - 1 && arr[i] > arr[i + 1]) {
                    i++;
                    count++;
                }

                ans = Math.max(count, ans); // Update the maximum length
            }
        }
        return ans;
    }
}
