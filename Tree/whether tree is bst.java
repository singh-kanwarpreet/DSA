public class Solution {
    public static boolean bool = true;
    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        bool = true;
        help(root,Integer.MIN_VALUE,INTEGER.MAX_VALUE);
        return bool;
    }
    public static void help(BinaryTreeNode<Integer> root,int low,int high){
        if(root == null) return;
        if(!(root.val >= low && root.val <= high)) bool = false;
        help(root.left,low,root.val);
        help(root.right,root.val,high);
    }
}

