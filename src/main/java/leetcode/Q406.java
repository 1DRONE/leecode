package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author drone
 * @date 2021/5/24
 */
public class Q406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (people1, people2) -> {
            if (people1[0] != people2[0]) {
                return people2[0] - people1[0];
            } else {
                return people1[1] - people2[1];
            }
        });

        List<int[]> result = new ArrayList<>();
        for (int[] person : people) {
            result.add(person[1], person);
        }
        return result.toArray(new int[result.size()][2]);
    }
}