package other;

import backtrack.No39;
import org.junit.jupiter.api.Test;

public class No39Test {

    @Test
    public void combinationSum() {
        No39 test = new No39();
        System.out.println(test.combinationSum(new int[]{1, 2, 3, 6, 7}, 10));
        System.out.println(test.combinationSumV2(new int[]{2, 3, 6, 7}, 10));
    }
}