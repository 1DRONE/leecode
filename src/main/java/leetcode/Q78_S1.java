package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典排序
 * @author zhangyizhang01
 * @date 2021-02-28
 */
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//
//
// 示例 2：
//
//
//输入：nums = [0]
//输出：[[],[0]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// nums 中的所有元素 互不相同
//
// Related Topics 位运算 数组 回溯算法
// 👍 1008 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Q78_S1 {
    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < (1 << length); i++) {
            List<Integer> c = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                if ((i & (1 << j)) != 0) {
                    c.add(nums[j]);
                }
            }
            result.add(c);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
