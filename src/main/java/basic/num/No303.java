package basic.num;

/**
 * 计算数组的区间和
 * （利用前缀和）
 *
 * @author huangxiaodong
 * @date 2021/11/24  9:42
 */
public class No303 {
    public static class NumArray {
        private int[] preSum;

        public NumArray(int[] sum) {
            // preSum[0]=0
            preSum = new int[sum.length + 1];
            for (int i = 1; i < sum.length; i++) {
                preSum[i] = preSum[i - 1] + sum[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return preSum[right + 1] - preSum[left];
        }
    }
}
