package leetcode;

/**
 * @author drone
 * @date 2021/5/27
 */
public class Q287 {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        //数组的数都在1-n之间(包括1和n)
        int left = 1;
        int right = n - 1;
        int result = -1;
        //cnt[i] 表示nums 数组中小于等于i的数有多少个，假设我们重复的数是target，那么 [1,[1,target−1]里的所有数满足cnt[i]≤i，[target,n] 里的所有数满足cnt[i]>i，具有单调性。

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }

            if (cnt <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
                result = mid;
            }
        }
        return result;
    }
}
