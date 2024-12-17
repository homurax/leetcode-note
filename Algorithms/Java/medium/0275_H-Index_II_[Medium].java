/**
 * 275. H-Index II
 *
 *
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper and citations is sorted in ascending order, return the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
 *
 * You must write an algorithm that runs in logarithmic time.
 *
 *
 *
 * Example 1:
 *
 * Input: citations = [0,1,3,5,6]
 * Output: 3
 * Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had received 0, 1, 3, 5, 6 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
 *
 *
 * Example 2:
 *
 * Input: citations = [1,2,100]
 * Output: 2
 *
 *
 * Constraints:
 *
 * n == citations.length
 * 1 <= n <= 10^5
 * 0 <= citations[i] <= 1000
 * citations is sorted in ascending order.
 */
public class HIndexII {

    // 必定有 0 篇引用次数为 0 的
    // 二分范围可以从 1 开始
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 1, r = n;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (citations[n - mid] >= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

}
