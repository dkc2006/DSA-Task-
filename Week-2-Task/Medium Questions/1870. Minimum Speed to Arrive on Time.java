class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        // Edge case: If hour is less than the number of distances, return -1
        if (hour <= dist.length - 1) {
            return -1;
        }

        int left = 1, right = Integer.MAX_VALUE;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            double timeSpent = 0;

            // Calculate total time with the current speed 'mid'
            for (int i = 0; i < dist.length; i++) {
                if (i == dist.length - 1) {
                    timeSpent += (double) dist[i] / mid;
                } else {
                    timeSpent += Math.ceil((double) dist[i] / mid); // Round up for non-final distances
                }
            }

            // If the total time is less than or equal to the given hour, try a smaller
            // speed
            if (timeSpent <= hour) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}
