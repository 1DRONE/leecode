package leetcode.hot100;

/**
 * @author drone
 * @date 2021/5/16
 */
public class Q42_DoublePointer {
    public int trap(int[] height) {
        int ans = 0;

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            //左边的最大值，它是从左往右遍历找到的
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            //在某个位置i处，它能存的水，取决于它左右两边的最大值中较小的一个。
            //当我们从左往右处理到left下标时，左边的最大值left_max对它而言是可信的，但right_max是不可信的。(可能中间存在更高的值)。从右向左同理。
            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
