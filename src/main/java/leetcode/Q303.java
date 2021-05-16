package leetcode;

/**
 * @author drone
 * @date 2021/5/16
 */
class Q303 {
    private int[] sums;

    public Q303(int[] nums) {
        int n = nums.length;
        this.sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    //正常情况sum[n]代表前n个数的和，此处sum(n+1)表示前n个数的和.不需要对 i=0i=0 的情况特殊处理。
    //sumRange(i,j)=sum(j)-sum(i-1); 此处 sumRange(i,j)=sum(j+1)-sum(i);
    public int sumRange(int left, int right) {
        return this.sums[right + 1] - this.sums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
