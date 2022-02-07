package other;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指offer的题目
 *
 * @author huangxiaodong
 * @date 2021/11/12  14:41
 */
public class OfferTest {

    @Test
    public void test() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append(i);
        }

        System.out.println(sb.charAt(100));
        System.out.println(sb.charAt(1000));


        System.out.println(findNoNDigit(100));
        System.out.println(findNoNDigit(1000));
    }

    private int findNoNDigit(int n) {
        int num = 0;
        int k = 0;
        if (n < 10) {
            return n;
        }
        while (n > 0) {
            // 保留剩余的n值
            num = n;
            n -= k * 9 * Math.pow(10, k - 1);
            k++;
        }
        k--;
        int kSum = (int) (Math.pow(10, k - 1) + (num - 1) / k);
        int kIndex = (num - 1) % k;
        // kSum中第KIndex个数
        return String.valueOf(kSum).charAt(kIndex) - '0';
    }

    @Test
    public void test2() {
        System.out.println(duplicate(new int[]{2, 6, 1, 0, 6, 5, 3}));
        System.out.println(duplicate2(new int[]{2, 6, 1, 0, 6, 5, 3}));
        System.out.println(duplicate3(new int[]{2, 6, 1, 0, 6, 5, 3}));
    }


    /**
     * O(n) = n ^ 2 O(n) = n ^ 2
     */
    public int duplicate(int[] numbers) {
        // 在数组中找出任意重复的一个数
        int index = -1;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    index = i;
                    break;
                }
            }
        }
        return index >= 0 ? numbers[index] : index;
    }

    public int duplicate2(int[] numbers) {
        // 在数组中找出任意重复的一个数
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : numbers) {
            if (map.get(number) != null) {
                return number;
            } else {
                map.put(number, number);
            }
        }
        return -1;
    }

    /**
     * 题目限制
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内
     */
    public int duplicate3(int[] numbers) {
        // 在数组中找出任意重复的一个数
        int[] count = new int[numbers.length];
        for (int number : numbers) {
            if (++count[number] == 2) {
                return number;
            }
        }
        return -1;
    }

}
