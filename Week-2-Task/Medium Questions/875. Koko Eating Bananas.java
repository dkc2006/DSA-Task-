class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Integer.MIN_VALUE;

        // Finding Max
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > end) {
                end = piles[i];
            }
        }

        int ans = -1;

        // Apply binary search on the possible value of k -> (1, max(piles))
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isEatingSpeedValid(piles, mid, h)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    // Helper method to check if a given eating speed is valid
    private boolean isEatingSpeedValid(int[] piles, int eatingSpeed, int hours) {
        int hoursSpent = 0;
        for (int i = 0; i < piles.length; i++) {
            hoursSpent += Math.ceil((double) piles[i] / eatingSpeed);
            if (hoursSpent > hours)
                return false;
        }
        return true;
    }
}
