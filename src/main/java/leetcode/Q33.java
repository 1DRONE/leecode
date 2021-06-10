package leetcode;

/**
 * @author drone
 * @date 2021/6/10
 */
public class Q33 {
    public int search(int[] nums, int target) {
        if (null == nums || 0 == nums.length) {
            return -1;
        }

        //二分查找  从中间分成2个部分  一定有一个部分是有序的
        int n = nums.length;
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            //前半部分有序  区分有序必须在全部的数组上
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
