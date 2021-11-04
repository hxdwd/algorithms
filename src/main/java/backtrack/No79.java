package backtrack;

import java.util.Objects;

public class No79 {
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 找到第一个出现的字符
                if ((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i >= board.length || i < 0 || j >= board.length || j < 0 || board[i][j] == word.charAt(index) || visited[i][j]) {
            return false;
        }

        // 已经访问
        visited[i][j] = true;
        if (search(board, word, i, j - 1, index + 1) ||
                search(board, word, i, j + 1, index + 1) ||
                search(board, word, i - 1, j, index + 1) ||
                search(board, word, i + 1, j, index + 1)) {
            return true;
        }

        // 重新设置
        visited[i][j] = false;
        return false;
    }
}
