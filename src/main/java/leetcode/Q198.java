package leetcode;

/**
 * @author drone
 * @date 2021/6/8
 */
public class Q198 {
    public int rob(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        int length = nums.length;
        if (1 == length) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        //对于第k(k>2) 间房屋，有两个选项：
        //偷窃第k间房屋，就不能偷窃第k−1间房屋，偷窃总金额为前k−2间房屋的最高总金额与第k间房屋的金额之和。
        //不偷窃第k间房屋，偷窃总金额为前k-1间房屋的最高总金额。
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
