package leetcode;

/**
 * @author drone
 * @date 2021/5/24
 */
public class Q238 {
    public int[] productExceptSelf(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return new int[0];
        }

        int n = nums.length;

        //left和right分别代表左右两侧的乘积列表
        int[] left = new int[n];
        int[] right = new int[n];

        //left[i]为索引i左侧所有元素的乘积
        //第一个元素左侧没有元素  乘积为1
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        //除了num[i]外的乘积=左侧乘积*右侧乘积
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }
}
