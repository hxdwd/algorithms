package binarysearch;

import java.util.Collections;

/**
 * Triple Inversion
 *
 * @author huangxiaodong
 * @date 2021/6/7  19:43
 */
public class TripleInversion {
    public static int solve(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j] * 3) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solve((new int[]{7, 1, 2})));
    }
}
