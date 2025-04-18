
class Solution {
    int idx = 1;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        if (preorder.length < 1)
            return null;
        else {
            TreeNode head = new TreeNode(preorder[0]);
            return help(head, preorder, (preorder.length - 1), 0);
        }
    }

    public TreeNode help(TreeNode root, int[] preorder, int high, int low) {
        if (idx == preorder.length) {
            return root;
        }

        int currKey = map.get(preorder[idx]);
        int rootKey = map.get(root.val);

        if (currKey >= low && currKey < rootKey) {
            TreeNode temp = new TreeNode(preorder[idx]);
            idx++;
            root.left = help(temp, preorder, rootKey, low);
        }

        if (idx == preorder.length)
            return root;
        currKey = map.get(preorder[idx]);

        if (currKey <= high) {
            TreeNode temp = new TreeNode(preorder[idx]);
            idx++;
            root.right = help(temp, preorder, high, rootKey);
        }

        return root;

    }
}
