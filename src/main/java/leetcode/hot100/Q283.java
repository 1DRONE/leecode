package leetcode.hot100;

/**
 * @author zhangyizhang01
 * @date 2021-02-22
 */
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针
// 👍 956 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Q283 {
    public void moveZeroes(int[] nums) {
        int start = 0;
        int end = 0;
        while (end < nums.length) {
            if (0 != nums[end]) {
                swap(nums, start, end);
                start++;
            }
            end++;
        }
    }

    private void swap(int[] nums, int start, int end) {
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

