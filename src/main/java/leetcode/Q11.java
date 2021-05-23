package leetcode;

/**
 * @author drone
 * @date 2021/5/24
 */
public class Q11 {
    public int maxArea(int[] height) {
        if (null == height || 0 == height.length) {
            return 0;
        }

        int length = height.length;
        int l = 0;
        int r = length - 1;

        int result = 0;
        while (l < r) {
            //水的面积由较小的一个边决定
            int area = Math.min(height[l], height[r]) * (r - l);

            result = Math.max(result, area);

            //哪边小  往另一边移动
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return result;
    }
}
