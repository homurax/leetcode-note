/**
 * 762. Prime Number of Set Bits in Binary Representation
 *
 * Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a prime number of set bits in their binary representation.
 *
 * (Recall that the number of set bits an integer has is the number of 1s present when written in binary. For example, 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)
 *
 * Example 1:
 *
 * Input: L = 6, R = 10
 * Output: 4
 * Explanation:
 * 6 -> 110 (2 set bits, 2 is prime)
 * 7 -> 111 (3 set bits, 3 is prime)
 * 9 -> 1001 (2 set bits , 2 is prime)
 * 10->1010 (2 set bits , 2 is prime)
 *
 * Example 2:
 *
 * Input: L = 10, R = 15
 * Output: 5
 * Explanation:
 * 10 -> 1010 (2 set bits, 2 is prime)
 * 11 -> 1011 (3 set bits, 3 is prime)
 * 12 -> 1100 (2 set bits, 2 is prime)
 * 13 -> 1101 (3 set bits, 3 is prime)
 * 14 -> 1110 (3 set bits, 3 is prime)
 * 15 -> 1111 (4 set bits, 4 is not prime)
 * Note:
 *
 * L, R will be integers L <= R in the range [1, 10^6].
 * R - L will be at most 10000.
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {

    /**
     * 计算置位位数方式就是题目461
     * 这里直接使用 {@link Integer#bitCount(int)}
     */
    public int countPrimeSetBits(int L, int R) {

        int sum = 0;
        for (int i = L; i <= R; i++) {
            sum += isPrimeNumber(Integer.bitCount(i));
        }
        return sum;
    }

    private int isPrimeNumber(int num) {

        if (num == 1) {
            return 0;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return 0;
            }
        }

        return 1;
    }

    public int countPrimeSetBits2(int L, int R) {
        int ans = 0;
        for (int i = L; i <= R; i++) {
            if (isSmallPrime(Integer.bitCount(i))) {
                ans++;
            }
        }

        return ans;
    }

    private boolean isSmallPrime(int x) {
        return (x == 2 || x == 3 || x == 5 || x == 7 ||
                x == 11 || x == 13 || x == 17 || x == 19);
    }
}
