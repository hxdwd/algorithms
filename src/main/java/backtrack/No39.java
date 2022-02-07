package backtrack;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个数组 返回和为目标数的所有集合
 *
 * @author huangxiaodong
 * @date 2021/10/27  17:22
 */
public class No39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // sort candidates to try them in asc order
        Arrays.sort(candidates);
        // dp[t] stores all combinations that add up to t
        List<List<Integer>>[] dp = new ArrayList[target + 1];


        // build up dp
        for (int t = 0; t <= target; t++) {
            // initialize
            dp[t] = new ArrayList();
            // initialize
            List<List<Integer>> combList = new ArrayList();

            for (int j = 0; j < candidates.length && candidates[j] <= t; j++) {
                if (candidates[j] == t) {
                    combList.add(Collections.singletonList(candidates[j]));
                } else {
                    for (List<Integer> prevList : dp[t - candidates[j]]) {
                        if (candidates[j] >= prevList.get(prevList.size() - 1)) {
                            List temp = new ArrayList(prevList);
                            temp.add(candidates[j]);
                            combList.add(temp);
                        }
                    }
                }
            }
            dp[t] = combList;
        }
        return dp[target];
    }

    /**
     * 递归的方法
     */
    public List<List<Integer>> combinationSumV2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) {
            // do nothing
        } else if (remain == 0) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
