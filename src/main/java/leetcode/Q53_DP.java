package leetcode;

/**
 * @author zhangyizhang01
 * @date 2021-02-22
 */
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//
//
// 示例 1：
//
//
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//
//
// 示例 2：
//
//
//输入：nums = [1]
//输出：1
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：0
//
//
// 示例 4：
//
//
//输入：nums = [-1]
//输出：-1
//
//
// 示例 5：
//
//
//输入：nums = [-100000]
//输出：-100000
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 104
// -105 <= nums[i] <= 105
//
//
//
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
// Related Topics 数组 分治算法 动态规划
// 👍 2903 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Q53_DP {
    public int maxSubArray(int[] nums) {
        //pre是以第i个数结尾的最大序列和。主要是试探加上第i个数后的最大值
        //maxAns是选择是否在序列中添加第i个数。如果以第i个数结尾的pre比之前的maxAns小，则最大子序列不添加第i个数
        int pre=0;
        int maxAns = nums[0];

        for (int num:nums){
            pre = Math.max(pre + num, num);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

