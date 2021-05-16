package leetcode;

/**
 * @author drone
 * @date 2021/5/17
 */
public class Q718 {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int ans = 0;

        //挪动nums1
        for (int i = 0; i < m; i++) {
            //计算最小重合数组长度
            int len = Math.min(n, m - i);
            int maxLength = maxLength(nums1, nums2, i, 0, len);
            ans = Math.max(ans, maxLength);
        }

        //挪动nums2
        for (int i = 0; i < n; i++) {
            //计算最小重合数组长度
            int len = Math.min(m, n - i);
            int maxLength = maxLength(nums1, nums2, 0, i, len);
            ans = Math.max(ans, maxLength);
        }
        return ans;
    }

    private int maxLength(int[] nums1, int[] nums2, int nums1Offset, int nums2Offset, int len) {
        int result = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (nums1[nums1Offset + i] == nums2[nums2Offset + i]) {
                max++;
            } else {
                max = 0;
            }
            result = Math.max(result, max);
        }
        return result;
    }
}
