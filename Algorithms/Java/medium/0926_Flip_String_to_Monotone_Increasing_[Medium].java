/**
 * 926. Flip String to Monotone Increasing
 *
 * A string of '0's and '1's is monotone increasing if it consists of some number of '0's (possibly 0), followed by some number of '1's (also possibly 0.)
 *
 * We are given a string S of '0's and '1's, and we may flip any '0' to a '1' or a '1' to a '0'.
 *
 * Return the minimum number of flips to make S monotone increasing.
 *
 *
 *
 * Example 1:
 *
 * Input: "00110"
 * Output: 1
 * Explanation: We flip the last digit to get 00111.
 *
 * Example 2:
 *
 * Input: "010110"
 * Output: 2
 * Explanation: We flip to get 011111, or alternatively 000111.
 *
 * Example 3:
 *
 * Input: "00011000"
 * Output: 2
 * Explanation: We flip to get 00000000.
 *
 *
 * Note:
 *
 * 1 <= S.length <= 20000
 * S only consists of '0' and '1' characters.
 */
public class FlipStringToMonotoneIncreasing {

    /**
     * P[i] 为 0 到 i 之间有多少个 1
     * 对于每一个 i
     *  left: P[i] 个 1 要反转为 0
     *  right: P[N] - P[i] 个 1，(N - i) - (P[N] - P[i]) 个 0 反转为 1
     * ans = min(P[i] + ((N - i) - (P[N] - P[i])))
     */
    public int minFlipsMonoIncr(String S) {
        int N = S.length();
        int[] P = new int[N + 1];
        for (int i = 0; i < N; i++) {
            P[i + 1] = P[i] + (S.charAt(i) == '1' ? 1 : 0);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= N; i++) {
            ans = Math.min(ans, P[i] + (N - i) - (P[N] - P[i]));
        }
        return ans;
    }

}
