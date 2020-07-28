/**
 * 1446. Consecutive Characters
 *
 * Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.
 *
 * Return the power of the string.
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 2
 * Explanation: The substring "ee" is of length 2 with the character 'e' only.
 *
 * Example 2:
 *
 * Input: s = "abbcccddddeeeeedcba"
 * Output: 5
 * Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
 *
 * Example 3:
 *
 * Input: s = "triplepillooooow"
 * Output: 5
 *
 * Example 4:
 *
 * Input: s = "hooraaaaaaaaaaay"
 * Output: 11
 *
 * Example 5:
 *
 * Input: s = "tourist"
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 500
 * s contains only lowercase English letters.
 */
public class ConsecutiveCharacters {

    public int maxPower(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int ans = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int curr = 1;
            while ((i + 1) < chars.length && chars[i] == chars[i + 1]) {
                curr++;
                i++;
            }
            if (curr > ans) {
                ans = curr;
            }
        }
        return ans;
    }

}
