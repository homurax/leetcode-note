/**
 * 3071. Minimum Operations to Write the Letter Y on a Grid
 *
 *
 * You are given a 0-indexed n x n grid where n is odd, and grid[r][c] is 0, 1, or 2.
 *
 * We say that a cell belongs to the Letter Y if it belongs to one of the following:
 *
 * The diagonal starting at the top-left cell and ending at the center cell of the grid.
 * The diagonal starting at the top-right cell and ending at the center cell of the grid.
 * The vertical line starting at the center cell and ending at the bottom border of the grid.
 * The Letter Y is written on the grid if and only if:
 *
 * All values at cells belonging to the Y are equal.
 * All values at cells not belonging to the Y are equal.
 * The values at cells belonging to the Y are different from the values at cells not belonging to the Y.
 * Return the minimum number of operations needed to write the letter Y on the grid given that in one operation you can change the value at any cell to 0, 1, or 2.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[1,2,2],[1,1,0],[0,1,0]]
 * Output: 3
 * Explanation: We can write Y on the grid by applying the changes highlighted in blue in the image above. After the operations, all cells that belong to Y, denoted in bold, have the same value of 1 while those that do not belong to Y are equal to 0.
 * It can be shown that 3 is the minimum number of operations needed to write Y on the grid.
 *
 *
 * Example 2:
 *
 *
 * Input: grid = [[0,1,0,1,0],[2,1,0,1,2],[2,2,2,0,1],[2,2,2,2,2],[2,1,2,2,2]]
 * Output: 12
 * Explanation: We can write Y on the grid by applying the changes highlighted in blue in the image above. After the operations, all cells that belong to Y, denoted in bold, have the same value of 0 while those that do not belong to Y are equal to 2.
 * It can be shown that 12 is the minimum number of operations needed to write Y on the grid.
 *
 *
 * Constraints:
 *
 * 3 <= n <= 49
 * n == grid.length == grid[i].length
 * 0 <= grid[i][j] <= 2
 * n is odd.
 */
public class MinimumOperationsToWriteTheLetterYOnAGrid {

    // 对于 i != j, Y 中的值都变为 i, 其余区域变为 j, 则不需要变的是 cnt1[i] + cnt2[j]
    // ans = n * n - max(cnt1[i] + cnt2[j])
    public int minimumOperationsToWriteY(int[][] grid) {
        int[] cnt1 = new int[3];
        int[] cnt2 = new int[3];
        int n = grid.length;
        int m = n / 2;
        for (int i = 0; i < m; i++) {
            cnt1[grid[i][i]]++;
            cnt1[grid[i][n - 1 - i]]++;
            for (int j = 0; j < n; j++) {
                if (j != i && j != n - 1 - i) {
                    cnt2[grid[i][j]]++;
                }
            }
        }
        for (int i = m; i < n; i++) {
            cnt1[grid[i][m]]++;
            for (int j = 0; j < n; j++) {
                if (j != m) {
                    cnt2[grid[i][j]]++;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    max = Math.max(max, cnt1[i] + cnt2[j]);
                }
            }
        }
        return n * n - max;
    }

}
