package so;

import java.util.PriorityQueue;

/**
 * @author drone
 * @date 2021/5/12
 */
public class Q40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (null == arr || 0 == arr.length || k <= 0) {
            return new int[0];
        }

        int[] result = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }
}
