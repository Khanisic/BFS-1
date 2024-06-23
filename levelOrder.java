// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    List<List<Integer>> result; // globally create result

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) { // base case
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(root, 0); // calling the recursive function
        return result;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == result.size()) { // current level is same as size of the result array
            List<Integer> temp = new ArrayList<>();
            result.add(temp); // empty array
        }
        result.get(level).add(root.val); // getting the array and adding to it
        dfs(root.left, level + 1); // left recursive call
        dfs(root.right, level + 1); // right recursive call
        // we increment the level as well

    }
}