package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 *
 * @author huangxiaodong
 * @date 2021/11/3  9:13
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
        } else {
            for (int num : nums) {
                if (tempList.contains(num)) {
                    continue;
                }
                tempList.add(num);
                backtrack(res, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        } 
    }

}
