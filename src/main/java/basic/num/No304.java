package basic.num;

/**
 * 303的进一步，求矩阵的和
 *
 * @author huangxiaodong
 * @date 2021/11/24  16:38
 */
public class No304 {

    class NumMatrix {
        // 记录(0,0) (i,j)的和
        private int[][] preSum;

        public NumMatrix(int[][] matrix) {
            preSum = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[i - 1].length; j++) {
                    preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1] - preSum[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1] + preSum[row1][col1];
        }
    }
}
