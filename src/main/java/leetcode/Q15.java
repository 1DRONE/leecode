package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author drone
 * @date 2021/6/8
 */
public class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //特判，对于数组长度n，如果数组为null或者数组长度小于3，返回[]。
        if (null == nums || 3 > nums.length) {
            return lists;
        }
        //排序
        Arrays.sort(nums);
        //双指针
        int len = nums.length;

        //遍历排序后数组
        for (int i = 0; i < len; i++) {
            //若nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于0，直接返回结果。
            if (nums[i] > 0) {
                return lists;
            }
            //对于重复元素：跳过，避免出现重复解
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = len - 1;

            while (left < right) {
                int tmp = nums[i] + nums[left] + nums[right];
                //若和小于0，说明nums[L] 太小，L 右移
                if (tmp < 0) {
                    left++;
                    //若和大于0，说明nums[R] 太大，R 左移
                } else if (tmp > 0) {
                    right--;
                } else {
                    //记录结果
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    //判断左界和右界是否和下一位置重复，去除重复解。
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    //同时将L,R移到下一位置，寻找新的解
                    left++;
                    right--;
                }
            }
        }
        return lists;
    }
}
