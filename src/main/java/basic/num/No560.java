package basic.num;

import java.io.PipedReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定数组，求连续子数组的和=k
 *
 * @author huangxiaodong
 * @date 2021/11/25  9:55
 */
public class No560 {
    private int count;

    class Solution {
        /**
         * 递归的写法
         */
        public int subarraySumV1(int[] nums, int k) {
            backtrace(new ArrayList<>(), nums, k, 0);
            return count;
        }
        private void backtrace(List<Integer> tempList, int[] nums, int remain, int start) {
            if (remain < 0) {
                return;
            } else if (remain == 0) {
                count++;
            } else {
                for (int i = start; i < nums.length; i++) {
                    tempList.add(nums[i]);
                    backtrace(tempList, nums, remain - nums[i], i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
        private int[] preSum;

        public Solution(int[] nums) {
            preSum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }
        }

        /**
         * 暴力前缀和
         */
        public int subarraySumV2(int[] nums, int k) {
            int count = 0;
            for (int item : preSum) {
                for (int value : preSum) {
                    if (item - value == k) {
                        count++;
                    }
                }
            }
            return count;
        }

    }


}
