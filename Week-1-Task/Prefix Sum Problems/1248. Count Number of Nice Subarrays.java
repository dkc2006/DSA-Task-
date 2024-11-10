// import java.util.HashMap;
// import java.util.Map;

// class Solution {
//     public int numberOfSubarrays(int[] nums, int k) {
//         int res = 0;
//         int curr = 0;
//         Map<Integer, Integer> map = new HashMap<>();
//         map.put(0, 1);

//         for (int i : nums) {
//             curr += i % 2;
//             res += map.getOrDefault(curr - k, 0);
//             map.put(curr, map.getOrDefault(curr, 0) + 1);
//         }

//         return res;
//     }
// }

//OR

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            nums[i] %= 2;
        }
        int[] arr = new int[len + 1];

        int sum = 0;
        for (int i : nums) {
            sum += i;
            arr[sum]++;
        }
        int ans = 0;
        arr[0]++;
        for (int i = 0; i + k <= sum; i++) {
            ans += arr[i] * arr[i + k];
        }
        return ans;
    }
}