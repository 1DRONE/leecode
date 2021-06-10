package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author drone
 * @date 2021/6/11
 */
public class Q560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int pre = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);

//每个元素对应一个“前缀和”
//遍历数组，根据当前“前缀和”，在 map 中寻找「与之相减 == k」的历史前缀和
//当前“前缀和”与历史前缀和，差分出一个子数组，该历史前缀和出现过 c 次，等价于当前项找到 c 个子数组求和等于 k。
//遍历过程中，c 不断加给 count，最后返回 count

        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
