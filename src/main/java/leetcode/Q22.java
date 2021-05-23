package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author drone
 * @date 2021/5/24
 */
public class Q22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    /**
     *
     * @param result  结果集
     * @param stringBuilder
     * @param left 左括号已使用个数
     * @param right  右括号已使用个数
     * @param max  最大可使用个数
     */
    public void backtrack(List<String> result, StringBuilder stringBuilder, int left, int right, int max) {
        if (stringBuilder.length() == 2 * max) {
            result.add(stringBuilder.toString());
            return;
        }

        if (left < max) {
            stringBuilder.append("(");
            backtrack(result, stringBuilder, left + 1, right, max);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        if (right < left) {
            stringBuilder.append(")");
            backtrack(result, stringBuilder, left, right + 1, max);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
