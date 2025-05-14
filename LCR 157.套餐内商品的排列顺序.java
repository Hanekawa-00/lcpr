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
    private Set<String> set;

    public String[] goodsOrder(String goods) {
        set = new HashSet<>();
        char[] charArray = goods.toCharArray();
        backtrack(charArray, new boolean[goods.length()], new StringBuilder());
        String[] res = set.toArray(new String[0]);
        return res;
    }

    private void backtrack(char[] goods, boolean[] path, StringBuilder str) {
        if (str.length() == goods.length) {
            set.add(str.toString());
            return;
        }
        // 因为是全集合，所以要从0开始，而不是一个起点多路径选择，是多个起点多个选择
        for (int i = 0; i < goods.length; i++) {
            char curr = goods[i];
            if (!path[i]) {
                str.append(curr);
                path[i] = true;
                backtrack(goods, path, str);
                str.deleteCharAt(str.length() - 1);
                path[i] = false;
            }
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "agew"\n
 * // @lcpr case=end
 * 
 */
