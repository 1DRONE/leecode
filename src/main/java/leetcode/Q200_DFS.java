package leetcode;

/**
 * @author drone
 * @date 2021/5/22
 */
public class Q200_DFS {
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
                    dfs(grid, r, c);
                }
            }
        }
        return result;
    }

    //r和c代表开始搜索坐标
    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        //将当前坐标的值设为0
        grid[r][c] = '0';

        //搜索当前坐标四周
        dfs(grid, r - 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r + 1, c);
        dfs(grid, r, c + 1);
    }
}
