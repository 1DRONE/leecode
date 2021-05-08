package leetcode.hot100;

/**
 * 矩阵幂方法
 * @author zhangyizhang01
 * @date 2021-02-23
 */
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 动态规划
// 👍 1479 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Q70_Matrix {
    public int climbStairs(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    public int[][] pow(int[][] q, int n) {
        int[][] res = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                res = multiply(res, q);
            }
            n >>= 1;
            q = multiply(q, q);
        }
        return res;
    }


    public int[][] multiply(int[][] a, int[][] b) {
        int[][] result = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

