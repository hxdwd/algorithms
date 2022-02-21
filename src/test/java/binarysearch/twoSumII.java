package binarysearch;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
public class twoSumII {

    @Test
    public void test() {
        long start = System.currentTimeMillis();
        log.info("{}", twoSum(new int[]{2, 7, 11, 15}, 9));
        log.info("耗时：{}ms", System.currentTimeMillis() - start);

        long start1 = System.currentTimeMillis();
        log.info("{}", twoSum2(new int[]{2, 7, 11, 15}, 9));
        log.info("耗时：{}ms", System.currentTimeMillis() - start1);
    }

    /**
     * 暴力冒泡
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] indexes = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    indexes[0] = i + 1;
                    indexes[1] = j + 1;
                    return indexes;
                }
            }
        }
        return indexes;
    }

    /**
     * 二分法
     */
    public int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];

        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum > target) {
                end--;
            } else if (sum < target) {
                start++;
            } else {
                return new int[]{start + 1, end + 1};
            }
        }
        return new int[]{-1, -1};
    }
}
