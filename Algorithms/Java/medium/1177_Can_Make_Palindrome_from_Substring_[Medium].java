/**
 * 1177. Can Make Palindrome from Substring
 *
 *
 * You are given a string s and array queries where queries[i] = [lefti, righti, ki]. We may rearrange the substring s[lefti...righti] for each query and then choose up to ki of them to replace with any lowercase English letter.
 *
 * If the substring is possible to be a palindrome string after the operations above, the result of the query is true. Otherwise, the result is false.
 *
 * Return a boolean array answer where answer[i] is the result of the ith query queries[i].
 *
 * Note that each letter is counted individually for replacement, so if, for example s[lefti...righti] = "aaa", and ki = 2, we can only replace two of the letters. Also, note that no query modifies the initial string s.
 *
 *
 *
 * Example :
 *
 * Input: s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
 * Output: [true,false,false,true,true]
 * Explanation:
 * queries[0]: substring = "d", is palidrome.
 * queries[1]: substring = "bc", is not palidrome.
 * queries[2]: substring = "abcd", is not palidrome after replacing only 1 character.
 * queries[3]: substring = "abcd", could be changed to "abba" which is palidrome. Also this can be changed to "baab" first rearrange it "bacd" then replace "cd" with "ab".
 * queries[4]: substring = "abcda", could be changed to "abcba" which is palidrome.
 *
 *
 * Example 2:
 *
 * Input: s = "lyb", queries = [[0,1,0],[2,2,1]]
 * Output: [false,true]
 *
 *
 * Constraints:
 *
 * 1. 1 <= s.length, queries.length <= 10^5
 * 2. 0 <= lefti <= righti < s.length
 * 3. 0 <= ki <= s.length
 * 4. s consists of lowercase English letters.
 */
public class CanMakePalindromeFromSubstring {


    // 直接记录字母的奇偶性
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[] status = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            status[i] = status[i - 1] ^ (1 << (s.charAt(i - 1) - 'a'));
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            int flag = status[query[1] + 1] ^ status[query[0]];
            int odd = Integer.bitCount(flag);
            ans.add(odd <= 2 * query[2] + 1);
        }
        return ans;
    }


    // 可以重排序则只需要考虑出现奇数次的字母有几个
    public List<Boolean> canMakePaliQueries1(String s, int[][] queries) {
        List<int[]> cntList = new ArrayList<>();
        cntList.add(new int[26]);
        for (int i = 1; i <= s.length(); i++) {
            int[] cnt = new int[26];
            System.arraycopy(cntList.get(i - 1), 0, cnt, 0, 26);
            cnt[s.charAt(i - 1) - 'a']++;
            cntList.add(cnt);
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            int l = query[0], r = query[1], k = query[2];
            if (l == r) {
                ans.add(true);
                continue;
            }
            int[] cntLeft = cntList.get(l);
            int[] cntRight = cntList.get(r + 1);
            int odd = 0;
            for (int i = 0; i < 26; i++) {
                odd += (cntRight[i] - cntLeft[i]) % 2;
            }
            ans.add(odd <= 2 * k + 1);
        }
        return ans;
    }

}
