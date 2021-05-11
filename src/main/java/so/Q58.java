package so;

import java.util.HashMap;
import java.util.Map;

/**
 * @author drone
 * @date 2021/5/12
 */
public class Q58 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0;
        int tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = dic.getOrDefault(s.charAt(i), -1);
            dic.put(s.charAt(i), i);
            tmp = tmp < i - j ? tmp + 1 : i - j;
            res = Math.max(tmp, res);
        }
        return res;
    }
}
