/**
 * 2537. Count the Number of Good Subarrays
 *
 *
 * Given an integer array nums and an integer k, return the number of good subarrays of nums.
 *
 * A subarray arr is good if it there are at least k pairs of indices (i, j) such that i < j and arr[i] == arr[j].
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,1,1], k = 10
 * Output: 1
 * Explanation: The only good subarray is the array nums itself.
 *
 *
 * Example 2:
 *
 * Input: nums = [3,1,4,3,2,2,4], k = 2
 * Output: 4
 * Explanation: There are 4 different good subarrays:
 * - [3,1,4,3,2,2] that has 2 pairs.
 * - [3,1,4,3,2,2,4] that has 3 pairs.
 * - [1,4,3,2,2,4] that has 2 pairs.
 * - [4,3,2,2,4] that has 2 pairs.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i], k <= 10^9
 */
public class CountTheNumberOfGoodSubarrays {

    public long countGood(int[] nums, int k) {
        long ans = 0;
        int l = 0;
        int pairs = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            pairs += cnt.getOrDefault(num, 0);
            cnt.merge(num, 1, Integer::sum);
            while (pairs - cnt.get(nums[l]) + 1 >= k) {
                pairs -= cnt.merge(nums[l++], -1, Integer::sum);
            }
            if (pairs >= k) {
                ans += l + 1;
            }
        }
        return ans;
    }

}
