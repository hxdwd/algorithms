package array;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.xml.stream.FactoryConfigurationError;
import java.util.TooManyListenersException;
import java.util.concurrent.TimeUnit;

/**
 * 数组/链表的原地去重
 *
 * @author huangxiaodong
 * @date 2022/2/8  13:49
 */
@Slf4j
class MoveDuplicatesTest {

    @Test
    void testNo26() {
        int[] case1 = new int[]{1, 1, 2, 2, 3};
        log.info("before:{}, res:{}, after:{}", case1, removeDuplicates(case1), case1);
        int[] case2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        log.info("before:{}, res:{}, after:{}", case2, removeDuplicates(case2), case2);
        int[] case3 = new int[]{0};
        log.info("before:{}, res:{}, after:{}", case3, removeDuplicates(case3), case3);
    }

    /**
     * No.26
     * 原地去除有序数组的重复项
     * Input: nums = [1,1,2]
     * Output: 2, nums = [1,2,_]
     */
    public int removeDuplicates(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[left] == nums[right]) {
                right++;
            } else {
                // 出现不同的数字，交换
                int temp = nums[left + 1];
                nums[left + 1] = nums[right];
                nums[right] = temp;

                // 更新索引
                left++;
                right++;
            }
        }
        return left + 1;
    }

    /**
     * 优化一版
     */
    public int removeDuplicates2(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                // 更新索引
                left++;
                // 出现不同的数字，交换
                nums[left] = nums[right];
            }
            right++;
        }
        return left + 1;
    }

}
