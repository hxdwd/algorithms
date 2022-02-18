package stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 单调栈
 *
 * @author huangxiaodong
 * @date 2022/2/11  16:21
 */
@Slf4j
class MonotonousStackTest {

    @Test
    void test1() {
        log.info("{}", dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        log.info("{}", dailyTemperatures(new int[]{30, 40, 50, 60}));

    }

    /**
     * 739. Daily Temperatures
     * Input: temperatures = [73,74,75,71,69,72,76,73]
     * Output: [1,1,4,2,1,1,0,0]
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        // 保存索引
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            // 如果比之前小的话 直接不要
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }

}
