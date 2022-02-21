package dfs;

import com.sun.corba.se.impl.ior.GenericIdentifiable;
import org.junit.jupiter.api.Test;

/**
 * 岛屿问题
 *
 * @author huangxiaodong
 * @date 2022/2/19  20:14
 */
public class IslandTest {

    @Test
    void test() {

    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }

    int dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        if (grid[i][j] == '0') {
            return 0;
        }
        grid[i][j] = '0';
        return dfs(grid, i + 1, j)
                + dfs(grid, i, j + 1)
                + dfs(grid, i - 1, j)
                + dfs(grid, i, j - 1) + 1;

    }
}
