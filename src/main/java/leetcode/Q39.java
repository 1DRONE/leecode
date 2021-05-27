package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author drone
 * @date 2021/5/24
 */
public class Q39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();

        dfs(candidates, target, result, combine, 0);

        return result;
    }

    /**
     * 我们定义递归函数 dfs(target, combine, idx) 表示当前在 candidates 数组的第 idx 位，还剩 target 要组合，已经组合的列表为 combine。
     *
     * @param candidates 候选数组
     * @param target     目标值
     * @param result
     * @param combine    已组合的列表
     * @param idx        候选数组的第idx位
     */
    private void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }

        //回溯终止条件
        if (target == 0) {
            result.add(new ArrayList<Integer>(combine));
            return;
        }

        //每次可以选择用当前数  也可以选择不用当前数
        //直接跳过
        dfs(candidates, target, result, combine, idx + 1);
        //选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], result, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }
}
