package listnode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * test
 *
 * @author huangxiaodong
 * @date 2021/5/12  14:42
 */
public class TestCon {
    @Test
    public void test() {
        String str = "23";
        List<String> res = new ArrayList<>();
        List<Integer> nums = castToArray(Integer.parseInt(str));
        for (Integer num : nums) {
            for (int i = 0; i < 3; i++) {

            }
        }

    }

    private List<Integer> castToArray(int num) {
        List<Integer> numList = new ArrayList<>();
        int numOfSize = num;
        while (numOfSize > 0) {
            numList.add(numOfSize % 10);
            numOfSize = numOfSize / 10;
        }
        return numList;
    }

}
