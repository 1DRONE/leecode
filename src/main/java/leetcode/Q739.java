package leetcode;

import java.util.LinkedList;

/**
 * @author drone
 * @date 2021/5/23
 */
public class Q739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                result[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return result;
    }
}
