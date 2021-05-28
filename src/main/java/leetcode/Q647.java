package leetcode;

/**
 * @author drone
 * @date 2021/5/29
 */
public class Q647 {
    public int countSubstrings(String s) {
        int n = s.length();
        int result = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            int left = i / 2;
            int right = i / 2 + i % 2;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                result++;
            }
        }
        return result;
    }
}
