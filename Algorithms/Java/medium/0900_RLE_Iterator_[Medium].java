/**
 * 900. RLE Iterator
 *
 *
 * We can use run-length encoding (i.e., RLE) to encode a sequence of integers. In a run-length encoded array of even length encoding (0-indexed), for all even i, encoding[i] tells us the number of times that the non-negative integer value encoding[i + 1] is repeated in the sequence.
 *
 * For example, the sequence arr = [8,8,8,5,5] can be encoded to be encoding = [3,8,2,5]. encoding = [3,8,0,9,2,5] and encoding = [2,8,1,8,2,5] are also valid RLE of arr.
 * Given a run-length encoded array, design an iterator that iterates through it.
 *
 * Implement the RLEIterator class:
 *
 * RLEIterator(int[] encoded) Initializes the object with the encoded array encoded.
 * int next(int n) Exhausts the next n elements and returns the last element exhausted in this way. If there is no element left to exhaust, return -1 instead.
 *
 *
 * Example 1:
 *
 * Input
 * ["RLEIterator", "next", "next", "next", "next"]
 * [[[3, 8, 0, 9, 2, 5]], [2], [1], [1], [2]]
 * Output
 * [null, 8, 8, 5, -1]
 *
 * Explanation
 * RLEIterator rLEIterator = new RLEIterator([3, 8, 0, 9, 2, 5]); // This maps to the sequence [8,8,8,5,5].
 * rLEIterator.next(2); // exhausts 2 terms of the sequence, returning 8. The remaining sequence is now [8, 5, 5].
 * rLEIterator.next(1); // exhausts 1 term of the sequence, returning 8. The remaining sequence is now [5, 5].
 * rLEIterator.next(1); // exhausts 1 term of the sequence, returning 5. The remaining sequence is now [5].
 * rLEIterator.next(2); // exhausts 2 terms, returning -1. This is because the first term exhausted was 5,
 * but the second term did not exist. Since the last term exhausted does not exist, we return -1.
 *
 *
 * Constraints:
 *
 * 1. 2 <= encoding.length <= 1000
 * 2. encoding.length is even.
 * 3. 0 <= encoding[i] <= 10^9
 * 4. 1 <= n <= 10^9
 * 5. At most 1000 calls will be made to next.
 */
public class RLEIterator {

    private int[] encoding;
    private int i;

    public RLEIterator(int[] encoding) {
        this.i = 0;
        this.encoding = encoding;
    }

    public int next(int n) {
        while (n > 0 && i < encoding.length / 2) {
            if (encoding[2 * i] == 0) {
                i++;
            }
            if (n > encoding[2 * i]) {
                n -= encoding[2 * i];
                i++;
            } else {
                encoding[2 * i] -= n;
                return encoding[2 * i + 1];
            }
        }
        return -1;
    }


    /*private int idx;
    private final int[] encoding;
    private final int len;

    public RLEIterator(int[] A) {
        this.idx = 0;
        this.encoding = A;
        this.len = A.length;
    }

    public int next(int n) {
        if (idx >= len) {
            return -1;
        }
        for (int i = idx; i < len; i += 2) {
            if (encoding[i] == n) {
                idx = i + 2;
                return encoding[i + 1];
            } else if (encoding[i] > n) {
                encoding[i] -= n;
                idx = i;
                return encoding[i + 1];
            } else {
                idx = i + 2;
                n -= encoding[i];
            }
        }
        return -1;
    }*/



    /*private final TreeMap<Long, Integer> treeMap;
    private long cost;

    public RLEIterator(int[] encoding) {
        this.cost = 0;
        this.treeMap = new TreeMap<>();
        long sum = 0;
        for (int i = 0; i < encoding.length; i += 2) {
            if (encoding[i] > 0) {
                sum += encoding[i];
                treeMap.put(sum, encoding[i + 1]);
            }
        }
    }

    public int next(int n) {
        cost += n;
        Map.Entry<Long, Integer> entry = treeMap.ceilingEntry(cost);
        if (entry == null) {
            return -1;
        }
        return entry.getValue();
    }*/


}
