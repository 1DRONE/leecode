package leetcode.hot100;

/**
 * @author drone
 * @date 2021/5/16
 */
public class Q5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        //边界判断
        if (len < 2) {
            return s;
        }

        //dp[i][j]表示s[i...j]是否是回文串
        boolean[][] dp = new boolean[len][len];
        //初始化：所有长度为1的字符串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        //回文最大长度
        int maxLen = 1;
        //最大回文起始位置
        int begin = -0;

        char[] charArray = s.toCharArray();

        //字串长度为l
        for (int l = 2; l <= len; l++) {
            //字串左边界为i
            for (int i = 0; i < len; i++) {
                //字串右边界为j j-i+1=l
                int j = l - 1 + i;

                //右边界越界
                if (j >= len) {
                    break;
                }

                if (charArray[i] == charArray[j]) {
                    if (2 == l) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }

                } else {
                    dp[i][j] = false;
                }

                //dp[i][j]为真 则s[i...j]为回文串，记录回文长度和起始位置
                if (dp[i][j] && l > maxLen) {
                    maxLen = l;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}