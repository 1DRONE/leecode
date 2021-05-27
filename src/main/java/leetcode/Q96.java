package leetcode;

/**
 * @author drone
 * @date 2021/5/24
 */
public class Q96 {
    public int numTrees(int n) {
        //G(n): 长度为n的序列能构成的不同二叉搜索树的个数。
        //F(i,n): 以 i为根、序列长度为n的不同二叉搜索树个数(1≤i≤n)。
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //笛卡尔积
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
