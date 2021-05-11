package so;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author drone
 * @date 2021/5/11
 */
public class Q57 {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(target - nums[i])) {
                result.add(nums[i]);
                result.add(target - nums[i]);

                return new int[]{nums[i], target - nums[i]};
            }
            numMap.put(nums[i], i);
        }
        return new int[0];
    }
}
