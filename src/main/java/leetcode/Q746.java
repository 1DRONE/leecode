package leetcode;

/**
 * @author drone
 * @date 2021/5/16
 */
public class Q746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        //从0开始和从1开始
        dp[0] = 0;
        dp[1] = 0;

        //cost[i]为离开i阶所需体力
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}
