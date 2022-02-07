package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合 不能重复选择nums[]的元素
 *
 * @author huangxiaodong
 * @date 2021/11/5  9:12
 */
public class No40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    int count = 0;

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                tempList.add(candidates[i]);
                // 避免重复选择
                backtrack(list, tempList, candidates, remain - candidates[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
