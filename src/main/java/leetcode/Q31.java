package leetcode;

/**
 * @author drone
 * @date 2021/5/16
 */
public class Q31 {
    //对于长度为n的排列a：
    //首先从后向前查找第一个顺序对(i,i+1)，满足a[i]<a[i+1]。这样「较小数」即为a[i]。此时[i+1,n) 必然是下降序列。
    //如果找到了顺序对，那么在区间[i+1,n)中从后向前查找第一个元素j满足a[i]<a[j]。这样「较大数」即为a[j]。
    //交换a[i]与a[j]，此时可以证明区间[i+1,n) 必为降序。我们可以直接使用双指针反转区间[i+1,n) 使其变为升序，而无需对该区间进行排序。

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }

        if (i >= 0) {
            int j = nums.length - 1;
            for (; j > i; j--) {
                if (nums[i] < nums[j]) {
                    break;
                }
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}