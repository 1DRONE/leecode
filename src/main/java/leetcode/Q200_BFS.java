package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author drone
 * @date 2021/5/22
 */
public class Q200_BFS {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;

        int result = 0;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    result++;

                    grid[r][c] = 0;
                    Queue<Integer> queue = new LinkedList<>();

                    queue.offer(r * nc + c);
                    while (!queue.isEmpty()) {
                        int id = queue.poll();
                        int row = id / nc;
                        int col = id % nc;

                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            queue.offer((row - 1) * nc + col);
                            grid[row - 1][col] = 0;
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            queue.offer(row * nc + col - 1);
                            grid[row][col - 1] = 0;
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            queue.offer((row + 1) * nc + col);
                            grid[row + 1][col] = 0;
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            queue.offer(row * nc + col + 1);
                            grid[row][col + 1] = 0;
                        }
                    }
                }
            }
        }
        return result;
    }
}
