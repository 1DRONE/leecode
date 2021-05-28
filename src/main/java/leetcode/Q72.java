package leetcode;

/**
 * @author drone
 * @date 2021/5/29
 */
public class Q72 {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        if (l1 == 0 || l2 == 0) {
            return l1 + l2;
        }

        //D[i][j] 表示 A 的前 i 个字母和 B 的前 j 个字母之间的编辑距离
        int[][] dp = new int[l1 + 1][l2 + 1];
        //边界
        //B为空
        for (int i = 0; i < l1 + 1; i++) {
            dp[i][0] = i;
        }
        //A为空
        for (int i = 0; i < l2 + 1; i++) {
            dp[0][i] = i;
        }

        //A的长度加A为空共l1+1长度
        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                int down = dp[i - 1][j] + 1;
                int left = dp[i][j - 1] + 1;
                int leftDown = dp[i - 1][j - 1];

                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    leftDown += 1;
                }

                dp[i][j] = Math.min(down, Math.min(left, leftDown));
            }
        }
        return dp[l1][l2];
    }
}
