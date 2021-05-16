package leetcode.hot100;

/**
 * @author drone
 * @date 2021/5/16
 */
public class Q42_DP {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        //leftMax[i] 表示下标 i 及其左边的位置中，height 的最大高度
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        //rightMax[i] 表示下标 i 及其右边的位置中，height 的最大高度
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}
