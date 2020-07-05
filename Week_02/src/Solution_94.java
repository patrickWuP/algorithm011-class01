class Solution_94 {
    
    //中序遍历的，迭代写法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        while(!stack.empty() || curr != null) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);

            curr = curr.right;
        }

        return result;
    }
}