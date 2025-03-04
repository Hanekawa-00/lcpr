/*
 * @lc app=leetcode.cn id=LCR 157 lang=java
 * @lcpr version=30204
 *
 * [LCR 157] 套餐内商品的排列顺序
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public String[] goodsOrder(String goods) {
        HashSet<String> resSet = new HashSet<String>();
        backtrack(goods, resSet, new boolean[goods.length()], new StringBuilder());
        return resSet.toArray(new String[0]);
    }

    private void backtrack(String goods, Set<String> resSet, boolean[] path, StringBuilder curr) {
        if (curr.length() == goods.length()) {
            resSet.add(curr.toString());
            return;
        }
        for (int i = 0; i < goods.length(); i++) {
            if (!path[i]) {
                // 尝试
                curr.append(goods.charAt(i));
                path[i] = true;
                backtrack(goods, resSet, path, curr);
                // 回退
                curr.deleteCharAt(curr.length() - 1);
                path[i] = false;
            }
        }
        return;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "agew"\n
 * // @lcpr case=end
 * 
 */
