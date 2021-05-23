package leetcode;

/**
 * @author drone
 * @date 2021/5/24
 */
public class Q338 {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];

        //x=x & (x−1)，该运算将 x 的二进制表示的最后一个 1 变成 0
        for (int i = 1; i <= num; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }
}
