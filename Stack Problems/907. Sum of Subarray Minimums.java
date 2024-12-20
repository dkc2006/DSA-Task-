import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;
        int n = arr.length;
        long result = 0;

        // Monotonic stack to store indices
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            int curr = (i < n) ? arr[i] : 0;

            while (!stack.isEmpty() && arr[stack.peek()] > curr) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;
                long count = (long) (mid - left) * (right - mid);
                result = (result + arr[mid] * count) % MOD;
            }

            stack.push(i);
        }

        return (int) result;
    }
}
