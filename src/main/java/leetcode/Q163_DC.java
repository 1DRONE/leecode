package leetcode;

/**
 * @author zhangyizhang01
 * @date 2021-02-24
 */
//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
// 示例 1：
//
//
//输入：[3,2,3]
//输出：3
//
// 示例 2：
//
//
//输入：[2,2,1,1,1,2,2]
//输出：2
//
//
//
//
// 进阶：
//
//
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
//
// Related Topics 位运算 数组 分治算法
// 👍 880 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Q163_DC {
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    public int majorityElementRec(int[] nums, int start, int end) {
        //如果数组只有一个元素
        if (start == end) {
            return nums[start];
        }
        int middle = (end - start) / 2 + start;
        int left = majorityElementRec(nums, start, middle);
        int right = majorityElementRec(nums, middle + 1, end);

        if (left == right) {
            return left;
        }
        return countInRange(nums, left, start, end) > countInRange(nums, right, start, end) ? left : right;
    }

    public int countInRange(int[] nums, int num, int start, int end) {
        int count = 0;
        for (int i = start; i < end + 1; i++) {
            if (num == nums[i]) {
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

